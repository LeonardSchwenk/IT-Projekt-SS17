package de.hdm.marketPlace.shared.report;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Robert Kresin
 *
 */
public abstract class Report implements Serializable{
	
/**
 * 
 */
	  private static final long serialVersionUID = 1L;

	  /**
	   * Impressum Variable vom Datentyp Paragraph
	   */
	  private Paragraph imprint = null;	
	  
	  /**
	   * Header Data Variable vom Datentyp Paragraph
	   */
	  private Paragraph headerData = null;

	  /**
	   * Titel des Reports
	   */
	  private String title = "Report";

	  /**
	   * Erstellungsdatum für den Report
	   */
	  private Date created = new Date();
	  

	  /**
	   * Ausgabe des Impressums
	   * @return Impressum
	   */
	  public Paragraph getImprint() {
		return imprint;
	}

	  /**
	   * Setzen des Impressums
	   * @param imprint
	   */
	  public void setImprint(Paragraph imprint) {
		this.imprint = imprint;
	}

	  /**
	   * Ausgabe der Header Daten
	   * @return Header Daten
	   */
	  public Paragraph getHeaderData() {
		return headerData;
	}

	  /**
	   * Setzen der Header Daten
	   * @param headerData
	   */
	  public void setHeaderData(Paragraph headerData) {
		this.headerData = headerData;
	}

	  /**
	   * Ausgabe des Titels
	   * @return Titel des Reports
	   */
	  public String getTitle() {
		return title;
	}

	  /**
	   * Setzen des Titels
	   * @param title
	   */
	  public void setTitle(String title) {
		this.title = title;
	}

	  /**
	   * Ausgabe des Erstellungsdatums
	   * @return Erstellungsdatum
	   */
	  public Date getCreated() {
		return created;
	}

	  /**
	   * Setzen des Erstellungsdatums
	   * @param created
	   */
	  public void setCreated(Date created) {
		this.created = created;
	}


	
}
