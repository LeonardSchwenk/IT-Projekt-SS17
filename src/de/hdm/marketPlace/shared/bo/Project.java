package de.hdm.marketPlace.shared.bo;

import java.util.Date; 

public class Project {
	
	private String name; 
	private String text; 
	private Date startDate;
	private Date endDate; 
	private int projectManager; 
	private int projectMarketplaceRef; 
	private int tenderRef;
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
	public int getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(int projectManager) {
		this.projectManager = projectManager;
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
	
	
	

}
