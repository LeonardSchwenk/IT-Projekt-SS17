package de.hdm.marketPlace.client;


import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Tender  extends Composite {
	
	VerticalPanel vP= new VerticalPanel();
	MainView main;
	
	public Tender (MainView menu){
		
		initWidget(this.vP);
		this.main = main;
}
}