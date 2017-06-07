package de.hdm.marketPlace.shared.bo;

	/**Realisierung eines Attributobjekts. Dieses gibt 
	 * weiter Informationen über einen Nutzer an. 
	 */

public class Attribute extends BusinessObject {
	
	/**
	 * Attribute der Klasse 
	 */
	
	/**
	 * Name des Attributs
	 */
	private String name = "";
	
	/**
	 * Weiterer beschreibender Text
	 */
	private String text = "";
	
	/**
	 * Werte die gesetzt werden können
	 */
	private int value = 0 ;
	
	/**
	 * Referenz auf das User Profil
	 */
	private int userprofileRef = 0;
	
	/**
	 * Referenz auf das Ausschreibungsprofil
	 */
	private int tenderprofilRef =0; 
	
	/**
	 *Alle Get und Set Methoden zum Auslesen und Setzen der Attribute 
	 */
	
	/**
	 * Ausgabe des Namens
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setzen des Namens
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Ausgabe des Textes
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Setzen des Textes
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * Integerwert wird auf String geändert, um im späteren Verlauf im Reportgenerator ausgegeben zu werden 
	 */
	public String getValue() {
		
		/*
		 * Objekt vom Datentyp String wird erstellt und dem Wert des Integers zu gewiesen
		 */
		String s = String.valueOf(value);
		
		/*
		 * String wurd zurückgegeben
		 */
		return s;
	}
	
	/**
	 * Setzen des Wertes
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * Ausgeben der Referenz auf das User Profil
	 */
	 public int getUserprofileRef() {
		return userprofileRef;
	}
	 
	/**
	 * Setzen der Referenz auf das User Profil
	 */
	public void setUserprofileRef(int userprofileRef) {
		this.userprofileRef = userprofileRef;
	}
	
	/**
	 * Ausgabe der Referenz auf das Ausschreibungsprofil
	 */
	public int getTenderprofilRef() {
		return tenderprofilRef;
	}
	
	/**
	 * Setzen der Referenz auf das Ausschreibungsprofil
	 */
	public void setTenderprofilRef(int tenderprofilRef) {
		this.tenderprofilRef = tenderprofilRef;
	}
	
	/**
	 * Textuelle Ausgabe der jeweiligen Attribut-Instanz 
	 */
	
	/**
	 * Erzeugen einer textuellen Beschreibung der jeweiligen Attributsinstanz
	 */
	public String toString() {
		
	/*
	 * Der Name gefolgt vom Text, Wert und den jeweiligen Referenzen auf das User Profil als auch das Ausschreibungsprofil wird zurückgegeben
	 */
	return super.toString() + "Name:  " + this.name + "Text: " + this.text+ " Value: " + this.value + "UserProfile: " + this.userprofileRef + 
		    		"TenderProfil : " + this.tenderprofilRef;
		  }
	
}
