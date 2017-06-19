package de.hdm.marketPlace.client.report;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.marketPlace.client.ClientsideSettings;
import de.hdm.marketPlace.client.Showcase;
import de.hdm.marketPlace.shared.ReportGeneratorAsync;
import de.hdm.marketPlace.shared.report.FanInFanOut;
import de.hdm.marketPlace.shared.report.HTMLReportWriter;

public class FanInFanOutShowcase extends Showcase {

	@Override
	protected String getHeadlineText() {
		return "Report: FanInFanOut-Analyse aller Nutzer";
	}

	@Override
	protected void run() {


final Showcase showcase = this;
		
		this.append("Auslesen der FanInFanOut-Analyse aller Nutzer");
		
		
		ReportGeneratorAsync reportGenerator = ClientsideSettings.getReportGenerator();
		
		
		reportGenerator.createFanInFanOutReport(new AsyncCallback<FanInFanOut>() {
			
			
			
			public void onFailure(Throwable caught) {
				showcase.append("Fehler: " + caught.getMessage());;
				
			}

			@Override
			public void onSuccess(FanInFanOut result) {
				if(result!= null){
					
					HTMLReportWriter writer = new HTMLReportWriter();
				
					writer.process(result);
					
					showcase.append(writer.getReportText());
				}	
			}
		});	

	}

}

