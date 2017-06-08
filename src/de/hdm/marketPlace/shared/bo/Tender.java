package de.hdm.marketPlace.shared.bo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Realisierung einer Ausschreibung/Stellenanzeige. 
 * Diese hat einen Namen und einen Text/Inhalt
 * usw.
 */

public class Tender extends BusinessObject{

	/**
	 * Attribute der Klasse 
	 */
	
	/**
	 * Text der Ausschreibung
	 */
	private String text = "";
	
	/**
	 * Name der Ausschreibung
	 */
	private String name = "";
	
	/**
	 * Referenz auf das zugehörige Projekt
	 */
	private int projectRef = 0;
	
	/**
	 * Startdatum der Ausschreibung
	 */
	private Date startDate;
	
	/**
	 * Enddatum der Ausschreibung
	 */
	private Date endDate;
	
	/**
	 * Alle Get und Set Methoden zum auslesen und setzen der Attribute
	 */
	
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
	 * Ausgabe der jeweiligen Projekt Referenz
	 */
	public int getProjectRef() {
		return projectRef;
	}
	
	/**
	 * Setzen der jeweiligen Projekt Referenz
	 */
	public void setProjectRef(int projectRef) {
		this.projectRef = projectRef;
	}
	
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
	 * Textuelle Darstellung der jeweiligen Ausschreibungs-Instanz 
	 */
	public String toString() {
		
		/*
		 * Ausgabe des Namens gefolgt von Text und der Projekt Referenz
		 */
		    return super.toString() + "Name:  " + this.name + "Text: " + this.text+ " ProjectRef: " + this.projectRef;
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
	
	/**
	 * Ausgabe des Startdatums
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
	 * Setzen des Enddatums
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
