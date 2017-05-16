package de.hdm.marketPlace.shared.bo;

import java.util.Date; 

public class Application extends BusinessObject{
	
	/* Realisierung der Bewerbungsclasse mit allen 
	 * relevanten Attributen*/
	
	
	
	private String titel = "";		//HIER noch Mapper anpassen + toString
	private String text = ""; 
	private Date createDate; 
	private Date updateDate;
	private int userRef = 0; 
	private int tenderRef = 0;
	private int ratingRef = 0;
	
	
	
	//Was muss in den Konstruktor 
	
	public Application(){
		
	}
	
	//Alle Get und Set Methoden zu gegebenen Attributen 
	

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public int getUserRef() {
		return userRef;
	}
	public void setUserRef(int userRef) {
		this.userRef = userRef;
	}
	public int getTenderRef() {
		return tenderRef;
	}
	public void setTenderRef(int tenderRef) {
		this.tenderRef = tenderRef;
	}
	public int getRatingRef() {
		return ratingRef;
	}
	public void setRatingRef(int ratingRef) {
		this.ratingRef = ratingRef;
	} 
	
	 public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String toString() {
		    return super.toString() + " Text: " +  " Rating: " + this.ratingRef+ " Tender: " + this.tenderRef+ " User: " + this.userRef;
		    }
		    
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
