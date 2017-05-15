package de.hdm.marketPlace.shared.bo;

public class Tender extends BusinessObject{

	//attributes of class
	
	private String text = "";
	private String name = "";
	
	private int projectRef = 0;
	
	//Setter and Getter of all attributes
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getProjectRef() {
		return projectRef;
	}
	public void setProjectRef(int projectRef) {
		this.projectRef = projectRef;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	 public String toString() {
		    return super.toString() + "Name:  " + this.name + "Text: " + this.text+ " ProjectRef: " + this.projectRef;
		  }
	
}
