package de.hdm.marketPlace.shared.bo;

/*Realisierung eines Nutzers des Systems*/ 

public class User extends BusinessObject {
	
	
	//Attribute der Klasse 
	
	private String name = "";
	
	/*Alle Get und Set Methoden zum auslesen und setzen der 
	Attribute */
	
	public void setName (String name){
		this.name = name;
	}
	public String getName (){
		return name;
	}
	
	//Textuelle Ausgabe der jeweiligen Nutzerprofil-Instanz  
	
		public String toString() {
			    return super.toString() + "Name:  " + this.name;
			  }
	}

