package de.hdm.marketPlace.shared;

import java.util.ArrayList;
import java.util.Vector;
import com.google.gwt.user.client.rpc.AsyncCallback;
import de.hdm.marketPlace.shared.bo.*;
import java.util.Date;

public interface MarketplaceAdministrationAsync {
	
	public void init(AsyncCallback<Void> callback) throws IllegalArgumentException;
	
	void createProject (String name, String text, Date startDate, Date endDate, int managerRef, AsyncCallback <Project> callback);
	
	void getProjectById (int projectId, AsyncCallback <Project> callback);
	
	void updateProject (Project p, String name, String text, Date startDate, Date endDate, int managerRef, AsyncCallback <Void> callback);
	
	void deleteProject (Project p, AsyncCallback <Void> callback);
	
	void getAllProjectsOfUser (int userRef, AsyncCallback <Vector<Project>> callback);
	
	void getAllProjects (AsyncCallback<Vector<Project>>callback);
	
	
	//Participation
	
	void createParticipation (int userRef, int projectRef, int wd, Date startDate, Date endDate, AsyncCallback<Participation>callback);
	
	void getParticipationById (int participationRef, AsyncCallback <Participation> callback);
	
	void updateParticipation (Participation pa, int userRef, int projectRef, int wd, Date startDate, Date endDate, AsyncCallback <Participation> callback);
	
	void deleteParticipation (Participation pa, AsyncCallback <Void> callback);
	
	void getParticipationByRatingRef (int ratingRef, AsyncCallback <Participation> callback);
	
	void getAllParticipationsOfUser (int userRef, AsyncCallback <Vector<Participation>> callback);
	
	void getParticipationsByTenderRef (int tenderRef, AsyncCallback <Participation> callback);
	
	void getAllParticipations (AsyncCallback <Vector<Participation>> callback);
	
	
	//Rating
	
	void createRating (float rate, String text, AsyncCallback<Rating> callback);
	
	void getRatingById (int ratingId, AsyncCallback <Rating> callback);
	
	void updateRating (Rating r, float rate, String text, AsyncCallback <Void> callback);
	
	void deleteRating (Rating r, AsyncCallback<Void> callback);
	
	void getAllRatings (AsyncCallback <Vector<Rating>> callback);
	
	void getRatingsByApplicationRef (int applicationRef, AsyncCallback <Rating> callback);
	
	
	//Ausschreiberprofil
	
	void createTenderProfile (int tenderRef, AsyncCallback <TenderProfile> callback);
	
	void getTenderProfileById (int tenderProfileRef, AsyncCallback <TenderProfile> callback);
	
	void updateTenderProfile (TenderProfile tp, int tenderRef, AsyncCallback <Void> callback);
	
	void delteTenderProfile (TenderProfile tp, AsyncCallback<Void> callback);
	
	void getAllTendersByProjectRef(int projectRef, AsyncCallback<Void> callback);
	
	
	//UserProfile
	
	void createUserProfile (User u, String text, AsyncCallback <UserProfile> callback);
	
	void getUserProfileById (int userProfileRef, AsyncCallback <UserProfile> callback);
	
	void updateUserProfile (UserProfile up, String text, AsyncCallback<Void> callback);
	
	void deleteUserProfile (UserProfile up, AsyncCallback <Void> callback);
	
	//User
	
	public User getUserById (int userRef, AsyncCallback <User> callback);
	
	
	public Vector<User> getAllApplicantOfUser(int userRef, AsyncCallback <User> callback);
	
	

}
