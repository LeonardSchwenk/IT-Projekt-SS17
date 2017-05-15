package de.hdm.marketPlace.shared;

import de.hdm.marketPlace.shared.bo.*;
import de.hdm.marketPlace.shared.report.*; // Warum muss importiert werden??

public interface ReportGenerator extends RemoteService{ //Import Remote Service muss noch importiert werden (welche Stelle?)
	
	
	 public void init() throws IllegalArgumentException;

	  public void setProjectMarketplace(ProjectMarketplace m) throws IllegalArgumentException; //User oder Marketplace??

	  public abstract AllTenders createAllTendersReport() throws IllegalArgumentException;
	  
	  public abstract TendersMatchProfil createTendersMatchProfilReport() throws IllegalArgumentException;
	  
	  public abstract AllApplicationsOnTender createAllApplicationsOnTenderReport(Tender t) throws IllegalArgumentException;

	  public abstract AllApplicationsOfUser createAllApplicationsOfUserReport(User u) throws IllegalArgumentException;
	  
	  public abstract ProjectInterconnection createProjectInterconnectionReport(User u) throws IllegalArgumentException;
	  
	  public abstract FanInFanOut createFanInFanOutReport(User u) throws IllegalArgumentException;
	  
  
	}
	

