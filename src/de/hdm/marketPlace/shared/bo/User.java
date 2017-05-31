package de.hdm.marketPlace.shared.bo;

/**
 * Realisierung eines Nutzers des Systems
 */ 

public class User extends BusinessObject {
	
	
	/**
	 * Attribute der Klasse 
	 */
	
	/**
	 * Vorname des Users
	 */
	private String firstname = "";
	
	/**
	 * Nachname des Users
	 */
	private String lastname = "";
	
	/**
	 * Referenz auf den jeweiligen Projektmarktplatz an dem der User eingeschrieben ist
	 */
	private int projectmarketplaceRef = 0; 
	
	/**
	 * Alle Get und Set Methoden zum auslesen und setzen der Attribute
	 */
	
	/**
	 * Ausgabe der Projektmarktplatz Referenz
	 */
	public int getProjectmarketplaceRef() {
		return projectmarketplaceRef;
	}
	
	/**
	 * Setzen der Projektmarktplatz Referenz
	 */
	public void setProjectmarketplaceRef(int projectmarketplaceRef) {
		this.projectmarketplaceRef = projectmarketplaceRef;
	}
	
	/**
	 * Ausgabe des Vornamens
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Setzen des Vornamens
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Ausgabe des Nachnamens
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Setzen des Nachnamens
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Textuelle Ausgabe der jeweiligen Nutzerprofil-Instanz  
	 */
	public String toString() {
		
		/*
		 * Ausgabe des Vornamens gefolgt von Nachname
		 */
		    return super.toString() + "FirstName:  " + this.firstname +
			    		"LastName: " + this.lastname;
			  }
	
}

