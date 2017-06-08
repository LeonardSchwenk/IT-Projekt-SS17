package de.hdm.marketPlace.shared.report;

import java.io.Serializable;
import java.util.Vector;

/**
 * 
 * @author Robert Kresin
 *
 */

public class Row implements Serializable{
	
	  private static final long serialVersionUID = 1L;
	
	  /**
	   * Ein neuer Vektor der aus Column Objekten bestehen soll wird erstelll
	   */
	  private Vector<Column> columns = new Vector<Column>();

	  /**
	   * Diese Methode realisiert das hinzufügen einer neuen Spalte
	   * @param c
	   */
	  public void addColumn(Column c) {
	    this.columns.addElement(c);
	  }

	  /**
	   * Diese Methode realisiert das Löschen einer Spalte
	   * @param c
	   */
	  public void removeColumn(Column c) {
	    this.columns.removeElement(c);
	  }

	  /**
	   * Ausgabe der Spalten
	   * @return Column Objekte
	   */
	  public Vector<Column> getColumns() {
	    return this.columns;
	  }

	  /**
	   * Ausgabe der Anzahl an Objekten im Vector
	   * @return numerischer Wert der die Anzahl an Objekten wiedrspiegelt
	   */
	  public int getNumColumns() {
	    return this.columns.size();
	  }

	  /**
	   * Ausgabe des Column Objekts an einer übergebenen Stelle im Vektor
	   * @param i
	   * @return Column Objekt 
	   */
	  public Column getColumnAt(int i) {
	    return this.columns.elementAt(i);
	  }

}
