package de.hdm.marketPlace.client.report;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.marketPlace.client.ClientsideSettings;
import de.hdm.marketPlace.client.Showcase;
import de.hdm.marketPlace.shared.LoginInfo;
import de.hdm.marketPlace.shared.MarketplaceAdministrationAsync;
import de.hdm.marketPlace.shared.ReportGeneratorAsync;
import de.hdm.marketPlace.shared.bo.User;
import de.hdm.marketPlace.shared.report.*;
import de.hdm.marketPlace.shared.report.HTMLReportWriter;

public class TendersMatchShowcase extends Showcase {

	@Override
	protected String getHeadlineText() {
		return "Report: Alle Ausschreibungen passend zu Nutzerprofil";
	}
	
	public LoginInfo loginInfo = null;
	public User currentUser = null;
	
	public TendersMatchShowcase(LoginInfo info){
		this.loginInfo = info;
	}

	@Override
	protected void run() {
	
		final Showcase showcase = this;
		
		this.append("Auslesen aller Ausschreibungenz");
		
		
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
		
		reportGenerator.createTendersMatchProfilReport(currentUser, new AsyncCallback <TendersMatchProfil> (){
			
			public void onFailure(Throwable caught) {
				showcase.append("Fehler: " + caught.getMessage());;
				
			}

			@Override
			public void onSuccess(TendersMatchProfil result) {
				if(result!= null){
					
					HTMLReportWriter writer = new HTMLReportWriter();
				
					writer.process(result);
					
					showcase.append(writer.getReportText());
				}	
			}
		});	

	}

}
