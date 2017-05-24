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

	  
	public void setProjectMarketplace(User u, ProjectMarketplace m) { //muss der marketplace gesetzt werden??
		    this.administration.joinMarketplace(u.getId(), m.getId()); 
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
		  header.addSubParagraph(new SimpleParagraph("Name: " + u.getLastname() +", " + u.getFirstname()));
		  
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
			  
			 applicationRow.addColumn(new Column(a.getName())); 
			 applicationRow.addColumn(new Column(administration.getUserById(a.getUserRef()).getLastname() + administration.getUserById(a.getUserRef()).getFirstname()));
			 applicationRow.addColumn(new Column(a.getText()));
			 applicationRow.addColumn(new Column(administration.getRatingByApplicationRef(a.getId()).getRate()));

			 
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
		  
		  header.addSubParagraph(new SimpleParagraph("Name: " + u.getLastname() +", " + u.getFirstname()));
		  
		  result.setHeaderData(header);
		  
		  
		  
		  Row headline = new Row(); //Erste Reihe in dem report (Bezeichnungen)
		  
		  headline.addColumn(new Column("Titel"));
		  headline.addColumn(new Column("ApplicationText"));
		  headline.addColumn(new Column("Rating"));
		  headline.addColumn(new Column("Tender"));
		  
		  result.addRow(headline);
		  
		  Vector<Application> allApplications = this.administration.getAllApplicationsByUserRef(u.getId());
		  
		  for(Application a : allApplications){
			  
			  Row applicationRow = new Row();
			  
			 applicationRow.addColumn(new Column(a.getName()));
			 applicationRow.addColumn(new Column(a.getText())); 
			 applicationRow.addColumn(new Column(administration.getRatingByApplicationRef(a.getId()).getRate()));
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
		  
		  header.addSubParagraph(new SimpleParagraph("Name: " + u.getLastname()+", "  + u.getFirstname()));
		  
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
		  
	  
	  
	  public ApplicationStatus createApplicationStatusReport(User u) throws IllegalArgumentException {
		  
		  if(this.getMarketplaceAdministration() == null)
			  return null;
		  
		  ApplicationStatus result = new ApplicationStatus(); //Leerer Report
		  
		  result.setTitle("ApplicationStatus");
		  
		  this.addImprint(result);
		  
		  result.setCreated(new Date());
		  
		  CompositeParagraph header = new CompositeParagraph();
		  
		  header.addSubParagraph(new SimpleParagraph("Name: " + u.getLastname()+", "  + u.getFirstname()));
		  
		  result.setHeaderData(header);
		  
		  
		  
		  Row headline = new Row(); //Erste Reihe in dem report (Bezeichnungen)
		  
		  headline.addColumn(new Column("Anzahl"));
		  headline.addColumn(new Column("ApplicationTitle"));
		  headline.addColumn(new Column("ApplicationStatus"));
		  
		  
		  result.addRow(headline);
		  
		  Vector<Application> allApplications = this.administration.getAllApplicationsByUserRef(u.getId());
		  		  
		  int Counter = 1;
		  
		  for(Application a : allApplications){
			  
			  Row applicationRow = new Row();
			  
			 String s = String.valueOf(Counter);
			 
			 String status = null;
			 
			 Date now = new Date();
			 
			 int dateInt = administration.getTenderById(a.getTenderRef()).getEndDate().compareTo(now);
					 
			 Participation p = null;
			 p = this.administration.getParticipationByRatingId(administration.getRatingByApplicationRef(a.getId())); //Methode noch in Administration erstellen
			 
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
		  
	  }
		  
		  // ----------------------------------------------------------------------------------
	  
	  public TenderStatus createTenderStatusReport(User u) throws IllegalArgumentException{
		  
		  if(this.getMarketplaceAdministration() == null)
			  return null;
		  
		  TenderStatus result = new TenderStatus(); //Leerer Report
		  
		  result.setTitle("TenderStatus");
		  
		  this.addImprint(result);
		  
		  result.setCreated(new Date());
		  
		  CompositeParagraph header = new CompositeParagraph();
		  
		  header.addSubParagraph(new SimpleParagraph("Name: " + u.getLastname()+", "  + u.getFirstname()));
		  
		  result.setHeaderData(header);
		  
		  
		  
		  Row headline = new Row(); //Erste Reihe in dem report (Bezeichnungen)
		  
		  headline.addColumn(new Column("Anzahl"));
		  headline.addColumn(new Column("TenderTitle"));
		  headline.addColumn(new Column("TenderStatus"));
		  
		  
		  result.addRow(headline);
		  
		  Vector<Tender> allTenders = this.administration.getAllTenderOfUser(u);
		  
		  int Counter = 1;
		  
		  
		  for(Tender t : allTenders){
			  
			  Row tenderRow = new Row();
			  
			 String s = String.valueOf(Counter);
			 
			 String status = null;
			 
			 Date now = new Date();
			 
			 int dateInt = t.getEndDate().compareTo(now);
					 
			 Participation part = administration.getParticipationByTenderId(t.getId());
			 
			 
			 if(part != null){
				 status = "Job Successfully filled";
			 
			 }
		 
			 else if(dateInt > 0 && part == null){
				 status = "Going on";
			 }
			 
			 else {
				 status = "Rejected";
			 }
			 
			 tenderRow.addColumn(new Column(s));
			 tenderRow.addColumn(new Column(t.getText())); 
			 tenderRow.addColumn(new Column(status));
			 
			Counter++;
			 
			 result.addRow(tenderRow);
		  }
		  
		  return result;
		  
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
		   
		      result.addSubReport(this.createApplicationStatusReport(u));
		      result.addSubReport(this.createTenderStatusReport(u));
		    }

		    return result;
		  
	  }


	
}
