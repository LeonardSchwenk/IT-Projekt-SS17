package de.hdm.marketPlace.shared;

import java.util.ArrayList.*;

import java.util.Date;
import java.util.Vector;

import de.hdm.marketPlace.shared.bo.*;



public interface MarketplaceAdministration {
	
	public void init() throws IllegalArgumentException;
	
	
	//Methoden zur Verwaltung von Projekten
	public Project createProject (String name, Date startDate, Date endDate) throws IllegalArgumentException;
	public void updateProject (Project project) throws IllegalArgumentException;
	public void deleteProject (Project project) throws IllegalArgumentException;
	public void getProject(Project project) throws IllegalArgumentException;
	public Vector <Project> getAllProjects (User user) throws IllegalArgumentException;
	
	
	//Methoden zur Verwaltung von ProjectMarketplace
	public ProjectMarketplace createMarketplace (String name) throws IllegalArgumentException;
	public void updateMarketplace (ProjectMarketplace marketplace) throws IllegalArgumentException;
	public void deleteMarketplace (ProjectMarketplace marketplace) throws IllegalArgumentException;
	public void joinMarketplace (int marketplaceId, User user) throws IllegalArgumentException;
	public void leaveMarketplace (int marketplaceId, User user) throws IllegalArgumentException;
	
	//Methoden zur Benutzerverwaltung
	public User createUser (User user) throws IllegalArgumentException;
	public void updateUser (int partnerProfilId) throws IllegalArgumentException;
	public void deleteUser (int partnerProfilId) throws IllegalArgumentException;
	public User findById (int partnerProfilId) throws IllegalArgumentException;
	public User findByName (String name) throws IllegalArgumentException;
	
	//Methoden zur Verwaltung von Methoden
	
	
	
	
	
	
	
}