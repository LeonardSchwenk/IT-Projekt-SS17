package de.hdm.marketPlace.client;



import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;

public class Profile extends VerticalPanel {
	
	Label header = new Label("Profil");
	Label EMail = new Label("E-Mail: ");
	Label FirstName = new Label("Vorname: ");
	Label LastName = new Label("Nachname: ");
	
	private Button saveEMail = new Button("speichern");
	private Button saveFirstName = new Button("speichern");
	private Button saveLastName = new Button("speichern");
	VerticalPanel contentPanel = new VerticalPanel();
	HorizontalPanel EMailPanel = new HorizontalPanel();
	HorizontalPanel FirstNamePanel = new HorizontalPanel();
	HorizontalPanel LastNamePanel = new HorizontalPanel();
	TextBox EMailTextBox = new TextBox();
	TextBox FirstNameTextBox = new TextBox();
	TextBox LastNameTextBox = new TextBox();
	
	public Profile() {

		// CSS verknüpfung des contentPanels
		//contentPanel.addStyleName("contentPanel");
		
		//Überschrift des Menüpunktes
		contentPanel.add(header);
		
		
		// Email bearbeiten
		EMailPanel.add(EMail);
		EMailPanel.add(EMailTextBox);
		EMailTextBox.setText("Beispiel@hdm-stuttgart.de");
		contentPanel.add(EMailPanel);
		contentPanel.add(saveEMail);
		
		// Vorname bearbeiten
		FirstNamePanel.add(FirstName);
		FirstNamePanel.add(FirstNameTextBox);
		FirstNameTextBox.setText("Max");
		contentPanel.add(FirstNamePanel);
		contentPanel.add(saveFirstName);
		
		
		//Nachname bearbeiten
		LastNamePanel.add(LastName);
		LastNamePanel.add(LastNameTextBox);
		LastNameTextBox.setText("Mustermann");
		contentPanel.add(LastNamePanel);
		contentPanel.add(saveLastName);
		
		
		// ContentPanel dem Content HTML Element hinzufügen
		RootPanel.get("Content").add(contentPanel);

	}

}