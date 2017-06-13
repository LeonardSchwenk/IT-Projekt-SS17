package de.hdm.marketPlace.client;

import java.util.logging.Logger;

import de.hdm.marketPlace.shared.MarketplaceAdministration;
import de.hdm.marketPlace.shared.*;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ClientsideSettings extends CommonSettings{
	
	private static MarketplaceAdministrationAsync administration = null;
	
	private static final String LOGGER_NAME = "Tngly Web Client";
	
	private static final  Logger log = Logger.getLogger(LOGGER_NAME);
	
	private static LoginInfo loginInfo = null;

	
	
	public static LoginInfo getLoginInfo() {
		return loginInfo;
	}
	
	public static void setLoginInfo(LoginInfo loginInfo) {
		ClientsideSettings.loginInfo = loginInfo;
	
	}
	
	public static Logger getLogger() {
		return log;
	}
	
	public static MarketplaceAdministrationAsync getAdministration() {
		if (administration == null) {
			administration = GWT.create(MarketplaceAdministration.class);

			final AsyncCallback<Void> initAdministrationCallback = new AsyncCallback<Void>() {
				public void onFailure(Throwable caught) {
					ClientsideSettings.getLogger()
							.severe("Der Administration konnte nicht initialisiert werden!" + caught);
				}
				public void onSuccess(Void result) {
					ClientsideSettings.getLogger().info("Der Administration wurde initialisiert.");
				}
			};
			administration.init(initAdministrationCallback);
		}
		return administration;
	}
	
}
