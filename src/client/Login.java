package client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.marketPlace.shared.bo.User;


public class ProjectMarketplace implements EntryPoint {

	// Verbindung zur Impl
	//ProjectMarketplaceAdministrationAsync ProjectMarketplaceVerwaltung = ClientsideSettings.getProjectMarketplaceAdministration();

	private User loginInfo = null;
	private VerticalPanel loginPanel = new VerticalPanel();
	private Label loginLabel = new Label("Please sign in to your Google Account to access application.");
	private Anchor signinLink = new Anchor("Sign In");
	private Anchor signOutLink = new Anchor("Sign Out");
	User user= ClientsideSettings.getAktuellerUser();
	

	public void onModuleLoad() {
		}}
	
		
