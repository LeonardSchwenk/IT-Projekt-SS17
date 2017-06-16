package de.hdm.marketPlace.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.marketPlace.client.report.AllApplicationsOfUserShowcase;
import de.hdm.marketPlace.client.report.AllApplicationsOnAllTendersShowcase;
import de.hdm.marketPlace.client.report.AllTendersShowcase;
import de.hdm.marketPlace.client.report.FanInFanOutShowcase;
import de.hdm.marketPlace.client.report.ProjectInterconnectionShowcase;
import de.hdm.marketPlace.client.report.TendersMatchShowcase;
import de.hdm.marketPlace.shared.LoginInfo;

public class ReportNavigation extends Composite {
	
	private static ClickHandler currentClickHandler = null;
	private static ClickEvent currentClickEvent = null;

	
	//Anlegen der Panels
	
	VerticalPanel reportPanel = new VerticalPanel();
	
	//Anlegen der Buttons
	
	Button showAllTendersButton = new Button("Alle Ausschreibungen");
	Button showTendersMatchButton = new Button("Alle Ausschreibungen die zu meinem Profil passen");
	Button showAllApplicationsOnAllTenderButton = new Button("Alle Bewerbungen auf alle Ausschreiben");
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
		
		reportPanel.add(showAllApplicationsOnAllTenderButton);
		showAllApplicationsOnAllTenderButton.setWidth("200px");
		showAllApplicationsOnAllTenderButton.setStylePrimaryName("menu-btn");
		
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
		
		
		showAllTendersButton.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){
				Showcase showcaseReport = new AllTendersShowcase();
				RootPanel.get("DetailsReport").clear();
				RootPanel.get("DetailsReport").add(showcaseReport);
				currentClickHandler=this;
				currentClickEvent=event;
			}
		});
		
		showTendersMatchButton.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){
				Showcase showcaseReport = new TendersMatchShowcase(loginInfo);
				RootPanel.get("DetailsReport").clear();
				RootPanel.get("DetailsReport").add(showcaseReport);
				currentClickHandler=this;
				currentClickEvent=event;
			}
		});
		
		showAllApplicationsOnAllTenderButton.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){
				Showcase showcaseReport = new AllApplicationsOnAllTendersShowcase(loginInfo);
				RootPanel.get("DetailsReport").clear();
				RootPanel.get("DetailsReport").add(showcaseReport);
				currentClickHandler=this;
				currentClickEvent=event;
			}
		});
		
		showAllApplicationsOfUserButton.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){
				Showcase showcaseReport = new AllApplicationsOfUserShowcase(loginInfo);
				RootPanel.get("DetailsReport").clear();
				RootPanel.get("DetailsReport").add(showcaseReport);
				currentClickHandler=this;
				currentClickEvent=event;
			}
		});
		
		showProjectInterconnectionButton.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){
				Showcase showcaseReport = new ProjectInterconnectionShowcase(loginInfo);
				RootPanel.get("DetailsReport").clear();
				RootPanel.get("DetailsReport").add(showcaseReport);
				currentClickHandler=this;
				currentClickEvent=event;
			}
		});
		
		showFanInFanOutButton.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event){
				Showcase showcaseReport = new FanInFanOutShowcase();
				RootPanel.get("DetailsReport").clear();
				RootPanel.get("DetailsReport").add(showcaseReport);
				currentClickHandler=this;
				currentClickEvent=event;
			}
		});
	}
	
	public static ClickHandler getCurrentClickHandler() {
		return currentClickHandler;
	}

	public static ClickEvent getCurrentClickEvent() {
		return currentClickEvent;
	}

	public static void setCurrentClickHandler(ClickHandler c){
		currentClickHandler = c;
	}
	public static void setCurrentClickEvent(ClickEvent e){
		currentClickEvent = e;
	}

	public static void reload(){
		currentClickHandler.onClick(currentClickEvent);
	}
	
}
