package de.hdm.marketPlace.shared.bo;

import java.util.Date; 

/*Realisierung eines Projekts welches am Marktplatz angelegt werden
 * kann. Ein Projekt hat einen Name, einen Text/Inhalt usw.*/

public class Project extends BusinessObject{
	
	//Attribute der Klasse 
	
	private String name = ""; 
	private String text =""; 
	private Date startDate;
	private Date endDate; 
	private int projectmarketplaceRef = 0; 
	private int userRef = 0; 
	private int tenderRef = 0;
	
	/*Alle Get und Set Methoden zum auslesen und setzen der 
	Attribute */
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
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
	public int getTenderRef() {
		return tenderRef;
	}
	public void setTenderRef(int tenderRef) {
		this.tenderRef = tenderRef;
	}
	public int getUserRef() {
		return userRef;
	}
	public void setUserRef(int userRef) {
		this.userRef = userRef;
	} 
	public int getProjectmarketplaceRef() {
		return projectmarketplaceRef;
	}
	public void setProjectmarketplaceRef(int projectmarketplaceRef) {
		this.projectmarketplaceRef = projectmarketplaceRef;
	}

		
	//Textuelle Ausgabe der jeweiligen Projekt-Instanz 
	
	public String toString() {
		    return super.toString() + "Name:  " + this.name + "Text: " + this.text+ " ProjectMarketplace: " + this.projectmarketplaceRef+  "Tender: " + this.tenderRef+ "User: " + this.userRef;
		  }

}
