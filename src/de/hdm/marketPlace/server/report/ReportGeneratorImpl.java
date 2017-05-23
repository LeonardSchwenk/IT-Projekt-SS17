package de.hdm.marketPlace.server.report;

import java.util.Date;
//import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.Vector;

import de.hdm.marketPlace.server.MarketplaceAdministrationImpl;
import de.hdm.marketPlace.shared.MarketplaceAdministration;
import de.hdm.marketPlace.shared.ReportGenerator;
import de.hdm.marketPlace.shared.bo.*;
import de.hdm.marketPlace.shared.report.*;



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
		  
		  result.addRow(headline);
		  
		  Vector<Tender> allTenders = this.administration.getAllTender(m); 
		  
		  for(Tender t : allTenders){
			  
			  Row tenderRow = new Row();
			  
			 tenderRow.addColumn(new Column(t.getName()));
			 tenderRow.addColumn(new Column(t.getText()));
			 
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
		  
		  Vector<Tender> allTenders = this.administration.getTenderMatch(u);
		  
		  for(Tender t : allTenders){
			  
			  Row tenderRow = new Row();
			  
			  tenderRow.addColumn(new Column(t.getName()));
				 tenderRow.addColumn(new Column(t.getText()));
				 tenderRow.addColumn(new Column(administration.getProjectById(t.getProjectRef()).getName()));
			 
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
		  
		  header.addSubParagraph(new SimpleParagraph("Tender: " + t.getName()));
		  header.addSubParagraph(new SimpleParagraph("Project: " + administration.getProjectById(t.getProjectRef()).getName()));
		  
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
			 applicationRow.addColumn(new Column(administration.getUserById(a.getUserRef()).getName()));
			 applicationRow.addColumn(new Column(a.getText()));
			 applicationRow.addColumn(new Column(administration.getRatingById(a.getRatingRef()).getRate()));

			 
			 result.addRow(applicationRow);
		  }
		  
		  return result;
		  
	  }

	  public AllApplicationsOfUser createAllApplicationsOfUserReport(User u) throws IllegalArgumentException{
		  
		  if(this.getMarketplaceAdministration() == null)
			  return null;
		  
		  AllApplicationsOfUser result = new AllApplicationsOfUser(); //Leerer Report
		  
		  result.setTitle("All Applications of User");
		  
		  this.addImprint(result);
		  
		  result.setCreated(new Date());
		  
		  CompositeParagraph header = new CompositeParagraph();
		  
		  header.addSubParagraph(new SimpleParagraph("User: " + u.getName()));
		  
		  result.setHeaderData(header);
		  
		  
		  
		  Row headline = new Row(); //Erste Reihe in dem report (Bezeichnungen)
		  
		  headline.addColumn(new Column("Titel"));
		  headline.addColumn(new Column("ApplicationText"));
		  headline.addColumn(new Column("Rating"));
		  headline.addColumn(new Column("Tender"));
		  
		  result.addRow(headline);
		  
		  Vector<Application> allApplications = this.administration.getAllApplicationsOfUser(u);
		  
		  for(Application a : allApplications){
			  
			  Row applicationRow = new Row();
			  
			 applicationRow.addColumn(new Column(a.getTitel()));
			 applicationRow.addColumn(new Column(a.getText())); 
			 applicationRow.addColumn(new Column(administration.getRatingById(a.getRatingRef()).getRate()));
			 applicationRow.addColumn(new Column(administration.getTenderById(a.getTenderRef()).getName()));
			 
			 result.addRow(applicationRow);
		  }
		  
		  return result;
		  
		  
	  }
	  
	  public ParticipationsOfUser createParticipationsOfUserReport(User u) throws IllegalArgumentException{
		  
		  if(this.getMarketplaceAdministration() == null)
			  return null;
		  
		 
		  ParticipationsOfUser result = new ParticipationsOfUser(); //Leerer Report
		  
		  result.setTitle("All Participations of User");
		  
		  this.addImprint(result);
		  
		  result.setCreated(new Date());
		  
		  CompositeParagraph header = new CompositeParagraph();
		  
		  header.addSubParagraph(new SimpleParagraph("User: " + u.getName()));
		  
		  result.setHeaderData(header);
		  
		  
		  
		  Row headline = new Row(); //Erste Reihe in dem report (Bezeichnungen)
		  
		  headline.addColumn(new Column("ProjectName"));
		  headline.addColumn(new Column("WorkingDays"));
		  headline.addColumn(new Column("StartDate"));
		  headline.addColumn(new Column("EndDate"));
		  
		  result.addRow(headline);
		  
		  Vector<Participation> allParticipations = this.administration.getAllParticipationsOfUser(u);
		  
		  for(Participation a : allParticipations){
			  
			  Row participationRow = new Row();
			  
			  participationRow.addColumn(new Column(administration.getProjectById(a.getProjectRef()).getName()));
			  participationRow.addColumn(new Column(a.getWorkingDays())); 
			  participationRow.addColumn(new Column(a.DateToString(a.getStartDate())));
			  participationRow.addColumn(new Column(a.DateToString(a.getEndDate())));
			 
			 result.addRow(participationRow);
		  }
		  
		  return result;
		  
	  }
	
	  public ProjectInterconnection createProjectInterconnectionReport(User u) throws IllegalArgumentException{
		  
		  if(this.getMarketplaceAdministration() == null)
			  return null;

		  ProjectInterconnection result = new ProjectInterconnection();

		    result.setTitle("ProjectInterconnection of User");

		    this.addImprint(result);

		    result.setCreated(new Date());

		    
		    result.addSubReport(this.createAllApplicationsOfUserReport(u));
		    result.addSubReport(this.createParticipationsOfUserReport(u));
		    

		    return result;
		  
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
			 
			 Date now = new Date();
			 
			 int dateInt = administration.getTenderById(a.getTenderRef()).getEndDate().compareTo(now);
					 
			 Participation p = null;
			 p = this.administration.getParticipationByRatingId(a.getRatingRef()); //Methode noch in Administration erstellen
			 
			 if(p != null){
					 status = "Accepted";
				 
				 }
			 
				 else if(dateInt >0){
					 status = "Going on";
				 }
				 
				 else {
					 status = "Rejected";
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
		  
		  Vector<Tender> allTenders = this.administration.getAllTenderOfUser(u);
		  
		  int Counter1 = 1;
		  
		  
		  for(Tender t : allTenders){
			  
			  Row tenderRow = new Row();
			  
			 String s1 = String.valueOf(Counter1);
			 
			 String status1 = null;
			 
			 Date now1 = new Date();
			 
			 int dateInt1 = t.getEndDate().compareTo(now1);
					 
			 Participation part1 = administration.getParticipationByTenderId(t.getId());
			 
			 
			 if(part1 != null){
				 status1 = "Job Successfully filled";
			 
			 }
		 
			 else if(dateInt1 > 0 && part1 == null){
				 status1 = "Going on";
			 }
			 
			 else {
				 status1 = "Rejected";
			 }
			 
			 tenderRow.addColumn(new Column(s1));
			 tenderRow.addColumn(new Column(t.getText())); 
			 tenderRow.addColumn(new Column(status1));
			 
			Counter++;
			 
			 result1.addRow(tenderRow);
		  }
		  
		  return result1;
		  
	  }
	  
	  
	  public FanInFanOut createFanInFanOutReport() throws IllegalArgumentException{
		  
		  if(this.getMarketplaceAdministration() == null)
			  return null;

		  FanInFanOut result = new FanInFanOut();

		    result.setTitle("FanInOut Analyse of all Users");

		    this.addImprint(result);

		    result.setCreated(new Date());

		    Vector<User> allUsers = this.administration.getAllUser();

		    for (User u : allUsers) {
		   
		      result.addSubReport(this.createFanInFanOutByUserReport(u));
		    }

		    return result;
		  
	  }
	  
	
}
