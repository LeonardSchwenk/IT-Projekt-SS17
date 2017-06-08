package de.hdm.marketPlace.shared.bo;

/**
 * Realisierung eines Projektmarktplatz auf welcheme Projekte angelegt 
 * werden können.
 */

public class ProjectMarketplace extends BusinessObject{

	/**
	 * Attribute der Klasse 
	 */
	
	/**
	 * Name des Projektmarktplatzes
	 */
	private String name = "";
	
	/**
	 * Alle Get und Set Methoden zum auslesen und setzen der Attribute
	 */
	
	/**
	 * Ausgabe des Namens
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setzen des Namens
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Textuelle Ausgabe der jeweiligen Martplatz-Instanz 
	 */
	public String toString() {
		
	/*
	 * Ausgabe des Namens
	 */
	    return super.toString()+"Name:" + this.name;	   
	}
	
}