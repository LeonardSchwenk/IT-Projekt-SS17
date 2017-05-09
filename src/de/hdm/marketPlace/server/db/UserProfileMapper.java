package de.hdm.marketPlace.server.db;

import java.sql.*;



import de.hdm.marketPlace.shared.bo.UserProfile;


public class UserProfileMapper {

	private static UserProfileMapper userMapper = null;
	
	protected UserProfileMapper(){
	}
	
	public UserProfile findByID(int Id){
		
		Connection con = DBConnection.getConnection();
		
	
	
	
	try {
		Statement stmt = con.createStatement();
		
		
		ResultSet rs =stmt.executeQuery("SELECT Id, name value FROM UserProfile" + "WHERE Id=" + Id +"ORDER BY name");
		
		if ( rs.next()){
			
			UserProfile u = new UserProfile();
			//Set ID fehlt // die ID muss erst im business objekt erstellt werden 
			u.setId(rs.getInt("Id"));
			u.setText(rs.getString("text"));
			u.setUserRef(rs.getInt("UserRef"));
			u.setAttributeRef(rs.getInt("AttributeRef"));
			
			
			
			
			return u; 
			
		}
	
	}
	catch(Exception e){
		e.printStackTrace();
		return null;
	}
	return null;
	
	}
	
	public UserProfile insert(UserProfile u) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	  
	      ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid "
	          + "FROM UserProfile ");

	     
	      if (rs.next()) {
	
	    u.setId(rs.getInt("maxid") + 1);

	        stmt = con.createStatement();

	        
	        stmt.executeUpdate("INSERT INTO UserProfile (Id, UserRef, AttributeRef ,text) "
	           + "VALUES (" + u.getUserRef() +  ",'" + u.getAttributeRef() +  ",'" + u.getText() +   "')");
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return u;
	  }


	  public UserProfile update(UserProfile u) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("UPDATE User " + "SET AttributeRef=\""
	    	          + u.getAttributeRef()+ "SET Text=\""   + u.getText()  + "SET UserRef=\""
	    	    	          + u.getUserRef() + "\" " + "WHERE Id=" + u.getId());

	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return u;
	  }

	  
	  public void delete(UserProfile u) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM UserProfile " + "WHERE Id=" + u.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	
	}

