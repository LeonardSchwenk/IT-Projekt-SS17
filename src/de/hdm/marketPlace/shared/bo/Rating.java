package de.hdm.marketPlace.shared.bo;

public class Rating extends BusinessObject{

	
	//attributes of class
	
	private float rate = 0;
	private String text = "";
	

	//Setter and Getter of all attributes
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getRate() {
		String s = String.valueOf(rate);
		return s;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	
	
	
	 public String toString() {
		    return super.toString() + "Rate:  " + this.rate + "Text: " + this.text;
		  }
	
}
