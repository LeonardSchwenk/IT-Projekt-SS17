package de.hdm.marketPlace.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MenuView extends Composite {

	private VerticalPanel vP = new VerticalPanel();
	private MainView main;
	Button homeButton = new Button("Startseite");
	Button profilButton = new Button("User");
	Button pMarketplace = new Button("Projektmarktplatz");
	Button projects = new Button("Projekte");
	Button tender = new Button("Ausschreibungen");
	Button bewerbungen = new Button("Bewerbungen");
	Button report = new Button("Report");
	Button impressumButton = new Button("Impressum");
	Button logout = new Button("Logout");
	
	public MenuView(MainView main){
		
		
		initWidget(this.vP);
		this.main = main;
		
		homeButton.setPixelSize(200, 40);
		homeButton.addClickHandler(new HomeButtonClickhandler());
		this.vP.add(homeButton);
		this.vP.setSpacing(20);
		profilButton.setPixelSize(200, 40);
		profilButton.addClickHandler(new ProfilButtonClickhandler());
		this.vP.add(profilButton);
		pMarketplace.setPixelSize(200, 40);
		pMarketplace.addClickHandler(new PMarketplaceClickhandler());
		this.vP.add(pMarketplace);
		projects.setPixelSize(200, 40);
		projects.addClickHandler(new ProjectsClickhandler());
		this.vP.add(projects);
		tender.setPixelSize(200, 40);
		tender.addClickHandler(new TenderClickhandler());
		this.vP.add(tender);
		
		bewerbungen.setPixelSize(200, 40);
		// bewerbungen.addClickHandler(new BewerbungenClickhandler());
		this.vP.add(bewerbungen);
		report.setPixelSize(200, 40);
		//report.addClickHandler(new ReportClickhandler());
		this.vP.add(report);
		impressumButton.setPixelSize(200, 40);
		//impressumButton.addClickHandler(new ImpressumButtonClickhandler());
		this.vP.add(impressumButton);
		logout.setPixelSize(200, 40);
		//logout.addClickHandler(new LogoutClickhandler());
		this.vP.add(logout);

		
	}
	
	private class HomeButtonClickhandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			main.openHome();
			
		}
	}
		private class ProfilButtonClickhandler implements ClickHandler {

			@Override
			public void onClick(ClickEvent event) {
				main.openProfil();
				
			}}
	
		class PMarketplaceClickhandler implements ClickHandler {

	@Override
	public void onClick(ClickEvent event) {
		main.openMarketplace();
		
	}
}
class ProjectsClickhandler implements ClickHandler {

	@Override
	public void onClick(ClickEvent event) {
		main.openProjects();
		
	}
}
class TenderClickhandler implements ClickHandler {

	@Override
	public void onClick(ClickEvent event) {
		main.openTender();
		
	}
}
/*
class BewerbungenClickhandler implements ClickHandler {

	@Override
	public void onClick(ClickEvent event) {
		main.openBewerbungen();
		
	}
}
class ReportClickhandler implements ClickHandler {

	@Override
	public void onClick(ClickEvent event) {
		main.openReport();
		
	}
}
class ImpressumButtonClickhandler implements ClickHandler {

	@Override
	public void onClick(ClickEvent event) {
		main.openImpressum();
		
	}
}

class LogoutClickhandler implements ClickHandler {

	@Override
	public void onClick(ClickEvent event) {
		main.openLogout();
		
	}
}
*/
}
