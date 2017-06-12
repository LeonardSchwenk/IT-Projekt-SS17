package de.hdm.marketPlace.server;

import de.hdm.marketPlace.shared.*;


import de.hdm.marketPlace.shared.bo.*;
import de.hdm.marketPlace.server.db.*;

import java.util.Vector;
import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;



public class MarketplaceAdministrationImpl extends RemoteServiceServlet implements MarketplaceAdministration {

	//Referenz auf den zugehörigen ProjektMarktplatz
	private ProjectMarketplace marketplace = null;
	
	//Anlegen der Mapper
	private ApplicationMapper apMapper = null;
	
	private AttributeMapper atMapper = null;
	
	private ParticipationMapper paMapper = null;
	
	private ProjectMapper prMapper = null;
	
	private ProjectMarketplaceMapper pmMapper = null;
	
	private RatingMapper raMapper = null;
	
	private TenderMapper teMapper = null;
	
	private UserMapper usMapper = null;
	
	private UserProfileMapper upMapper = null;
	
	private TenderProfileMapper tpMapper = null;
	
	
	//Anlegen eines Null-Argument-Constructors für die Klasse MarketplaceAdministrationImpl
	public MarketplaceAdministrationImpl() throws IllegalArgumentException {
		
	}
	
	//Implementierung des Codes in die Klassen, welche vorher in dem Interface MarketplaceAdministration definiert wurden
	public void init() throws IllegalArgumentException {
		
		this.apMapper = ApplicationMapper.applicationMapper();
		this.atMapper = AttributeMapper.attributeMapper();
		this.paMapper = ParticipationMapper.participationMapper();
		this.prMapper = ProjectMapper.projectMapper();
		this.pmMapper = ProjectMarketplaceMapper.projectMarketplaceMapper();
		this.raMapper = RatingMapper.ratingMapper();
		this.teMapper = TenderMapper.tenderMapper();
		this.usMapper = UserMapper.userMapper();
		this.upMapper = UserProfileMapper.userProfileMapper();
		this.tpMapper = TenderProfileMapper.tenderProfileMapper();
		
	}
	
	//Methoden zur Verwaltung von Marktplätzen
	
	public ProjectMarketplace createMarketplace (String name) throws IllegalArgumentException {
		ProjectMarketplace pm = new ProjectMarketplace();
		pm.setName(name);
		
		return pmMapper.insert(pm);
	}
	public void updateMarketplace(ProjectMarketplace pm, String name) throws IllegalArgumentException {
		pm.setName(name);
		
		pmMapper.update(pm);
	}
	public void deleteMarketplace(ProjectMarketplace pm) throws IllegalArgumentException {
		pmMapper.delete(pm);
	}
	
	public ProjectMarketplace getMarketplaceById (int projectmarketplaceRef) throws IllegalArgumentException {
		return pmMapper.findByID(projectmarketplaceRef);
	}
	
	public void joinMarketplace (int userRef, int projectmarketplaceRef) throws IllegalArgumentException {
		User u = usMapper.findByID(userRef);
		u.setProjectmarketplaceRef(projectmarketplaceRef); 
		
		usMapper.update(u);
	}
	public Vector<ProjectMarketplace> getAllProjectMarketplace() throws IllegalArgumentException {
		return this.pmMapper.findAll();
	}
	
	
	
	//Methoden zur Benutzerverwaltung
	
		public User createUser (String firstName, String lastName) throws IllegalArgumentException {
			User u = new User ();
			
			u.setFirstname(firstName);
			u.setLastname(lastName);
			//Google ID ? 
			//Usertyp einf�gen?
			return usMapper.insert(u);
		}
		
		public User getUserById (int userRef) throws IllegalArgumentException {
			return usMapper.findByID(userRef);
		}
		
		public void updateUser (User u, String firstName, String lastName) throws IllegalArgumentException{
			u.setFirstname(firstName);
			u.setLastname(lastName);
			
			usMapper.update(u);
		}
		
		public void deleteUser (User u) throws IllegalArgumentException {
			usMapper.delete(u);
			
			//Zugehöriges UserProfile löschen
			UserProfile up = upMapper.findUserProfileByUserRef(u.getId());
			
			if (up != null) {
				this.deleteUserProfile(up);
			}
			/*
			 //Zugeh�riges UserProfile l�schen
			UserProfile userProfile = upMapper.findByUser(User);
	  		
	  		if(userProfile != null) {
	  			this.deleteUserProfile(userProfile);
	  		}
	      
	      	//Zugeh�rige Projekte l�schen		      
	      	Vector<Project> pl = new Vector<Project>();
	      	
	      	if(pl != null) {
	      		pl = prMapper.findByUser(User);
	      		for(Project project: pl){
	      			this.delete(project);

	      		}
	      	}
			
			//Zugeh�rige Bewerbungen l�schen
	  		Vector<Application> al = new Vector<Application>();
	  		
	  		if (al != null) {
	  			al = this.raMapper.findByUser(User);
	  			for(Application application : al){
	  				this.deleteApplication(a);
	  			}
	  		}
	      
	  		
	    
	      	this.usMapper.delete(User);
	  	
		} 
			 */
			
		
		}
		
		public Vector <User> getAllUserByName (String lastName) throws IllegalArgumentException {
			return usMapper.findByName(lastName);
		}
		
		public Vector <User> getAllUser() throws IllegalArgumentException {
			return usMapper.findAll();
		}
		
		//----------------------------------------------------
		
		//Methoden zur Verwaltung von Bewerbungen
		
		public Application createApplication (String name, String text, int userRef, int tenderRef) throws IllegalArgumentException {
			Application a = new Application();
			a.setName(name);
			a.setText(text);
			a.setApplicationDate(new Date());
			a.setUserRef(userRef);
			a.setTenderRef(tenderRef);
			
			return apMapper.insert(a);
		}
		
		
		public Application getApplicationById (int applicationRef) throws IllegalArgumentException {
			return apMapper.findByID(applicationRef);
		}
		
		public void updateApplication (Application a, String name, String text, int userRef, int tenderRef) throws IllegalArgumentException {
			a.setName(name);
			a.setText(text);
			a.setApplicationDate(new Date());
			a.setUserRef(userRef);
			a.setTenderRef(tenderRef);
			
			apMapper.update(a);
		}
		
		public void deleteApplication (Application a) throws IllegalArgumentException {
			apMapper.delete(a);
			/*
			 public void deleteApplication(Application application) {
			
			
			Application a = this.apMapper.findByApplication(application);
	  		if (a != null) {
	  			//fehlt noch
	  			}
	  		this.apMapper.deleteRatingOfApplication(application);
			this.apMapper.delete(application);
	  		}
		
			 */
		}
		
		public Vector <Application> getAllApplicationsByTenderRef (int tenderRef) throws IllegalArgumentException {
			return apMapper.findAllApplicationsByTenderRef(tenderRef);
					
		}
		
		public Vector <Application> getAllApplications () throws IllegalArgumentException {
			return apMapper.findAll();
		}
		
		public Vector <Application> getAllApplicationsByUserRef (int userRef) throws IllegalArgumentException {
			return apMapper.findAllApplicationsByUserRef (userRef);
		}
		
		//-------------------------------------------------
		
		//Methoden zur Verwaltung von Ausschreibungen
		public Tender createTender (String name, int projectRef, String text, Date startDate, Date endDate) throws IllegalArgumentException {
			Tender t = new Tender();
			t.setName(name);
			t.setProjectRef(projectRef);
			t.setText(text);
			t.setStartDate(startDate);
			t.setEndDate(endDate);
			
			return teMapper.insert(t);
		}
		
		public Tender getTenderById (int tenderRef) throws IllegalArgumentException {
			return teMapper.findByID(tenderRef);
		}
		
		public void updateTender (Tender t, int projectRef, String text, String name, Date startDate, Date endDate) throws IllegalArgumentException {
			t.setProjectRef(projectRef);
			t.setText(text);
			t.setName(name);
			t.setStartDate(startDate);
			t.setEndDate(endDate);
			
			teMapper.update(t);
		}
		
		public void deleteTender (Tender t) throws IllegalArgumentException{
			teMapper.delete(t);
		}
		
		public Vector <Tender> getAllTenderOfUser (int userRef) throws IllegalArgumentException {
			return teMapper.findAllTenderByUserRef(userRef);
		}
		
		public Vector <Tender> getAllTenderByName (String name) throws IllegalArgumentException {
			return teMapper.findByName(name);
		}
		
		public Vector <Tender> getAllTender () throws IllegalArgumentException {
			return teMapper.findAll();
		}
		
		public Vector <Tender> getAllTendersByMatch(int Ref) throws IllegalArgumentException{
			
			Vector <Attribute> userAt = atMapper.findAllAttributesByUserProfileRef(Ref);
			Vector <TenderProfile> AllTp = tpMapper.findAll();
			Vector <Tender> matches = new Vector <Tender>();
			
			//Hohlt sich die Attribute jedes Ausschreibungsprofils
			for(TenderProfile tp : AllTp){
				Vector <Attribute> tpAt = atMapper.findAllAttributesByUserProfileRef(tp.getId());
				
				//Der Name jedes Attributes jedes Ausschreibungsprofils wird gespeichert
				for(Attribute at : tpAt){
					String attriTender = at.getName();
					
					//Der Name jedes Attributes des Users wird gespeichert
					for(Attribute uAt : userAt){
						String attriUser = uAt.getName();
						
						//Stimmen die Namen �berein wird die passende Ausschreibung geholt
						if(attriTender == attriUser){
							matches.add(this.getTenderById(tp.getTenderRef()));
						}
					}
				}
			}
			
			return matches;
		}
		
		
		//--------------------------------------------
		//Methoden zur Verwaltung von Projekten
		
		public Project createProject (String name, String text, Date startDate, Date endDate, int managerRef) throws IllegalArgumentException {
			Project p = new Project();
			p.setName(name);
			p.setText(text);
			p.setStartDate(startDate);
			p.setEndDate(endDate);
			p.setUserRef(managerRef);
			
			return prMapper.insert(p);
		}
		
		public Project getProjectById (int projectId) throws IllegalArgumentException {
			return prMapper.findByID(projectId);
					
		}
		
		public void updateProject (Project p, String name, String text, Date startDate, Date endDate, int managerRef) throws IllegalArgumentException {
			p.setName(name);
			p.setText(text);
			p.setStartDate(startDate);
			p.setEndDate(endDate);
			p.setUserRef(managerRef);
			
			prMapper.update(p);
			
		}
		
		public void deleteProject (Project p) throws IllegalArgumentException {
			prMapper.delete(p);
		}
		
		public Vector <Project> getAllProjectsOfUser (int userRef) throws IllegalArgumentException {
			return prMapper.findAllProjectsByUserRef(userRef);
		}
		
		public Vector <Project> getAllProjects () throws IllegalArgumentException {
			return prMapper.findAll();
		}
		
		//-----------------------------------------------------
		

	
	//Methoden zur Verwaltung von Teilnahmen an Projekten
	
		public Participation createParticipation(int userRef, int projectRef, int wd, Date startDate, Date endDate) throws IllegalArgumentException {
			Participation pa = new Participation();
			pa.setUserRef(userRef);
			pa.setProjectRef(projectRef);
			pa.setWorkingDays(wd);
			pa.setStartDate(startDate);
			pa.setEndDate(endDate);
			
			return this.paMapper.insert(pa);
		}
		
		public Participation getParticipationById (int participationRef) throws IllegalArgumentException{
			return this.paMapper.findByID(participationRef);
		}
		
		public void updateParticipation (Participation pa, int userRef, int projectRef, int wd, Date startDate, Date endDate) throws IllegalArgumentException {
			pa.setUserRef(userRef);
			pa.setProjectRef(projectRef);
			pa.setWorkingDays(wd);
			pa.setStartDate(startDate);
			pa.setEndDate(endDate);
			
			paMapper.update(pa);
		}
		
		public void deleteParticipation (Participation pa) throws IllegalArgumentException {
			paMapper.delete(pa);
		}
		
		public Participation getParticipationByRatingRef (int ratingRef) throws IllegalArgumentException {
			return paMapper.findAllParticipationsByRatingRef(ratingRef);
		}
		
		
		public Vector <Participation> getAllParticipationsOfUser (int userRef) throws IllegalArgumentException {
			return paMapper.findAllParticipationsByUserRef(userRef);
		}
		
		public Participation getParticipationByTenderRef (int tenderRef) throws IllegalArgumentException {
			return paMapper.findAllParticipationsByTenderRef(tenderRef);
		}
		
		public Vector <Participation> getAllParticipations () throws IllegalArgumentException {
			return paMapper.findAll();
		}
		
		//--------------------------------------------------
	
	//Methoden zur Verwaltung von Ratings
	
	public Rating createRating (float rate, String text) throws IllegalArgumentException {
		Rating ra = new Rating ();
		ra.setRate(rate);
		ra.setText(text);
		
		return this.raMapper.insert(ra);
	}
	
	public Rating getRatingById (int ratingRef) throws IllegalArgumentException {
		return this.raMapper.findByID(ratingRef);
	}
	
	public void updateRating (Rating r, float rate, String text) throws IllegalArgumentException{
		r.setRate(rate);
		r.setText(text);
		
		raMapper.update(r);
	}
	
	public void deleteRating (Rating r) throws IllegalArgumentException {
		raMapper.delete(r);
	}
	
	public Vector <Rating> getAllRatings () throws IllegalArgumentException {
		return raMapper.findAll();
	}
	
	public Rating getRatingsByApplicationRef (int applicationRef) throws IllegalArgumentException{
		return raMapper.findRatingByApplicationRef(applicationRef);
	}
	//---------------------------------------------------
	
	//Methoden zur Verwaltung eines Ausschreiberprofils
	
	public TenderProfile createTenderProfile ( int tenderRef) throws IllegalArgumentException{
		TenderProfile tp = new TenderProfile();
		tp.setTenderprofileDate(new Date());
		tp.setTenderRef(tenderRef);
		
		return this.tpMapper.insert(tp);
	}
	
	public TenderProfile getTenderProfileById (int tenderProfileRef) throws IllegalArgumentException{
		return this.tpMapper.findByID(tenderProfileRef);
	}
	
	public void updateTenderProfile (TenderProfile tp, int tenderRef) throws IllegalArgumentException {
		tp.setTenderprofileDate(new Date());
		tp.setTenderRef(tenderRef);
		
		this.tpMapper.update(tp);
	}
	
	public void deleteTenderProfile (TenderProfile tp) throws IllegalArgumentException {
		this.tpMapper.delete(tp);
	}
	//-----------------------------------------------------
	

	// UserProfile Methoden
	
	public UserProfile createUserProfile(User u, String text) throws IllegalArgumentException {
		
		UserProfile up = new UserProfile();
			up.setUserRef(u.getId());
			up.setText(text);
			
			return this.upMapper.insert(up);
		}

		public UserProfile getUserProfileById(int userProfileRef) throws IllegalArgumentException {
			return this.upMapper.findByID(userProfileRef);
		}

		
		public void updateUserProfile(UserProfile up, String text) throws IllegalArgumentException {
			up.setText(text);
			
			upMapper.update(up);
		}

		public void deleteUserProfile(UserProfile up) throws IllegalArgumentException {
			
	    		//Partnerprofil l�schen
	    		this.upMapper.delete(up);
	      	}
			
			
			
		//---------------------------------------------------------
		//Methoden zur Verwaltung einer Eigenschaft
		
		public Attribute createAttribute(int userprofileRef, String name, String text, int value)throws IllegalArgumentException{
			Attribute a = new Attribute();
			a.setName(name);
			a.setText(text);
			a.setUserprofileRef(userprofileRef);
			a.setValue(value);
			
			return atMapper.insert(a);
		}
		
		public void updateAttribute(Attribute a, int userprofileRef, String name, String text, int value)throws IllegalArgumentException{
			a.setUserprofileRef(userprofileRef);
			a.setName(name);
			a.setText(text);
			a.setValue(value);
			
			atMapper.update(a);
		}
		
		public void deleteAttribute(Attribute a)throws IllegalArgumentException{
			atMapper.delete(a);
		}
		
		
		
		public Vector<Attribute> getAttributesByUserProfileRef (int userprofileRef) throws IllegalArgumentException{
			return this.atMapper.findAllAttributesByUserProfileRef(userprofileRef);
		}
		
		public Vector <Attribute> getAllAttributes () throws IllegalArgumentException {
			return atMapper.findAll();
		}
		

	
	
	
	
	
	
	
	
	
	
	
}
