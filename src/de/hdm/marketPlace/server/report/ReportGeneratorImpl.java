package de.hdm.marketPlace.server.report;

import java.util.Date;
//import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.Vector;

import de.hdm.marketPlace.shared.MarketplaceAdministration;
import de.hdm.marketPlace.shared.ReportGenerator;
import de.hdm.marketPlace.shared.bo.*;
import de.hdm.marketPlace.shared.report.*;


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
	
	protected MarketplaceAdministration getMarketplaceAdministration() {
		    return this.administration;
		  }

	  
	public void setProjectMarketplace(ProjectMarketplace m) { //muss der marketplace gesetzt werden??
		    this.administration.setMarketplace(m); // Methode fehlt noch in der Administration Klasse
		  }
		   
		  
		  
	protected void addImprint(Report r) { //Impressumsdaten anpassen + bank durch ProjectMarketplace ersetzen
			 
			    ProjectMarketplace projectMarketplace = this.administration.getMarketplace(); //warum User als Übergabewert??
			    CompositeParagraph imprint = new CompositeParagraph(); //getter fehlt noch in Administration Klasse

			    imprint.addSubParagraph(new SimpleParagraph(projectMarketplace.getName()));
			    // Mehr Information darstellen??

			    r.setImprint(imprint);

			  }
	
	
	// ALLE noch mit entsprechendem Code zum erzeugen der einzelnen Reportss
	
	  public AllTenders createAllTendersReport(ProjectMarketplace m) throws IllegalArgumentException{
		  
		  if(this.getMarketplaceAdministration() == null)
			  return null;
		  
		  AllTenders result = new AllTenders(); //Leerer Report
		  
		  result.setTitle("All Tenders on Marketplace");
		  
		  this.addImprint(result);
		  
		  result.setCreated(new Date());
		  
		  CompositeParagraph header = new CompositeParagraph();
		  
		  header.addSubParagraph(new SimpleParagraph("Marketplace: " + m.getName()));
		  
		  result.setHeaderData(header);
		  
		  
		  
		  Row headline = new Row(); //Erste Reihe in dem report (Bezeichnungen)
		  
		  headline.addColumn(new Column("TenderName"));
		  headline.addColumn(new Column("TenderText"));
		  
		  result.addRow(headline);
		  
		  Vector<Tender> allTenders = this.administration.geTaLLtender(); //Hier passende Methode ändern
		  
		  }
		  
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
