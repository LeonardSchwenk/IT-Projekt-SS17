package de.hdm.marketPlace.shared;

import java.util.ArrayList.*;

import java.util.Date;
import java.util.Vector;

import de.hdm.marketPlace.shared.bo.*;

/**
 * Die Klasse realisiert ein Interface welches als Methoden�bersicht f�r die MarketplaceAdministrationImpl dient
 */

public interface MarketplaceAdministration {
	
	/**
	 * Die init() Methode l�sst die Impl Klasse auf die Methoden dieses Interfaces zugreifen
	 */
	public void init() throws IllegalArgumentException;
	
	/**
	 * Methoden zur Verwaltung von Marktplätzen
	 */
	
	/**
	 * Methode zur Erstellung eines Marktplatzes
	 * @param name
	 * @throws IllegalArgumentException
	 */
	public ProjectMarketplace createMarketplace (String name) throws IllegalArgumentException;
	
	/**
	 * Methode zum Aktkualisieren eines Marktplatzes
	 * @param pm
	 * @param name
	 * @throws IllegalArgumentException
	 */
	public void updateMarketplace (ProjectMarketplace pm, String name)throws IllegalArgumentException;
	
	/**
	 * Methode zum L�schen eines Marktplatzes
	 * @param pm
	 * @throws IllegalArgumentException
	 */
	public void deleteMarketplace (ProjectMarketplace pm)throws IllegalArgumentException;
	
	/**
	 * Methode zur Rückgabe eines Marketplace anhand seiner Id
	 * @param projectmarketplaceRef
	 * @throws IllegalArgumentException
	 */
	public ProjectMarketplace getMarketplaceById (int projectmarketplaceRef) throws IllegalArgumentException;
	
	/**
	 * Methode zum Beitreten eines Marktplatzes
	 * @param userRef
	 * @param projectmarketplaceRef
	 * @throws IllegalArgumentException
	 */
	public void joinMarketplace (int userRef, int projectmarketplaceRef)throws IllegalArgumentException;
	
	/**
	 * Methode zur Ausgabe des aktuellen Marktplatzes
	 * @throws IllegalArgumentException
	 */
	public Vector <ProjectMarketplace> getAllProjectMarketplace() throws IllegalArgumentException;
	
	
	
	
	
	/**
	 * Methoden zur Benutzerverwaltung 
	 */
	
	/**
	 * Methode zur Erstellung eines Benutzers
	 * @param firstName
	 * @param lastName
	 * @throws IllegalArgumentException
	 */
	public User createUser (String firstName, String lastName) throws IllegalArgumentException;
	
	/**
	 * Methode zur R�ckgabe eines Users anhand seiner ID
	 * @param userRef
	 * @throws IllegalArgumentException
	 */
	public User getUserById (int userRef) throws IllegalArgumentException;
	
	/**
	 * Methode zum Bearbeiten eines Benutzers
	 * @param u
	 * @param firstName
	 * @param lastName
	 * @throws IllegalArgumentException
	 */
	public void updateUser (User u, String firstName, String lastName) throws IllegalArgumentException;
	
	/**
	 * Methode zum L�schen eines Benutzers
	 * @param u
	 * @throws IllegalArgumentException
	 */
	public void deleteUser (User u) throws IllegalArgumentException;
	
	/**
	 * Methode zum Finden von Benutzern anhand deren Nachnamen
	 * @param lastName
	 * @throws IllegalArgumentException
	 */
	public Vector <User> getAllUserByName (String lastName) throws IllegalArgumentException;
	
	/**
	 * Ausgeben aller Benutzer
	 * @throws IllegalArgumentException
	 */
	public Vector <User> getAllUser () throws IllegalArgumentException;
	
	public Vector <User> getAllApplicantOfUser (int userRef) throws IllegalArgumentException;
	
	
	/**
	 * Methoden zur Verwaltung von Bewerbungen
	 */
	
	/**
	 * eine Bewerbung erstellen
	 * @param name
	 * @param text
	 * @param userRef
	 * @param tenderRef
	 * @throws IllegalArgumentException
	 */
	public Application createApplication (String name, String text, int userRef, int tenderRef)throws IllegalArgumentException;
	
	/**
	 * Rückgabe einer Methode anhand einer Id
	 * @param applicationRef
	 * @throws IllegalArgumentException
	 */
	public Application getApplicationById (int applicationRef) throws IllegalArgumentException;
	
	/**
	 * eine Bewerbung bearbeiten
	 * @param a
	 * @param name
	 * @param text
	 * @param userRef
	 * @param tenderRef
	 * @throws IllegalArgumentException
	 */
	public void updateApplication (Application a, String name, String text, int userRef, int tenderRef) throws IllegalArgumentException;
	
	/**
	 * eine Bewerbung l�schen
	 * @param a
	 * @throws IllegalArgumentException
	 */
	public void deleteApplication (Application a)throws IllegalArgumentException;
	
	/**
	 * Ausgeben aller Bewerbungen auf eine Ausschreibung
	 * @param tenderRef
	 * @throws IllegalArgumentException
	 */
	public Vector <Application> getAllApplicationsByTenderRef(int tenderRef) throws IllegalArgumentException;
	
	/**
	 * Ausgeben aller Bewerbungen
	 * @throws IllegalArgumentException
	 */
	public Vector <Application> getAllApplications () throws IllegalArgumentException;
	
	/**
	 * Ausgeben aller Bewerbungen eines bestimmten Users
	 * @param userRef
	 * @throws IllegalArgumentException
	 */
	public Vector <Application> getAllApplicationsByUserRef(int userRef) throws IllegalArgumentException;
	
	/**
	 * Methoden zur Verwaltung von Ausschreibungen
	 */
	
	/**
	 * eine Ausschreibung erstellen
	 * @param name
	 * @param projectRef
	 * @param text
	 * @param startDate
	 * @param endDate
	 * @throws IllegalArgumentException
	 */
	public Tender createTender (String name, int projectRef, String text, Date startDate, Date endDate) throws IllegalArgumentException;
	
	/**
	 * R�ckgabe einer Ausschreibung anhand einer Id
	 * @param tenderRef
	 * @throws IllegalArgumentException
	 */
	public Tender getTenderById (int tenderRef) throws IllegalArgumentException;
	
	/**
	 * eine Ausschreibung bearbeiten
	 * @param t
	 * @param projectRef
	 * @param text
	 * @param name
	 * @param startDate
	 * @param endDate
	 * @throws IllegalArgumentException
	 */
	public void updateTender (Tender t, int projectRef, String text, String name, Date startDate, Date endDate ) throws IllegalArgumentException;
	
	/**
	 * eine Ausschreibung l�schen
	 * @param t
	 * @throws IllegalArgumentException
	 */
	public void deleteTender (Tender t) throws IllegalArgumentException;
	
	/**
	 * Ausgeben aller Ausschreibungen eines Users
	 * @param userRef
	 * @throws IllegalArgumentException
	 */
	public Vector <Tender> getAllTenderOfUser (int userRef) throws IllegalArgumentException;
	
	/**
	 * Ausgeben von Ausschreibungen anhand vom Namen
	 * @param name
	 * @throws IllegalArgumentException
	 */
	public Vector <Tender> getAllTenderByName (String name)  throws IllegalArgumentException;
	
	/**
	 * Ausgeben aller Ausschreibungen
	 * @throws IllegalArgumentException
	 */
	public Vector <Tender> getAllTender () throws IllegalArgumentException;
	
	//Ausgeben aller Ausschreibungen passend zum eigenen Profil
	
	public Vector <Tender> getAllTendersByMatch(int userprofileRef) throws IllegalArgumentException;
	
	public Vector<Tender> getAllTendersByProjectRef(int projectRef)throws IllegalArgumentException;
	
	
	
	/**
	 * Methoden zur Verwaltung von Projekten
	 */
	
	/**
	 * ein Projekt erstellen
	 * @param name
	 * @param text
	 * @param startDate
	 * @param endDate
	 * @param managerRef
	 * @throws IllegalArgumentException
	 */
	public Project createProject (String name, String text, Date startDate, Date endDate, int managerRef) throws IllegalArgumentException;
	
	/**
	 * Rückgabe eines Projekts anhand einer Id
	 * @param projectRef
	 * @throws IllegalArgumentException
	 */
	public Project getProjectById (int projectRef) throws IllegalArgumentException;
	
	/**
	 * ein Projekt bearbeiten
	 * @param p
	 * @param name
	 * @param text
	 * @param startDate
	 * @param endDate
	 * @param managerRef
	 * @throws IllegalArgumentException
	 */
	public void updateProject (Project p, String name, String text, Date startDate, Date endDate, int managerRef)  throws IllegalArgumentException;
	
	/**
	 * ein Projekt löschen
	 * @param p
	 * @throws IllegalArgumentException
	 */
	public void deleteProject (Project p) throws IllegalArgumentException;
	
	/**
	 * Ausgeben aller Projekte eines Managers
	 * @param userRef
	 * @throws IllegalArgumentException
	 */
	public Vector <Project> getAllProjectsOfUser (int userRef) throws IllegalArgumentException;
	
	/**
	 * Ausgeben aller Projekte
	 * @throws IllegalArgumentException
	 */
	public Vector <Project> getAllProjects () throws IllegalArgumentException;
	
	
	
	/**
	 * Methoden zur Vewaltung von Mitarbeit an Projekten
	 */
	
	/**
	 * Erstellen einer Teilnahme
	 * @param userRef
	 * @param projectRef
	 * @param wd
	 * @param startDate
	 * @param endDate
	 * @throws IllegalArgumentException
	 */
	public Participation createParticipation (int userRef, int projectRef, int wd, Date startDate, Date endDate) throws IllegalArgumentException;
	
	/**
	 * Rückgabe einer Teilnahme anhand einer id
	 * @param participationRef
	 * @throws IllegalArgumentException
	 */
	public Participation getParticipationById (int participationRef) throws IllegalArgumentException;
	
	/**
	 * Bearbeiten einer Teilnahme
	 * @param pa
	 * @param userRef
	 * @param projectRef
	 * @param wd
	 * @param startDate
	 * @param endDate
	 * @throws IllegalArgumentException
	 */
	public void updateParticipation (Participation pa, int userRef, int projectRef, int wd, Date startDate, Date endDate) throws IllegalArgumentException;
	
	/**
	 * L�schen einer Teilnahme
	 * @param pa
	 * @throws IllegalArgumentException
	 */
	public void deleteParticipation (Participation pa) throws IllegalArgumentException;
	
	/**
	 * Anzeigen einer Teilnahme anhand von RatingRef
	 * @param ratingRef
	 * @throws IllegalArgumentException
	 */
	public Participation getParticipationByRatingRef(int ratingRef) throws IllegalArgumentException;
	
	
	/**
	 * Anzeigen aller Teilnahmen einer Person
	 * @param userRef
	 * @throws IllegalArgumentException
	 */
	public Vector <Participation> getAllParticipationsOfUser (int userRef) throws IllegalArgumentException;
	
	/**
	 * Ausgabe einer Teilnahme anhand einer Ausschreibung
	 * @param tenderRef
	 * @throws IllegalArgumentException
	 */
	public Participation getParticipationByTenderRef (int tenderRef) throws IllegalArgumentException;
	
	/**
	 * Anzeigen aller Teilnahmen aller Projekte
	 * @throws IllegalArgumentException
	 */
	public Vector <Participation> getAllParticipations () throws IllegalArgumentException;
	
	
	
	/**
	 * Methoden zur Verwaltung von Ratings
	 */
	
	/**
	 * Erstellen einer Bewertung
	 * @param rate
	 * @param text
	 * @throws IllegalArgumentException
	 */
	public Rating createRating (float rate, String text) throws IllegalArgumentException;
	
	/**
	 * R�ckgabe eines Ratings anhand einer Id
	 * @param ratingRef
	 * @throws IllegalArgumentException
	 */
	public Rating getRatingById (int ratingRef) throws IllegalArgumentException;
	
	/**
	 * Bearbeiten einer Bewertung
	 * @param r
	 * @param rate
	 * @param text
	 * @throws IllegalArgumentException
	 */
	public void updateRating (Rating r, float rate, String text) throws IllegalArgumentException;
	
	/**
	 * L�schen einer Bewertung
	 * @param r
	 * @throws IllegalArgumentException
	 */
	public void deleteRating (Rating r) throws IllegalArgumentException;
	
	/**
	 * Anzeigen aller Bewertungen
	 * @throws IllegalArgumentException
	 */
	public Vector <Rating> getAllRatings() throws IllegalArgumentException;
	
	/**
	 * Anzeigen aller Bewertungen einer Bewerbung
	 * @param applicationRef
	 * @throws IllegalArgumentException
	 */
	public Rating getRatingsByApplicationRef (int applicationRef) throws IllegalArgumentException;
	
	
	/**
	 * Methoden zur Verwaltung eines Ausschreiberprofils
	 */
	
	/**
	 * Erstellen eines Ausschreiberprofils
	 * @param tenderRef
	 * @throws IllegalArgumentException
	 */
	public TenderProfile createTenderProfile (int tenderRef) throws IllegalArgumentException;
	
	/**
	 * Rückgabe eines Ausschreiberprofils anhand einer Id
	 * @param TenderProfileRef
	 * @throws IllegalArgumentException
	 */
	public TenderProfile getTenderProfileById (int TenderProfileRef) throws IllegalArgumentException;
	
	/**
	 * Bearbeiten eines Ausschreiberprofils
	 * @param up
	 * @param tenderRef
	 * @throws IllegalArgumentException
	 */
	public void updateTenderProfile (TenderProfile up, int tenderRef) throws IllegalArgumentException;
	
	/**
	 * L�schen eines Ausschreiberprofils
	 * @param tenderProfile
	 * @throws IllegalArgumentException
	 */
	public void deleteTenderProfile (TenderProfile tenderProfile) throws IllegalArgumentException;
	
	public Vector<TenderProfile> getAllTenderProfilesByTenderRef (int tenderRef) throws IllegalArgumentException;
	
	
	/**
	 * Methoden zur Verwaltung eines UserProfile
	 */
	
	/**
	 * Erstellen eines UserProfils
	 * @param u
	 * @param text
	 * @throws IllegalArgumentException
	 */
	public UserProfile createUserProfile (User u, String text) throws IllegalArgumentException;
	
	/**
	 * Rückgabe eines UserProfils anhand einer Id
	 * @param userProfileRef
	 * @throws IllegalArgumentException
	 */
	public UserProfile getUserProfileById (int userProfileRef) throws IllegalArgumentException;
	
	/**
	 * Bearbeiten eines UserProfile
	 * @param up
	 * @param text
	 * @throws IllegalArgumentException
	 */
	public void updateUserProfile (UserProfile up, String text) throws IllegalArgumentException;
	
	/**
	 * L�schen eines Ausschreiberprofils
	 * @param up
	 * @throws IllegalArgumentException
	 */
	public void deleteUserProfile (UserProfile up) throws IllegalArgumentException;
	
	
	/**
	 * Methoden zur Verwaltung einer Eigenschaft
	 */
	
	/**
	 * Ein Attribut einem Userprofil hinzuf�gen
	 * @param userprofileRef
	 * @param name
	 * @param text
	 * @param value
	 * @throws IllegalArgumentException
	 */
	public Attribute createAttribute(int userprofileRef, String name, String text, int value)throws IllegalArgumentException;
				
	/**
	 * Bearbeiten eines Attributes
	 * @param a
	 * @param userprofileRef
	 * @param name
	 * @param text
	 * @param value
	 * @throws IllegalArgumentException
	 */
	public void updateAttribute(Attribute a, int userprofileRef, String name, String text, int value) throws IllegalArgumentException;
				
	/**
	 * L�schen eines Attributes
	 * @param a
	 * @throws IllegalArgumentException
	 */
	public void deleteAttribute(Attribute a) throws IllegalArgumentException;
	
	/**
	 * Anzeigen von Attributen anhand eines UserProfiles
	 * @param userprofileRef
	 * @throws IllegalArgumentException
	 */
	public Vector<Attribute> getAttributesByUserProfileRef(int userprofileRef) throws IllegalArgumentException;

	/**
	 * Anzeigen aller Attribute
	 * @throws IllegalArgumentException
	 */
	public Vector <Attribute> getAllAttributes () throws IllegalArgumentException;
	
	
	
	
	
	
	
	
	
 	
	
	
	
	
	
	
	
	
	
	
}