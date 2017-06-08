package de.hdm.marketPlace.shared.report;

import java.util.Vector;

/**
 * Diese Klasse realisiert einen SimpleReport 
 * @author Robert Kresin
 *
 */

public class SimpleReport extends Report{
	
	  private static final long serialVersionUID = 1L;

	  /**
	   * Ein neuer Vektor wird erstellt der aus Row Objekten bestehten soll
	   */
	  private Vector<Row> table = new Vector<Row>();

	  /**
	   * Diese Methode realisiert das Hinzufügen von Row Objekten zum Vektor
	   * @param r
	   */
	  public void addRow(Row r) {
	    this.table.addElement(r);
	  }

	  /**
	   * Diese Methode realisiert das Löschen von Row Objekten aus dem Vektor
	   * @param r
	   */
	  public void removeRow(Row r) {
	    this.table.removeElement(r);
	  }

	  /**
	   * Ausgabe der Row Elemente aus dem Vektor als Tabelle
	   * @return Tabelle 
	   */
	  public Vector<Row> getRows() {
	    return this.table;
	  }

}
