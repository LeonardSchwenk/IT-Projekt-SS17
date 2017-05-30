package de.hdm.marketPlace.shared.bo;

	/**Realsierung des Business-Objects. Dieses wird als 
	 * abstrakte Klasse aufgebaut, da es als Vorlage für 
	 * alle Klassen im shared.bo dient. Die Klasse hat das
	 * Attribut ID, welches an alle BusinessObjects des Packages 
	 * übergeben wird
	 */ 

public abstract class BusinessObject {
	
	
	  /**
	   * ID welche an alle BOs übergeben wird 
	   */
	  private int id = 0;
	 
	  /**
	   * Alle Get und Set Methoden zum Auslesen und Setzen der Attribute
	   */

	  /**
	   * Ausgabe der ID
	   */
	  public int getId() {
	    return this.id;
	  }
	  
	  /**
	   * Setzen der ID
	   */
	  public void setId(int id) {
	    this.id = id;
	  }
	
	  /**
	   * Textuelle Ausgabe der jeweiligen BusinessObject-Instanz 
	   */
	  public String toString() {
		  
		  /*
		   * Klassenname und ID wird ausgegeben
		   */
		   return this.getClass().getName() + " #" + this.id;
	  }
	  
	  /**
	   * Feststellen der inhaltlichen Gleichheit zweier Objekte und Ausgabe der jeweilig zugehörigen Bewerbung
	   */
	  public boolean equals(Object o) {
		    
		  /*
		   * das übergeben Objekt o wird überprüft ob es
		   * a) einen Inhalt besitzt und
		   * b) ob es zu einer Bewerbung gehört
		   * falls diese Regeln true sind dann wird einer Variable c vom Typ Application den jeweiligen Wert des übergeben Objektes o zugewiesen
		   */
		    if (o != null && o instanceof Application) {
		    	Application c = (Application) o;
		   
		   /*
		    * Es wird versucht die Bewerbung c zurückzugeben
		    */
		      try {
		        return super.equals(c);
		      }
		      
		   /*
		    * Bei auftretenden möglichen Fehlern soll der Wert false ausgegeben werden
		    */
		      catch (IllegalArgumentException e) {
		        return false;
		      }
		    }
		    
		   /*
		    * Falls die IF Bedingung false ist soll der Wert false zurückgegeben werden
		    */
		    return false;
	  }
}