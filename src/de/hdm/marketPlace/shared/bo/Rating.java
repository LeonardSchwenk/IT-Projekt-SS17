package de.hdm.marketPlace.shared.bo;

public class Rating {

	
	//attributes of class
	
	private float rate;
	private String ratingText;
	
	//constructor
	
	public Rating(float rate, String ratingText) {
		this.rate = rate;
		this.ratingText = ratingText;		
	}

	//Setter and Getter of all attributes
	
	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public String getRatingText() {
		return ratingText;
	}

	public void setRatingText(String ratingText) {
		this.ratingText = ratingText;
	}
	
	
	
}
