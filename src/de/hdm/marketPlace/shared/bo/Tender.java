package de.hdm.marketPlace.shared.bo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*Realisierung einer Ausschreibung/Stellenanzeige. 
 * Diese hat einen Namen und einen Text/Inhalt
 * usw.*/

public class Tender extends BusinessObject{

	//Attribute der Klasse 
	
	private String text = "";
	private String name = "";
	private int projectRef = 0;

	private Date startDate;
	private Date endDate;
	
	/*Alle Get und Set Methoden zum auslesen und setzen der 
	Attribute */
	

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getProjectRef() {
		return projectRef;
	}
	public void setProjectRef(int projectRef) {
		this.projectRef = projectRef;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// Textuelle Darstellung der jeweiligen Ausschreibungs-Instanz 
	
	public String toString() {
		    return super.toString() + "Name:  " + this.name + "Text: " + this.text+ " ProjectRef: " + this.projectRef;
		  }
	
	public String DateToString(Date d){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String stringDate = df.format(d);
		return stringDate;
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
	
}
