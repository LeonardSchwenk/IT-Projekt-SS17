package de.hdm.marketPlace.shared.bo;

/*Realisierung einer Ausschreibung/Stellenanzeige. 
 * Diese hat einen Namen und einen Text/Inhalt
 * usw.*/

public class Tender extends BusinessObject{

	//Attribute der Klasse 
	
	private String text = "";
	private String name = "";
	private int projectRef = 0;
	private int tenderProfilRef = 0;
	
	/*Alle Get und Set Methoden zum auslesen und setzen der 
	Attribute */
	
	public int getTenderProfilRef() {
		return tenderProfilRef;
	}
	public void setTenderProfilRef(int tenderProfilRef) {
		this.tenderProfilRef = tenderProfilRef;
	}
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
	
}
