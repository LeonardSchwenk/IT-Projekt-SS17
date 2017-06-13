package de.hdm.marketPlace.shared;
import java.io.Serializable;

// Tutorial

public class LoginInfo implements Serializable {
	
	
private static final long serialVersionUID = 1L;

	  private boolean loggedIn = false;
	  private String loginUrl;
	  private String logoutUrl;
	  private String emailAddress;
	  private int userId;
	  private String firtsname;
	  private String lastanem;
	  
	  
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
