package de.hdm.marketPlace.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Impressum extends Composite {

	VerticalPanel vP= new VerticalPanel();
	MainView main;
	
	public Impressum (MainView menu){
		
		initWidget(this.vP);
		this.main = main;
}
}
