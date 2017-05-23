package de.hdm.marketPlace.shared.bo;

/*Realisierung eines Nutzers des Systems*/ 

public class User extends BusinessObject {
	
	
	//Attribute der Klasse 
	
	private String firstname = "";
	private String lastname = "";
	private int projectmarketplaceRef = 0; 
	
	/*Alle Get und Set Methoden zum auslesen und setzen der 
	Attribute */
	
	
	
	public int getProjectmarketplaceRef() {
		return projectmarketplaceRef;
	}
	
	public void setProjectmarketplaceRef(int projectmarketplaceRef) {
		this.projectmarketplaceRef = projectmarketplaceRef;
	}
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	//Textuelle Ausgabe der jeweiligen Nutzerprofil-Instanz  


		public String toString() {
			    return super.toString() + "FirstName:  " + this.firstname +
			    		"LastName: " + this.lastname;
			  }
	}

