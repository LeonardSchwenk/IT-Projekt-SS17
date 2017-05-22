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
	
	
	
	//Anlegen eines Null-Argument-Constructors für die Klasse MarketplaceAdministrationImpl
	public MarketplaceAdministrationImpl() throws IllegalArgumentException {
		
	}
	
	//Implementierung des Codes in die Klassen, welche vorher in dem Interface MarketplaceAdministration definiert wurden
	public void init() throws IllegalArgumentException {
		this.apMapper = ApplicationMapper.applicationMapper();
		this.atMapper = AttributeMapper.attributeMapper();
		this.paMapper = ParticipationMapper.participationMapper();
		this.prMapper = ProjectMapper.projectMapper();
		this.pmMapper = ProjectMarketplaceMapper.ProjectMarketplaceMapper();
		this.raMapper = RatingMapper.ratingMapper();
		this.teMapper = TenderMapper.tenderMapper();
		this.usMapper = UserMapper.userMapper();
		this.upMapper = UserProfileMapper.userProfileMapper();
		
	}
	
	//Methoden für die Customer-Objekte
	//Methoden zur Verwaltung eines Ausschreiberprofils
	
	public TenderProfile createTenderProfile (Date createDate) throws IllegalArgumentException{
		TenderProfile tp = new TenderProfile();
	}
	
	
	
	
	
	
}
