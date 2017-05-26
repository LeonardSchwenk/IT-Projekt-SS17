package de.hdm.marketPlace.shared;

import de.hdm.marketPlace.shared.bo.*;
import de.hdm.marketPlace.shared.report.*; // Warum muss importiert werden??

public interface ReportGenerator extends RemoteService{ //Import Remote Service muss noch importiert werden (welche Stelle?)
	
	
	 public void init() throws IllegalArgumentException;

	  public void setProjectMarketplace(User u, ProjectMarketplace m) throws IllegalArgumentException; 

	  public abstract AllTenders createAllTendersReport(ProjectMarketplace m) throws IllegalArgumentException;
	  
	  public abstract TendersMatchProfil createTendersMatchProfilReport(ProjectMarketplace m, User u) throws IllegalArgumentException;
	  
	  public abstract AllApplicationsOnTender createAllApplicationsOnTenderReport(Tender t) throws IllegalArgumentException;

	  public abstract AllApplicationsOfUser createAllApplicationsOfUserReport(User u) throws IllegalArgumentException;
	  
	  //------------------------------------------------------ProjectInterconnection
	  public abstract ProjectInterconnection createProjectInterconnectionReport(User u) throws IllegalArgumentException;
	  
	  public ParticipationsOfUser createParticipationsOfUserReport(User u) throws IllegalArgumentException;
	  
	  //---------------------------------------------------- FanInFanOut
	  public abstract FanInFanOut createFanInFanOutReport() throws IllegalArgumentException;
	  
	  public abstract ApplicationStatus createApplicationStatusReport(User u) throws IllegalArgumentException;
	  
	  public abstract TenderStatus createTenderStatusReport(User u) throws IllegalArgumentException;
  
	}
	

