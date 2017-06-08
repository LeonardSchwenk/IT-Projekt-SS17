package de.hdm.marketPlace.shared.report;

import java.io.Serializable;

/**
 * Diese Klasse realisiert einen SimpleParagraph der lediglich aus einem String besteht
 * @author Robert Kresin
 *
 */

public class SimpleParagraph extends Paragraph implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * text des SimpleParagraphs
   */
  private String text = "";

  /**
   * Null Konstruktor
   */
  public SimpleParagraph() {
  }

  /**
   * Konstruktor bei dem der Inhalt bei der Erzeugung übergeben wird
   * @param value
   */
  public SimpleParagraph(String value) {
    this.text = value;
  }

  /**
   * Ausgabe des Inhalts des SimpleParagraphs
   * @return Inhalt 
   */
  public String getText() {
    return this.text;
  }

  /**
   * Setzen des Inhalts
   * @param text
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * Einfache textuelle Beschreibung der Klasse welche den Text ausgibt
   */
  public String toString() {
    return this.text;
  }
}
