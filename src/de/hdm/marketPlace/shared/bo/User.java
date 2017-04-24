package de.hdm.marketPlace.shared.bo;

public class User {
	
	
	//Anlegen der Attribute für die Klasse User
	private int userId;
	private String name;
	
	//Getter und Setter-Methoden für die Attribute
	
	public void setUserId (int userId){
		this.userId = userId;
	}
	public int getUserId (){
		return userId;
	}
	
	public void setName (String name){
		this.name = name;
	}
	public String getName (){
		return name;
	}
	
	
	

}
