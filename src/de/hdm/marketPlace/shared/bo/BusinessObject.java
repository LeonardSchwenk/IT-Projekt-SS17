package de.hdm.marketPlace.shared.bo;

public abstract class BusinessObject {
	
	
	//ID welche an alle BOs übergeben wird 

	 private int id = 0;

	 
	  public int getId() {
	    return this.id;
	  }
	  
	  public void setId(int id) {
	    this.id = id;
	  }
	
	  public String toString() {
		   
		    return this.getClass().getName() + " #" + this.id;
	
}
}
