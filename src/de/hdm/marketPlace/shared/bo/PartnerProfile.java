package de.hdm.marketPlace.shared.bo;

public abstract class PartnerProfile extends BusinessObject {
	
	private String text = "";
	
	//vektor ergänzen
	
	private String attribute = "";

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	 public String toString() {
		    return super.toString() + "Attribute:  " + this.attribute + "Text: " + this.text;
		  }

}
