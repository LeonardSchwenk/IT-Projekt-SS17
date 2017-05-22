package de.hdm.marketPlace.server.report;

import java.util.Date;
//import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.Vector;

import de.hdm.marketPlace.shared.MarketplaceAdministration;
import de.hdm.marketPlace.shared.ReportGenerator;
import de.hdm.marketPlace.shared.bo.*;
import de.hdm.marketPlace.shared.report.*;
import de.hdm.thies.bankProjekt.shared.bo.Customer;
import de.hdm.thies.bankProjekt.shared.report.AllAccountsOfAllCustomersReport;


public class ReportGeneratorImpl extends RemoteServiceServlet implements ReportGenerator{ //Wo findet sich RemotService Servlet??

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
		  
		  Vector<Application> allApplications = this.administration.getAllApplicationsByTender(t); //Andern
		  
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
		  
		  if(this.getMarketplaceAdministration() == null)
			  return null;
		  
		  ProjectInterconnection result1 = new ProjectInterconnection(); //Leerer Report
		  
		  result1.setTitle("All Applications of User");
		  
		  this.addImprint(result1);
		  
		  result1.setCreated(new Date());
		  
		  CompositeParagraph header = new CompositeParagraph();
		  
		  header.addSubParagraph(new SimpleParagraph("Marketplace: " + m.getName())); //Muss bei jedem Report der marketplace gewählt werden??
		  header.addSubParagraph(new SimpleParagraph("User: " + u.getName()));
		  
		  result1.setHeaderData(header);
		  
		  
		  
		  Row headline = new Row(); //Erste Reihe in dem report (Bezeichnungen)
		  
		  headline.addColumn(new Column("ApplicationTitel"));
		  headline.addColumn(new Column("ApplicationText"));
		  headline.addColumn(new Column("TenderTitle"));
		  
		  result1.addRow(headline);
		  
		  Vector<Application> allApplications = this.administration.getAllApplicationsOfUser(u);
		  
		  for(Application a : allApplications){
			  
			  Row applicationRow = new Row();
			  
			 applicationRow.addColumn(new Column(a.getTitel()));
			 applicationRow.addColumn(new Column(a.getText())); 
			 applicationRow.addColumn(new Column(a.getTenderRef())); // Methode fehlt noch
			 
			 result1.addRow(applicationRow);
		  }
		  
		  return result1;
		  
		  
ProjectInterconnection result2 = new ProjectInterconnection(); //Leerer Report
		  
		  result2.setTitle("All Participations of User");
		  
		  this.addImprint(result2);
		  
		  result2.setCreated(new Date());
		  
		  CompositeParagraph header2 = new CompositeParagraph();
		  
		  header2.addSubParagraph(new SimpleParagraph("Marketplace: " + m.getName())); //Muss bei jedem Report der marketplace gewählt werden??
		  header2.addSubParagraph(new SimpleParagraph("User: " + u.getName()));
		  
		  result2.setHeaderData(header2);
		  
		  
		  
		  Row headline2 = new Row(); //Erste Reihe in dem report (Bezeichnungen)
		  
		  headline2.addColumn(new Column("ProjectName"));
		  headline2.addColumn(new Column("WorkingDays"));
		  headline2.addColumn(new Column("TenderTitle"));
		  
		  result2.addRow(headline);
		  
		  Vector<Participation> allParticipations = this.administration.getAllParticipationsOfUser(u);
		  
		  for(Participation a : allParticipations){
			  
			  Row participationRow = new Row();
			  
			  participationRow.addColumn(new Column(administration.getProjectName(a.getProjectRef())));
			  participationRow.addColumn(new Column(a.getWorkingDays())); 
			  participationRow.addColumn(new Column(administration.getRatingbyId(a.getRatingRef().getRate()))); // Methode fehlt noch
			 
			 result2.addRow(participationRow);
		  }
		  
		  return result2;
		  
	  }
	
	  public FanInFanOutByUser createFanInFanOutByUserReport(User u)throws IllegalArgumentException{ // NICHT OBJEKT SONDERN NUR REFERENZ
		  
		  if(this.getMarketplaceAdministration() == null)
			  return null;
		  
		  FanInFanOutByUser result = new FanInFanOutByUser(); //Leerer Report
		  
		  result.setTitle("Applications");
		  
		  this.addImprint(result);
		  
		  result.setCreated(new Date());
		  
		  CompositeParagraph header = new CompositeParagraph();
		  
		  header.addSubParagraph(new SimpleParagraph("User: " + u.getName()));
		  
		  result.setHeaderData(header);
		  
		  
		  
		  Row headline = new Row(); //Erste Reihe in dem report (Bezeichnungen)
		  
		  headline.addColumn(new Column("Anzahl"));
		  headline.addColumn(new Column("ApplicationTitle"));
		  headline.addColumn(new Column("ApplicationStatus"));
		  
		  
		  result.addRow(headline);
		  
		  Vector<Application> allApplications = this.administration.getAllApplicationsOfUser(u);
		  
		  int Counter = 1;
		  
		  for(Application a : allApplications){
			  
			  Row applicationRow = new Row();
			  
			 String s = String.valueOf(Counter);
			 
			 String status = null;
			 
			 Vector<Participation> allParticipations = this.administration.getAllParticipationsOfUser(u);
			 
			 for(Participation p : allParticipations){
			 
				 if(p.getRatingRef() == a.getRatingRef()){
					 status = "Accepted";
				 
			 }
				 else if(){
					 
				 }
				 
			 }
			 applicationRow.addColumn(new Column(s));
			 applicationRow.addColumn(new Column(a.getText())); 
			 applicationRow.addColumn(new Column(status));
			 
			Counter++;
			 
			 result.addRow(applicationRow);
		  }
		  
		  return result;
		  
 FanInFanOutByUser result1 = new FanInFanOutByUser(); //Leerer Report
		  
		  result1.setTitle("Tenders");
		  
		  this.addImprint(result1);
		  
		  result1.setCreated(new Date());
		  
		  CompositeParagraph header1 = new CompositeParagraph();
		  
		  header1.addSubParagraph(new SimpleParagraph("User: " + u.getName()));
		  
		  result1.setHeaderData(header1);
		  
		  
		  
		  Row headline1 = new Row(); //Erste Reihe in dem report (Bezeichnungen)
		  
		  headline1.addColumn(new Column("Anzahl"));
		  headline1.addColumn(new Column("TenderTitle"));
		  headline1.addColumn(new Column("TenderStatus"));
		  
		  
		  result1.addRow(headline1);
		  
		  Vector<Tender> allTenders = this.administration.getAllTenderByUser(u);
		  
		  int Counter1 = 1;
		  
		  for(Tender a : allTenders){
			  
			  Row applicationRow1 = new Row();
			  
			 String s1 = String.valueOf(Counter1);
			 
			 applicationRow1.addColumn(new Column(s1));
			 applicationRow1.addColumn(new Column(a.getText())); 
			 applicationRow1.addColumn(new Column(administration.getRatingbyId(a.getRatingRef().getRate()))); // Methode fehlt noch
			 
			Counter++;
			 
			 result1.addRow(applicationRow1);
		  }
		  
		  return result1;
		  
	  }
	  
	  
	  public FanInFanOut createFanInFanOutReport() throws IllegalArgumentException{
		  
		  if(this.getMarketplaceAdministration() == null)
			  return null;

		  FanInFanOut result = new FanInFanOut();

		    result.setTitle("FanInOut Analyse");

		    this.addImprint(result);

		    result.setCreated(new Date());

		    Vector<User> allUsers = this.administration.getAllUser();

		    for (User c : allUsers) {
		   
		      result.addSubReport(this.createFanInFanOutByUserReport(c));
		    }

		    return result;
		  
	  }
	  
	
}
