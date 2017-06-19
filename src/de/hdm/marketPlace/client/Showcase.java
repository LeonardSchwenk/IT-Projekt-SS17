package de.hdm.marketPlace.client;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.*;


public abstract class Showcase extends VerticalPanel {
	 
	public void onLoad(){
		
		super.onLoad();
		
		this.add(this.createHeadline(this.getHeadlineText()));
		
		this.run();
	}
	
	public HTML createHeadline(String text) {
	    HTML content = new HTML(text);
	    content.setStylePrimaryName("projectMarketplace-headline");
	    return content;
	  }
	
	public void append(String text) {
	    HTML content = new HTML(text);
	    content.setStylePrimaryName("projectMarketplace-simpletext");
	    this.add(content);
	  }
	
	protected abstract String getHeadlineText();

	 
	protected abstract void run();
	
}
