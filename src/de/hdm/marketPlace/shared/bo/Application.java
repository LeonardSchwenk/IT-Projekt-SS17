package de.hdm.marketPlace.shared.bo;

import java.util.Date; 

/*Realisierung einer Bewerbung, welche ein Nutzer des Projektmarktplatz
 * anlegen kann. Eine Bewerbung besitz ein Titel, einen Text (Inhalt/Motivationsschreiben)
 * usw. 
 * */
public class Application extends BusinessObject{
	
	//Attribute der Klasse 
	
	private String titel = "";		
	private String text = ""; 
	private Date applicationDate; 
	private int userRef = 0; 
	private int tenderRef = 0;
	private int ratingRef = 0;
	
	// No Argument Konstruktor 
	
	public Application(){
		super();
		
	}
	
	/*Alle Get und Set Methoden zum auslesen und setzen der 
	Attribute */
	

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getUserRef() {
		return userRef;
	}
	public void setUserRef(int userRef) {
		this.userRef = userRef;
	}
	public int getTenderRef() {
		return tenderRef;
	}
	public void setTenderRef(int tenderRef) {
		this.tenderRef = tenderRef;
	}
	public int getRatingRef() {
		return ratingRef;
	}
	public void setRatingRef(int ratingRef) {
		this.ratingRef = ratingRef;
	} 
	
	 public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}
	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	
	// Erzeugt textuelle Darstellung der jeweiligen Bewerbungs-Instanz 

	public String toString() {
		    return super.toString() + " Text: " +  " Rating: " + this.ratingRef+ " Tender: " + this.tenderRef+ " User: " + this.userRef;
		    }
}
		   
