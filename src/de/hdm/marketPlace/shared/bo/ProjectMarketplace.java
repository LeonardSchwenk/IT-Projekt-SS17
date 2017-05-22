package de.hdm.marketPlace.shared.bo;

/*Realisierung eines Projektmarktplatz auf welcheme Projekte angelegt 
 * werden können. */

public class ProjectMarketplace extends BusinessObject{

	//Attribute der Klasse 
	
	private String name = "";
	private int userRef = 0; 
	
	/*Alle Get und Set Methoden zum auslesen und setzen der 
	Attribute */
	
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
	
	//Textuelle Ausgabe der jeweiligen Martplatz-Instanz 
	
	public String toString() {
	    return super.toString()+"Name:" + this.name + "User" + this.userRef;	   
}
}