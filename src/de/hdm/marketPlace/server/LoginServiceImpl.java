package de.hdm.marketPlace.server;


import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import de.hdm.marketPlace.shared.bo.*;


public class LoginServiceImpl extends RemoteServiceServlet implements
    LoginService {

// Ausführung 

  public User login(String requestUri) {
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
    User loginInfo = new User();

    if (user != null) {
      loginInfo.setLoggedIn(true);
      loginInfo.setGoogleId(user.getEmail());
      loginInfo.setLogoutUrl(userService.createLogoutURL(requestUri));
    } else {
      loginInfo.setLoggedIn(false);
      loginInfo.setLoginUrl(userService.createLoginURL(requestUri));
    }
    return loginInfo;
  }

}