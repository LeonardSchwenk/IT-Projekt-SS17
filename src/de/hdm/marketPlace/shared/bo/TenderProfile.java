package de.hdm.marketPlace.shared.bo;

import java.util.Date;

/*Realisierung eines Partnerprofils. Dieses Profil ist einer 
 * Ausschreibung zuzuordnen und stellt das Profil des 
 * gesuchten Mitarbeiters dar. */

public class TenderProfile extends BusinessObject{
	
	//Attribute der Klasse 
	
	private Date tenderDate;
	private int tenderRef = 0;
	
	
	
	/*Alle Get und Set Methoden zum auslesen und setzen der 
	Attribute */
	
	
	public int getTenderRef() {
		return tenderRef;
	}
	public Date getTenderDate() {
		return tenderDate;
	}
	public void setTenderDate(Date tenderDate) {
		this.tenderDate = tenderDate;
	}
	public void setTenderRef(int tenderRef) {
		this.tenderRef = tenderRef;
	}
	
	
	
	//Textuelle Darstellung der jeweiligen Partnerprofil-Instanz 
	
	public String toString() {
		    return super.toString() + "TenderRef:  " + this.tenderRef;
		  }
}
