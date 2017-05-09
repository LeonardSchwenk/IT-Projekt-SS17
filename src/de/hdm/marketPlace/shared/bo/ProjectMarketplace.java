package de.hdm.marketPlace.shared.bo;

import java.util.Vector; 

public class ProjectMarketplace extends BusinessObject{

	//attributes of the class
	
	private String name = "";
	
	private Vector<UserProfile> userRef = new Vector<UserProfile>();
	
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
	
	public void addUserRef (UserProfile a){
		this.userRef.addElement (a);
	}
	
	public void removeUserRef (UserProfile a){
		this.userRef.addElement(a);
	}
	
	public UserProfile getParagraphAt(int a) {
	    return this.userRef.elementAt(a);
	}
	
	public String toString() {
	    
	    StringBuffer result = new StringBuffer();

	    
	    for (int i = 0; i < this.userRef.size(); i++) {
	      UserProfile a = this.userRef.elementAt(i);

	     
	      result.append(a.toString() + "\n");
	    }

	    
	    return result.toString();
}
}