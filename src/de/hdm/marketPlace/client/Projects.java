package de.hdm.marketPlace.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Projects extends Composite {
	
	VerticalPanel vP= new VerticalPanel();
	MainView main;
	
	public Projects (MainView menu){
		
		initWidget(this.vP);
		this.main = main;
}
}