package de.hdm.marketPlace.shared.bo;

import java.util.Date; 

public class Participation extends BusinessObject{
	
	private int projectRef = 0;
	private int userRef = 0; 
	private int ratingRef = 0; 
	private int workingDays = 0;
	private Date startDate;
	private Date endDate;
	
	
	public int getProjectRef() {
		return projectRef;
	}
	public void setProjectRef(int projectRef) {
		this.projectRef = projectRef;
	}
	public int getUserRef() {
		return userRef;
	}
	public void setUserRef(int userRef) {
		this.userRef = userRef;
	}
	public int getRatingRef() {
		return ratingRef;
	}
	public void setRatingRef(int ratingRef) {
		this.ratingRef = ratingRef;
	}
	public int getWorkingDays() {
		return workingDays;
	}
	public void setWorkingDays(int workingDays) {
		this.workingDays = workingDays;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	 public String toString() {
		    return super.toString() + "projectRef:  " + this.projectRef + "userRef: " + this.userRef+ " ratingRef: " + this.ratingRef + "workingDays" + this.workingDays+ "startdate" + this.startDate+ "enddate" + this.endDate;
		  }
}
