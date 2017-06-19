package de.hdm.marketPlace.client;

import com.google.gwt.event.dom.client.ClickEvent;


import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Projects extends Composite  {
	
	
	
	VerticalPanel vP= new VerticalPanel();
	HorizontalPanel hP = new HorizontalPanel();
	
	MainView main;
	
	Button showCreateProjectButton = new Button("Create Project");
	Button showUpdateProjectButton = new Button("Update Project");
	Button showDeleteProjectButton = new Button("Delete Project");
	
	public Projects (MainView menu){
		
		initWidget(this.vP);
		this.main = main;
		
		
		
		
		

	/*	hP.add(showCreateProjectButton);
		showCreateProjectButton.setWidth("200px");
		showCreateProjectButton.setStylePrimaryName("menu-btn");
		
		hP.add(showUpdateProjectButton);
		showUpdateProjectButton.setWidth("200px");
		showUpdateProjectButton.setStylePrimaryName("menu-btn");
		
		hP.add(showDeleteProjectButton);
		showDeleteProjectButton.setWidth("200px");
		showDeleteProjectButton.setStylePrimaryName("menu-btn");
		
		*/
		
		
		
		
		
		
		
}
	

	
}