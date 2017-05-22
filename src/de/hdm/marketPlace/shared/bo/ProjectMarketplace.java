package de.hdm.marketPlace.shared.bo;


public class ProjectMarketplace extends BusinessObject{

	//attributes of the class
	
	private String name = "";
	
	private int userRef = 0; 
	
	//Setters and Getters of all attributes
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public int getUserRef() {
		return userRef;
	}
	public void setUserRef(int userRef) {
		this.userRef = userRef;
	}
	
	public String toString() {
	    
	      
		return super.toString()+"Name:" + this.name + "User" + this.userRef;

		
	   
}
}