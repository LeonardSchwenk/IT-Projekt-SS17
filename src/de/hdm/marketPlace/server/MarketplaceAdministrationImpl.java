package de.hdm.marketPlace.server;

import de.hdm.marketPlace.shared.*;

import de.hdm.marketPlace.shared.bo.*;
import de.hdm.marketPlace.server.db.*;

import java.util.Vector;
import java.util.ArrayList;
import java.util.Date;



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
	
	//Methoden für die Customer-Objekte
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
	
	
	
	
	
	
	
	
	
	
	
}
