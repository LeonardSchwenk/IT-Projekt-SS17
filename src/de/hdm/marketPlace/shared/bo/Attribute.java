package de.hdm.marketPlace.shared.bo;

/*Realisierung eines Attributobjekts. Dieses gibt 
 * weiter Informationen über einen Nutzer an. 
*/

public class Attribute extends BusinessObject {
	
	//Attribute der Klasse 
	
	private String name = "";
	private String text = "";
	private int value = 0 ;
	private int userprofileRef = 0;
	priavte int tenderprofilRef =0; 
	
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
	/*Integerwert wird auf String geändert, um im späteren Verlauf 
	 * im Reportgeneratro ausgegeben zu werden */
	
	public String getValue() {
		String s = String.valueOf(value);
		return s;
	}
	public void setValue(int value) {
		this.value = value;
	}
	 public int getUserprofileRef() {
		return userprofileRef;
	}
	public void setUserprofileRef(int userprofileRef) {
		this.userprofileRef = userprofileRef;
	}
	public int getTenderprofilRef() {
		return tenderprofilRef;
	}
	public void setTenderprofilRef(int tenderprofilRef) {
		this.tenderprofilRef = tenderprofilRef;
	}
	
	//Textuelle Ausgabe der jeweiligen Attribut-Instanz 
	
	public String toString() {
		    return super.toString() + "Name:  " + this.name + "Text: " + this.text+ " Value: " + this.value + "UserProfile: " + this.userprofileRef + 
		    		"TenderProfil : " + this.tenderprofilRef;
		  }
	
	

}
