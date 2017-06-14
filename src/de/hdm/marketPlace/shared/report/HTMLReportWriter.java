package de.hdm.marketPlace.shared.report;


import java.util.Vector;

/**
 * 
 * @author Robert Kresin
 *
 */

public class HTMLReportWriter extends ReportWriter {

/**
 * String Variable die den Text des Reports realisieren soll	
 */
  private String reportText = "";

  /**
   * Methode setzt den Text des Reports wieder zurück auf einen leeren Anfangszustand
   */
  public void resetReportText() {
    this.reportText = "";
  }

  /**
   * Ausgabe eines übergebenen Paragraphen
   * @param p
   * @return CompositeParagraph als String
   * @return SimpleParagraph als String
   */
  public String paragraph2HTML(Paragraph p) {
	  
	/*
	 * Überprüfung ob es sich bei dem übergebenen Paragraphen um einen
	 * CompositeParagraph oder einen SimpleParagraph handelt  
	 */
    if (p instanceof CompositeParagraph) {
    	
    /*
     * Ausgabe des CompositeParagraphs	
     */
      return this.paragraph2HTML((CompositeParagraph) p);
    }
    else {
    	
    /*
     * Ausgabe des SimpleParagraphs	
     */
      return this.paragraph2HTML((SimpleParagraph) p);
    }
  }

  /**
   * Ausgabe aller unter Paragraphen eines Composite Reports in HTML Form
   * @param p
   * @return String alle unter Paragraphen in HTML Form
   */
  public String paragraph2HTML(CompositeParagraph p) {
	  
	/*
	 * Erzeugen eines String Buffer der alle unter Paragraphen abbilden soll
	 */
    StringBuffer result = new StringBuffer();

    /*
     * for-Schleife durchläuft den CompositePargraph und fügt alle unterParagraphen an den String Buffer an
     */
    for (int i = 0; i < p.getNumParagraphs(); i++) {
      result.append("<p>" + p.getParagraphAt(i) + "</p>");
    }

    /*
     * Rückgabe des StringBuffers 
     */
    return result.toString();
  }

  /**
   * Ausgabe des SimpleParagraphs on HTML Form
   * @param p
   * @return String mit dem SimpleParagraph in HTML Form
   */
  public String paragraph2HTML(SimpleParagraph p) {
    return "<p>" + p.toString() + "</p>";
  }

  /**
   * Um den erstellten StringBuffer result werden die Header Daten und body für die HTML Form hinzugefügt
   * @return HTML Form ohne body end Tag und ohne html end Tag
   */
  public String getHeader() {
	  
	/*
	 * Neuer String Buffer wird angelegt  
	 */
    StringBuffer result = new StringBuffer();

    /*
     * An den String Buffer werden die Elemente zum Aufbau einer HTMl Seite angefügt
     */
    result.append("<html><head><title></title></head><body>");
    return result.toString();
  }

  /**
   * Diese Methode bildet den Abschluss der HTML Seite
   * @return HTML Form Vollendung durch body und html end Tag
   */
  public String getTrailer() {
    return "</body></html>";
  }

  //---------------------------------------------------

  /**
   * Erstellung des Reports AllTenders der in der ReportGeneratorImpl aufgerufen wird
   * @param r
   */
  public void process(AllTenders r){
	  
	  /*
	   * Zuerst werden alle gespeicherten Texte im Report resetet um einen komplett neuen
	   * Report zu garantieren
	   */
	  this.resetReportText();

	  /*
	   * Ein neuer String Buffer wird erstellt der für die Realisierung eines Reports benötigt wird
	   */
	    StringBuffer result = new StringBuffer();

	    /*
	     * An den String Buffer wird der Titel des Reports angefügt  
	     */
	    result.append("<H1>" + r.getTitle() + "</H1>");
	    
	    /*
	     * Der weitere Grundlegende Aufbau des Reports in HTMl Form wird definiert
	     * Hierbei handelt es sich nur um den grafischen Aufbau
	     */
	    result.append("<table style=\"width:400px;border:1px solid silver\"><tr>");
	    
	    /*
	     * eine Tabelle mit einer Zeile wird erstellt welche die oben beschriebene getHeaderData Methode aufruft
	     */
	    result.append("<td valign=\"top\"><b>" + paragraph2HTML(r.getHeaderData())
	        + "</b></td>");
	    
	    /*
	     * Eine Weitere Tabelle mit einer Zeile wird erstellt die das Impressum anfügt
	     */
	    result.append("<td valign=\"top\">" + paragraph2HTML(r.getImprint())
	        + "</td>");
	    
	    /*
	     * Dem Report wird ein Erstellungsdatum hinzugefügt
	     */
	    result.append("</tr><tr><td></td><td>" + r.getCreated().toString()
	        + "</td></tr></table>");

	    /*
	     * Einem Vektor der nur aus Zeilen Elementen bestehen soll werden alle Reihen aus r zugewiesen 
	     */
	    Vector<Row> rows = r.getRows();
	    
	    /*
	     * Dem String Buffer werden weiter Style Elemente für die Tabellen hinzugefügt und nun auch eine erstellt
	     */
	    result.append("<table style=\"width:400px\">");

	    /*
	     * Mithilfe einer for-Schleife soll der Vector rows durchsucht werden und der Report eine richtige Ausgabe die
	     * gewünschten Daten ausgeben
	     */
	    for (int i = 0; i < rows.size(); i++) {
	    	
	    /*
	     * Der Variable row wird bei jedem Durchgang die Werte von rows zugewiesen 	
	     */
	      Row row = rows.elementAt(i);
	     
	    /*
	     * Eine Tabellenreihe wird erstellt in der die Daten des Reports kommen sollen  
	     */
	      result.append("<tr>");
	      
	    /*
	     * Durch eine for-Schleife wie die Variable row durchlaufen  
	     */
	      for (int k = 0; k < row.getNumColumns(); k++) {
	    	  
	    /*
	     * Die Tabelle beginnt mit einigen Style angaben um die grafische Ausgabe der Tabelle zu gestalten	  
	     */
	        if (i == 0) {
	          result.append("<td style=\"background:silver;font-weight:bold\">" + row.getColumnAt(k)
	              + "</td>");
	        }
	        else {
	     
	    /*
	     * als Nächstes werden weitere style Elemente angefügt und die Werte in der Tabelle ausgegebenen
	     * hierbei ist zu unterscheiden bei der ersten Ausgabe dieser Daten werden eben genannte Style Elemente mit angegeben
	     * bei jeder weiteren Ausgabe nur noch die Werte angefügt 
	     */
	          if (i > 1) {
	            result.append("<td style=\"border-top:1px solid silver\">"
	                + row.getColumnAt(k) + "</td>");
	          }
	          else {
	            result.append("<td valign=\"top\">" + row.getColumnAt(k) + "</td>");
	          }
	        }
	      }
	    
	   /*
	    * Die Tabelle wird abgeschlossen mit dem end tag für die Tabellen Reihe
	    */
	      result.append("</tr>");
	    }

	  /*
	   * Nach dem kompletten Durchlauf der for-Schleife wird das End Tag der Tabelle angefügt um die Tabelle abzuschließen  
	   */
	    result.append("</table>");

	  /*
	   * In der Variable report Text wird der StringBuffer in String Form gespeichert  
	   */
	    this.reportText = result.toString();
	  }
	 
  /**
   * Erstellung des Reports TendersMatchProfil der in der ReportGeneratorImpl aufgerufen wird
   * @param r
   */
  public void process(TendersMatchProfil r){
	  
	  /*
	   * Zuerst werden alle gespeicherten Texte im Report resetet um einen komplett neuen
	   * Report zu garantieren
	   */
	  this.resetReportText();

	  /*
	   * Ein neuer String Buffer wird erstellt der für die Realisierung eines Reports benötigt wird
	   */
	    StringBuffer result = new StringBuffer();

	    /*
	     * An den String Buffer wird der Titel des Reports angefügt  
	     */
	    result.append("<H1>" + r.getTitle() + "</H1>");
	    
	    /*
	     * Der weitere Grundlegende Aufbau des Reports in HTMl Form wird definiert
	     * Hierbei handelt es sich nur um den grafischen Aufbau
	     */
	    result.append("<table style=\"width:400px;border:1px solid silver\"><tr>");
	    
	    /*
	     * eine Tabelle mit einer Zeile wird erstellt welche die oben beschriebene getHeaderData Methode aufruft
	     */
	    result.append("<td valign=\"top\"><b>" + paragraph2HTML(r.getHeaderData())
	        + "</b></td>");
	    
	    /*
	     * Eine Weitere Tabelle mit einer Zeile wird erstellt die das Impressum anfügt
	     */
	    result.append("<td valign=\"top\">" + paragraph2HTML(r.getImprint())
	        + "</td>");
	    
	    /*
	     * Dem Report wird ein Erstellungsdatum hinzugefügt
	     */
	    result.append("</tr><tr><td></td><td>" + r.getCreated().toString()
	        + "</td></tr></table>");

	    /*
	     * Einem Vektor der nur aus Zeilen Elementen bestehen soll werden alle Reihen aus r zugewiesen 
	     */
	    Vector<Row> rows = r.getRows();
	    
	    /*
	     * Dem String Buffer werden weiter Style Elemente für die Tabellen hinzugefügt und nun auch eine erstellt
	     */
	    result.append("<table style=\"width:400px\">");

	    /*
	     * Mithilfe einer for-Schleife soll der Vector rows durchsucht werden und der Report eine richtige Ausgabe die
	     * gewünschten Daten ausgeben
	     */
	    for (int i = 0; i < rows.size(); i++) {
	    	
		/*
		 * Der Variable row wird bei jedem Durchgang die Werte von rows zugewiesen 	
		 */	
	      Row row = rows.elementAt(i);
	      
		/*
		 * Eine Tabellenreihe wird erstellt in der die Daten des Reports kommen sollen  
		 */
	      result.append("<tr>");
	      
	    /*
		 * Durch eine for-Schleife wie die Variable row durchlaufen  
		 */
	      for (int k = 0; k < row.getNumColumns(); k++) {
	    	  
	  	/*
	  	 * Die Tabelle beginnt mit einigen Style angaben um die grafische Ausgabe der Tabelle zu gestalten	  
	  	 */
	        if (i == 0) {
	          result.append("<td style=\"background:silver;font-weight:bold\">" + row.getColumnAt(k)
	              + "</td>");
	        }
	        else {
	        	
	    /*
	     * als Nächstes werden weitere style Elemente angefügt und die Werte in der Tabelle ausgegebenen
	     * hierbei ist zu unterscheiden bei der ersten Ausgabe dieser Daten werden eben genannte Style Elemente mit angegeben
	     * bei jeder weiteren Ausgabe nur noch die Werte angefügt 
	     */ 	
	          if (i > 1) {
	            result.append("<td style=\"border-top:1px solid silver\">"
	                + row.getColumnAt(k) + "</td>");
	          }
	          else {
	            result.append("<td valign=\"top\">" + row.getColumnAt(k) + "</td>");
	          }
	        }
	      }
	      
		/*
		 * Die Tabellenreihe wird abgeschlossen mit dem end tag für die Tabellen Reihe
		 */
	      result.append("</tr>");
	    }

	   /*
		* Nach dem kompletten Durchlauf der for-Schleife wird das End Tag der Tabelle angefügt um die Tabelle abzuschließen  
		*/
	    result.append("</table>");

	   /*
		* In der Variable report Text wird der StringBuffer in String Form gespeichert  
		*/
	    this.reportText = result.toString();
	  
  }
 
  /**
   * Erstellung des Reports AllApplicationsonTender der in der ReportGeneratorImpl aufgerufen wird
   * @param r
   */
  public void process(AllApplicationsOnTender r){
	  
	  /*
	   * Zuerst werden alle gespeicherten Texte im Report resetet um einen komplett neuen
	   * Report zu garantieren
	   */
	  this.resetReportText();

	  /*
	   * Ein neuer String Buffer wird erstellt der für die Realisierung eines Reports benötigt wird
	   */
	    StringBuffer result = new StringBuffer();

	    /*
	     * An den String Buffer wird der Titel des Reports angefügt  
	     */
	    result.append("<H1>" + r.getTitle() + "</H1>");
	    
	    /*
	     * Der weitere Grundlegende Aufbau des Reports in HTMl Form wird definiert
	     * Hierbei handelt es sich nur um den grafischen Aufbau
	     */
	    result.append("<table style=\"width:400px;border:1px solid silver\"><tr>");
	    
	    /*
	     * eine Tabelle mit einer Zeile wird erstellt welche die oben beschriebene getHeaderData Methode aufruft
	     */
	    result.append("<td valign=\"top\"><b>" + paragraph2HTML(r.getHeaderData())
	        + "</b></td>");
	    
	    /*
	     * Eine Weitere Tabelle mit einer Zeile wird erstellt die das Impressum anfügt
	     */
	    result.append("<td valign=\"top\">" + paragraph2HTML(r.getImprint())
	        + "</td>");
	    
	    /*
	     * Dem Report wird ein Erstellungsdatum hinzugefügt
	     */
	    result.append("</tr><tr><td></td><td>" + r.getCreated().toString()
	        + "</td></tr></table>");

	    /*
	     * Einem Vektor der nur aus Zeilen Elementen bestehen soll werden alle Reihen aus r zugewiesen 
	     */
	    Vector<Row> rows = r.getRows();
	    
	    /*
	     * Dem String Buffer werden weiter Style Elemente für die Tabellen hinzugefügt und nun auch eine erstellt
	     */
	    result.append("<table style=\"width:400px\">");

	    /*
	     * Mithilfe einer for-Schleife soll der Vector rows durchsucht werden und der Report eine richtige Ausgabe die
	     * gewünschten Daten ausgeben
	     */
	    for (int i = 0; i < rows.size(); i++) {
	    	
	    /*
		 * Der Variable row wird bei jedem Durchgang die Werte von rows zugewiesen 	
		 */	
	      Row row = rows.elementAt(i);
	      
		/*
		 * Eine Tabellenreihe wird erstellt in der die Daten des Reports kommen sollen  
		 */
	      result.append("<tr>");
	      
		/*
		 * Durch eine for-Schleife wie die Variable row durchlaufen  
		 */
	      for (int k = 0; k < row.getNumColumns(); k++) {
	    	  
	  	/*
	  	 * Die Tabelle beginnt mit einigen Style angaben um die grafische Ausgabe der Tabelle zu gestalten	  
	  	 */
	        if (i == 0) {
	          result.append("<td style=\"background:silver;font-weight:bold\">" + row.getColumnAt(k)
	              + "</td>");
	        }
	        else {
	        	
	    /*
	     * als Nächstes werden weitere style Elemente angefügt und die Werte in der Tabelle ausgegebenen
	     * hierbei ist zu unterscheiden bei der ersten Ausgabe dieser Daten werden eben genannte Style Elemente mit angegeben
	     * bei jeder weiteren Ausgabe nur noch die Werte angefügt 
	     */ 	
	          if (i > 1) {
	            result.append("<td style=\"border-top:1px solid silver\">"
	                + row.getColumnAt(k) + "</td>");
	          }
	          else {
	            result.append("<td valign=\"top\">" + row.getColumnAt(k) + "</td>");
	          }
	        }
	      }
	      
		/*
		 * Die Tabellenreihe wird abgeschlossen mit dem end tag für die Tabellen Reihe
		 */
	      result.append("</tr>");
	    }

	    /*
		 * Nach dem kompletten Durchlauf der for-Schleife wird das End Tag der Tabelle angefügt um die Tabelle abzuschließen  
		 */
	    result.append("</table>");

		/*
		 * In der Variable report Text wird der StringBuffer in String Form gespeichert  
		 */
	    this.reportText = result.toString();
	  
  }
  
  /**
   * Erstellung des Reports AllApplicationsOfUser der in der ReportGeneratorImpl aufgerufen wird
   * @param r
   */
  public void process(AllApplicationsOfUser r){
	  
	  /*
	   * Zuerst werden alle gespeicherten Texte im Report resetet um einen komplett neuen
	   * Report zu garantieren
	   */
	  this.resetReportText();

	  /*
	   * Ein neuer String Buffer wird erstellt der für die Realisierung eines Reports benötigt wird
	   */
	    StringBuffer result = new StringBuffer();

	    /*
	     * An den String Buffer wird der Titel des Reports angefügt  
	     */
	    result.append("<H1>" + r.getTitle() + "</H1>");
	    
	    /*
	     * Der weitere Grundlegende Aufbau des Reports in HTMl Form wird definiert
	     * Hierbei handelt es sich nur um den grafischen Aufbau
	     */
	    result.append("<table style=\"width:400px;border:1px solid silver\"><tr>");
	    
	    /*
	     * eine Tabelle mit einer Zeile wird erstellt welche die oben beschriebene getHeaderData Methode aufruft
	     */
	    result.append("<td valign=\"top\"><b>" + paragraph2HTML(r.getHeaderData())
	        + "</b></td>");
	    
	    /*
	     * Eine Weitere Tabelle mit einer Zeile wird erstellt die das Impressum anfügt
	     */
	    result.append("<td valign=\"top\">" + paragraph2HTML(r.getImprint())
	        + "</td>");
	    
	    /*
	     * Dem Report wird ein Erstellungsdatum hinzugefügt
	     */
	    result.append("</tr><tr><td></td><td>" + r.getCreated().toString()
	        + "</td></tr></table>");

	    /*
	     * Einem Vektor der nur aus Zeilen Elementen bestehen soll werden alle Reihen aus r zugewiesen 
	     */
	    Vector<Row> rows = r.getRows();
	    
	    /*
	     * Dem String Buffer werden weiter Style Elemente für die Tabellen hinzugefügt und nun auch eine erstellt
	     */
	    result.append("<table style=\"width:400px\">");

	    /*
	     * Mithilfe einer for-Schleife soll der Vector rows durchsucht werden und der Report eine richtige Ausgabe die
	     * gewünschten Daten ausgeben
	     */
	    for (int i = 0; i < rows.size(); i++) {
	    	
		/*
		 * Der Variable row wird bei jedem Durchgang die Werte von rows zugewiesen 	
		 */	
	      Row row = rows.elementAt(i);
	      
		/*
		 * Eine Tabellenreihe wird erstellt in der die Daten des Reports kommen sollen  
		 */
	      result.append("<tr>");
	      
		/*
		 * Durch eine for-Schleife wie die Variable row durchlaufen  
		 */
	      for (int k = 0; k < row.getNumColumns(); k++) {
	    	  
	  	/*
	  	 * Die Tabelle beginnt mit einigen Style angaben um die grafische Ausgabe der Tabelle zu gestalten	  
	  	 */
	        if (i == 0) {
	          result.append("<td style=\"background:silver;font-weight:bold\">" + row.getColumnAt(k)
	              + "</td>");
	        }
	        else {
	        	
	     /*
	      * als Nächstes werden weitere style Elemente angefügt und die Werte in der Tabelle ausgegebenen
	      * hierbei ist zu unterscheiden bei der ersten Ausgabe dieser Daten werden eben genannte Style Elemente mit angegeben
	      * bei jeder weiteren Ausgabe nur noch die Werte angefügt 
	      */ 	
	          if (i > 1) {
	            result.append("<td style=\"border-top:1px solid silver\">"
	                + row.getColumnAt(k) + "</td>");
	          }
	          else {
	            result.append("<td valign=\"top\">" + row.getColumnAt(k) + "</td>");
	          }
	        }
	      }
	      
	     /*
		  * Die Tabellenreihe wird abgeschlossen mit dem end tag für die Tabellen Reihe
		  */
	      result.append("</tr>");
	    }

	    /*
		 * Nach dem kompletten Durchlauf der for-Schleife wird das End Tag der Tabelle angefügt um die Tabelle abzuschließen  
		 */
	    result.append("</table>");

		/*
		 * In der Variable report Text wird der StringBuffer in String Form gespeichert  
		 */
	    this.reportText = result.toString();
	  
  }
  
  /**
   * Erstellung des Reports PartivipationOfUser der in der ReportGeneratorImpl aufgerufen wird
   * @param r
   */
  public void process(ParticipationsOfUser r){
	  
	  /*
	   * Zuerst werden alle gespeicherten Texte im Report resetet um einen komplett neuen
	   * Report zu garantieren
	   */
	  this.resetReportText();

	  /*
	   * Ein neuer String Buffer wird erstellt der für die Realisierung eines Reports benötigt wird
	   */
	    StringBuffer result = new StringBuffer();

	    /*
	     * An den String Buffer wird der Titel des Reports angefügt  
	     */
	    result.append("<H1>" + r.getTitle() + "</H1>");
	    
	    /*
	     * Der weitere Grundlegende Aufbau des Reports in HTMl Form wird definiert
	     * Hierbei handelt es sich nur um den grafischen Aufbau
	     */
	    result.append("<table style=\"width:400px;border:1px solid silver\"><tr>");
	    
	    /*
	     * eine Tabelle mit einer Zeile wird erstellt welche die oben beschriebene getHeaderData Methode aufruft
	     */
	    result.append("<td valign=\"top\"><b>" + paragraph2HTML(r.getHeaderData())
	        + "</b></td>");
	    
	    /*
	     * Eine Weitere Tabelle mit einer Zeile wird erstellt die das Impressum anfügt
	     */
	    result.append("<td valign=\"top\">" + paragraph2HTML(r.getImprint())
	        + "</td>");
	    
	    /*
	     * Dem Report wird ein Erstellungsdatum hinzugefügt
	     */
	    result.append("</tr><tr><td></td><td>" + r.getCreated().toString()
	        + "</td></tr></table>");

	    /*
	     * Einem Vektor der nur aus Zeilen Elementen bestehen soll werden alle Reihen aus r zugewiesen 
	     */
	    Vector<Row> rows = r.getRows();
	    
	    /*
	     * Dem String Buffer werden weiter Style Elemente für die Tabellen hinzugefügt und nun auch eine erstellt
	     */
	    result.append("<table style=\"width:400px\">");

	    /*
	     * Mithilfe einer for-Schleife soll der Vector rows durchsucht werden und der Report eine richtige Ausgabe die
	     * gewünschten Daten ausgeben
	     */
	    for (int i = 0; i < rows.size(); i++) {
	    	
		/*
		 * Der Variable row wird bei jedem Durchgang die Werte von rows zugewiesen 	
		 */	
	      Row row = rows.elementAt(i);
	      
		/*
		 * Eine Tabellenreihe wird erstellt in der die Daten des Reports kommen sollen  
		 */
	      result.append("<tr>");
	      
		/*
		 * Durch eine for-Schleife wie die Variable row durchlaufen  
		 */
	      for (int k = 0; k < row.getNumColumns(); k++) {
	    	  
	  	/*
	  	 * Die Tabelle beginnt mit einigen Style angaben um die grafische Ausgabe der Tabelle zu gestalten	  
	  	 */
	        if (i == 0) {
	          result.append("<td style=\"background:silver;font-weight:bold\">" + row.getColumnAt(k)
	              + "</td>");
	        }
	        else {
	        	
	   	 /*
	   	  * als Nächstes werden weitere style Elemente angefügt und die Werte in der Tabelle ausgegebenen
	   	  * hierbei ist zu unterscheiden bei der ersten Ausgabe dieser Daten werden eben genannte Style Elemente mit angegeben
	   	  * bei jeder weiteren Ausgabe nur noch die Werte angefügt 
	   	  */ 	
	          if (i > 1) {
	            result.append("<td style=\"border-top:1px solid silver\">"
	                + row.getColumnAt(k) + "</td>");
	          }
	          else {
	            result.append("<td valign=\"top\">" + row.getColumnAt(k) + "</td>");
	          }
	        }
	      }
	      
		 /*
		  * Die Tabellenreihe wird abgeschlossen mit dem end tag für die Tabellen Reihe
		  */
	      result.append("</tr>");
	    }

	    /*
		 * Nach dem kompletten Durchlauf der for-Schleife wird das End Tag der Tabelle angefügt um die Tabelle abzuschließen  
		 */
	    result.append("</table>");

		/*
		 * In der Variable report Text wird der StringBuffer in String Form gespeichert  
		 */
	    this.reportText = result.toString();
	  
  }
  
  /**
   * Erstellung des Reports ProjectInerconnection der in der ReportGeneratorImpl aufgerufen wird
   * @param r
   */
  public void process(ProjectInterconnection r){ //CompositeReport
	  
	  /*
	   * Zuerst werden alle gespeicherten Texte im Report resetet um einen komplett neuen
	   * Report zu garantieren
	   */
	  this.resetReportText();

	  /*
	   * Ein neuer String Buffer wird erstellt der für die Realisierung eines Reports benötigt wird
	   */
	    StringBuffer result = new StringBuffer();

	    /*
	     * An den String Buffer wird der Titel des Reports angefügt  
	     */
	    result.append("<H1>" + r.getTitle() + "</H1>");
	    
	    /*
	     * Eine Tabelle wird mit einer Tabellenreihe erstellt und an den String Buffer angefügt
	     */
	    result.append("<table><tr>");

	    /*
	     * Durch eine if Abfrage wird überprüft ob der CompositeReport bereits Header Daten besitzt
	     * falls dies nicht der Fall ist werden diese angefügt
	     */
	    if (r.getHeaderData() != null) {
	      result.append("<td>" + paragraph2HTML(r.getHeaderData()) + "</td>");
	    }

	    /*
	     * Ansonsten werden im Anschluss das Impressum angefügt
	     */
	    result.append("<td>" + paragraph2HTML(r.getImprint()) + "</td>");
	    
	    /*
	     * Ein Erstellungsdatum wird ebenfalss erzeugt
	     */
	    result.append("</tr><tr><td></td><td>" + r.getCreated().toString() + "</td></tr></table>");

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
	    	 * Anschließend wird für diese Variablen ein Report erstellt
	    	 */
	      this.process(subReport);
	      this.process(subReport1);

	      /*
	       * Diese werden an den String Buffer angehängt
	       */
	      result.append(this.reportText + "\n");

	      /*
	       * Anschließend wird der Report Text resetet um nicht immer die gleichen Ergebnisse erneut mit an den String Buffer anzuhängen
	       */
	      this.resetReportText();
	    }

	    /*
	     * Abschließend wird in den reportText alle angehängten Strings aus dem String Buffer result gespeichert
	     */
	    this.reportText = result.toString();
	  
  }
  
  /**
   * Erstellung des ApplicationStatus der in der ReportGeneratorImpl aufgerufen wird
   * @param r
   */
  public void process(ApplicationStatus r){
	  
	  /*
	   * Zuerst werden alle gespeicherten Texte im Report resetet um einen komplett neuen
	   * Report zu garantieren
	   */
	  this.resetReportText();

	  /*
	   * Ein neuer String Buffer wird erstellt der für die Realisierung eines Reports benötigt wird
	   */
	    StringBuffer result = new StringBuffer();

	    /*
	     * An den String Buffer wird der Titel des Reports angefügt  
	     */
	    result.append("<H1>" + r.getTitle() + "</H1>");
	    
	    /*
	     * Der weitere Grundlegende Aufbau des Reports in HTMl Form wird definiert
	     * Hierbei handelt es sich nur um den grafischen Aufbau
	     */
	    result.append("<table style=\"width:400px;border:1px solid silver\"><tr>");
	    
	    /*
	     * eine Tabelle mit einer Zeile wird erstellt welche die oben beschriebene getHeaderData Methode aufruft
	     */
	    result.append("<td valign=\"top\"><b>" + paragraph2HTML(r.getHeaderData())
	        + "</b></td>");
	    
	    /*
	     * Eine Weitere Tabelle mit einer Zeile wird erstellt die das Impressum anfügt
	     */
	    result.append("<td valign=\"top\">" + paragraph2HTML(r.getImprint())
	        + "</td>");
	    
	    /*
	     * Dem Report wird ein Erstellungsdatum hinzugefügt
	     */
	    result.append("</tr><tr><td></td><td>" + r.getCreated().toString()
	        + "</td></tr></table>");

	    /*
	     * Einem Vektor der nur aus Zeilen Elementen bestehen soll werden alle Reihen aus r zugewiesen 
	     */
	    Vector<Row> rows = r.getRows();
	    
	    /*
	     * Dem String Buffer werden weiter Style Elemente für die Tabellen hinzugefügt und nun auch eine erstellt
	     */
	    result.append("<table style=\"width:400px\">");

	    /*
	     * Mithilfe einer for-Schleife soll der Vector rows durchsucht werden und der Report eine richtige Ausgabe die
	     * gewünschten Daten ausgeben
	     */
	    for (int i = 0; i < rows.size(); i++) {
	    	
		/*
		 * Der Variable row wird bei jedem Durchgang die Werte von rows zugewiesen 	
		 */	
	      Row row = rows.elementAt(i);
	      
		/*
		 * Eine Tabellenreihe wird erstellt in der die Daten des Reports kommen sollen  
		 */
	      result.append("<tr>");
	      
		/*
		 * Durch eine for-Schleife wie die Variable row durchlaufen  
		 */
	      for (int k = 0; k < row.getNumColumns(); k++) {
	    	  
	  	/*
	  	 * Die Tabelle beginnt mit einigen Style angaben um die grafische Ausgabe der Tabelle zu gestalten	  
	  	 */
	        if (i == 0) {
	          result.append("<td style=\"background:silver;font-weight:bold\">" + row.getColumnAt(k)
	              + "</td>");
	        }
	        else {
	        	
	   	 /*
	   	  * als Nächstes werden weitere style Elemente angefügt und die Werte in der Tabelle ausgegebenen
	   	  * hierbei ist zu unterscheiden bei der ersten Ausgabe dieser Daten werden eben genannte Style Elemente mit angegeben
	   	  * bei jeder weiteren Ausgabe nur noch die Werte angefügt 
	   	  */ 
	          if (i > 1) {
	            result.append("<td style=\"border-top:1px solid silver\">"
	                + row.getColumnAt(k) + "</td>");
	          }
	          else {
	            result.append("<td valign=\"top\">" + row.getColumnAt(k) + "</td>");
	          }
	        }
	      }
	      
		/*
		 * Die Tabellenreihe wird abgeschlossen mit dem end tag für die Tabellen Reihe
		 */
	      result.append("</tr>");
	    }

	    /*
		 * Nach dem kompletten Durchlauf der for-Schleife wird das End Tag der Tabelle angefügt um die Tabelle abzuschließen  
		 */
	    result.append("</table>");

		/*
		 * In der Variable report Text wird der StringBuffer in String Form gespeichert  
		 */
	    this.reportText = result.toString();

	  
  }
  
  /**
   * Erstellung des Reports Tenderstatus der in der ReportGeneratorImpl aufgerufen wird
   * @param r
   */
  public void process(TenderStatus r){
	  
	  /*
	   * Zuerst werden alle gespeicherten Texte im Report resetet um einen komplett neuen
	   * Report zu garantieren
	   */
	  this.resetReportText();

	  /*
	   * Ein neuer String Buffer wird erstellt der für die Realisierung eines Reports benötigt wird
	   */
	    StringBuffer result = new StringBuffer();

	    /*
	     * An den String Buffer wird der Titel des Reports angefügt  
	     */
	    result.append("<H1>" + r.getTitle() + "</H1>");
	    
	    /*
	     * Der weitere Grundlegende Aufbau des Reports in HTMl Form wird definiert
	     * Hierbei handelt es sich nur um den grafischen Aufbau
	     */
	    result.append("<table style=\"width:400px;border:1px solid silver\"><tr>");
	    
	    /*
	     * eine Tabelle mit einer Zeile wird erstellt welche die oben beschriebene getHeaderData Methode aufruft
	     */
	    result.append("<td valign=\"top\"><b>" + paragraph2HTML(r.getHeaderData())
	        + "</b></td>");
	    
	    /*
	     * Eine Weitere Tabelle mit einer Zeile wird erstellt die das Impressum anfügt
	     */
	    result.append("<td valign=\"top\">" + paragraph2HTML(r.getImprint())
	        + "</td>");
	    
	    /*
	     * Dem Report wird ein Erstellungsdatum hinzugefügt
	     */
	    result.append("</tr><tr><td></td><td>" + r.getCreated().toString()
	        + "</td></tr></table>");

	    /*
	     * Einem Vektor der nur aus Zeilen Elementen bestehen soll werden alle Reihen aus r zugewiesen 
	     */
	    Vector<Row> rows = r.getRows();
	    
	    /*
	     * Dem String Buffer werden weiter Style Elemente für die Tabellen hinzugefügt und nun auch eine erstellt
	     */
	    result.append("<table style=\"width:400px\">");

	    /*
	     * Mithilfe einer for-Schleife soll der Vector rows durchsucht werden und der Report eine richtige Ausgabe die
	     * gewünschten Daten ausgeben
	     */
	    for (int i = 0; i < rows.size(); i++) {
	    	
		/*
		 * Der Variable row wird bei jedem Durchgang die Werte von rows zugewiesen 	
		 */	
	      Row row = rows.elementAt(i);
	      
		/*
		 * Eine Tabellenreihe wird erstellt in der die Daten des Reports kommen sollen  
		 */
	      result.append("<tr>");
	      
		/*
		 * Durch eine for-Schleife wie die Variable row durchlaufen  
		 */
	      for (int k = 0; k < row.getNumColumns(); k++) {
	    	  
	  	/*
	  	 * Die Tabelle beginnt mit einigen Style angaben um die grafische Ausgabe der Tabelle zu gestalten	  
	  	 */
	        if (i == 0) {
	          result.append("<td style=\"background:silver;font-weight:bold\">" + row.getColumnAt(k)
	              + "</td>");
	        }
	        else {
	        	
	   	 /*
	   	  * als Nächstes werden weitere style Elemente angefügt und die Werte in der Tabelle ausgegebenen
	   	  * hierbei ist zu unterscheiden bei der ersten Ausgabe dieser Daten werden eben genannte Style Elemente mit angegeben
	   	  * bei jeder weiteren Ausgabe nur noch die Werte angefügt 
	   	  */ 
	          if (i > 1) {
	            result.append("<td style=\"border-top:1px solid silver\">"
	                + row.getColumnAt(k) + "</td>");
	          }
	          else {
	            result.append("<td valign=\"top\">" + row.getColumnAt(k) + "</td>");
	          }
	        }
	      }
	      
	     /*
		  * Die Tabellenreihe wird abgeschlossen mit dem end tag für die Tabellen Reihe
		  */
	      result.append("</tr>");
	    }

	    /*
		 * Nach dem kompletten Durchlauf der for-Schleife wird das End Tag der Tabelle angefügt um die Tabelle abzuschließen  
		 */
	    result.append("</table>");

		/*
		 * In der Variable report Text wird der StringBuffer in String Form gespeichert  
		 */
	    this.reportText = result.toString();

  }
  
  /**
   * Erstellung des Reports FaniInFanOut der in der ReportGeneratorImpl aufgerufen wird
   * @param r
   */
  public void process(FanInFanOut r){ //CompositeReport
	  
	  /*
	   * Zuerst werden alle gespeicherten Texte im Report resetet um einen komplett neuen
	   * Report zu garantieren
	   */
	  this.resetReportText();

	  /*
	   * Ein neuer String Buffer wird erstellt der für die Realisierung eines Reports benötigt wird
	   */
	    StringBuffer result = new StringBuffer();

	    /*
	     * An den String Buffer wird der Titel des Reports angefügt  
	     */
	    result.append("<H1>" + r.getTitle() + "</H1>");
	    
	    /*
	     * Eine Tabelle wird mit einer Tabellenreihe erstellt und an den String Buffer angefügt
	     */
	    result.append("<table><tr>");

	    /*
	     * Durch eine if Abfrage wird überprüft ob der CompositeReport bereits Header Daten besitzt
	     * falls dies nicht der Fall ist werden diese angefügt
	     */
	    if (r.getHeaderData() != null) {
	      result.append("<td>" + paragraph2HTML(r.getHeaderData()) + "</td>");
	    }

	    /*
	     * Ansonsten werden im Anschluss das Impressum angefügt
	     */
	    result.append("<td>" + paragraph2HTML(r.getImprint()) + "</td>");
	    
	    /*
	     * Ein Erstellungsdatum wird ebenfalss erzeugt
	     */
	    result.append("</tr><tr><td></td><td>" + r.getCreated().toString()
	        + "</td></tr></table>");

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
	    	 * Anschließend wird für diese Variablen ein Report erstellt
	    	 */
	      this.process(subReport);
	      this.process(subReport1);

	      /*
	       * Diese werden an den String Buffer angehängt
	       */
	      result.append(this.reportText + "\n");

	      /*
	       * Anschließend wird der Report Text resetet um nicht immer die gleichen Ergebnisse erneut mit an den String Buffer anzuhängen
	       */
	      this.resetReportText();
	    }
	    
	    /*
	     * Abschließend wird in den reportText alle angehängten Strings aus dem String Buffer result gespeichert
	     */
	    this.reportText = result.toString();
  }


  
  //-------------------------------------------------------------
  

  
  
public void process(AllApplicationsOnAllTenders r){ //CompositeReport
	  
	  /*
	   * Zuerst werden alle gespeicherten Texte im Report resetet um einen komplett neuen
	   * Report zu garantieren
	   */
	  this.resetReportText();

	  /*
	   * Ein neuer String Buffer wird erstellt der für die Realisierung eines Reports benötigt wird
	   */
	    StringBuffer result = new StringBuffer();

	    /*
	     * An den String Buffer wird der Titel des Reports angefügt  
	     */
	    result.append("<H1>" + r.getTitle() + "</H1>");
	    
	    /*
	     * Eine Tabelle wird mit einer Tabellenreihe erstellt und an den String Buffer angefügt
	     */
	    result.append("<table><tr>");

	    /*
	     * Durch eine if Abfrage wird überprüft ob der CompositeReport bereits Header Daten besitzt
	     * falls dies nicht der Fall ist werden diese angefügt
	     */
	    if (r.getHeaderData() != null) {
	      result.append("<td>" + paragraph2HTML(r.getHeaderData()) + "</td>");
	    }

	    /*
	     * Ansonsten werden im Anschluss das Impressum angefügt
	     */
	    result.append("<td>" + paragraph2HTML(r.getImprint()) + "</td>");
	    
	    /*
	     * Ein Erstellungsdatum wird ebenfalss erzeugt
	     */
	    result.append("</tr><tr><td></td><td>" + r.getCreated().toString()
	        + "</td></tr></table>");

	    /*
	     * Mit Hilfe einer for-Schleife wird r durchlaufen
	     */
	    for (int i = 0; i < r.getNumSubReports(); i++) {
	   
	    	/*
	    	 * Dabei wird das Objekt AllApplicationsOfUser in der Variable subReport gespeichert
	    	 * und das Objekt ParticipationOfUser in subReport1
	    	 */
	    	AllApplicationsOnTender subReport = (AllApplicationsOnTender) r.getSubReportAt(i);

	    	/*
	    	 * Anschließend wird für diese Variablen ein Report erstellt
	    	 */
	      this.process(subReport);

	      /*
	       * Diese werden an den String Buffer angehängt
	       */
	      result.append(this.reportText + "\n");

	      /*
	       * Anschließend wird der Report Text resetet um nicht immer die gleichen Ergebnisse erneut mit an den String Buffer anzuhängen
	       */
	      this.resetReportText();
	    }
	    
	    /*
	     * Abschließend wird in den reportText alle angehängten Strings aus dem String Buffer result gespeichert
	     */
	    this.reportText = result.toString();
  }


  
  //-------------------------------------------------------------
  
  /**
   * Ausgabe des Report Textes
   * @return Report Text als String
   */
  public String getReportText() {
	  
	  /*
	   * Rückgabe des Headers gefolgt von Report Text und End Tags von Body und Html
	   */
    return this.getHeader() + this.reportText + this.getTrailer();
  }
}


