package de.hdm.marketPlace.shared.bo;

/**Realisierung eines Partnerprofils. Ein Partnerprofil wird durch 
 * ein User in Bewerberrolle angelegt und hat einen Text/Inhalt
 * und ein Attribut. Dieses stellt den Beruf/Ausbildung dar.
 */

public abstract class PartnerProfile extends BusinessObject {
	
	/**
	 * Attribute der Klasse 
	 */
	
	/**
	 * Text des Partnerprofiles
	 */
	private String text = "";
	
	/**
	 * Attribut des Partnerprofiles
	 */
	private String attribute = "";
	
	/**
	 * Alle Get und Set Methoden zum Auslesen und Setzen der Attribute
	 */

	/**
	 * Ausgabe des Attributs
	 */
	public String getAttribute() {
		return attribute;
	}

	/**
	 * Setzen des Attributs
	 */
	public void setAttribute(String attribute) {
		this.attribute = attribute;
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
	 * Textuelle Ausgabe der jeweiligen Partnerprofil-Instanz
	 */
	public String toString() {
		
	/*
	 * Ausgabe des Attributs gefolgt vom Text
	 */
	    return super.toString() + "Attribute:  " + this.attribute + "Text: " + this.text;
		  }

}
