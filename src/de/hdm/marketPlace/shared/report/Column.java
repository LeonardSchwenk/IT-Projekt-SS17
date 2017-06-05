package de.hdm.marketPlace.shared.report;

import java.io.Serializable;

/**
 * 
 * @author Robert Kresin
 *
 */

public class Column implements Serializable{
	
	  private static final long serialVersionUID = 1L;


	  /**
	   * String Variable die benötigt wird um int Werte in Strings zu speichern
	   */
	  private String value = "";

	  /**
	   * Null Konstruktor
	   */
	  public Column() {
	  }

	  /**
	   * Konstruktor der einen umgewandelten Wert enthält
	   * @param s
	   */
	  public Column(String s) {
	    this.value = s;
	  }

	  /**
	   * Ausgabe des Wertes
	   * @return umgewandelter Wert
	   */
	  public String getValue() {
	    return value;
	  }

	  /**
	   * Setzen des Wertes
	   * @param value
	   */
	  public void setValue(String value) {
	    this.value = value;
	  }

	  /**
	   * Einfache textuelle Ausgabe der jeweiligen Column Instanz
	   */
	  public String toString() {
	    return this.value;
	  }

}



