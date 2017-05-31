package de.hdm.marketPlace.shared.bo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Realisierung eines Partnerprofils. Dieses Profil ist einer 
 * Ausschreibung zuzuordnen und stellt das Profil des 
 * gesuchten Mitarbeiters dar.
 */

public class TenderProfile extends BusinessObject{
	
	/**
	 * Attribute der Klasse 
	 */
	
	/**
	 * Erstellungsdatum des Ausschreibendenprofils
	 */
	private Date tenderprofileDate;
	
	/**
	 * Referenz auf den Ausschreibenden
	 */
	private int tenderRef = 0;
	
	
	
	/**
	 * Alle Get und Set Methoden zum auslesen und setzen der Attribute
	 */
	
	/**
	 * Ausgabe der Ausschreibenden Referenz
	 */
	public int getTenderRef() {
		return tenderRef;
	}
	
	/**
	 * Setzen der Ausschreibenden Referenz
	 */
	public void setTenderRef(int tenderRef) {
		this.tenderRef = tenderRef;
	}
	
	
	
	/**
	 * Textuelle Darstellung der jeweiligen Partnerprofil-Instanz 
	 */
	
	/**
	 * Textuelle Ausgabe des jeweiligen Ausschreibenden Profil-Instanz 
	 */
	public String toString() {
		
		/*
		 * Ausgabe der Ausschreibenden Referenz
		 */
		    return super.toString() + "TenderRef:  " + this.tenderRef;
		  }


	/**
	 * Ausgabe des Datums
	 */
	public Date getTenderprofileDate() {
		return tenderprofileDate;
	}

	/**
	 * Setzeb des Datums
	 */
	public void setTenderprofileDate(Date tenderprofileDate) {
		this.tenderprofileDate = tenderprofileDate;
	}

	/**
	 * Ein Übergabeparameter vom Typ Date wird in einen String umgewandelt und im Anschluss zurückgegeben
	 */
	public String DateToString(Date d){
		
		/*
		 * Ein neues Datums Objekt wird erstellt 
		 */
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		/*
		 * Einer neuen String Variable werden die Werte vom Übergabeparameter d zugewiesen
		 */
		String stringDate = df.format(d);
		
		/*
		 * Die neue String Variable wird zurückgegeben
		 */
		return stringDate;
	}

}
