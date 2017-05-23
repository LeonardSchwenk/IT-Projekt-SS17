package de.hdm.marketPlace.shared.bo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*Realisierung eines Partnerprofils. Dieses Profil ist einer 
 * Ausschreibung zuzuordnen und stellt das Profil des 
 * gesuchten Mitarbeiters dar. */

public class TenderProfile extends BusinessObject{
	
	//Attribute der Klasse 
	
	private Date createDate;
	private Date updateDate;
	private int tenderRef = 0;
	private int partnerprofileRef = 0;
	private int attributeRef = 0;
	
	/*Alle Get und Set Methoden zum auslesen und setzen der 
	Attribute */
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
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
	public int getAttributeRef() {
		return attributeRef;
	}
	public void setAttributeRef(int attributeRef) {
		this.attributeRef = attributeRef;
	}
	
	//Textuelle Darstellung der jeweiligen Partnerprofil-Instanz 
	
	public String toString() {
		    return super.toString() + "TenderRef:  " + this.tenderRef + "PartnerprofileRef: " + this.partnerprofileRef+ " AttributeRef: " + this.attributeRef;
		  }
	
	public String DateToString(Date d){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String stringDate = df.format(d);
		return stringDate;
	}
	

}
