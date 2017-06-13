package de.hdm.marketPlace.client;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Profile extends Composite {
	
	VerticalPanel vP= new VerticalPanel();
	MainView main;
	
	Label header = new Label("Profil");
	Label EMail = new Label("E-Mail: ");
	Label FirstName = new Label("Vorname: ");
	Label LastName = new Label("Nachname: ");
	
	private Button saveEMail = new Button("speichern");
	private Button saveFirstName = new Button("speichern");
	private Button saveLastName = new Button("speichern");
	
	HorizontalPanel EMailPanel = new HorizontalPanel();
	HorizontalPanel FirstNamePanel = new HorizontalPanel();
	HorizontalPanel LastNamePanel = new HorizontalPanel();
	TextBox EMailTextBox = new TextBox();
	TextBox FirstNameTextBox = new TextBox();
	TextBox LastNameTextBox = new TextBox();
	
	private FlexTable ft = new FlexTable();
	
	public Profile (MainView menu){
		
		initWidget(this.vP);
		//this.main = main;

		/*
		 EMailPanel.add(EMail);
		 
	
		
		EMailPanel.add(EMailTextBox);
		EMailTextBox.setText("Beispiel@hdm-stuttgart.de");
		
		
		// Vorname bearbeiten
		FirstNamePanel.add(FirstName);
		FirstNamePanel.add(FirstNameTextBox);
		FirstNameTextBox.setText("Max");
		
		
		
		//Nachname bearbeiten
		LastNamePanel.add(LastName);
		LastNamePanel.add(LastNameTextBox);
		LastNameTextBox.setText("Mustermann");
		
		// Befüllen der FlexTable
		ft.setWidget(0, 1, EMailPanel);
		ft.setWidget(0, 0, EMailTextBox);
		
		
		ft.setWidget(2, 1, FirstNamePanel);
		ft.setWidget(2, 0, FirstNameTextBox);

		ft.setWidget(3, 1, LastNamePanel);
		ft.setWidget(3, 0, LastNameTextBox);

		
*/
	}}
