package de.hdm.marketPlace.shared.bo;

/*Realisierung eines Nutzerprofils. */ 

public class UserProfile extends BusinessObject {

	//Attribute der Klasse
	
	private int userRef = 0;
	private String text = "";
	private int attributeRef = 0;

	/*Alle Get und Set Methoden zum auslesen und setzen der 
	Attribute */
	
	public int getUserRef() {
		return userRef;
	}
	public void setUserRef(int userRef) {
		this.userRef = userRef;
	}
	public int getAttributeRef() {
		return attributeRef;
	}
	public void setAttributeRef(int attributeRef) {
		this.attributeRef = attributeRef;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	//Textuelle Ausgabe der jeweiligen Nutzerprofil-Instanz  
	
	public String toString() {
		    return super.toString() + "UserRef:  " + this.userRef + "Text: " + this.text+ " AttributeRef: " + this.attributeRef;
		  }
}
