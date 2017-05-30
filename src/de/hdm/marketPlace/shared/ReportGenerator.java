package de.hdm.marketPlace.shared;

import de.hdm.marketPlace.shared.bo.*;
import de.hdm.marketPlace.shared.report.*; 
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

public interface ReportGenerator extends RemoteService{ //Import Remote Service muss noch importiert werden (welche Stelle?)
	
	
	 public void init() throws IllegalArgumentException;

	  // public void setProjectMarketplace(User u, ProjectMarketplace m) throws IllegalArgumentException; 

	  public abstract AllTenders createAllTendersReport() throws IllegalArgumentException;
	  
	  public abstract TendersMatchProfil createTendersMatchProfilReport(User u) throws IllegalArgumentException;
	  
	  public abstract AllApplicationsOnTender createAllApplicationsOnTenderReport(Tender t) throws IllegalArgumentException;

	  public abstract AllApplicationsOfUser createAllApplicationsOfUserReport(User u) throws IllegalArgumentException;
	  
	  //------------------------------------------------------ProjectInterconnection
	  public abstract ProjectInterconnection createProjectInterconnectionReport(User u) throws IllegalArgumentException;
	  
	  public abstract ParticipationsOfUser createParticipationsOfUserReport(User u) throws IllegalArgumentException;
	  
	  //---------------------------------------------------- FanInFanOut
	  public abstract FanInFanOut createFanInFanOutReport() throws IllegalArgumentException;
	  
	  public abstract ApplicationStatus createApplicationStatusReport(User u) throws IllegalArgumentException;
	  
	  public abstract TenderStatus createTenderStatusReport(User u) throws IllegalArgumentException;
  
	}
	

