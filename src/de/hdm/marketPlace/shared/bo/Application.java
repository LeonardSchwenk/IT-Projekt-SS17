package de.hdm.marketPlace.shared.bo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date; 

/*Realisierung einer Bewerbung, welche einen Nutzer des Projektmarktplatzes
 * anlegen kann. Eine Bewerbung besitzt ein Titel, einen Text (Inhalt/Motivationsschreiben)
 * usw. 
 * */
public class Application extends BusinessObject{
	
	/**
	 * Alle Attribute der Klasse   
	 */
	
	/**
	 * Name der Bewerbung
	 */
	private String name = "";	
	
	/**
	 * Inhalt der Bewerbung
	 */
	private String text = ""; 
	
	/**
	 * Bewerbungsdatum der Bewerbung
	 */
	private Date applicationDate;
	
	/**
	 * Referenz zum User der die Bewerbung schreibt
	 */
	private int userRef = 0;
	
	/**
	 * Referenz zur Ausschreibung auf die, die Bewerbung geschrieben wird
	 */
	private int tenderRef = 0;
	
	
	/**
	 *  No Argument Konstruktor 
	 */
		public Application(){
		super();
	}
	
	/**
	 * Alle Get und Set Methoden zum Auslesen und Setzen der Attribute
	 */
	
		
	/**
	 * Auslesen des Inhaltes
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Setzen des Inhaltes
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * Auslesen der User Referenz
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
	 * Auslesen der Ausschreibungsreferenz
	 */
	public int getTenderRef() {
		return tenderRef;
	}
	
	/**
	 * setzen der Ausschreibungsreferenz
	 */
	public void setTenderRef(int tenderRef) {
		this.tenderRef = tenderRef;
	}
	
	/**
	 * Auslesen des Namens
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
	 * Auslesen des Bewerbungsdatums
	 */
	public Date getApplicationDate() {
		return applicationDate;
	}

	/**
	 * Setzen des Bewerbungsdatums
	 */
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	
	/**
	 *  Erzeugt textuelle Darstellung der jeweiligen Bewerbungs-Instanz 
	 */

	/**
	 * Erzeugen einer textuellen Beschreibung der jeweiligen Bewerbungsinstanz
	 */
	@Override
	public String toString() {
		/*
		 * Der Name gefolgt vom Inhalt, der Ausschreibung und dem User wird zurückgegeben
		 */
		    return super.toString() + "Name : " + this.name +" Text: " + this.text + " Tender: " + this.tenderRef+ " User: " + this.userRef;
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
		   
