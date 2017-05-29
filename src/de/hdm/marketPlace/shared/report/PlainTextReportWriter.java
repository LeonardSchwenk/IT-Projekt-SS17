package de.hdm.marketPlace.shared.report;


import java.util.Vector;

public class PlainTextReportWriter extends ReportWriter {

  private String reportText = "";

  public void resetReportText() {
    this.reportText = "";
  }

  public String getHeader() {

    return "";
  }

  public String getTrailer() {
  
    return "___________________________________________";
  }



  public void process(AllTenders r) {

	    this.resetReportText();

	    StringBuffer result = new StringBuffer();

	    result.append("*** " + r.getTitle() + " ***\n\n");
	    result.append(r.getHeaderData() + "\n");
	    result.append("Erstellt am: " + r.getCreated().toString() + "\n\n");
	    Vector<Row> rows = r.getRows();

	    for (Row row : rows) {
	      for (int k = 0; k < row.getNumColumns(); k++) {
	        result.append(row.getColumnAt(k) + "\t ; \t");
	      }

	      result.append("\n");
	    }

	    result.append("\n");
	    result.append(r.getImprint() + "\n");

	    this.reportText = result.toString();
	
}


public void process(TendersMatchProfil r) {
	this.resetReportText();

    StringBuffer result = new StringBuffer();

    result.append("*** " + r.getTitle() + " ***\n\n");
    result.append(r.getHeaderData() + "\n");
    result.append("Erstellt am: " + r.getCreated().toString() + "\n\n");
    Vector<Row> rows = r.getRows();

    for (Row row : rows) {
      for (int k = 0; k < row.getNumColumns(); k++) {
        result.append(row.getColumnAt(k) + "\t ; \t");
      }

      result.append("\n");
    }

    result.append("\n");
    result.append(r.getImprint() + "\n");

    this.reportText = result.toString();
}


public void process(AllApplicationsOnTender r) {
	this.resetReportText();

    StringBuffer result = new StringBuffer();

    result.append("*** " + r.getTitle() + " ***\n\n");
    result.append(r.getHeaderData() + "\n");
    result.append("Erstellt am: " + r.getCreated().toString() + "\n\n");
    Vector<Row> rows = r.getRows();

    for (Row row : rows) {
      for (int k = 0; k < row.getNumColumns(); k++) {
        result.append(row.getColumnAt(k) + "\t ; \t");
      }

      result.append("\n");
    }

    result.append("\n");
    result.append(r.getImprint() + "\n");

    this.reportText = result.toString();
}


public void process(AllApplicationsOfUser r) {
	this.resetReportText();

    StringBuffer result = new StringBuffer();

    result.append("*** " + r.getTitle() + " ***\n\n");
    result.append(r.getHeaderData() + "\n");
    result.append("Erstellt am: " + r.getCreated().toString() + "\n\n");
    Vector<Row> rows = r.getRows();

    for (Row row : rows) {
      for (int k = 0; k < row.getNumColumns(); k++) {
        result.append(row.getColumnAt(k) + "\t ; \t");
      }

      result.append("\n");
    }

    result.append("\n");
    result.append(r.getImprint() + "\n");

    this.reportText = result.toString();
}


public void process(ProjectInterconnection r) {
	this.resetReportText();

    StringBuffer result = new StringBuffer();

    result.append("*** " + r.getTitle() + " ***\n\n");

    if (r.getHeaderData() != null)
      result.append(r.getHeaderData() + "\n");

    result.append("Erstellt am: " + r.getCreated().toString() + "\n\n");

    for (int i = 0; i < r.getNumSubReports(); i++) {
   
      AllApplicationsOfUser subReport = (AllApplicationsOfUser) r.getSubReportAt(i);
      ParticipationsOfUser subReport1 = (ParticipationsOfUser) r.getSubReportAt(i);

      this.process(subReport);
      this.process(subReport1);

      result.append(this.reportText + "\n\n\n\n\n");

      this.resetReportText();
    }

    this.reportText = result.toString();
  }



public void process(FanInFanOut r) {
	this.resetReportText();

    StringBuffer result = new StringBuffer();

    result.append("*** " + r.getTitle() + " ***\n\n");

    if (r.getHeaderData() != null)
      result.append(r.getHeaderData() + "\n");

    result.append("Erstellt am: " + r.getCreated().toString() + "\n\n");

    for (int i = 0; i < r.getNumSubReports(); i++) {
   
      ApplicationStatus subReport = (ApplicationStatus) r.getSubReportAt(i);
      TenderStatus subReport1 = (TenderStatus) r.getSubReportAt(i);

      this.process(subReport);
      this.process(subReport1);

      result.append(this.reportText + "\n\n\n\n\n");

      this.resetReportText();
    }

    this.reportText = result.toString();
  }

  public String getReportText() {
    return this.getHeader() + this.reportText + this.getTrailer();
}


public void process(ApplicationStatus r) {
	this.resetReportText();

    StringBuffer result = new StringBuffer();

    result.append("*** " + r.getTitle() + " ***\n\n");
    result.append(r.getHeaderData() + "\n");
    result.append("Erstellt am: " + r.getCreated().toString() + "\n\n");
    Vector<Row> rows = r.getRows();

    for (Row row : rows) {
      for (int k = 0; k < row.getNumColumns(); k++) {
        result.append(row.getColumnAt(k) + "\t ; \t");
      }

      result.append("\n");
    }

    result.append("\n");
    result.append(r.getImprint() + "\n");

    this.reportText = result.toString();
	
}


	public void process(TenderStatus r) {
	this.resetReportText();

    StringBuffer result = new StringBuffer();

    result.append("*** " + r.getTitle() + " ***\n\n");
    result.append(r.getHeaderData() + "\n");
    result.append("Erstellt am: " + r.getCreated().toString() + "\n\n");
    Vector<Row> rows = r.getRows();

    for (Row row : rows) {
      for (int k = 0; k < row.getNumColumns(); k++) {
        result.append(row.getColumnAt(k) + "\t ; \t");
      }

      result.append("\n");
    }

    result.append("\n");
    result.append(r.getImprint() + "\n");

    this.reportText = result.toString();
	
}


	public void process(ParticipationsOfUser r) {
		this.resetReportText();

	    StringBuffer result = new StringBuffer();

	    result.append("*** " + r.getTitle() + " ***\n\n");
	    result.append(r.getHeaderData() + "\n");
	    result.append("Erstellt am: " + r.getCreated().toString() + "\n\n");
	    Vector<Row> rows = r.getRows();

	    for (Row row : rows) {
	      for (int k = 0; k < row.getNumColumns(); k++) {
	        result.append(row.getColumnAt(k) + "\t ; \t");
	      }

	      result.append("\n");
	    }

	    result.append("\n");
	    result.append(r.getImprint() + "\n");

	    this.reportText = result.toString();
		
	}
}