package de.hdm.marketPlace.client.report;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.marketPlace.client.ClientsideSettings;
import de.hdm.marketPlace.client.Showcase;
import de.hdm.marketPlace.shared.LoginInfo;
import de.hdm.marketPlace.shared.MarketplaceAdministrationAsync;
import de.hdm.marketPlace.shared.ReportGeneratorAsync;
import de.hdm.marketPlace.shared.bo.User;
import de.hdm.marketPlace.shared.report.AllApplicationsOfUser;
import de.hdm.marketPlace.shared.report.AllApplicationsOnAllTenders;
import de.hdm.marketPlace.shared.report.HTMLReportWriter;

public class AllApplicationsOfUserShowcase extends Showcase {

	@Override
	protected String getHeadlineText() {
		return "Report: Alle Bewerbungen des Nutzers";
	}
	
	public LoginInfo loginInfo = null;
	public User currentUser = null;
	
	public AllApplicationsOfUserShowcase(LoginInfo info){
		this.loginInfo = info;
	}

	@Override
	protected void run() {
	
		final Showcase showcase = this;
		
		this.append("Auslesen aller Bewerbungen des Nutzers");
		
		
		ReportGeneratorAsync reportGenerator = ClientsideSettings.getReportGenerator();
		MarketplaceAdministrationAsync admin = ClientsideSettings.getAdministration();
		
		
				
		admin.getUserById(loginInfo.getUserId(), new AsyncCallback <User>(){
			
			public void onFailure(Throwable caught) {
				showcase.append("Fehler: " + caught.getMessage());;
				
			}

			@Override
			public void onSuccess(User result) {
				if(result!= null){
					
					currentUser = result;
				}	
			}
		});	
		
		reportGenerator.createAllApplicationsOfUserReport(currentUser, new AsyncCallback <AllApplicationsOfUser> (){
			
			public void onFailure(Throwable caught) {
				showcase.append("Fehler: " + caught.getMessage());;
				
			}

			@Override
			public void onSuccess(AllApplicationsOfUser result) {
				if(result!= null){
					
					HTMLReportWriter writer = new HTMLReportWriter();
				
					writer.process(result);
					
					showcase.append(writer.getReportText());
				}	
			}
		});	

	}

}
