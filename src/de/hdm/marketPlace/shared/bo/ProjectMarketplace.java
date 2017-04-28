package de.hdm.marketPlace.shared.bo;

public class ProjectMarketplace {

	//attributes of the class
	
	private String name;
	private Vector<UserProfile> userRef;
	
	//Setters and Getters of all attributes
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Vector<UserProfile> getUserRef() {
		return userRef;
	}
	public void setUserRef(Vector<UserProfile> userRef) {
		this.userRef = userRef;
	}
	
	
	
	
}
