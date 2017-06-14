package de.hdm.marketPlace.client.report;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.marketPlace.client.ClientsideSettings;
import de.hdm.marketPlace.client.Showcase;
import de.hdm.marketPlace.shared.ReportGeneratorAsync;
import de.hdm.marketPlace.shared.report.AllTenders;
import de.hdm.marketPlace.shared.report.HTMLReportWriter;

public class AllTendersShowcase extends Showcase {

	@Override
	protected String getHeadlineText() {
		return "Report: Alle Ausschreibungen";
	}

	@Override
	protected void run() {


final Showcase showcase = this;
		
		this.append("Auslesen aller Ausschreibungenz");
		
		
		ReportGeneratorAsync reportGenerator = ClientsideSettings.getReportGenerator();
		
		
		reportGenerator.createAllTendersReport(new AsyncCallback<AllTenders>() {
			
			
			
			public void onFailure(Throwable caught) {
				showcase.append("Fehler: " + caught.getMessage());;
				
			}

			@Override
			public void onSuccess(AllTenders result) {
				if(result!= null){
					
					HTMLReportWriter writer = new HTMLReportWriter();
				
					writer.process(result);
					
					showcase.append(writer.getReportText());
				}	
			}
		});	

	}

}
