package de.hdm.marketPlace.shared.report;

import java.io.Serializable;
import java.util.Vector;

/**
 * 
 * @author Robert Kresin
 *
 */

public class CompositeParagraph extends Paragraph implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * Vector der aus SimpleParagraph Objekten bestehen soll, welcher zur Realisierung von Unter Paragraphen
   * für die jeweiligen Reports verwendet werden soll.
   */
  private Vector<SimpleParagraph> subParagraphs = new Vector<SimpleParagraph>();

  /**
   * Methode realisiert das Hinzufügen von unter Paragraphen zum Vector 
   * @param p
   */
  public void addSubParagraph(SimpleParagraph p) {
	  
	  /*
	   * Der übergebene SimpleParagraph p wird dem Vector subParagraphs hinzugefügt
	   */
    this.subParagraphs.addElement(p);
  }

  /**
   * Methode realisiert das Entfernen eines SimpleParagraphs aus dem Vector
   * @param p
   */
  public void removeSubParagraph(SimpleParagraph p) {
	  
	  /*
	   * Der übergebene SimpleParagraph p wird aus dem Vector gelöscht
	   */
    this.subParagraphs.removeElement(p);
  }

  /**
   * Ausgabe des Vectors
   * @return Vector mit allen in ihm gespeicherten SimpleParagraphs
   */
  public Vector<SimpleParagraph> getSubParagraphs() {
    return this.subParagraphs;
  }

  /**
   * Größte des Vectors beziehungsweise Anzahl der in ihm gespeicherten
   * Einträge werden ausgegeben
   * @return int Wert der die Anzahl wiederspiegelt
   */
  public int getNumParagraphs() {
    return this.subParagraphs.size();
  }

  /**
   * Ausgabe eines SimpleParagraphs an einer bestimmten Stelle im Vector
   * @param i
   * @return Simpleparagraph Objekt an der übergebenen Stelle im Vector
   */
  public SimpleParagraph getParagraphAt(int i) {
    return this.subParagraphs.elementAt(i);
  }

  /**
   * Einfache textuelle Ausgabe aller im Vector gespeicherten Elemente
   * @return String mit allen Einträgen
   */
  public String toString() {
 
	  /*
	   * Ein neuer StringBuffer wird erstellt der alle Einträge in String Form aneinanderreiht
	   */
    StringBuffer result = new StringBuffer();

    /*
     * Durch die for-Schleife wird der Vector durchsucht 
     */
    for (int i = 0; i < this.subParagraphs.size(); i++) {
    	
    	/*
    	 * Bei jedem Durchlauf wird dem SimpleParagraph p den Wert vom
    	 * SimpleParagraph an der Stelle i im Vector zugewiesen
    	 */
      SimpleParagraph p = this.subParagraphs.elementAt(i);

      /*
       * Bei jedem Durchlauf wird der SimpleParagraph p dem String hinzugefügt
       */
      result.append(p.toString() + "\n");
    }

    /*
     * Rückgabe des fertigen Strings
     */
    return result.toString();
  }
}
