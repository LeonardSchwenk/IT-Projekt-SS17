package de.hdm.marketPlace.shared.bo;

/*Realisierung eines Partnerprofils. Ein Partnerprofil wird durch 
 * ein User in Bewerberrolle angelegt und hat einen Text/Inhalt
 * und ein Attribut. Dieses stellt den Beruf/Ausbildung dar. */

public abstract class PartnerProfile extends BusinessObject {
	
	//Attribute der Klasse 
	
	private String text = "";
	private String attribute = "";
	
	/*Alle Get und Set Methoden zum auslesen und setzen der 
	Attribute */

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	 public String toString() {
		    return super.toString() + "Attribute:  " + this.attribute + "Text: " + this.text;
		  }

}
