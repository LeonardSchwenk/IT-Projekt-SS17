package de.hdm.marketPlace.shared.bo;

import java.util.Date; 

public class Project extends BusinessObject{
	
	private String name = ""; 
	private String text =""; 
	private Date startDate;
	private Date endDate; 
	private int projectManagerRef = 0; 
	private int projectMarketplaceRef = 0; 
	private int tenderRef = 0;
	
	private int userRef = 0;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
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
	public int getProjectManagerRef() {
		return projectManagerRef;
	}
	public void setProjectManagerRef(int projectManager) {
		this.projectManagerRef = projectManager;
	}
	public int getProjectMarketplaceRef() {
		return projectMarketplaceRef;
	}
	public void setProjectMarketplaceRef(int projectMarketplaceRef) {
		this.projectMarketplaceRef = projectMarketplaceRef;
	}
	public int getTenderRef() {
		return tenderRef;
	}
	public void setTenderRef(int tenderRef) {
		this.tenderRef = tenderRef;
	}
	public int getUserRef() {
		return userRef;
	}
	public void setUserRef(int userRef) {
		this.userRef = userRef;
	} 
	
	 public String toString() {
		    return super.toString() + "Name:  " + this.name + "Text: " + this.text+ " ProjectManager: " + this.projectManagerRef+ " ProjectMarketplace: " + this.projectMarketplaceRef+ "Tender: " + this.tenderRef+ "User: " + this.userRef;
		  }

		}
	


