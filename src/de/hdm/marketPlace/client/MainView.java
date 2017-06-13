package de.hdm.marketPlace.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainView extends Composite {

		private VerticalPanel vP = new VerticalPanel();
		private VerticalPanel contentP;
		Label head  = new Label();
		
		
		public MainView(){
			
			this.head.setText("IT-Projekt");
			initWidget(this.vP);
			this.vP.setBorderWidth(6);
			MenuView menu = new MenuView(this);
			this.vP.add(head);
			this.vP.setSpacing(80);
			this.vP.add(menu);
			
			this.contentP = new VerticalPanel();
			this.vP.add(contentP);
			
		
		}
		
		public void openHome(){
			this.contentP.clear();
			Label home = new Label("Willkommen!");
			this.contentP.add(home);
		}
		public void openProfil(){
			this.contentP.clear();
			Profile profil= new Profile(this);
			this.contentP.add(profil);
		}
		


		public void openMarketplace(){
			this.contentP.clear();
			ProjectMarketPlace marketplace= new ProjectMarketPlace(this);
			this.contentP.add(marketplace);
		}
		public void openProjects(){
			this.contentP.clear();
			Projects projects= new Projects(this);
			this.contentP.add(projects);
		}
		public void openTender(){
			this.contentP.clear();
			Tender tender= new Tender(this);
			this.contentP.add(tender);
		}
		/*
		public void openBewerbungen(){
			this.contentP.clear();
			Bewerbungen bewerbungen= new Bewerbungen(this);
			this.contentP.add(bewerbungen);
		}
		public void openReport(){
			this.contentP.clear();
			Report report= new Report(this);
			this.contentP.add(report);
		}
		public void openImpressum(){
			this.contentP.clear();
			Impressum impressum= new Impressum(this);
			this.contentP.add(impressum);
		}
		public void openLogout(){
			this.contentP.clear();
			Logout logout= new Logout(this);
			this.contentP.add(logout);
		}
		*/
}
