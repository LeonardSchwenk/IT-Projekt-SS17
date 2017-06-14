package de.hdm.marketPlace.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.marketPlace.shared.LoginInfo;

public class ReportNavigation extends Composite {
	
	//Anlegen der Panels
	
	VerticalPanel reportPanel = new VerticalPanel();
	
	//Anlegen der Buttons
	
	Button showAllTendersButton = new Button("Alle Ausschreibungen");
	Button showTendersMatchButton = new Button("Alle Ausschreibungen die zu meinem Profil passen");
	Button showAllApplicationsOnTenderButton = new Button("Alle Bewerbungen auf Ausschreiben");
	Button showAllApplicationsOfUserButton = new Button("Alle Bewerbungen von Nutzer");
	Button showProjectInterconnectionButton = new Button("Projektverflechtung von Nutzer");
	Button showFanInFanOutButton = new Button("Fan-In/Fan-Out Analyse eines Nutzers");
	
	
	
	public ReportNavigation(final LoginInfo loginInfo){
		
		reportPanel.add(showAllTendersButton);
		showAllTendersButton.setWidth("200px");
		showAllTendersButton.setStylePrimaryName("menu-btn");
		
		reportPanel.add(showTendersMatchButton);
		showTendersMatchButton.setWidth("200px");
		showTendersMatchButton.setStylePrimaryName("menu-btn");
		
		reportPanel.add(showAllApplicationsOnTenderButton);
		showAllApplicationsOnTenderButton.setWidth("200px");
		showAllApplicationsOnTenderButton.setStylePrimaryName("menu-btn");
		
		reportPanel.add(showAllApplicationsOfUserButton);
		showAllApplicationsOfUserButton.setWidth("200px");
		showAllApplicationsOfUserButton.setStylePrimaryName("menu-btn");
		
		reportPanel.add(showProjectInterconnectionButton);
		showProjectInterconnectionButton.setWidth("200px");
		showProjectInterconnectionButton.setStylePrimaryName("menu-btn");
		
		reportPanel.add(showFanInFanOutButton);
		showFanInFanOutButton.setWidth("200px");
		showFanInFanOutButton.setStylePrimaryName("menu-btn");
		
		//---------------------------------------------------------
		
		//Anlegen der Clickhandler
		
		/*
		showAllTendersButton.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){
				Showcase showcaseReport = new AllTendersShowcase(loginInfo);
				
				currentClickHandler=this;
				currentClickHandler=this;
			}
		});
		*/
		//Alle Clickhandler hinzufügen
	}
}
