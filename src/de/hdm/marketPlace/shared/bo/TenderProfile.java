package de.hdm.marketPlace.shared.bo;

import java.util.Date;

/*Realisierung eines Partnerprofils. Dieses Profil ist einer 
 * Ausschreibung zuzuordnen und stellt das Profil des 
 * gesuchten Mitarbeiters dar. */

public class TenderProfile extends BusinessObject{
	
	//Attribute der Klasse 
	
	private Date tenderprofileDate;
	private int tenderRef = 0;
	private int partnerprofileRef = 0;
	
	
	/*Alle Get und Set Methoden zum auslesen und setzen der 
	Attribute */
	
	
	public int getTenderRef() {
		return tenderRef;
	}
	
	public void setTenderRef(int tenderRef) {
		this.tenderRef = tenderRef;
	}
	public int getPartnerprofileRef() {
		return partnerprofileRef;
	}
	public void setPartnerprofileRef(int partnerprofileRef) {
		this.partnerprofileRef = partnerprofileRef;
	}
	
	
	//Textuelle Darstellung der jeweiligen Partnerprofil-Instanz 
	
	public String toString() {
		    return super.toString() + "TenderRef:  " + this.tenderRef + "PartnerprofileRef: " + this.partnerprofileRef;
		  }

	public Date getTenderprofileDate() {
		return tenderprofileDate;
	}

	public void setTenderprofileDate(Date tenderprofileDate) {
		this.tenderprofileDate = tenderprofileDate;
	}
}
