package de.hdm.marketPlace.shared.bo;

public class UserProfile extends BusinessObject {
	
	

	//attributes of class
	
	private int userRef = 0;
	private String text = "";
	private int attributeRef = 0;

	//Setter and Getter of all attributes
	
	public int getUserRef() {
		return userRef;
	}

	public void setUserRef(int userRef) {
		this.userRef = userRef;
	}

	public int getAttributeRef() {
		return attributeRef;
	}

	public void setAttributeRef(int attributeRef) {
		this.attributeRef = attributeRef;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	 public String toString() {
		    return super.toString() + "UserRef:  " + this.userRef + "Text: " + this.text+ " AttributeRef: " + this.attributeRef;
		  }

}
