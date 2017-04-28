package de.hdm.marketPlace.shared.bo;

import java.util.Date; 

public class Application {
	
	/* Realisierung der Bewerbungsclasse mit allen 
	 * relevanten Attributen*/
	
	
	
	
	 private String text; 
	private Date createDate; 
	private Date updateDate;
	private int userRef; 
	private int tenderRef;
	private int ratingRef;
	
	
	
	public void Application(); 
	
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
	
	
	

}
