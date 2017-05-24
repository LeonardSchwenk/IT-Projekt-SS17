package de.hdm.marketPlace.shared.bo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date; 

/*Realisierung einer Projektbeteiligung. Diese deutet an, dass ein
 * Projektleiter mit einem Bewerber zusammenarbeiten will.*/

public class Participation extends BusinessObject{
	
	//Attribute der Klasse
	
	private int projectRef = 0;
	private int userRef = 0; 
	private int ratingRef = 0; 
	private int tenderRef  = 0;
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
	public int getTenderRef() {
		return tenderRef;
	}
	public void setTenderRef(int tenderRef) {
		this.tenderRef = tenderRef;
	}

	/*Integerwert wird auf String geändert, um im späteren Verlauf 
	 * im Reportgeneratro ausgegeben zu werden */
	
	public String getWorkingDays() {
		String s = String.valueOf(workingDays);
		return s;
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
	//Textuelle Ausgabe der jeweiligen Projektbeteiligungs-Instanz 
	
	 public String toString() {
		    return super.toString() + "projectRef:  " + this.projectRef + "userRef: " + this.userRef+ " ratingRef: " + this.ratingRef + "workingDays" + this.workingDays+ "startdate" + this.startDate+ "enddate" + this.endDate;
		  }
	 
	 public String DateToString(Date d){
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String stringDate = df.format(d);
			return stringDate;
		}
	
}