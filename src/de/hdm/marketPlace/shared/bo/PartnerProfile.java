package de.hdm.marketPlace.shared.bo;

import java.util.Vector; 

public class PartnerProfile extends BusinessObject{

	private String text = "";
 
	
	private Vector<Attribute> attributeRef = new Vector<Attribute>();
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public void addAttributeRef (Attribute a){
		this.attributeRef.addElement (a);
	}
	
	public void removeAttributeRef (Attribute a){
		this.attributeRef.removeElement(a);
	}
	public Vector<Attribute> getAttributeRef() {
		return attributeRef;
	}
	
	//Ausgabe eines Unterabschnitts
	
	public Attribute getParagraphAt(int i) {
	    return this.attributeRef.elementAt(i);
	  }
	
	public String toString() {
		StringBuffer result = new StringBuffer();

	    
	    for (int i = 0; i < this.attributeRef.size(); i++) {
	      Attribute a = this.attributeRef.elementAt(i);

	      
	      result.append(a.toString() + "\n");
	    }

	   
	     
	    return result.toString();
	
}
}
