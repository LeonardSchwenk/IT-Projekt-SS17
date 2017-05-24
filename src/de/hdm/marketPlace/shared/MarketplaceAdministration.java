package de.hdm.marketPlace.shared;

import java.util.ArrayList.*;

import java.util.Date;
import java.util.Vector;

import de.hdm.marketPlace.shared.bo.*;



public interface MarketplaceAdministration {
	
	public void init() throws IllegalArgumentException;
	
	
	
	//Methoden zur Verwaltung von Marktplätzen
	//Methode zur Erstellung eines Marktplatzes
	public ProjectMarketplace createMarketplace (String name) throws IllegalArgumentException;
	
	//Methode zur Rückgabe eines Marketplace anhand seiner Id
	public ProjectMarketplace getMarketplaceById (int marketplaceRef) throws IllegalArgumentException;
	
	//Methode zum Beitreten eines Marktplatzes
	public void joinMarketplace (int userRef, int marketplaceRef)throws IllegalArgumentException;
	
	//Methode zum Löschen eines Marktplatzes
	public void deleteMarketplace (ProjectMarketplace marketplace)throws IllegalArgumentException;
	
	//Methode zur Ausgabe des aktuellen Marktplatzes
	public ProjectMarketplace getMarketplace() throws IllegalArgumentException;
	
	//Methode zum Aktkualisieren eines Marktplatzes
		public void updateMarketplace (ProjectMarketplace marketplace)throws IllegalArgumentException;
	
	
	
	//Methoden zur Benutzerverwaltung 
	//Methode zur Erstellung eines Benutzers
	public User createUser (String firstName, String lastName) throws IllegalArgumentException;
	
	//Methode zum Bearbeiten eines Benutzers
	public void updateUser (User user, String firstName, String lastName) throws IllegalArgumentException;
	
	//Methode zum Löschen eines Benutzers
	public void deleteUser (User user) throws IllegalArgumentException;
	
	//Methode zur Rückgabe eines Users anhand seiner ID
	public User getUserById (int userRef) throws IllegalArgumentException;
		
	//Methode zum Finden von Benutzern anhand deren Nachnamen
	public Vector <User> getAllUserByName (String lastName) throws IllegalArgumentException;
	
	//Ausgeben aller Benutzer
	public Vector <User> getAllUser () throws IllegalArgumentException;
	
	
	//Methoden zur Verwaltung von Bewerbungen
	//eine Bewerbung erstellen
	public Application createApplicationFor (String titel, String text, Date createDate, Date updateDate, int userRef, int tenderRef, int ratingRef)throws IllegalArgumentException;
	
	//Rückgabe einer Methode anhand einer Id
	public Application getApplicationById (int applicationRef) throws IllegalArgumentException;
	
	//eine Bewerbung bearbeiten
	public void updateApplication (Application application, String inhalt) throws IllegalArgumentException;
	
	//eine Bewerbung löschen
	public void deleteApplication (Application application)throws IllegalArgumentException;
	
	//Ausgeben aller Bewerbungen auf eine Ausschreibung
	public Vector <Application> getAllApplicationsByTenderRef(int tenderRef) throws IllegalArgumentException;
	
	//Ausgeben aller Bewerbungen
	public Vector <Application> getAllApplications () throws IllegalArgumentException;
	
	//ausgeben aller Bewerbungen eines bestimmten Users
	public Vector <Application> getAllApplicationsByUserRef(int userRef) throws IllegalArgumentException;
	
	
	
	
	//Methoden zur Verwaltung von Ausschreibungen
	//eine Ausschreibung erstellen
	public Tender createTender (String name, int projectRef, String text, Date startDate, Date endDate) throws IllegalArgumentException;
	
	//Rückgabe einer Ausschreibung anhand einer Id
	public Tender getTenderById (int tenderRef) throws IllegalArgumentException;
	
	//eine Ausschreibung bearbeiten
	public void updateTender (Tender tender, String text ) throws IllegalArgumentException;
	
	//eine Ausschreibung löschen
	public void deleteTender (Tender tender) throws IllegalArgumentException;
	
	//Ausgeben aller Ausschreibungen eines Users
	public Vector <Tender> getAllTenderOfUser (User user ) throws IllegalArgumentException;
	
	//Ausgeben von Ausschreibungen anhand vom Namen
	public Vector <Tender> getAllTenderByName (String text)  throws IllegalArgumentException;
	
	//Ausgeben aller Ausschreibungen
	public Vector <Tender> getAllTender (ProjectMarketplace m) throws IllegalArgumentException;
	
	//Ausgeben von allen Auschreibungen die zu meinem Profil passen
	public Vector<Tender> getTenderMatch (User u) throws IllegalArgumentException;
	

	
	
	
	//Methoden zur Verwaltung von Projekten
	//ein Projekt erstellen
	public Project createProject (String name, String text, Date startDate, Date endDate, User manager) throws IllegalArgumentException;
	
	//Rückgabe eines Projekts anhand einer Id
	public Project getProjectById (int projectRef) throws IllegalArgumentException;
	
	//ein Projekt bearbeiten
	public void updateProject (Project project, String name, String text, Date startDate, Date endDate, User manager)  throws IllegalArgumentException;
	
	//ein Projekt löschen
	public void deleteProject (Project project) throws IllegalArgumentException;
	
	//Ausgeben aller Projekte eines Managers
	public Vector <Project> getAllProjectsOfUser (int userRef) throws IllegalArgumentException;
	
	//Ausgeben aller Projekte
	public Vector <Project> getAllProjects () throws IllegalArgumentException;
	
	
	
	//Methoden zur Vewaltung von Mitarbeit an Projekten
	//Erstellen einer Teilnahme
	public Participation createParticipation (User user, Project project, int workingDays, Date startDate, Date endDate) throws IllegalArgumentException;
	
	//Rückgabe einer Teilnahme anhand einer id
	public Participation getParticipationById (int participationRef) throws IllegalArgumentException;
	
	//Bearbeiten einer Teilnahme
	public void updateParticipation (Participation participation, User user, Project project, int workingDays, Date startDate, Date endDate) throws IllegalArgumentException;
	
	//Löschen einer Teilnahme
	public void deleteParticipation (Participation paricipation) throws IllegalArgumentException;
	
	//Anzeigen einer Teilnahme anhand von RatingRef
	public Participation getParticipationByRatingRef(int ratingRef) throws IllegalArgumentException;
	
	
	//Anzeigen aller Teilnahmen einer Person
	public Vector <Participation> getAllParticipationsOfUser (User user) throws IllegalArgumentException;
	
	//Anzeigen aller Teilnahmen aller Projekte
	public Vector <Participation> getAllParticipations () throws IllegalArgumentException;
	
	
	
	//Methoden zur Verwaltung von Ratings
	//Erstellen einer Bewertung
	public Rating createRating (float rate, String ratingText) throws IllegalArgumentException;
	
	//Rückgabe eines Ratings anhand einer Id
	public Rating getRatingById (int ratingRef) throws IllegalArgumentException;
	
	//Bearbeiten einer Bewertung
	public void updateRating (Rating rating, float rate, String ratingText) throws IllegalArgumentException;
	
	//Löschen einer Bewertung
	public void deleteRating (Rating rating) throws IllegalArgumentException;
	
	//Anzeigen aller Bewertungen einer Bewerbung
	public Vector <Rating> getAllRatingsOfApplication (Application application) throws IllegalArgumentException;
	
	
	//Methoden zur Verwaltung eines Ausschreiberprofils
	//Erstellen eines Ausschreiberprofils
	public TenderProfile createTenderProfile (Date createDate) throws IllegalArgumentException;
	
	//Rückgabe eines Ausschreiberprofils anhand einer Id
	public TenderProfile getTenderProfileById (int TenderProfileRef) throws IllegalArgumentException;
	
	//Bearbeiten eines Ausschreiberprofils
	public void updateTenderProfile (TenderProfile tenderProfile, Date updateDate) throws IllegalArgumentException;
	
	//Löschen eines Ausschreiberprofils
	public void deleteTenderProfile (TenderProfile tenderProfile) throws IllegalArgumentException;
	
	
	//Methoden zur Verwaltung eines UserProfile
	//Erstellen eines UserProfils
	public UserProfile createUserProfile (User u, String text) throws IllegalArgumentException;
	
	//Rückgabe eines UserProfils anhand einer Id
	public UserProfile getUserProfileById (int userProfileRef) throws IllegalArgumentException;
	
	//Bearbeiten eines UserProfile
	public void updateUserProfile (UserProfile userProfile, Date updateDate) throws IllegalArgumentException;
	
	//Löschen eines Ausschreiberprofils
	public void deleteUserProfile (UserProfile userProfile) throws IllegalArgumentException;
	
	
	//Methoden zur Verwaltung einer Eigenschaft
	
	//Ein Attribut einem Userprofil hinzuf�gen
	public Attribute insertAttribute(Attribute a, UserProfile up)throws IllegalArgumentException;
				
	//Bearbeiten eines Attributes
	public void updateAttribute(Attribute a, int userprofileRef, String name, String text, int value) throws IllegalArgumentException;
				
	//L�schen eines Attributes
	public void deleteAttribute(Attribute a)throws IllegalArgumentException;
	
	//L�sche alle Attribute eines UserProfils
	public void deleteAllAttributeOfUserprofile(UserProfile up)throws IllegalArgumentException;

	//Alle Attribute eines Users
	public Vector<Attribute> selectAllAttributeOfUserProfile(UserProfile up)throws IllegalArgumentException;

	
	
	
	
	
	
	
	
	
 	
	
	
	
	
	
	
	
	
	
	
}