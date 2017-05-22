package de.hdm.marketPlace.shared.bo;

public class Attribute extends BusinessObject {
	
	private String name = "";
	private String text = "";
	private int value = 0 ;
	private int partnerprofileRef = 0;
	
	
	
	
	
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
	public String getValue() {
		String s = String.valueOf(value);
		return s;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getPartnerprofileRef() {
		return partnerprofileRef;
	}
	public void setPartnerprofileRef(int partnerprofileRef) {
		this.partnerprofileRef = partnerprofileRef;
	}
	
	 public String toString() {
		    return super.toString() + "Name:  " + this.name + "Text: " + this.text+ " Value: " + this.value + "PartnerProfile" + this.partnerprofileRef;
		  }
	
	

}
