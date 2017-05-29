package client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


public class Menu extends Composite{
	
	//Auffangswidget		
	VerticalPanel menuPanel = new VerticalPanel();
	//Verbindung zur Impl
	//ProjectMarketplaceAdministrationAsync verwaltung = ClientsideSettings.getProjectMarketplaceAdministration();

	Button homeButton = new Button("Startseite");
	Button profilButton = new Button("User");
	Button pMarketplace = new Button("Projektmarktplatz");
	Button projekte = new Button("Projekte");
	Button ausschreibungen = new Button("Ausschreibungen");
	Button bewerbungen = new Button("Bewerbungen");
	Button report = new Button("Report");
	Button impressumButton = new Button("Impressum");
	Button logout = new Button("Logout");
	

	public Menu() {

		menuPanel.add(homeButton);
		menuPanel.add(profilButton);
		menuPanel.add(pMarketplace);
		menuPanel.add(projekte);
		menuPanel.add(bewerbungen);
		menuPanel.add(ausschreibungen);
		menuPanel.add(report);
		menuPanel.add(impressum);
 		menuPanel.add(logout);

		
		

		// Layout Button einfügen--> setPixelSize
// Abstand zwischen Buttons
// verknüpfung mit css Datei

		
		//sämtliche Clickhandler
	}
void init(menuPanel);
}
