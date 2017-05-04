package de.hdm.marketPlace.server.report;

import java.util.Date;

import de.hdm.marketPlace.shared.MarketplaceAdministration;
import de.hdm.marketPlace.shared.ReportGenerator;
import de.hdm.marketPlace.shared.bo.Tender;
import de.hdm.marketPlace.shared.bo.User;
import de.hdm.marketPlace.shared.report.AllApplicationsOfUser;
import de.hdm.marketPlace.shared.report.AllApplicationsOnTender;
import de.hdm.marketPlace.shared.report.AllTenders;
import de.hdm.marketPlace.shared.report.FanInFanOut;
import de.hdm.marketPlace.shared.report.ProjectInterconnection;
import de.hdm.marketPlace.shared.report.TendersMatchProfil;


public class ReportGeneratorImpl extends RemotServiceServlet implements ReportGenerator{ //Wo findet sich RemotService Servlet??

	// Erzeugt später die fertigen Reports und gibt sich mit Hilfe der tabellen aus
	
	private MarketplaceAdministration administration = null;
	
	public ReportGeneratorImpl() throws IllegalArgumentException {
	  }
	
	public void init() throws IllegalArgumentException {
		  
		    MarketplaceAdministrationImpl a = new MarketplaceAdministrationImpl();  //Passende Klasse fehlt noch
		    a.init();
		    this.administration = a;
		  }
	
	protected MarketplaceAdministration getBankVerwaltung() {
		    return this.administration;
		  }

	  
	public void setProjectMarketplace(ProjectMarktplace m) { //muss der marketplace gesetzt werden??
		    this.administration.setMarketplace(m);
		  }
		   
		  
		  
	protected void addImprint(Report r) { //Impressumsdaten anpassen
			 
			    Bank bank = this.administration.getBank();s imprint = new CompositeParagraph();

			    imprint.addSubParagraph(new SimpleParagraph(bank.getName()));
			    imprint.addSubParagraph(new SimpleParagraph(bank.getStreet()));
			    imprint.addSubParagraph(new SimpleParagraph(bank.getZip() + " " + bank.getCity()));

			    r.setImprint(imprint);

			  }
	
	
	// ALLE noch mit entsprechendem Code zum erzeugen der einzelnen Reportss
	
	  public AllTenders createAllTendersReport() throws IllegalArgumentException{
		  
	  }
	  
	  public TendersMatchProfil createTendersMatchProfilReport() throws IllegalArgumentException{
		  
	  }
	  
	  public AllApplicationsOnTender createAllApplicationsOnTenderReport(Tender t) throws IllegalArgumentException{
		  
	  }

	  public AllApplicationsOfUser createAllApplicationsOfUserReport(User u) throws IllegalArgumentException{
		  
	  }
	  
	  public ProjectInterconnection createProjectInterconnectionReport(User u) throws IllegalArgumentException{
		  
	  }
	  
	  public FanInFanOut createFanInFanOutReport(User u) throws IllegalArgumentException{
		  
	  }
	  
	
}
