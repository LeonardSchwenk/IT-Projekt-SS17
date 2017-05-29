package de.hdm.marketPlace.shared.report;

import de.hdm.marketPlace.shared.report.AllTenders;
import de.hdm.marketPlace.shared.report.TendersMatchProfil;
import de.hdm.marketPlace.shared.report.AllApplicationsOnTender;
import de.hdm.marketPlace.shared.report.AllApplicationsOfUser;
import de.hdm.marketPlace.shared.report.ProjectInterconnection;
import de.hdm.marketPlace.shared.report.FanInFanOut;

public abstract class ReportWriter {
	
	  public abstract void process(AllTenders r);

	  
	  public abstract void process(TendersMatchProfil r);
	  
	  
	  public abstract void process(AllApplicationsOnTender r);
	  
	  
	  public abstract void process(AllApplicationsOfUser r);
	  
	  
	  public abstract void process(ProjectInterconnection r);
	  
	  public abstract void process(ApplicationStatus r);
	  
	  public abstract void process(TenderStatus r);
	  
	  public abstract void process(ParticipationsOfUser r);
	  
	  public abstract void process(FanInFanOut r);

	}
