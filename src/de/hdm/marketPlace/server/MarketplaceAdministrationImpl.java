package de.hdm.marketPlace.server;

import de.hdm.marketPlace.shared.*;

import de.hdm.marketPlace.shared.bo.*;
import de.hdm.marketPlace.server.db.*;

import java.util.Vector;
import java.util.ArrayList;
import java.util.Date;



public class MarketplaceAdministrationImpl extends RemoteServiceServlet implements MarketplaceAdministration {

	//Referenz auf den zugehÃ¶rigen ProjektMarktplatz
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
	
	
	//Anlegen eines Null-Argument-Constructors fÃ¼r die Klasse MarketplaceAdministrationImpl
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
	
	//Methoden zur Verwaltung von MarktplÃ¤tzen
	
	public ProjectMarketplace createMarketplace (String name) throws IllegalArgumentException {
		ProjectMarketplace pm = new ProjectMarketplace();
		pm.setName(name);
		
		pmMapper.insert(pm);
	}
	public void update(ProjectMarketPlace pm) throws IllegalArgumentException {
		pmMapper.update(pm);
	}
	public void delete(ProjectMarketPlace pm) throws IllegalArgumentException {
		pmMapper.delete(pm);
	}
	
	public ProjectMarketplace getMarketplaceById (int projectmarketplaceRef) throws IllegalArgumentException {
		return pmMapper.findById(projectmarketplaceRef);
	}
	
	public void joinMarketplace (int userRef, int projectmarketplaceRef) throws IllegalArgumentException {
		User u = usMapper.findByID(userRef);
		u.setMarketplaceRef (projectmarketplaceRef);
		
		usMapper.update(u);
	}
	public Vector<ProjectMarketPlace> findAllProjectMarketPlace() throws IllegalArgumentException {
		return this.pmMapper.findAll();
	}
	
	//-----------------------------------------
	
	//Methoden zur Benutzerverwaltung
	
		public User createUser (String name) throws IllegalArgumentException {
			User u = new User ();
			
			u.setName(name);
			//Google ID ? 
			//Usertyp einfügen?
			return usMapper.insert(u);
		}
		
		public User getUserById (int userRef) throws IllegalArgumentException {
			return usMapper.findByID(userRef);
		}
		
		public void updateUser (User u, String name) throws IllegalArgumentException{
			u.setName(name);
			
			usMapper.update(u);
		}
		
		public void deleteUser (User u) throws IllegalArgumentException {
			usMapper.delete(u);
			
			/*
			 //Zugehöriges UserProfile löschen
			UserProfile userProfile = upMapper.findByUser(User);
	  		
	  		if(userProfile != null) {
	  			this.deleteUserProfile(userProfile);
	  		}
	      
	      	//Zugehörige Projekte löschen		      
	      	Vector<Project> pl = new Vector<Project>();
	      	
	      	if(pl != null) {
	      		pl = prMapper.findByUser(User);
	      		for(Project project: pl){
	      			this.delete(project);

	      		}
	      	}
			
			//Zugehörige Bewerbungen löschen
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
		
		public Vector <User> getAllUserByName (String name) throws IllegalArgumentException {
			return usMapper.findAllUserByName (name);
		}
		
		public Vector <User> getAllUser() throws IllegalArgumentException {
			return usMapper.findAll();
		}
		
		//----------------------------------------------------
		
		//Methoden zur Verwaltung von Bewerbungen
		
		public Application createApplication (String titel, String text, int userRef, int tenderRef, int ratingRef) throws IllegalArgumentException {
			Application a = new Application();
			a.setTitel(titel);
			a.setText(text);
			a.setCreateDate(new Date());
			a.setUserRef(userRef);
			a.setTenderRef(tenderRef);
			a.setRatingRef(ratingRef);
			
			return apMapper.insert(a);
		}
		
		
		public Application getApplicationById (int applicationRef) throws IllegalArgumentException {
			return apMapper.findByID(applicationRef);
		}
		
		public void updateApplication (Application a, String titel, String text, int userRef, int tenderRef, int ratingRef) throws IllegalArgumentException {
			a.setTitel(titel);
			a.setText(text);
			a.setUpdateDate(new Date());
			a.setUserRef(userRef);
			a.setTenderRef(tenderRef);
			a.setRatingRef(ratingRef);
			
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
		
		public Vector <Application> getAllApplicationsByTender (int tenderRef) throws IllegalArgumentException {
			return apMapper.getAllApplicationsByTender(tenderRef);
		}
		
		public Vector <Application> getAllApplications () throws IllegalArgumentException {
			return apMapper.getAllApplications;
		}
		
		public Vector <Application> getAllApplicationsByUserRef (int userRef) throws IllegalArgumentException {
			return apMapper.findAllApplicationsByUserRef (userRef);
		}
		
		//-------------------------------------------------
		
		//Methoden zur Verwaltung von Ausschreibungen
		public Tender createTender (int projectRef, int tenderProfileRef, String text) throws IllegalArgumentException {
			Tender t = new Tender();
			t.setProjectRef(projectRef);
			t.setTenderProfilRef(tenderProfileRef);
			t.setText(text);
			
			return teMapper.insert(t);
		}
		
		public Tender getTenderById (int tenderRef) throws IllegalArgumentException {
			return teMapper.findByID(tenderRef);
		}
		
		public void updateTender (Tender t, int projectRef, int tenderProfileRef, String text) throws IllegalArgumentException {
			t.setProjectRef(projectRef);
			t.setTenderProfilRef(tenderProfileRef);
			t.setText(text);
			
			teMapper.update(t);
		}
		
		public void deleteTender (Tender t) throws IllegalArgumentException{
			teMapper.delete(t);
		}
		
		public Vector <Tender> getAllTenderOfUser (int userRef) throws IllegalArgumentException {
			return teMapper.getAllTenderOfUser(userRef);
		}
		
		public Vector <Tender> getAllTenderByName (String name) throws IllegalArgumentException {
			return teMapper.getAllTenderByName (name);
		}
		
		public Vector <Tender> getAllTender () throws IllegalArgumentException {
			return teMapper.getAllTender();
		}
		
		public Vector <Tender> getTenderMatch (UserProfile up) throws IllegalArgumentException {
			return teMapper.getTenderMatch (up);
		}
		
		//--------------------------------------------
		//Methoden zur Verwaltung von Projekten
		
		public Project createProject (String name, String text, Date startDate, Date endDate, int managerRef, int tenderRef) throws IllegalArgumentException {
			Project p = new Project();
			p.setName(name);
			p.setText(text);
			p.setStartDate(startDate);
			p.setEndDate(endDate);
			p.setUserRef(managerRef);
			p.setTenderRef(tenderRef);
			
			return prMapper.insert(p);
		}
		
		public Project getProjectById (int projectId) throws IllegalArgumentException {
			return prMapper.findByID(projectId);
					
		}
		
		public void updateProject (Project p, String name, String text, Date startDate, Date endDate, int managerRef, int tenderRef) throws IllegalArgumentException {
			p.setName(name);
			p.setText(text);
			p.setStartDate(startDate);
			p.setEndDate(endDate);
			p.setUserRef(managerRef);
			p.setTenderRef(tenderRef);
			
			prMapper.update(p);
			
		}
		
		public void deleteProject (Project p) throws IllegalArgumentException {
			prMapper.delete(p);
		}
		
		public Vector <Project> getAllProjectsOfUser (int userRef) throws IllegalArgumentException {
			prMapper.getAllProjectsOfUser (userRef);
		}
		
		public Vector <Project> getAllProjects () throws IllegalArgumentException {
			prMapper.getAllProjects();
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
			paMapper.findParticipationByRatingRef(ratingRef);
		}
		
		public Vector <Participation> getAllParticipationsOfUser (int userRef) throws IllegalArgumentException {
			return paMapper.getAllParticipationsOfUser (userRef);
		}
		
		public Vector <Participation> getAllParticipations () throws IllegalArgumentException {
			return paMapper.getAllParticipations();
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
	
	public Vector <Rating> getAllRatingsOfApplication (Application a) throws IllegalArgumentException{
		return this.raMapper.getAllRatingsOfApplication (a);
	}
	//---------------------------------------------------
	
	//Methoden zur Verwaltung eines Ausschreiberprofils
	
	public TenderProfile createTenderProfile (Date createDate) throws IllegalArgumentException{
		TenderProfile tp = new TenderProfile();
		tp.setCreateDate(new Date());
		
		return this.tpMapper.insert(tp);
	}
	
	public TenderProfile getTenderProfileById (int tenderProfileRef) throws IllegalArgumentException{
		return this.tpMapper.findByID(tenderProfileRef);
	}
	
	public void updateTenderProfile (TenderProfile tp, Date updateDate) throws IllegalArgumentException {
		tp.setUpdateDate (new Date());
		this.tpMapper.update(tp);
	}
	
	public void deleteTenderProfile (TenderProfile tp) throws IllegalArgumentException {
		this.tpMapper.delete(tp);
	}
	//-----------------------------------------------------
	

	// UserProfile Methoden
	
	public UserProfile createUserProfile(User u) throws IllegalArgumentException {
		
		UserProfile up = new UserProfile();
			up.setId(u.getId());
			
			return this.upMapper.insertUserProfile(up);
		}

		public UserProfile getById(int i) throws IllegalArgumentException {
			return this.upMapper.findById(i);
		}

		
		public UserProfile updateUserProfile(UserProfile up) throws IllegalArgumentException {
			return this.upMapper.updateUserProfile(up);
		}

		public void deleteUserProfile(UserProfile up) throws IllegalArgumentException {
			
			
			Vector<Attribute> a= new Vector<Attribute>();
	      	
	      	if(a != null) {
	      		a = atMapper.findByUserprofile(pp);
	      		for(Attribute attribute : a){
	      			this.deleteAttribute(Attribute);
	      		}
	      	}
	    		//Partnerprofil löschen
	    		this.upMapper.deleteUserProfile(up);
	      	}
			
			
			
		//---------------------------------------------------------
		//Methoden zur Verwaltung einer Eigenschaft
		
		public Attribute insertAttribute(Attribute a, UserProfile up)throws IllegalArgumentException{
			return this.atMapper.insertAttribute(a, up);
		}
		
		public Attribute updateAttribute(Attribute a)throws IllegalArgumentException{
			return this.atMapper.updateAttribute(a);
		}
		
		public void deleteAttribute(Attribute a)throws IllegalArgumentException{
			atMapper.deleteAttribute(a);
		}
		
		
		public void deleteAllAttributeOfUserProfile(UserProfile up)throws IllegalArgumentException{
			atMapper.deleteAllAttributeOfUserProfile(up);
		}
		
		
		public Vector<Attribute> selectAllAttributeOfUserProfile(UserProfile up)throws IllegalArgumentException{
			return this.atMapper.findByUserProfile(up);
		}
		

	
	
	
	
	
	
	
	
	
	
	
}
