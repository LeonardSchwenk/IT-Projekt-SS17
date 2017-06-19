package de.hdm.marketPlace.client.report;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.marketPlace.client.ClientsideSettings;
import de.hdm.marketPlace.client.Showcase;
import de.hdm.marketPlace.shared.LoginInfo;
import de.hdm.marketPlace.shared.MarketplaceAdministrationAsync;
import de.hdm.marketPlace.shared.ReportGeneratorAsync;
import de.hdm.marketPlace.shared.bo.User;
import de.hdm.marketPlace.shared.report.HTMLReportWriter;
import de.hdm.marketPlace.shared.report.AllApplicationsOnAllTenders;

public class AllApplicationsOnAllTendersShowcase extends Showcase {


	@Override
	protected String getHeadlineText() {
		return "Report: Alle Ausschreibungen und die zugehörigen Bewerbungen";
	}
	
	public LoginInfo loginInfo = null;
	public User currentUser = null;
	
	public AllApplicationsOnAllTendersShowcase(LoginInfo info){
		this.loginInfo = info;
	}

	@Override
	protected void run() {
	
		final Showcase showcase = this;
		
		this.append("Auslesen aller Ausschreibungen und die zugehörigen Bewerbungen");
		
		
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
		
		reportGenerator.createAllApplicationsOnAllTendersReport(currentUser, new AsyncCallback <AllApplicationsOnAllTenders> (){
			
			public void onFailure(Throwable caught) {
				showcase.append("Fehler: " + caught.getMessage());;
				
			}

			@Override
			public void onSuccess(AllApplicationsOnAllTenders result) {
				if(result!= null){
					
					HTMLReportWriter writer = new HTMLReportWriter();
				
					writer.process(result);
					
					showcase.append(writer.getReportText());
				}	
			}
		});	

	}
}
