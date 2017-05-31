package de.hdm.marketPlace.shared.bo;

/**
 * Realisierung eines Nutzerprofils.
 */ 

public class UserProfile extends BusinessObject {

	/**
	 * Attribute der Klasse
	 */
	
	/**
	 * Referenz auf den User
	 */
	private int userRef = 0;
	
	/**
	 * Text des User Profils
	 */
	private String text = "";
	

	/**
	 * Alle Get und Set Methoden zum Auslesen und Setzen der Attribute
     */
	
	/**
	 * Ausgabe der User Referenz
	 */
	public int getUserRef() {
		return userRef;
	}
	
	/**
	 * Setzen der User Referenz
	 */
	public void setUserRef(int userRef) {
		this.userRef = userRef;
	}
	
	/**
	 * Ausgabe des Textes
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Setzen des Textes
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * Textuelle Ausgabe der jeweiligen Nutzerprofil-Instanz  
	 */
	public String toString() {
		
		/*
		 * Ausgabe der User Referenz gefolgt von dem Text des Profils
		 */
		    return super.toString() + "UserRef:  " + this.userRef + "Text: " + this.text;
		  }
	
}
