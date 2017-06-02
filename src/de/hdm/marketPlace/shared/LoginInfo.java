package de.hdm.marketPlace.shared;
import java.io.Serializable;

// Tutorial

public class LoginInfo implements Serializable {
private static final long serialVersionUID = 1L;


	 /**
	  * Login Status des Users
	  */
	  private boolean loggedIn = false;
	  
	 /**
	  * Login Url 
	  */
	  private String loginUrl;
	  
	  /**
	   * Logou Url
	   */
	  private String logoutUrl;
	  
	  /**
	   * Email Adresse des Users
	   */
	  private String emailAddress;
	  
	  /**
	   * Benutzername des Users
	   */
	  private String nickname;

	  /**
	   * Abfrage ob der User eingeloggt ist
	   */
	  public boolean isLoggedIn() {
	    return loggedIn;
	  }

	  /**
	   * Setzen des Login Status
	   */
	  public void setLoggedIn(boolean loggedIn) {
	    this.loggedIn = loggedIn;
	  }

	  /**
	   * Ausgabe der LoginUrl
	   */
	  public String getLoginUrl() {
	    return loginUrl;
	  }

	  
	  /**
	   * Setzen der LoginUrl
	   */
	  public void setLoginUrl(String loginUrl) {
	    this.loginUrl = loginUrl;
	  }

	  /**
	   * Asugabe der LogoutUrl
	   */
	  public String getLogoutUrl() {
	    return logoutUrl;
	  }

	  /**
	   * Setzen der LogoutUrl
	   */
	  public void setLogoutUrl(String logoutUrl) {
	    this.logoutUrl = logoutUrl;
	  }

	  /**
	   * Ausgabe der EmailAdresse des Users
	   */
	  public String getEmailAddress() {
	    return emailAddress;
	  }

	  /**
	   * Setzen der EmailAdresse des Users
	   */
	  public void setEmailAddress(String emailAddress) {
	    this.emailAddress = emailAddress;
	  }

	  /**
	   * Ausgabe des Benutzernamens des Users
	   */
	  public String getNickname() {
	    return nickname;
	  }

	  /**
	   * Setzen des Benutzernamens des Users
	   */
	  public void setNickname(String nickname) {
	    this.nickname = nickname;
	  }
	  
}