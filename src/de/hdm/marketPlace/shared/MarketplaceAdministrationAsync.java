package de.hdm.marketPlace.shared;


import java.util.Vector;
import com.google.gwt.user.client.rpc.AsyncCallback;
import de.hdm.marketPlace.shared.bo.*;
import java.util.Date;

public interface MarketplaceAdministrationAsync {
	
	public void init(AsyncCallback<Void> callback) throws IllegalArgumentException;
	
	//Marketplace
	
	void createMarketplace (String name, AsyncCallback <ProjectMarketplace> callback);
	
	void updateMarketplace (ProjectMarketplace pm, String name, AsyncCallback <Void> callback);
	
	void deleteMarketplace (ProjectMarketplace pm, AsyncCallback<Void> callback);
	
	void getMarketplaceById (int projectmarketplaceRef, AsyncCallback<ProjectMarketplace> callback);
	
	void joinMarketplace (int userRef, int projectmarketplaceRef, AsyncCallback <Void> callback);
	
	void getAllProjectMarketplace (AsyncCallback <Vector <ProjectMarketplace>> callback);
	
	//User
	
	void createUser (String firstName, String lastName, AsyncCallback <User> callback);
	
	void getUserById (int userRef, AsyncCallback <User> callback);
	
	void updateUser (User u, String firstName, String lastName, AsyncCallback <Void> callback);
	
	void deleteUser (User u, AsyncCallback <Void> callback);
	
	void getAllUserByName(String lastName, AsyncCallback <Vector<User>>callback);
	
	void getAllApplicantOfUser (int userRef, AsyncCallback <Vector<User>>callback);
	
	void getAllUser (AsyncCallback <Vector<User>>callback);
	
	//Application
	
	void createApplication (String name, String text, int userRef, int tenderRef, AsyncCallback <Application> callback);
	
	void getApplicationById (int applicationRef, AsyncCallback<Application> callback);
	
	void updateApplication (Application a, String name, String text, int userRef, int tenderRef, AsyncCallback <Void> callback);
	
	void deleteApplication (Application a, AsyncCallback <Void>callback);
	
	void getAllApplicationsByTenderRef (int tenderRef, AsyncCallback <Vector <Application>> callback);
	
	void getAllApplications (AsyncCallback <Vector<Application>> callback);
	
	void getAllApplicationsByUserRef (int userRef, AsyncCallback <Vector<Application>> callback);
	
	//Tender
	
	void createTender (String name, int projectRef, String text, Date startDate, Date endDate, AsyncCallback <Tender> callback);
	
	void getTenderById (int tenderRef, AsyncCallback <Tender> callback);
	
	void updateTender (Tender t, String name, int projectRef, String text, Date startDate, Date endDate, AsyncCallback <Void> callback);
	
	void deleteTender (Tender t, AsyncCallback <Void> callback);
	
	void getAllTenderOfUser (int userRef, AsyncCallback <Vector<Tender>> callback);
	
	void getAllTenderByName (String name, AsyncCallback <Vector <Tender>> callback);
	
	void getAllTender (AsyncCallback <Vector<Tender>> callback);
	
	void getAllTendersByMatch (int userprofileRef, AsyncCallback <Vector <Tender>> callback);
	
	void getAllTendersByProjectRef (int projectRef, AsyncCallback <Vector <Tender>> callback);
	
	
	
	//Project
	
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
	
	void getParticipationsByProjectRef (int projectRef, AsyncCallback <Vector<Participation>> callback);
	
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
	
	void deleteTenderProfile (TenderProfile tp, AsyncCallback<Void> callback);
	
	void getAllTenderProfilesByTenderRef (int tenderRef, AsyncCallback <TenderProfile> callback);
	
	
	
	
	//UserProfile
	
	void createUserProfile (User u, String text, AsyncCallback <UserProfile> callback);
	
	void getUserProfileById (int userProfileRef, AsyncCallback <UserProfile> callback);
	
	void updateUserProfile (UserProfile up, String text, AsyncCallback<Void> callback);
	
	void deleteUserProfile (UserProfile up, AsyncCallback <Void> callback);
	
	//Attribute
	
	void createAttribute (int userprofileRef, String name, String text, int value, AsyncCallback <Attribute> callback);
	
	void updateAttribute (Attribute a, int userprofileRef, String name, String text, int value, AsyncCallback< Void> callback);
	
	void deleteAttribute (Attribute a, AsyncCallback <Void> callback);
	
	void getAttributesByUserProfileRef (int userprofileRef, AsyncCallback <Vector<Attribute>> callback);
	
	void getAttributesByTenderProfileRef (int tenderprofileRef, AsyncCallback <Vector<Attribute>> callback);
	
	void getAllAttributes (AsyncCallback <Vector<Attribute>> callback);
	

}
