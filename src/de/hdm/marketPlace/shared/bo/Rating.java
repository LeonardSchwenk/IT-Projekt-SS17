package de.hdm.marketPlace.shared.bo;

/*Realisierung einer Bewertung. Diese bewertet eine Bewerbung/einen Bewerber
 * und ist unter anderem ausschlaggeben für eine Projektbeteiligung*/

public class Rating extends BusinessObject{

	//Attribute der Klasse
	
	private float rate = 0;
	private String text = "";
	private int applicationRef = 0; 
	
	/*Alle Get und Set Methoden zum auslesen und setzen der 
	Attribute */
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	/*Integerwert wird auf String geändert, um im späteren Verlauf 
	 * im Reportgeneratro ausgegeben zu werden */
	
	public String getRate() {
		String s = String.valueOf(rate);
		return s;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public int getApplicationRef() {
		return applicationRef;
	}
	public void setApplicationRef(int applicationRef) {
		this.applicationRef = applicationRef;
	}
	

	//Textuelle Ausgabe einer Bewertungs-Instanz
	
	
	public String toString() {
		    return super.toString() + "Rate:  " + this.rate + "Text: " + this.text
		    		+ " ApplicationRef: " + this.applicationRef;
		  }
	
}
