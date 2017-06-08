package de.hdm.marketPlace.shared.bo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date; 

/**
 * Realisierung eines Projekts welches am Marktplatz angelegt werden
 * kann. Ein Projekt hat einen Name, einen Text/Inhalt usw.
 */

public class Project extends BusinessObject{
	
	/**
	 * Attribute der Klasse 
	 */
	
	/**
	 * Name des Projektes
	 */
	private String name = ""; 
	
	/**
	 * Text des Projektes
	 */
	private String text =""; 
	
	/**
	 * Anfangsdatum an dem das Projekt beginnt
	 */
	private Date startDate;
	
	/**
	 * Enddatum an dem das Projekt beginnt
	 */
	private Date endDate; 
	
	/**
	 * Referenz auf den jeweilig zugehörigen Projektmarktplatz
	 */
	private int projectmarketplaceRef = 0; 
	
	/**
	 * Referenz auf den User der das Projekt erstellt
	 */
	private int userRef = 0; 
	
	
	/**
	 * Alle Get und Set Methoden zum auslesen und setzen der Attribute
	 */
	
	/**
	 * Ausgabe des Projektnamens
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setzen des Projektnamens
	 */
	public void setName(String name) {
		this.name = name;
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
	 * Ausgabe des Anfangsdatums
	 */
	public Date getStartDate() {
		return startDate;
	}
	
	/**
	 * Setzen des Startdatums
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * Ausgabe des Enddatums
	 */
	public Date getEndDate() {
		return endDate;
	}
	
	/**
	 *Setzen des Enddatums
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
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
	 * Textuelle Ausgabe der jeweiligen Projekt-Instanz 
	 */
	public String toString() {
		
		/*
		 * Ausgabe des Namens gefolgt von Text, Projektmarktplatzreferenz und User Referenz
		 */
		    return super.toString() + "Name:  " + this.name + "Text: " + this.text+ " ProjectMarketplace: " + this.projectmarketplaceRef+ "User: " + this.userRef;
		  }
	
	/**
	 * Ein Übergabeparameter vom Typ Date wird in einen String umgewandelt und im Anschluss zurückgegeben
	 */
	public String DateToString(Date d){
		
		/*
		 * Ein neues Datums Objekt wird erstellt 
		 */
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		/*
		 * Einer neuen String Variable werden die Werte vom Übergabeparameter d zugewiesen
		 */
		String stringDate = df.format(d);
		
		/*
		 * Die neue String Variable wird zurückgegeben
		 */
		return stringDate;
	}

}
