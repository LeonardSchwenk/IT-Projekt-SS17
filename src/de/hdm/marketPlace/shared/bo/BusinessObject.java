package de.hdm.marketPlace.shared.bo;

/*Realsierung des Business-Objects. Dieses wird als 
 * abstrakte Klasse aufgebaut, da es als Vorlage für 
 * alle Klassen im shared.bo dient. Die Klasse hat das
 * Attribut ID, welches an alle BusinessObjects des Packages 
 * übergeben wird*/ 

public abstract class BusinessObject {
	
	
	//ID welche an alle BOs übergeben wird 

	 private int id = 0;
	 
	 /*Alle Get und Set Methoden zum auslesen und setzen der 
		Attribute */

	  public int getId() {
	    return this.id;
	  }
	  
	  public void setId(int id) {
	    this.id = id;
	  }
	
	  // Textuelle Ausgabe der jeweiligen BusinessObject-Instanz 
	  
	  public String toString() {
		   return this.getClass().getName() + " #" + this.id;
	
	  }
	  
	  //Feststellen der Gleichheit zweier Objekte
		 
		public boolean equals(Object o) {
		    
		    if (o != null && o instanceof Application) {
		    	Application c = (Application) o;
		      try {
		        return super.equals(c);
		      }
		      catch (IllegalArgumentException e) {
		        return false;
		      }
		    }
		    return false;
}
}