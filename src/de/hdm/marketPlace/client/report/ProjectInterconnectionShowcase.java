package de.hdm.marketPlace.client.report;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import de.hdm.marketPlace.client.ClientsideSettings;
import de.hdm.marketPlace.client.Showcase;
import de.hdm.marketPlace.shared.LoginInfo;
import de.hdm.marketPlace.shared.MarketplaceAdministrationAsync;
import de.hdm.marketPlace.shared.ReportGeneratorAsync;
import de.hdm.marketPlace.shared.bo.User;
import de.hdm.marketPlace.shared.report.HTMLReportWriter;
import de.hdm.marketPlace.shared.report.ProjectInterconnection;

public class ProjectInterconnectionShowcase extends Showcase {

	@Override
	protected String getHeadlineText() {
		return "Report: Projektverflechtung eines bestimmten Nutzers";
	}
	
	public LoginInfo loginInfo = null;
	public User currentUser = null;
	
	public ProjectInterconnectionShowcase(LoginInfo info){
		this.loginInfo = info;
	}

	@Override
	protected void run() {
		
		VerticalPanel inputPanel = new VerticalPanel();
		final HTMLResultPanel resultPanel = new HTMLResultPanel();
		final Showcase showcase = this;

		
		this.append("Auslesen der Projektverflechtung eines bestimmten Nutzers");
		
		
		ReportGeneratorAsync reportGenerator = ClientsideSettings.getReportGenerator();
		MarketplaceAdministrationAsync admin = ClientsideSettings.getAdministration();
		
		
				
	
		//HIER WEITER
		
		final ListBox bewerberBox = new ListBox();
		bewerberBox.addItem("Bitte wähle einen Bewerber aus");
		
		reportGenerator.getBewerberAufEigeneAusschreibungen(identityChoiceReport.getSelectedIdentityAsObject(), 
				new AsyncCallback<Vector<Organisationseinheit>>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Fehler: "+caught.getMessage());
						
					}

					@Override
					public void onSuccess(Vector<Organisationseinheit> result) {
						
						for (Organisationseinheit bewerber : result) {
							
							bewerberBox.addItem(result.getName());  
							
						   	
						}	
				}
		});
		
		
		//___________________________________________
		
		reportGenerator.createProjectInterconnectionReport(currentUser, new AsyncCallback <ProjectInterconnection> (){
			
			public void onFailure(Throwable caught) {
				showcase.append("Fehler: " + caught.getMessage());;
				
			}

			@Override
			public void onSuccess(ProjectInterconnection result) {
				if(result!= null){
					
					HTMLReportWriter writer = new HTMLReportWriter();
				
					writer.process(result);
					
					showcase.append(writer.getReportText());
				}	
			}
		});	

	}

}
