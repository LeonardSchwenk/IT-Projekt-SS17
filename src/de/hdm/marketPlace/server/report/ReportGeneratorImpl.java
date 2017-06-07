package de.hdm.marketPlace.server.report;

import java.util.Date;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.Vector;

import de.hdm.marketPlace.server.MarketplaceAdministrationImpl;
import de.hdm.marketPlace.shared.MarketplaceAdministration;
import de.hdm.marketPlace.shared.ReportGenerator;
import de.hdm.marketPlace.shared.bo.*;
import de.hdm.marketPlace.shared.report.*;


/**
 *  Erzeugt später die fertigen Reports und gibt sich mit Hilfe der tabellen aus
 */

public class ReportGeneratorImpl extends RemoteServiceServlet implements ReportGenerator{ //Wo findet sich RemotService Servlet??

	/**
	 * Attribute der Klasse
	 */
	
	/**
	 * Administrations Variable die für die Reports benötigt wird
	 */
	private MarketplaceAdministration administration = null;
	
	/**
	 * Null Konstruktor der Klasse
	 * @throws IllegalArgumentException
	 */
	public ReportGeneratorImpl() throws IllegalArgumentException {
	  }
	
	/**
	 * 
	 */
	public void init() throws IllegalArgumentException {
		  
		    /*
		     * Neues MarketplaceAdministrationImpl Objekt wird erzeugt
		     */
		    MarketplaceAdministrationImpl a = new MarketplaceAdministrationImpl();  //Passende Klasse fehlt noch
		    /*
		     * Aufruf der init() Methode durch das neu erstellte Objekt
		     */
		    a.init();
		    /*
		     * administration Variable werden die Attribute von dem neu erzeugtem Objekt zugewiesen
		     */
		    this.administration = a;
		  }
	
	/**
	 * Ausgabe der adminstration Variable
	 * @return administration Variable des Datentyps MarketplaceAdministration
	 */
	protected MarketplaceAdministration getMarketplaceAdministration() {
		    return this.administration;
		  }

	
	/**
	 * Setzen des Projektmarktplatzes
	 * @param u
	 * @param m
	 */
	public void setProjectMarketplace(User u, ProjectMarketplace m) { //muss der marketplace gesetzt werden??
		
		this.administration.joinMarketplace(u.getId(), m.getId()); 
		  }
		   
		  
	/**
	 * Einem Report wird ein Impressum hinzugefügt	  
	 * @param r
	 */
	protected void addImprint(Report r) { //Impressumsdaten anpassen + bank durch ProjectMarketplace ersetzen
			 
				/*
				 * 
				 */
			    // ProjectMarketplace projectMarketplace = this.administration.getMarketplace(); 
			    
			    /*
			     * ein neues Impressums Objekt wird erstellt
			     */
			    CompositeParagraph imprint = new CompositeParagraph();

			    /*
			     * 
			     */
			    //imprint.addSubParagraph(new SimpleParagraph(projectMarketplace.getName()));
			    // Mehr Information darstellen??

			    /*
			     * Dem Report r wird das erzeugte Impressum hinzugefügt
			     */
			    r.setImprint(imprint);

			  }
	
	
	// ALLE noch mit entsprechendem Code zum erzeugen der einzelnen Reports
	
	  /**
	   * Erstellen eines Reports, welcher alle Ausschreibungen eines Marktplatzes ausgibt
	   * @param m
	   * @throws IllegalArgumentException
	   * @return Fehlermeldung wenn keine Ausschreibungen vorhanden
	   * @return Fertiger Report
	   */
	  public AllTenders createAllTendersReport() throws IllegalArgumentException{
		  
		  /*
		   * Überprüfung ob der übergebene Marktplatz vorhanden ist beziehungsweise Ausschreibungen erhält
		   */
		  if(this.getMarketplaceAdministration() == null)
			  return null;
		  
		  /*
		   * Ein leerer Report wird erzeugt
		   */
		  AllTenders result = new AllTenders(); //Leerer Report
		  
		  /*
		   * Dem Report wird ein Titel hinzugefügt
		   */
		  result.setTitle("All Tenders on Marketplace");
		  
		  /*
		   * Dem Report wird ein Impressum hinzugefügt
		   */
		  this.addImprint(result);
		  
		  /*
		   * Dem Report wird ein Erstellungsdatum hinzugefügt
		   */
		  result.setCreated(new Date());
		  
		  /*
		   * Erstellung der Kopfdaten
		   */
		  CompositeParagraph header = new CompositeParagraph();
		  
		  /*
		   * Inhalt der Kopfdaten
		   */
		  header.addSubParagraph(new SimpleParagraph("Marketplace: " ));
		  
		  /*
		   * Header Daten dem Report hinzufügen
		   */
		  result.setHeaderData(header);
		  
		  
		  /*
		   * Erzeugen der ersten Reihe des Reports
		   */
		  Row headline = new Row(); //Erste Reihe in dem report (Bezeichnungen)
		  
		  /*
		   * Die Reihe erhält die Spalten Name der Ausschreibung und den den Text, da Report in Tabellen Form ausgegeben wird
		   */
		  headline.addColumn(new Column("TenderName"));
		  headline.addColumn(new Column("TenderText"));
		  
		  /*
		   * weitere Reihe wird angefügt
		   */
		  result.addRow(headline);
		  
		  /*
		   * In einem Vector der aus Ausschreibungsobjekten bestehen soll werden die Ausschreibungen
		   * des übergeben Marktplatzes m gespeichert
		   */
		  Vector<Tender> allTenders = this.administration.getAllTender();
		  
		  /*
		   * der Vector wird durchsucht wobei jeder Durchgang die Werte in t speichert
		   */
		  for(Tender t : allTenders){
			  
			  /*
			   * Bei jedem Durchlauf wird eine neue Reihe erzeugt
			   */
			  Row tenderRow = new Row();
			 
			  /*
			   * Der neuen Reihe tenderRow werden die ausgelesenen Werte den jeweiligen Spalten hinzugefügt
			   */
			 tenderRow.addColumn(new Column(t.getName()));
			 tenderRow.addColumn(new Column(t.getText()));
			 
			 /*
			  * Dem Report wird die neue beschriebene Reihe hinzugefügt
			  */
			 result.addRow(tenderRow);
		  }
		  
		  /*
		   * Der fertige Report wird zurückgegeben
		   */
		  return result;
		  
	  }
	
	  /**
	   * Erstellen eines Reports, welcher alle Ausschreibungen auf einem Marktplatz ausgibt, die zu dem User passen
	   * @param m
	   * @param u
	   * @throws IllegalArgumentException
	   * @return Fehlermeldung wenn Marktplatz Administration nicht vorhanden
	   * @return Der fertige Report
	   */
	  public TendersMatchProfil createTendersMatchProfilReport(User u) throws IllegalArgumentException{
		  
		  /*
		   * Überprüfung ob MarktplatzAdministration vorhanden
		   */
		  if(this.getMarketplaceAdministration() == null)
			  return null;
		  
		  /*
		   * Leerer Report wird erstellt
		   */
		  TendersMatchProfil result = new TendersMatchProfil(); //Leerer Report
		  
		  /*
		   * Der Report erhält einen Titel
		   */
		  result.setTitle("Tenders which match my Profil on Marketplace");
		  
		  /*
		   * Dem Report wird ein Impressum hinzugefügt
		   */
		  this.addImprint(result);
		  
		  /*
		   * Dem Report wird ein Erstellungsdatum hinzugefügt
		   */
		  result.setCreated(new Date());
		  
		  /*
		   * Ein neuer Header wird angelegt 
		   */
		  CompositeParagraph header = new CompositeParagraph();
		  
		  /*
		   * Dem Header werden zwei unter Abschnitte hinzugefügt
		   * Der Erste trägt die Daten des übergebenen Marktplatzes
		   * Der Zweite trägt die Daten des Users der den Report abfrägt
		   */
		  header.addSubParagraph(new SimpleParagraph("Marketplace: "));
		  header.addSubParagraph(new SimpleParagraph("Name: " + u.getLastname() +", " + u.getFirstname()));
		  
		  /*
		   * Dem Report wird der Header hinzugefügt
		   */
		  result.setHeaderData(header);
		  
		  
		  /*
		   * Die erste Reihe des Reports wird erzeugt welche als Tabellen Überschriften dienen
		   */
		  Row headline = new Row(); //Erste Reihe in dem report (Bezeichnungen)
		  
		  /*
		   * Der Erste Reihe werden drei Spalten hinzugefügt die als Tabellen Überschriften dienen
		   */
		  headline.addColumn(new Column("TenderName"));
		  headline.addColumn(new Column("TenderText"));
		  headline.addColumn(new Column("Project"));
		  
		  /*
		   * Dem Report wird die erste Reihe hinzugefügt
		   */
		  result.addRow(headline);
		  
		  /*
		   * Einem Vector der nur aus Ausschreibungsobjekten bestehen soll werden
		   * die Ausschreibungs Matches des übergebenen Users s zugewiesen
		   */
		  Vector<Tender> allTenders = this.administration.getAllTendersByMatch(u.getId());
		  
		  /*
		   * der Vector wird durchsucht wobei jeder Durchgang die Werte in t speichert
		   */
		  for(Tender t : allTenders){
			  
			  /*
			   * Bei jedem Durchlauf wird eine neue Reihe erzeugt
			   */
			  Row tenderRow = new Row();
			  
			  /*
			   * Der neuen reihe werden die gespeicherten Werte aus t hinzugefügt
			   */
			  tenderRow.addColumn(new Column(t.getName()));
				 tenderRow.addColumn(new Column(t.getText()));
				 tenderRow.addColumn(new Column(administration.getProjectById(t.getProjectRef()).getName()));
			 
		     /*
		      * dem Report wird die Reihe hinzugefügt
		      */
			 result.addRow(tenderRow);
		  }
		  
		  /*
		   * Der Report wird zurückgegeben
		   */
		  return result;
		  
	  }
	  
	  /**
	   * Erstellen eines Reports, welcher alle Bewerbungen auf eine Ausschreibung ausgibt
	   * @param t
	   * @throws IllegalArgumentException
	   * @return Fehlermeldung wenn Marktplatz Administration nicht vorhanden
	   * @return fertiger Report
	   */
	  public AllApplicationsOnTender createAllApplicationsOnTenderReport(Tender t) throws IllegalArgumentException{
		  
		  /*
		   * Überprüfung ob MarktplatzAdministration vorhanden
		   */
		  if(this.getMarketplaceAdministration() == null)
			  return null;
		  
		  /*
		   * Leerer Report wird erstellt
		   */
		  AllApplicationsOnTender result = new AllApplicationsOnTender(); //Leerer Report
		  
		  /*
		   * Der Report erhält einen Titel
		   */
		  result.setTitle("All Applications on Tender");
		  
		  /*
		   * Dem Report wird ein Impressum hinzugefügt
		   */
		  this.addImprint(result);
		  
		  /*
		   * Dem Report wird ein Erstellungsdatum hinzugefügt	  
		   */
		  result.setCreated(new Date());
		  
		  /*
		   * Ein neuer Header wird angelegt
		   */
		  CompositeParagraph header = new CompositeParagraph();
		  
		  /*
		   * Dem Header werden zwei unter Abschnitte hinzugefügt
		   * Der Erste trägt die Daten der übergebenen Ausschreibung
		   * Der Zweite trägt die Daten des Projektes
		   */
		  header.addSubParagraph(new SimpleParagraph("Tender: " + t.getName()));
		  header.addSubParagraph(new SimpleParagraph("Project: " + administration.getProjectById(t.getProjectRef()).getName()));
		  
		  /*
		   * Dem Report wird der Header hinzugefügt
		   */
		  result.setHeaderData(header);
		  
		  
		  /*
		   * Die erste Reihe des Reports wird erzeugt welche als Tabellen Überschriften dienen
		   */
		  Row headline = new Row(); //Erste Reihe in dem report (Bezeichnungen)
		  
		  /*
		   * Der ersten Reihe werden vier Spalten hnzugefügt
		   * Die erste Spalte trägt den Titel
		   * Die zweite Spalte den User Namen
		   * Die dritte Spalte den Bewerbungstext
		   * Die vierte Spalte die jeweilige Bewertung
		   */
		  headline.addColumn(new Column("Titel"));
		  headline.addColumn(new Column("UserName"));
		  headline.addColumn(new Column("ApplicationText"));
		  headline.addColumn(new Column("Rating"));
		  
		  /*
		   * Dem Report wird die erste Zeile hinzugefügt
		   */
		  result.addRow(headline);
		  
		  /*
		   * Einem Vector der nur aus Bewerbungsobjekten bestehen soll, werden
		   * alle Bewerbungen der zugehörigen übergebenen Ausschreibung, hinzugefügt
		   */
		  Vector<Application> allApplications = this.administration.getAllApplicationsByTenderRef(t.getId());
		  
		  /*
		   * der Vector wird durchsucht wobei jeder Durchgang die Werte in a gespeichert wird
		   */
		  for(Application a : allApplications){
			  
			  /*
			   * Bei jedem Durchlauf wird eine neue Reihe erstellt
			   */
			  Row applicationRow = new Row();
			 
			 /*
			  * Der neuen Reihe werden die gespeichterten Werte aus a hinzugefügt
			  */
			 applicationRow.addColumn(new Column(a.getName())); 
			 applicationRow.addColumn(new Column(administration.getUserById(a.getUserRef()).getLastname() + administration.getUserById(a.getUserRef()).getFirstname()));
			 applicationRow.addColumn(new Column(a.getText()));
			 applicationRow.addColumn(new Column(administration.getRatingsByApplicationRef(a.getId()).getRate()));

			 /*
			  * Die neue Reihe wird dem Report hinzugefügt
			  */
			 result.addRow(applicationRow);
		  }
		  
		  /*
		   * Der fertige Report wird zurückgegeben
		   */
		  return result;
		  
	  }

	  /**
	   * Erstellen eines Reports, welcher alle Bewerbungen eines Users ausgibt
	   * @param u
	   * @throws IllegalArgumentException
	   * @return Fehlermeldung wenn Marktplatz Administration nicht vorhanden
	   * @return fertiger Report
	   */
	  public AllApplicationsOfUser createAllApplicationsOfUserReport(User u) throws IllegalArgumentException{
		  
		  /*
		   * Überprüfung ob MarktplatzAdministration vorhanden
		   */
		  if(this.getMarketplaceAdministration() == null)
			  return null;
		  
		  /*
		   * Leerer Report wird erstellt
		   */
		  AllApplicationsOfUser result = new AllApplicationsOfUser(); //Leerer Report
		  
		  /*
		   * Der Report erhält einen Titel
		   */
		  result.setTitle("All Applications of User");
		  
		  /*
		   * Dem Report wird ein Impressum hinzugefügt
		   */
		  this.addImprint(result);
		  
		  /*
		   * Dem Report wird ein Erstellungsdatum hinzugefügt	  
		   */
		  result.setCreated(new Date());
		  
		  /*
		   * Ein neuer Header wird angelegt
		   */
		  CompositeParagraph header = new CompositeParagraph();
		  
		  /*
		   * Dem Header wird ein unter Abschnitt hinzugefügt
		   * Die Zeile trägt den Namen des übergebenen Users
		   */
		  header.addSubParagraph(new SimpleParagraph("Name: " + u.getLastname() +", " + u.getFirstname()));
		  
		  /*
		   * Dem Report wird der Header hinzugefügt
		   */
		  result.setHeaderData(header);
		  
		  
		  /*
		   * Die erste Reihe des Reports wird erzeugt welche als Tabellen Überschriften dienen
		   */
		  Row headline = new Row(); //Erste Reihe in dem report (Bezeichnungen)
		  
		  /*
		   * Der ersten Reihe werden vier Spalten hnzugefügt
		   * Die erste Spalte trägt den Titel
		   * Die zweite Spalte den Bewerbungstext
		   * Die dritte Spalte die jeweilige Bewertung
		   * Die vierte Spalte die jeweilige Ausschreibung
		   */
		  headline.addColumn(new Column("Titel"));
		  headline.addColumn(new Column("ApplicationText"));
		  headline.addColumn(new Column("Rating"));
		  headline.addColumn(new Column("Tender"));
		  
		  /*
		   * Dem Report wird die erste Zeile hinzugefügt
		   */
		  result.addRow(headline);
		  
		  /*
		   * Einem Vector der nur aus Bewerbungsobjekten bestehen soll, werden
		   * alle Bewerbungen des übergebenen Users, hinzugefügt
		   */
		  Vector<Application> allApplications = this.administration.getAllApplicationsByUserRef(u.getId());
		  
		  /*
		   * der Vector wird durchsucht wobei jeder Durchgang die Werte in a gespeichert wird
		   */
		  for(Application a : allApplications){
			  
			  /*
			   * Bei jedem Durchlauf wird eine neue Reihe erstellt
			   */
			  Row applicationRow = new Row();
			  
			/*
			 * Der neuen Reihe werden die gespeichterten Werte aus a hinzugefügt
			 */
			 applicationRow.addColumn(new Column(a.getName()));
			 applicationRow.addColumn(new Column(a.getText())); 
			 applicationRow.addColumn(new Column(administration.getRatingsByApplicationRef(a.getId()).getRate()));
			 applicationRow.addColumn(new Column(administration.getTenderById(a.getTenderRef()).getName()));
			 
			 /*
			  * Die neue Reihe wird dem Report hinzugefügt
			  */
			 result.addRow(applicationRow);
		  }
		  
		  /*
		   * Der fertige Report wird zurückgegeben
		   */
		  return result;
		  
		  
	  }
	  
	  /**
	   * Erstellen eines Reports, welcher alle Beteiligungen eines Users ausgibt
	   * @param u
	   * @throws IllegalArgumentException
	   * @return Fehlermeldung wenn Marktplatz Administration nicht vorhanden ist
	   * @return fertiger Report
	   */
	  public ParticipationsOfUser createParticipationsOfUserReport(User u) throws IllegalArgumentException{
		  
		  /*
		   * Überprüfung ob MarktplatzAdministration vorhanden
		   */
		  if(this.getMarketplaceAdministration() == null)
			  return null;
		  
		  /*
		   * Leerer Report wird erstellt
		   */
		  ParticipationsOfUser result = new ParticipationsOfUser(); //Leerer Report
		  
		  /*
		   * Der Report erhält einen Titel
		   */
		  result.setTitle("All Participations of User");
		  
		  /*
		   * Dem Report wird ein Impressum hinzugefügt
		   */
		  this.addImprint(result);
		  
		  /*
		   * Dem Report wird ein Erstellungsdatum hinzugefügt	  
		   */
		  result.setCreated(new Date());
		  
		  /*
		   * Ein neuer Header wird angelegt
		   */
		  CompositeParagraph header = new CompositeParagraph();
		  
		  /*
		   * Dem Header wird ein unter Abschnitt hinzugefügt
		   * Die Zeile trägt den Namen des übergebenen Users
		   */
		  header.addSubParagraph(new SimpleParagraph("Name: " + u.getLastname()+", "  + u.getFirstname()));
		  
		  /*
		   * Dem Report wird der Header hinzugefügt
		   */
		  result.setHeaderData(header);
		  
		  
		  /*
		   * Die erste Reihe des Reports wird erzeugt welche als Tabellen Überschriften dienen
		   */
		  Row headline = new Row(); //Erste Reihe in dem report (Bezeichnungen)
		  
		  /*
		   * Der ersten Reihe werden vier Spalten hnzugefügt
		   * Die erste Spalte trägt den Projekt Namen
		   * Die zweite Spalte die Arbeitszeit
		   * Die dritte Spalte das Anfangsdatum
		   * Die vierte Spalte das Enddatum
		   */
		  headline.addColumn(new Column("ProjectName"));
		  headline.addColumn(new Column("WorkingDays"));
		  headline.addColumn(new Column("StartDate"));
		  headline.addColumn(new Column("EndDate"));
		  
		  /*
		   * Dem Report wird die erste Zeile hinzugefügt
		   */
		  result.addRow(headline);
		  
		  /*
		   * Einem Vector der nur aus Beteiligungsobjekten bestehen soll, werden
		   * alle Beteiligungen des übergebenen Users, hinzugefügt
		   */
		  Vector<Participation> allParticipations = this.administration.getAllParticipationsOfUser(u.getId());
		  
		  /*
		   * der Vector wird durchsucht wobei jeder Durchgang die Werte in a gespeichert wird
		   */
		  for(Participation a : allParticipations){
			  
			  /*
			   * Bei jedem Durchlauf wird eine neue Reihe erstellt
			   */
			  Row participationRow = new Row();
			  
				/*
				 * Der neuen Reihe werden die gespeichterten Werte aus a hinzugefügt
				 */
			  participationRow.addColumn(new Column(administration.getProjectById(a.getProjectRef()).getName()));
			  participationRow.addColumn(new Column(a.getWorkingDays())); 
			  participationRow.addColumn(new Column(a.DateToString(a.getStartDate())));
			  participationRow.addColumn(new Column(a.DateToString(a.getEndDate())));
			 
			/*
			 * Die neue Reihe wird dem Report hinzugefügt
			 */
			 result.addRow(participationRow);
		  }
		  
		  /*
		   * Der fertige Report wird zurückgegeben
		   */
		  return result;
		  
	  }
	
	  /**
	   * Erstellen eines Reports, welcher alle Projektverflechtungen eines Users ausgibt
	   * @param u
	   * @throws IllegalArgumentException
	   * @return Fehlermeldung wenn keine Marktplatz Administration vorhanden ist
	   * @return fertiger Report
	   */
	  public ProjectInterconnection createProjectInterconnectionReport(User u) throws IllegalArgumentException{
		  
		  /*
		   * Überprüfung ob MarktplatzAdministration vorhanden
		   */
		  if(this.getMarketplaceAdministration() == null)
			  return null;

		  /*
		   * Leerer Report wird erstellt
		   */
		  ProjectInterconnection result = new ProjectInterconnection();

		/*
		 * Der Report erhält einen Titel
		 */
		    result.setTitle("ProjectInterconnection of User");

		/*
		 * Dem Report wird ein Impressum hinzugefügt
		 */
		    this.addImprint(result);

		/*
		 * Dem Report wird ein Erstellungsdatum hinzugefügt	  
		 */
		    result.setCreated(new Date());

		    /*
		     * Dem Report werden zwei unter Reports hinzugefügt
		     * der erste Unter Report erstellt einen Report, welcher alle Bewerbungen eines Users ausgibt
		     * der zweite Unter Report erstellt einen Report, welcher alle Beteiligunen eines Users ausgibt
		     */
		    result.addSubReport(this.createAllApplicationsOfUserReport(u));
		    result.addSubReport(this.createParticipationsOfUserReport(u));
		    
		    /*
		     * Der fertige Report wird zurückgegeben
		     */
		    return result;
		  
	  }
		  
	  
	  /**
	   * Erstellen eines Reports, welcher den Status aller Bewerbungen eines Users ausgibt
	   * @param u
	   * @throws IllegalArgumentException
	   * @return Fehlermeldung wenn keine Marktplatz Administration vorhanden ist
	   * @return fertiger Report
	   */
	  public ApplicationStatus createApplicationStatusReport(User u) throws IllegalArgumentException {
		  
		  /*
		   * Überprüfung ob MarktplatzAdministration vorhanden
		   */
		  if(this.getMarketplaceAdministration() == null)
			  return null;
		  
		  /*
		   * Leerer Report wird erstellt
		   */
		  ApplicationStatus result = new ApplicationStatus(); //Leerer Report
		  
			/*
			 * Der Report erhält einen Titel
			 */
		  result.setTitle("ApplicationStatus");
		  
			/*
			 * Dem Report wird ein Impressum hinzugefügt
			 */
		  this.addImprint(result);
		  
			/*
			 * Dem Report wird ein Erstellungsdatum hinzugefügt	  
			 */
		  result.setCreated(new Date());
		  
		  /*
		   * Ein neuer Header wird angelegt
		   */
		  CompositeParagraph header = new CompositeParagraph();
		  
		  /*
		   * Dem Header wird ein unter Abschnitt hinzugefügt
		   * Die Zeile trägt den Namen des übergebenen Users
		   */
		  header.addSubParagraph(new SimpleParagraph("Name: " + u.getLastname()+", "  + u.getFirstname()));
		  
		  /*
		   * Dem Report wird der Header hinzugefügt
		   */
		  result.setHeaderData(header);
		  
		  
		  /*
		   * Die erste Reihe des Reports wird erzeugt welche als Tabellen Überschriften dienen
		   */
		  Row headline = new Row(); //Erste Reihe in dem report (Bezeichnungen)
		  
		  /*
		   * Der ersten Reihe werden drei Spalten hnzugefügt
		   * Die erste Spalte zeigt die Anzahl
		   * Die zweite Spalte zeigt den Bewerbungstitel
		   * Die dritte Spalte zeigt den Bewerbungsstatus
		   */
		  headline.addColumn(new Column("Anzahl"));
		  headline.addColumn(new Column("ApplicationTitle"));
		  headline.addColumn(new Column("ApplicationStatus"));
		  
		  /*
		   * Dem Report wird die erste Zeile hinzugefügt
		   */
		  result.addRow(headline);
		  
		  /*
		   * Einem Vector der nur aus Bewerbungssobjekten bestehen soll, werden
		   * alle Bewerbungen des übergebenen Users, hinzugefügt
		   */
		  Vector<Application> allApplications = this.administration.getAllApplicationsByUserRef(u.getId());
		  		 
		  /*
		   * 
		   */
		  int Counter = 1;
		  
		  /*
		   * der Vector wird durchsucht wobei jeder Durchgang die Werte in a gespeichert wird
		   */
		  for(Application a : allApplications){
			 
			  /*
			   * Bei jedem Durchlauf wird eine neue Reihe erstellt
			   */
			  Row applicationRow = new Row();
			 
			 /*
			  * Der Wert der counter Variable wird in einen String umgewandelt
			  * und in die String Variable s gespeichert
			  */
			 String s = String.valueOf(Counter);
			 
			 /*
			  * Diese Variable soll den Status der Bewerbung repräsentieren
			  */
			 String status = null;
			 
			 /*
			  * Ein neues Datumsobjekt mit dem aktuellen Datum wird erstellt
			  */
			 Date now = new Date();
			 
			 /*
			  * 
			  */
			 int dateInt = administration.getTenderById(a.getTenderRef()).getEndDate().compareTo(now);
					 
			 Participation p = null;
			 p = this.administration.getParticipationByRatingRef(administration.getRatingsByApplicationRef(a.getId()).getId());
			 
			 if(p != null){
					 status = "Accepted";
				 
				 }
			 
				 else if(dateInt >0){
					 status = "Going on";
				 }
				 
				 else {
					 status = "Rejected";
				 }
				 
			/*
			 * Der neuen Reihe werden die gespeichterten Werte aus a hinzugefügt
			 */
			 applicationRow.addColumn(new Column(s));
			 applicationRow.addColumn(new Column(a.getText())); 
			 applicationRow.addColumn(new Column(status));
			 
			/*
			 * Der Counter erhöht sich pro Durchlauf um eins
			 */
			Counter++;
			 
			/*
			 * Die neue Reihe wird dem Report hinzugefügt
			 */
			 result.addRow(applicationRow);
		  }
		  
		  /*
		   * Der fertige Report wird zurückgegeben
		   */
		  return result;
		  
	  }
		  
		  // ----------------------------------------------------------------------------------
	  
	  /**
	   * Erstellen eines Reports, welcher den Status alle Ausschreibungen eines Users ausgibt
	   * @param u
	   * @throws IllegalArgumentException
	   * @return Fehlermeldung wenn keine Marktplatz Administration vorhanden ist
	   * @return fertiger Report
	   */
	  public TenderStatus createTenderStatusReport(User u) throws IllegalArgumentException{
		  
		  /*
		   * Überprüfung ob MarktplatzAdministration vorhanden
		   */
		  if(this.getMarketplaceAdministration() == null)
			  return null;
		  
		  /*
		   * Leerer Report wird erstellt
		   */
		  TenderStatus result = new TenderStatus(); //Leerer Report
		  
			/*
			 * Der Report erhält einen Titel
			 */
		  result.setTitle("TenderStatus");
		  
			/*
			 * Dem Report wird ein Impressum hinzugefügt
			 */
		  this.addImprint(result);
		  
			/*
			 * Dem Report wird ein Erstellungsdatum hinzugefügt	  
			 */
		  result.setCreated(new Date());
		  
		  /*
		   * Ein neuer Header wird angelegt
		   */
		  CompositeParagraph header = new CompositeParagraph();
		  
		  /*
		   * Dem Header wird ein unter Abschnitt hinzugefügt
		   * Die Zeile trägt den Namen des übergebenen Users
		   */
		  header.addSubParagraph(new SimpleParagraph("Name: " + u.getLastname()+", "  + u.getFirstname()));
		  
		  /*
		   * Dem Report wird der Header hinzugefügt
		   */
		  result.setHeaderData(header);
		  
		  
		  /*
		   * Die erste Reihe des Reports wird erzeugt welche als Tabellen Überschriften dienen
		   */
		  Row headline = new Row(); //Erste Reihe in dem report (Bezeichnungen)
		  
		  /*
		   * Der ersten Reihe werden drei Spalten hnzugefügt
		   * Die erste Spalte zeigt die Anzahl
		   * Die zweite Spalte zeigt den Ausschreibungstitel
		   * Die dritte Spalte zeigt den Ausschreibungsstatus
		   */
		  headline.addColumn(new Column("Anzahl"));
		  headline.addColumn(new Column("TenderTitle"));
		  headline.addColumn(new Column("TenderStatus"));
		  
		  /*
		   * Dem Report wird die erste Zeile hinzugefügt
		   */
		  result.addRow(headline);
		  
		  /*
		   * Einem Vector der nur aus Ausschreibungssobjekten bestehen soll, werden
		   * alle Ausschreibungen des übergebenen Users, hinzugefügt
		   */
		  Vector<Tender> allTenders = this.administration.getAllTenderOfUser(u.getId());
		  
		  /*
		   * 
		   */
		  int Counter = 1;
		  
		  /*
		   * der Vector wird durchsucht wobei jeder Durchgang die Werte in t gespeichert wird
		   */
		  for(Tender t : allTenders){
			  
			  /*
			   * Bei jedem Durchlauf wird eine neue Reihe erstellt
			   */
			  Row tenderRow = new Row();
			  
			/*
			 * Der Wert der counter Variable wird in einen String umgewandelt
			 * und in die String Variable s gespeichert
			 */
			 String s = String.valueOf(Counter);
			
			 /*
			  * Diese Variable soll den Status der Bewerbung repräsentieren
			  */
			 String status = null;
			 
			 /*
			  * Ein neues Datumsobjekt mit dem aktuellen Datum wird erstellt
			  */
			 Date now = new Date();
			 
			 int dateInt = t.getEndDate().compareTo(now);
					 
			 Participation part = administration.getParticipationByTenderRef(t.getId());
			 
			 
			 if(part != null){
				 status = "Job Successfully filled";
			 
			 }
		 
			 else if(dateInt > 0 && part == null){
				 status = "Going on";
			 }
			 
			 else {
				 status = "Rejected";
			 }
			 
			/*
			 * Der neuen Reihe werden die gespeichterten Werte aus t hinzugefügt
			 */
			 tenderRow.addColumn(new Column(s));
			 tenderRow.addColumn(new Column(t.getText())); 
			 tenderRow.addColumn(new Column(status));
			 
			/*
			 * Der Counter erhöht sich pro Durchlauf um eins
			 */
			Counter++;
			 
			/*
			 * Die neue Reihe wird dem Report hinzugefügt
			 */
			 result.addRow(tenderRow);
		  }
		  
		  /*
		   * Der fertige Report wird zurückgegeben
		   */
		  return result;
		  
	  }
	  
	  /**
	   * Erstellen einer Fan-in/Fan-out Analyse
	   * @throws IllegalArgumentException
	   * @return Fehlermeldung wenn keine Marktplatz Administration vorhanden ist
	   * @return fertiger Report
	   */
	  public FanInFanOut createFanInFanOutReport() throws IllegalArgumentException{
		  
		  /*
		   * Überprüfung ob MarktplatzAdministration vorhanden
		   */
		  if(this.getMarketplaceAdministration() == null)
			  return null;

		  /*
		   * Leerer Report wird erstellt
		   */
		  FanInFanOut result = new FanInFanOut();

			/*
			 * Der Report erhält einen Titel
			 */
		    result.setTitle("FanInOut Analyse of all Users");

			/*
			 * Dem Report wird ein Impressum hinzugefügt
			 */
		    this.addImprint(result);

			/*
			 * Dem Report wird ein Erstellungsdatum hinzugefügt	  
			 */
		    result.setCreated(new Date());

			  /*
			   * Einem Vector der nur aus Usersobjekten bestehen soll, werden
			   * alle User hinzugefügt
			   */
		    Vector<User> allUsers = this.administration.getAllUser();

			  /*
			   * der Vector wird durchsucht wobei jeder Durchgang die Werte in u gespeichert wird
			   */
		    for (User u : allUsers) {
		   
			 /*
			  * Dem Report werden zwei unter Reports hinzugefügt
			  * der erste Unter Report erstellt einen Report, welcher den Status aller Bewerbungen eines Users ausgibt
			  * der zweite Unter Report erstellt einen Report, welcher alle den Status aller Ausschreibungen eines Users ausgibt
			  */
		      result.addSubReport(this.createApplicationStatusReport(u));
		      result.addSubReport(this.createTenderStatusReport(u));
		    }

			/*
			 * Der fertige Report wird zurückgegeben
			 */
		    return result;
		  
	  }



	
}
