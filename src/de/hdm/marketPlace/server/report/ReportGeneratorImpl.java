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
		    this.administration.setMarketplace(m); 
		  }
		   
		  
		  
	protected void addImprint(Report r) { //Impressumsdaten anpassen + bank durch ProjectMarketplace ersetzen
			 
			    ProjectMarketplace projectMarketplace = this.administration.getMarketplace(); 
			    CompositeParagraph imprint = new CompositeParagraph();

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
		  headline.addColumn(new Column("TenderProfil"));
		  
		  result.addRow(headline);
		  
		  Vector<Tender> allTenders = this.administration.getAllTender(m); 
		  
		  for(Tender t : allTenders){
			  
			  Row tenderRow = new Row();
			  
			 tenderRow.addColumn(new Column(t.getName()));
			 tenderRow.addColumn(new Column(t.getText()));
			 tenderRow.addColumn(new Column(administration.getProjectName(t.getProjectRef()))); 
			 
			 result.addRow(tenderRow);
		  }
		  
		  return result;
		  
	  }
		  
	  public TendersMatchProfil createTendersMatchProfilReport(ProjectMarketplace m, User u) throws IllegalArgumentException{
		  
		  if(this.getMarketplaceAdministration() == null)
			  return null;
		  
		  TendersMatchProfil result = new TendersMatchProfil(); //Leerer Report
		  
		  result.setTitle("Tenders which match my Profil on Marketplace");
		  
		  this.addImprint(result);
		  
		  result.setCreated(new Date());
		  
		  CompositeParagraph header = new CompositeParagraph();
		  
		  header.addSubParagraph(new SimpleParagraph("Marketplace: " + m.getName()));
		  header.addSubParagraph(new SimpleParagraph("Name: " + u.getName()));
		  
		  result.setHeaderData(header);
		  
		  
		  
		  Row headline = new Row(); //Erste Reihe in dem report (Bezeichnungen)
		  
		  headline.addColumn(new Column("TenderName"));
		  headline.addColumn(new Column("TenderText"));
		  headline.addColumn(new Column("Project"));
		  
		  result.addRow(headline);
		  
		  Vector<Tender> allTenders = this.administration.getTenderMatch(u); //Hier passende Methode ändern
		  
		  for(Tender t : allTenders){
			  
			  Row tenderRow = new Row();
			  
			  tenderRow.addColumn(new Column(t.getName()));
				 tenderRow.addColumn(new Column(t.getText()));
				 tenderRow.addColumn(new Column(administration.getProjectName(t.getProjectRef())));
			 
			 result.addRow(tenderRow);
		  }
		  
		  return result;
		  
	  }
	  
	  public AllApplicationsOnTender createAllApplicationsOnTenderReport(Tender t) throws IllegalArgumentException{
		  
		  if(this.getMarketplaceAdministration() == null)
			  return null;
		  
		  AllApplicationsOnTender result = new AllApplicationsOnTender(); //Leerer Report
		  
		  result.setTitle("All Applications on Tender");
		  
		  this.addImprint(result);
		  
		  result.setCreated(new Date());
		  
		  CompositeParagraph header = new CompositeParagraph();
		  
		  header.addSubParagraph(new SimpleParagraph("Marketplace: " + m.getName())); //Muss bei jedem Report der marketplace gewählt werden??
		  header.addSubParagraph(new SimpleParagraph("Tender: " + t.getName()));
		  
		  result.setHeaderData(header);
		  
		  
		  
		  Row headline = new Row(); //Erste Reihe in dem report (Bezeichnungen)
		  
		  headline.addColumn(new Column("Titel"));
		  headline.addColumn(new Column("UserName"));
		  headline.addColumn(new Column("ApplicationText"));
		  headline.addColumn(new Column("Rating"));
		  
		  result.addRow(headline);
		  
		  Vector<Application> allApplications = this.administration.getAllApplicationsByTender(t); 
		  
		  for(Application a : allApplications){
			  
			  Row applicationRow = new Row();
			  
			 applicationRow.addColumn(new Column(a.getTitel())); 
			 applicationRow.addColumn(new Column(a.getUserRef())); //Hier noch UserName finden
			 applicationRow.addColumn(new Column(a.getText()));
			 applicationRow.addColumn(new Column(a.getRatingRef())); //RatingRef muss noch in String umgewandelt werden

			 
			 result.addRow(applicationRow);
		  }
		  
		  return result;
		  
	  }

	  public AllApplicationsOfUser createAllApplicationsOfUserReport(ProjectMarketplace m, User u) throws IllegalArgumentException{
		  
		  if(this.getMarketplaceAdministration() == null)
			  return null;
		  
		  AllApplicationsOfUser result = new AllApplicationsOfUser(); //Leerer Report
		  
		  result.setTitle("All Applications of User");
		  
		  this.addImprint(result);
		  
		  result.setCreated(new Date());
		  
		  CompositeParagraph header = new CompositeParagraph();
		  
		  header.addSubParagraph(new SimpleParagraph("Marketplace: " + m.getName())); //Muss bei jedem Report der marketplace gewählt werden??
		  header.addSubParagraph(new SimpleParagraph("User: " + u.getName()));
		  
		  result.setHeaderData(header);
		  
		  
		  
		  Row headline = new Row(); //Erste Reihe in dem report (Bezeichnungen)
		  
		  headline.addColumn(new Column("Titel"));
		  headline.addColumn(new Column("ApplicationText"));
		  headline.addColumn(new Column("Rating"));
		  
		  result.addRow(headline);
		  
		  Vector<Application> allApplications = this.administration.getAllApplicationsOfUser(u);
		  
		  for(Application a : allApplications){
			  
			  Row applicationRow = new Row();
			  
			 applicationRow.addColumn(new Column(a.getTitel()));
			 applicationRow.addColumn(new Column(a.getText())); 
			 applicationRow.addColumn(new Column(a.getRatingRef())); // Methode fehlt noch
			 
			 result.addRow(applicationRow);
		  }
		  
		  return result;
		  
		  
	  }
	  
	  public ProjectInterconnection createProjectInterconnectionReport(User u) throws IllegalArgumentException{
		  
	  }
	  
	  public FanInFanOut createFanInFanOutReport(User u) throws IllegalArgumentException{
		  
	  }
	  
	
}
