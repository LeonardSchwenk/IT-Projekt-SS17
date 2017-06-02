package de.hdm.marketPlace.shared;

import de.hdm.marketPlace.shared.bo.*;
import de.hdm.marketPlace.shared.report.*; // Warum muss importiert werden??

public interface ReportGenerator extends RemoteService{ //Import Remote Service muss noch importiert werden (welche Stelle?)
	
	
	/**
	 * Die init() Methode lässt andere Klassen aus anderen Packages auf diese zugreifen
	 */
	  public void init() throws IllegalArgumentException;

	  /**
	   * Setzen des zugehörigen Projektmarktplatzes 
	   * @param u
	   * @param m
	   * @throws IllegalArgumentException
	   */
	  public void setProjectMarketplace(User u, ProjectMarketplace m) throws IllegalArgumentException; 

	  /**
	   * Erstellen eines Reports, welcher alle Ausschreibungen eines Marktplatzes ausgibt
	   * @param m
	   * @throws IllegalArgumentException
	   */
	  public abstract AllTenders createAllTendersReport(ProjectMarketplace m) throws IllegalArgumentException;
	  
	  /**
	   * Erstellen eines Reports, welcher alle Ausschreibungen auf einem Marktplatz ausgibt, die zu dem User passen 
	   * @param m
	   * @param u
	   * @throws IllegalArgumentException
	   */
	  public abstract TendersMatchProfil createTendersMatchProfilReport(ProjectMarketplace m, User u) throws IllegalArgumentException;
	  
	  /**
	   * Erstellen eines Reports, welcher alle Bewerbungen auf eine Ausschreibung ausgibt
	   * @param t
	   * @throws IllegalArgumentException
	   */
	  public abstract AllApplicationsOnTender createAllApplicationsOnTenderReport(Tender t) throws IllegalArgumentException;
	  
	  /**
	   * Erstellen eines Reports, welcher alle Bewerbungen eines Users ausgibt
	   * @param u
	   * @throws IllegalArgumentException
	   */
	  public abstract AllApplicationsOfUser createAllApplicationsOfUserReport(User u) throws IllegalArgumentException;
	  
	  
	  //------------------------------------------------------ProjectInterconnection
	  
	  /**
	   * Erstellen eines Reports, welcher alle Projektverflechtungen eines Users ausgibt
	   * @param u
	   * @throws IllegalArgumentException
	   */
	  public abstract ProjectInterconnection createProjectInterconnectionReport(User u) throws IllegalArgumentException;
	  
	  /**
	   * Erstellen eines Reports, welcher alle Beteiligungen eines Users ausgibt
	   * @param u
	   * @throws IllegalArgumentException
	   */
	  public ParticipationsOfUser createParticipationsOfUserReport(User u) throws IllegalArgumentException;
	  
	  //---------------------------------------------------- FanInFanOut
	  
	  /**
	   * Erstellen einer Fan-in/Fan-out Analyse
	   * @throws IllegalArgumentException
	   */
	  public abstract FanInFanOut createFanInFanOutReport() throws IllegalArgumentException;
	  
	  /**
	   * Erstellen eines Reports, welcher den Status aller Bewerbungen eines Users ausgibt
	   * @param u
	   * @throws IllegalArgumentException
	   */
	  public abstract ApplicationStatus createApplicationStatusReport(User u) throws IllegalArgumentException;
	  
	  /**
	   * Erstellen eines Reports, welcher den Status alle Ausschreibungen eines Users ausgibt
	   * @param u
	   * @throws IllegalArgumentException
	   */
	  public abstract TenderStatus createTenderStatusReport(User u) throws IllegalArgumentException;
  
	}
	

