package de.hdm.marketPlace.shared.bo;

public class Rating extends BusinessObject{

	
	//attributes of class
	
	private float rate = 0;
	private String Text = "";
	

	//Setter and Getter of all attributes
	
	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public String getText() {
		return Text;
	}

	public void setText(String Text) {
		this.Text = Text;
	}
	
	
	
}
