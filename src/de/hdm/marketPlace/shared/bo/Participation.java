package de.hdm.marketPlace.shared.bo;

import java.util.Date; 

/*Realisierung der Projektbeteiligung, die nach erfolgreicher 
 * Bewerbung angelegt werden kann. Diese Beteiligung hat 
 * Referenzen zum jeweiligen Projekt, User und zur Bewertung.
 * Auﬂerdem gibt es Start- und Enddaten in Form von Terminen. */

public class Participation extends BusinessObject{
	
	//Attribute der Klasse 
	
	private int projectRef = 0;
	private int userRef = 0; 
	private int ratingRef = 0; 
	private int workingDays = 0;
	private Date startDate;
	private Date endDate;
	
	/*Alle Get und Set Methoden zum auslesen und setzen der 
	Attribute */
	
	public int getProjectRef() {
		return projectRef;
	}
	public void setProjectRef(int projectRef) {
		this.projectRef = projectRef;
	}
	public int getUserRef() {
		return userRef;
	}
	public void setUserRef(int userRef) {
		this.userRef = userRef;
	}
	public int getRatingRef() {
		return ratingRef;
	}
	public void setRatingRef(int ratingRef) {
		this.ratingRef = ratingRef;
	}
	
	/*Integerwert wird auf String ge‰ndert, um im sp‰teren Verlauf 
	 * im Reportgeneratro ausgegeben zu werden */
	
	public int getWorkingDays() {
		return workingDays;
	}
	public void setWorkingDays(int workingDays) {
		this.workingDays = workingDays;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	//Textuelle Ausgabe der jeweiligen Projektbeteiligungsinstanz 
	
	 public String toString() {
		    return super.toString() + "projectRef:  " + this.projectRef + "userRef: " + this.userRef+ " ratingRef: " + this.ratingRef + "workingDays" + this.workingDays+ "startdate" + this.startDate+ "enddate" + this.endDate;
		  }
}
