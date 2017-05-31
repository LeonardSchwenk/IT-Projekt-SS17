package de.hdm.marketPlace.shared.bo;

/**
 * Realisierung einer Bewertung. Diese bewertet eine Bewerbung/einen Bewerber
 * und ist unter anderem ausschlaggeben für eine Projektbeteiligung
 */

public class Rating extends BusinessObject{

	/**
	 * Attribute der Klasse
	 */
	
	/**
	 * Wert der Bewertung
	 */
	private float rate = 0;
	
	/**
	 * Beschreibender Text
	 */
	private String text = "";
	
	/**
	 * Referenz auf die zugehörige Bewerbung
	 */
	private int applicationRef = 0; 
	
	/**
	 * Alle Get und Set Methoden zum auslesen und setzen der Attribute
	 */
	
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
	 * Integerwert wird auf String geändert, um im späteren Verlauf 
	 * im Reportgenerator ausgegeben zu werden
	 */
	public String getRate() {
		String s = String.valueOf(rate);
		return s;
	}
	
	/**
	 * Setzen des Bewertungswertes
	 */
	public void setRate(float rate) {
		this.rate = rate;
	}
	
	/**
	 * Ausgabe der Bewerbungs Referenz
	 */
	public int getApplicationRef() {
		return applicationRef;
	}
	
	/**
	 * Setzen der Bewerbungs Referenz
	 */
	public void setApplicationRef(int applicationRef) {
		this.applicationRef = applicationRef;
	}
	

	/**
	 * Textuelle Ausgabe der jeweiligen Bewertungs-Instanz
	 */
	public String toString() {
		
		/*
		 * Ausgabe des Bewertungswertes gefolgt vom Text, der Bewerbungsreferenz
		 */
		    return super.toString() + "Rate:  " + this.rate + "Text: " + this.text
		    		+ " ApplicationRef: " + this.applicationRef;
		  }
	
}
