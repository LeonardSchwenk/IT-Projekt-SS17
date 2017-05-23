package de.hdm.marketPlace.shared;
import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.marketPlace.shared.bo.User;

public interface LoginServiceAsync {
	public void login(String requestUri, AsyncCallback<User> async);

}
