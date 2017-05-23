package de.hdm.marketPlace.shared;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.hdm.marketPlace.shared.bo.User;

import java.io.Serializable;


public interface LoginService extends RemoteService {
  public User login(String requestUri);
}