package de.hdm.marketPlace.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.marketPlace.server.MarketplaceAdministrationImpl;
import de.hdm.marketPlace.shared.MarketplaceAdministration;
import de.hdm.marketPlace.shared.ReportGenerator;
import de.hdm.marketPlace.shared.bo.*;
import de.hdm.marketPlace.shared.report.*;

	
	public interface ReportGeneratorAsync {
		
		void init(AsyncCallback<Void> callback);
		
		void createAllTendersReport (AsyncCallback<AllTenders> callback);
		
		void createTendersMatchProfilReport (User u, AsyncCallback<TendersMatchProfil> callback);
		
		void createAllApplicationsOnTenderReport (Tender t, AsyncCallback<AllApplicationsOnTender> callback);

		void createAllApplicationsOfUserReport (User u, AsyncCallback<AllApplicationsOfUser> callback);
		
		void createProjectInterconnectionReport (User u, AsyncCallback<ProjectInterconnection> callback);
		
		void createParticipationsOfUserReport (User u, AsyncCallback<ParticipationsOfUser> callback);
		
		void createFanInFanOutReport (AsyncCallback<FanInFanOut> callback);
		
		void createApplicationStatusReport (User u, AsyncCallback<ApplicationStatus> callback);
		
		void createTenderStatusReport (User u, AsyncCallback<TenderStatus> callback);
		
		
		


}
