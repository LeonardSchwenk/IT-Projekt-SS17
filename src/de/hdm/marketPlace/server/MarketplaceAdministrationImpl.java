package de.hdm.marketPlace.server;

import de.hdm.marketPlace.shared.*;
import java.io.Serializable;

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
	
	//Methoden zur Verwaltung von Projektmarkplätzen
	
	public ProjectMarketPlace createProjectMarketPlace(int id, String name )
			throws IllegalArgumentException {

		ProjectMarketPlace projectMarketPlace = new ProjectMarketPlace();
		projectMarketPlace.setProjectMarketPlaceId(1);
		projectMarketPlace.setName(name);
		

		return this.pmMapper.insert(projectMarketPlace);

	}
	
	public ProjectMarketPlace findProjectMarketPlaceById(int id) throws IllegalArgumentException {
		return this.pmMapper.findById(id);
	}

	public Vector<ProjectMarketPlace> findAllProjectMarketPlace() throws IllegalArgumentException {
		return this.pmMapper.findAll();
	}

	public void update(ProjectMarketPlace pm) throws IllegalArgumentException {
		pmMapper.update(pm);
	}

	public void delete(ProjectMarketPlace pm) throws IllegalArgumentException {
		pmMapper.delete(pm);
	}
	
	//Methoden zur Verwaltung eines Users
	
	public User createUser(String google_id, String name, String typ)
			throws IllegalArgumentException {

		User user= new User();
		user.setGoogleId(google_id);
		user.setName(name);
		user.setTyp(typ);

		return this.usMapper.insert(User)

	}
	
	public User getUserById(int id) throws IllegalArgumentException {
		return this.usMapper.findByKey(id);
	}

	public Vector<User> getAllUser() throws IllegalArgumentException {
		return this.usMapper.findAll();
	}

	public Vector<User> getUserByName(String name) {
		return this.usMapper.findByName(name);
	}
	
	public Vector<User> getUserByTyp(String typ) {
		return this.usMapper.findByTyp(typ);
	}

	public void updateUser(User User) throws IllegalArgumentException {
		this.usMapper.update(User);
	}

	public void deleteUser(User User) throws IllegalArgumentException {
		
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
      	
	//Methoden zur Verwaltung einer Bewerbung
	public Application createApplication (int applicationID, Date startdate, String definition)
			throws IllegalArgumentException {
		Application application = new Application();
		return this.apMapper.insert(application, null, null);
	}

	public void updateApplication(int applicationID, Date startDate, String definition
			throws IllegalArgumentException {
		Application application = new Application ();
		application.setApplicationID(applicationID);
		application.setStartDate(startDate);
		application.setDefinition(definition);
		this.apMapper.update(application);
	}
	
	public void deleteApplication(Application application) {
		
		
		Application a = this.apMapper.findByApplication(application);
  		if (a != null) {
  			//fehlt noch
  			}
  		this.apMapper.deleteRatingOfApplication(application);
		this.apMapper.delete(application);
  		}
	
	//Methoden zur Verwaltung eines UserProfils
	
public UserProfile createUserProfile(User u) throws IllegalArgumentException {
		
	UserProfile up = new UserProfile();
		up.setUserId(u.getUserId());
		
		return this.upMapper.insertUserProfile(up);
	}

	public UserProfile findById(int i) throws IllegalArgumentException {
		return this.upMapper.findById(i);
	}

	
	public UserProfile updateUserProfile(UserProfile up) throws IllegalArgumentException {
		return this.upMapper.updateUserProfile(up);
	}

	public void deleteUserProfile(UserProfile up) throws IllegalArgumentException {
		
		
		Vector<Attribute> a= new Vector<Attribute>();
      	
      	if(a != null) {
      		a = atMapper.findByPartnerprofile(pp);
      		for(Attribute attribute : a){
      			this.deleteAttribute(Attribute);
      		}
      	}
    		//Partnerprofil löschen
    		this.upMapper.deleteUserProfile(up);
      	}
		
		
		
		//Zugehörige EIgenschaften löschen
		this.attributeMapper.deleteAttributeOfUserProfile(up);
		
	}
	public ArrayList<Tender> getAllTender() throws IllegalArgumentException {
		return this.teMapper.findAll();
	}
	
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
	
	
	public void deleteAllAttributeOfPartnerprofile(UserProfile up)throws IllegalArgumentException{
		atMapper.deleteAllAttributeOfUserProfile(up);
	}
	
	
	public Vector<Attribute> selectAllAttributeOfUserProfile(UserProfile up)throws IllegalArgumentException{
		return this.atMapper.findByUserProfile(up);
	}
	

	
	//Methoden fÃ¼r die Customer-Objekte
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
	
	public Vector <Participation> getAllParticipationsOfUser (int userRef) throws IllegalArgumentException {
		return paMapper.getAllParticipationsOfUser (userRef);
	}
	
	public Vector <Participation> getAllParticipations () throws IllegalArgumentException {
		return paMapper.getAllParticipations();
	}
	
	
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
	
	
	//Methoden zur Verwaltung von Ausschreibungen
	public Tender createTender (int projectRef, int tenderProfileRef, String text) throws IllegalArgumentException {
		Tender t = new Tender();
		t.setProjectRef(projectRef);
		t.setTenderProfilRef(tenderProfileRef);
		t.setText(text);
		
		return teMapper.insert(t);
	}
	
	public Tender findTenderById (int tenderRef) throws IllegalArgumentException {
		return teMapper.findByID(tenderRef);
	}
	
	public void updateTender (Tender t, int projectRef, int tenderProfileRef, String text) throws IllegalArgumentException {
		t.setProjectRef(projectRef);
		t.setTenderProfilRef(tenderProfileRef);
		t.setText(text);
		
		teMapper.update(t);
	}
	
	public Vector <Tender> getAllTenderOfUser (int userRef) throws IllegalArgumentException {
		return teMapper.getAllTenderOfUser(userRef);
	}
	
	
	*/
	
	*/
	
	
	
	
	
	
	
	
}
