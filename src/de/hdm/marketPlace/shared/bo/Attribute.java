package de.hdm.marketPlace.shared.bo;

public class Attribute extends BusinessObject {
	
	private String name = "";
	private String Text = "";
	private int value = 0 ;
	private int partnerprofileRef = 0;
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return Text;
	}
	public void setText(String Text) {
		this.Text = Text;
	}
	public int getValue() {
		return value;
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
	
	
	
	

}
