package de.hdm.marketPlace.shared.report;


import java.util.Vector;

/**
 * 
 * @author Robert Kresin
 *
 */

public class PlainTextReportWriter extends ReportWriter {

	/**
	 * Text des Reports als String
	 * welcher aber beim PlainTextReport leer bleibt
	 */
  private String reportText = "";

  /**
   * Diese Methode realisiert das zur�cksetzen des Inhalts eines Reports
   */
  public void resetReportText() {
    this.reportText = "";
  }

  /**
   * Ausgabe der Header Daten
   * welche aber beim PlainTextReport leer bleiben
   * @return leere Zur�ckgabe
   */
  public String getHeader() {

    return "";
  }

  /**
   * Ausgabe der restlichen Daten die f�r einen HTML Report ben�tigt werden
   * welche aber beim PlainTextReport nicht vorhanden sind
   * @return
   */
  public String getTrailer() {
  
    return "___________________________________________";
  }


  /**
   * Erstellen des Reports AllTenders
   */
  public void process(AllTenders r) {

	    /*
	     * Zuerst werden alle gespeicherten Texte im Report resetet um einen komplett neuen
	     * Report zu garantieren
	     */
	    this.resetReportText();

	    /*
	     * Ein neuer String Buffer wird erstellt der f�r die Realisierung eines Reports ben�tigt wird
	     */
	    StringBuffer result = new StringBuffer();

	    /*
	     * Der Titel des Reports wird angeh�ngt
	     */
	    result.append("*** " + r.getTitle() + " ***\n\n");
	    
	    /*
	     * Die Header Daten werden angeh�ngt
	     */
	    result.append(r.getHeaderData() + "\n");
	    
	    /*
	     * Das Erstellungsdatum wird angeh�ngt
	     */
	    result.append("Erstellt am: " + r.getCreated().toString() + "\n\n");
	    
	    /*
	     * Dem Vector rows der aus Row Elementen beseht werden die Werte des �bergebenen Objektes r zugewiesen
	     */
	    Vector<Row> rows = r.getRows();

	    /*
	     * Mit Hilfe einer for-Schleife wird der Vector durchsucht und bei jedem Durchlauf die Werte
	     * in die row Variable gespeichert
	     */
	    for (Row row : rows) {
	    	
	    /*
	     * Zus�tzlich wird bei jedem Durchlauf die Position im Vector mit angeh�ngt	
	     */
	      for (int k = 0; k < row.getNumColumns(); k++) {
	        result.append(row.getColumnAt(k) + "\t ; \t");
	      }

	    /*
	     * Am Ende jedes Durchlaufs wird ein Zeilenumbruch mit angeh�ngt zur �bersichtlichkeit  
	     */
	      result.append("\n");
	    }

	   /*
	    * Am Ende des Reports soll ein weiter Umbruch und Abschlie�end das Impressum
	    * f�r den Report angeh�ngt werden 
	    */
	    result.append("\n");
	    result.append(r.getImprint() + "\n");

	    /*
	     * Abschlie�end werden die Ergebnisse des StringBuffers in der Variable reportText gespeichert 
	     */
	    this.reportText = result.toString();
	
}


  /**
   * Erstellen des Reports TendersMatchProfil
   */
public void process(TendersMatchProfil r) {
	
    /*
     * Zuerst werden alle gespeicherten Texte im Report resetet um einen komplett neuen
     * Report zu garantieren
     */
	this.resetReportText();

    /*
     * Ein neuer String Buffer wird erstellt der f�r die Realisierung eines Reports ben�tigt wird
     */
    StringBuffer result = new StringBuffer();

    /*
     * Der Titel des Reports wird angeh�ngt
     */
    result.append("*** " + r.getTitle() + " ***\n\n");
    
    /*
     * Die Header Daten werden angeh�ngt
     */
    result.append(r.getHeaderData() + "\n");
    
    /*
     * Das Erstellungsdatum wird angeh�ngt
     */
    result.append("Erstellt am: " + r.getCreated().toString() + "\n\n");
    
    /*
     * Dem Vector rows der aus Row Elementen beseht werden die Werte des �bergebenen Objektes r zugewiesen
     */
    Vector<Row> rows = r.getRows();

    /*
     * Mit Hilfe einer for-Schleife wird der Vector durchsucht und bei jedem Durchlauf die Werte
     * in die row Variable gespeichert
     */
    for (Row row : rows) {
    	
	    /*
	     * Zus�tzlich wird bei jedem Durchlauf die Position im Vector mit angeh�ngt	
	     */
      for (int k = 0; k < row.getNumColumns(); k++) {
        result.append(row.getColumnAt(k) + "\t ; \t");
      }

	    /*
	     * Am Ende jedes Durchlaufs wird ein Zeilenumbruch mit angeh�ngt zur �bersichtlichkeit  
	     */
      result.append("\n");
    }

    /* Am Ende des Reports soll ein weiter Umbruch und Abschlie�end das Impressum
    * f�r den Report angeh�ngt werden 
    */
    result.append("\n");
    result.append(r.getImprint() + "\n");

    /*
     * Abschlie�end werden die Ergebnisse des StringBuffers in der Variable reportText gespeichert 
     */
    this.reportText = result.toString();
}

/**
 * Erstellen des Reports AllApplicationsOnTender
 */
public void process(AllApplicationsOnTender r) {
	
    /*
     * Zuerst werden alle gespeicherten Texte im Report resetet um einen komplett neuen
     * Report zu garantieren
     */
	this.resetReportText();

    /*
     * Ein neuer String Buffer wird erstellt der f�r die Realisierung eines Reports ben�tigt wird
     */
    StringBuffer result = new StringBuffer();

    /*
     * Der Titel des Reports wird angeh�ngt
     */
    result.append("*** " + r.getTitle() + " ***\n\n");
    
    /*
     * Die Header Daten werden angeh�ngt
     */
    result.append(r.getHeaderData() + "\n");
    
    /*
     * Das Erstellungsdatum wird angeh�ngt
     */
    result.append("Erstellt am: " + r.getCreated().toString() + "\n\n");
    
    /*
     * Dem Vector rows der aus Row Elementen beseht werden die Werte des �bergebenen Objektes r zugewiesen
     */
    Vector<Row> rows = r.getRows();

    /*
     * Mit Hilfe einer for-Schleife wird der Vector durchsucht und bei jedem Durchlauf die Werte
     * in die row Variable gespeichert
     */
    for (Row row : rows) {
    	
	    /*
	     * Zus�tzlich wird bei jedem Durchlauf die Position im Vector mit angeh�ngt	
	     */
      for (int k = 0; k < row.getNumColumns(); k++) {
        result.append(row.getColumnAt(k) + "\t ; \t");
      }

	    /*
	     * Am Ende jedes Durchlaufs wird ein Zeilenumbruch mit angeh�ngt zur �bersichtlichkeit  
	     */
      result.append("\n");
    }

    /* Am Ende des Reports soll ein weiter Umbruch und Abschlie�end das Impressum
    * f�r den Report angeh�ngt werden 
    */
    result.append("\n");
    result.append(r.getImprint() + "\n");

    /*
     * Abschlie�end werden die Ergebnisse des StringBuffers in der Variable reportText gespeichert 
     */
    this.reportText = result.toString();
}

/**
 * Erstellen des Reports AllApllicationsOfUser
 */
public void process(AllApplicationsOfUser r) {
	
    /*
     * Zuerst werden alle gespeicherten Texte im Report resetet um einen komplett neuen
     * Report zu garantieren
     */
	this.resetReportText();

    /*
     * Ein neuer String Buffer wird erstellt der f�r die Realisierung eines Reports ben�tigt wird
     */
    StringBuffer result = new StringBuffer();

    /*
     * Der Titel des Reports wird angeh�ngt
     */
    result.append("*** " + r.getTitle() + " ***\n\n");
    
    /*
     * Die Header Daten werden angeh�ngt
     */
    result.append(r.getHeaderData() + "\n");
    
    /*
     * Das Erstellungsdatum wird angeh�ngt
     */
    result.append("Erstellt am: " + r.getCreated().toString() + "\n\n");
    
    /*
     * Dem Vector rows der aus Row Elementen beseht werden die Werte des �bergebenen Objektes r zugewiesen
     */
    Vector<Row> rows = r.getRows();

    /*
     * Mit Hilfe einer for-Schleife wird der Vector durchsucht und bei jedem Durchlauf die Werte
     * in die row Variable gespeichert
     */
    for (Row row : rows) {
    	
	    /*
	     * Zus�tzlich wird bei jedem Durchlauf die Position im Vector mit angeh�ngt	
	     */
      for (int k = 0; k < row.getNumColumns(); k++) {
        result.append(row.getColumnAt(k) + "\t ; \t");
      }

	    /*
	     * Am Ende jedes Durchlaufs wird ein Zeilenumbruch mit angeh�ngt zur �bersichtlichkeit  
	     */
      result.append("\n");
    }

    /* Am Ende des Reports soll ein weiter Umbruch und Abschlie�end das Impressum
    * f�r den Report angeh�ngt werden 
    */
    result.append("\n");
    result.append(r.getImprint() + "\n");

    /*
     * Abschlie�end werden die Ergebnisse des StringBuffers in der Variable reportText gespeichert 
     */
    this.reportText = result.toString();
}

/**
 * Erstellen des Reports ProjektInterconnection
 */
public void process(ProjectInterconnection r) {
	
    /*
     * Zuerst werden alle gespeicherten Texte im Report resetet um einen komplett neuen
     * Report zu garantieren
     */
	this.resetReportText();

    /*
     * Ein neuer String Buffer wird erstellt der f�r die Realisierung eines Reports ben�tigt wird
     */
    StringBuffer result = new StringBuffer();

    /*
     * Der Titel des Reports wird angeh�ngt
     */
    result.append("*** " + r.getTitle() + " ***\n\n");

    /*
     * Die Header Daten werden angeh�ngt falls welche vorhanden sind
     */
    if (r.getHeaderData() != null)
      result.append(r.getHeaderData() + "\n");

    /*
     * Das Erstellungsdatum wird angeh�ngt
     */
    result.append("Erstellt am: " + r.getCreated().toString() + "\n\n");

    /*
     * Mit Hilfe einer for-Schleife wird r durchlaufen
     */
    for (int i = 0; i < r.getNumSubReports(); i++) {
   
    	/*
    	 * Dabei wird das Objekt AllApplicationsOfUser in der Variable subReport gespeichert
    	 * und das Objekt ParticipationOfUser in subReport1
    	 */
      AllApplicationsOfUser subReport = (AllApplicationsOfUser) r.getSubReportAt(i);
      ParticipationsOfUser subReport1 = (ParticipationsOfUser) r.getSubReportAt(i);

  	/*
  	 * Anschlie�end wird f�r diese Variablen ein Report erstellt
  	 */
      this.process(subReport);
      this.process(subReport1);

      /*
       * Diese werden an den String Buffer angeh�ngt
       */
      result.append(this.reportText + "\n\n\n\n\n");

      /*
       * Anschlie�end wird der Report Text resetet um nicht immer die gleichen Ergebnisse erneut mit an den String Buffer anzuh�ngen
       */
      this.resetReportText();
    }

    /*
     * Abschlie�end wird in den reportText alle angeh�ngten Strings aus dem String Buffer result gespeichert
     */
    this.reportText = result.toString();
  }


/**
 * Erstellen des Reports FanInFanOut
 */
public void process(FanInFanOut r) {
	
    /*
     * Zuerst werden alle gespeicherten Texte im Report resetet um einen komplett neuen
     * Report zu garantieren
     */
	this.resetReportText();

    /*
     * Ein neuer String Buffer wird erstellt der f�r die Realisierung eines Reports ben�tigt wird
     */
    StringBuffer result = new StringBuffer();

    /*
     * Der Titel des Reports wird angeh�ngt
     */
    result.append("*** " + r.getTitle() + " ***\n\n");

    /*
     * Die Header Daten werden angeh�ngt falls welche vorhanden sind
     */
    if (r.getHeaderData() != null)
      result.append(r.getHeaderData() + "\n");

    /*
     * Das Erstellungsdatum wird angeh�ngt
     */
    result.append("Erstellt am: " + r.getCreated().toString() + "\n\n");

    /*
     * Mit Hilfe einer for-Schleife wird r durchlaufen
     */
    for (int i = 0; i < r.getNumSubReports(); i++) {
   
    	/*
    	 * Dabei wird das Objekt AllApplicationsOfUser in der Variable subReport gespeichert
    	 * und das Objekt ParticipationOfUser in subReport1
    	 */
      ApplicationStatus subReport = (ApplicationStatus) r.getSubReportAt(i);
      TenderStatus subReport1 = (TenderStatus) r.getSubReportAt(i);

    	/*
    	 * Anschlie�end wird f�r diese Variablen ein Report erstellt
    	 */
      this.process(subReport);
      this.process(subReport1);

      /*
       * Diese werden an den String Buffer angeh�ngt
       */
      result.append(this.reportText + "\n\n\n\n\n");

      /*
       * Anschlie�end wird der Report Text resetet um nicht immer die gleichen Ergebnisse erneut mit an den String Buffer anzuh�ngen
       */
      this.resetReportText();
    }

    /*
     * Abschlie�end wird in den reportText alle angeh�ngten Strings aus dem String Buffer result gespeichert
     */
    this.reportText = result.toString();
  }

/**
 * Ausgabe des Reports 
 * @return Kompletter Report
 */
  public String getReportText() {
    return this.getHeader() + this.reportText + this.getTrailer();
}

/**
 * Erstellen des Reports ApplicationStatus
 */
public void process(ApplicationStatus r) {
	
    /*
     * Zuerst werden alle gespeicherten Texte im Report resetet um einen komplett neuen
     * Report zu garantieren
     */
	this.resetReportText();

    /*
     * Ein neuer String Buffer wird erstellt der f�r die Realisierung eines Reports ben�tigt wird
     */
    StringBuffer result = new StringBuffer();

    /*
     * Der Titel des Reports wird angeh�ngt
     */
    result.append("*** " + r.getTitle() + " ***\n\n");
    
    /*
     * Die Header Daten werden angeh�ngt
     */
    result.append(r.getHeaderData() + "\n");
    
    /*
     * Das Erstellungsdatum wird angeh�ngt
     */
    result.append("Erstellt am: " + r.getCreated().toString() + "\n\n");
    
    /*
     * Dem Vector rows der aus Row Elementen beseht werden die Werte des �bergebenen Objektes r zugewiesen
     */
    Vector<Row> rows = r.getRows();

    /*
     * Mit Hilfe einer for-Schleife wird der Vector durchsucht und bei jedem Durchlauf die Werte
     * in die row Variable gespeichert
     */
    for (Row row : rows) {
    	
	    /*
	     * Zus�tzlich wird bei jedem Durchlauf die Position im Vector mit angeh�ngt	
	     */
      for (int k = 0; k < row.getNumColumns(); k++) {
        result.append(row.getColumnAt(k) + "\t ; \t");
      }

	    /*
	     * Am Ende jedes Durchlaufs wird ein Zeilenumbruch mit angeh�ngt zur �bersichtlichkeit  
	     */
      result.append("\n");
    }

    /* Am Ende des Reports soll ein weiter Umbruch und Abschlie�end das Impressum
    * f�r den Report angeh�ngt werden 
    */
    result.append("\n");
    result.append(r.getImprint() + "\n");

    /*
     * Abschlie�end werden die Ergebnisse des StringBuffers in der Variable reportText gespeichert 
     */
    this.reportText = result.toString();
	
}

/**
 * Erstellen des Reports TenderStatus
 */
	public void process(TenderStatus r) {
		
	    /*
	     * Zuerst werden alle gespeicherten Texte im Report resetet um einen komplett neuen
	     * Report zu garantieren
	     */	
	this.resetReportText();

    /*
     * Ein neuer String Buffer wird erstellt der f�r die Realisierung eines Reports ben�tigt wird
     */
    StringBuffer result = new StringBuffer();

    /*
     * Der Titel des Reports wird angeh�ngt
     */
    result.append("*** " + r.getTitle() + " ***\n\n");
    
    /*
     * Die Header Daten werden angeh�ngt
     */
    result.append(r.getHeaderData() + "\n");
    
    /*
     * Das Erstellungsdatum wird angeh�ngt
     */
    result.append("Erstellt am: " + r.getCreated().toString() + "\n\n");
    
    /*
     * Dem Vector rows der aus Row Elementen beseht werden die Werte des �bergebenen Objektes r zugewiesen
     */
    Vector<Row> rows = r.getRows();

    /*
     * Mit Hilfe einer for-Schleife wird der Vector durchsucht und bei jedem Durchlauf die Werte
     * in die row Variable gespeichert
     */
    for (Row row : rows) {
    	
	    /*
	     * Zus�tzlich wird bei jedem Durchlauf die Position im Vector mit angeh�ngt	
	     */
      for (int k = 0; k < row.getNumColumns(); k++) {
        result.append(row.getColumnAt(k) + "\t ; \t");
      }

	    /*
	     * Am Ende jedes Durchlaufs wird ein Zeilenumbruch mit angeh�ngt zur �bersichtlichkeit  
	     */
      result.append("\n");
    }

    /* Am Ende des Reports soll ein weiter Umbruch und Abschlie�end das Impressum
    * f�r den Report angeh�ngt werden 
    */
    result.append("\n");
    result.append(r.getImprint() + "\n");

    /*
     * Abschlie�end werden die Ergebnisse des StringBuffers in der Variable reportText gespeichert 
     */
    this.reportText = result.toString();
	
}

/**
 * Erstellen des Reports ParticipationOfUser
 */
	public void process(ParticipationsOfUser r) {
		
	    /*
	     * Zuerst werden alle gespeicherten Texte im Report resetet um einen komplett neuen
	     * Report zu garantieren
	     */
		this.resetReportText();

	    /*
	     * Ein neuer String Buffer wird erstellt der f�r die Realisierung eines Reports ben�tigt wird
	     */
	    StringBuffer result = new StringBuffer();

	    /*
	     * Der Titel des Reports wird angeh�ngt
	     */
	    result.append("*** " + r.getTitle() + " ***\n\n");
	    
	    /*
	     * Die Header Daten werden angeh�ngt
	     */
	    result.append(r.getHeaderData() + "\n");
	    
	    /*
	     * Das Erstellungsdatum wird angeh�ngt
	     */
	    result.append("Erstellt am: " + r.getCreated().toString() + "\n\n");
	    
	    /*
	     * Dem Vector rows der aus Row Elementen beseht werden die Werte des �bergebenen Objektes r zugewiesen
	     */
	    Vector<Row> rows = r.getRows();

	    /*
	     * Mit Hilfe einer for-Schleife wird der Vector durchsucht und bei jedem Durchlauf die Werte
	     * in die row Variable gespeichert
	     */
	    for (Row row : rows) {
	    	
		    /*
		     * Zus�tzlich wird bei jedem Durchlauf die Position im Vector mit angeh�ngt	
		     */
	      for (int k = 0; k < row.getNumColumns(); k++) {
	        result.append(row.getColumnAt(k) + "\t ; \t");
	      }

		    /*
		     * Am Ende jedes Durchlaufs wird ein Zeilenumbruch mit angeh�ngt zur �bersichtlichkeit  
		     */
	      result.append("\n");
	    }

	    /* Am Ende des Reports soll ein weiter Umbruch und Abschlie�end das Impressum
	     * f�r den Report angeh�ngt werden 
	     */
	    result.append("\n");
	    result.append(r.getImprint() + "\n");

	    /*
	     * Abschlie�end werden die Ergebnisse des StringBuffers in der Variable reportText gespeichert 
	     */
	    this.reportText = result.toString();
		
	}
}