package de.hdm.marketPlace.shared.bo;

import java.util.Vector; 

public class PartnerProfile {

	private String text;
	private Vector<Attribute> attributeRef;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Vector<Attribute> getAttributeRef() {
		return attributeRef;
	}
	public void setAttributeRef(Vector<Attribute> attributeRef) {
		this.attributeRef = attributeRef;
	} 
	
	
	
	
}
