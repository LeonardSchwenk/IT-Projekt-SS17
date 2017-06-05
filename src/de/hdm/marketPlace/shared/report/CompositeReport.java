package de.hdm.marketPlace.shared.report;

import java.io.Serializable;
import java.util.*;

/**
 * 
 * @author Robert Kresin
 *
 */

public abstract class CompositeReport 
	extends Report 
	implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * Ein neuer Vector der aus Report Objekten bestehen soll wird erzeugt
   * Dies wird für die Realisierung von unter Reports benötigt
   */
	private Vector<Report> subReports = new Vector<Report>();

	/**
	 * Methode realisiert das Hinzufügen von unter Reports zum Vector 
	 * @param r
	 */
	public void addSubReport(Report r) {
		
		/*
		 * Der übergebene Report r wird dem Vector subReports hinzugefügt
		 */
		this.subReports.addElement(r);
	}

	/**
	 * Methode realisiert das Entfernen eines Reports aus dem Vector
	 * @param r
	 */
	public void removeSubReport(Report r) {
		
		/*
		 * Der übergebene Report r wird aus dem Vector gelöscht
		 */
		this.subReports.removeElement(r);
	}

/**
 * Größte des Vectors beziehungsweise Anzahl der in ihm gespeicherten
 * Einträge werden ausgegeben
 * @return int Wert der die Anzahl wiederspiegelt
 */
	public int getNumSubReports() {
		return this.subReports.size();
	}
	
/**
 * Ausgabe eines Reports an einer bestimmten Stelle im Vector
 * @param i
 * @return Report Objekt an der übergebenen Stelle im Vector
 */
	public Report getSubReportAt(int i) {
		return this.subReports.elementAt(i);
	}
}
