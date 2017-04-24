package de.hdm.marketPlace.server.db;

import java.sql.*;

import de.hdm.marketPlace.shared.bo.User;


public class UserProfileMapper {

	private static UserProfileMapper userMapper = null;
	
	protected UserProfileMapper(){
	}
	
	public User findByID(int ID){
		
		Connection con = DBConnection.getConnection();
		
	
	
	
	try {
		Statement stmt = con.createStatement();
		
		
		ResultSet rs =stmt.executeQuery("SELECT ID, name value FROM User" + "WHERE ID=" + ID +"ORDER BY name");
		
		if ( rs.next()){
			
			User u = new User();
			//Set ID fehlt // die ID muss erst im business objekt erstellt werden 
			u.setID(rs.getInt("ID");
			u.setName(rs.getString("name"));
		
			return u; 
			
		}
	
	}
	catch(Exception e){
		e.printStackTrace();
		return null;
	}
	return null;
	
	}
	
	public User insert(User u) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	  
	      ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid "
	          + "FROM User ");

	     
	      if (rs.next()) {
	
	    u.setID(rs.getInt("maxid") + 1);

	        stmt = con.createStatement();

	        
	        stmt.executeUpdate("INSERT INTO User (ID, name) "
	           + "VALUES (" + u.getName() +  "')");
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return u;
	  }


	  public User update(User u) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("UPDATE User " + "SET Name=\""
	          + u.getName() +  "\" "
	          + "WHERE id=" + u.getID());

	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return u;
	  }

	  
	  public void delete(User u) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM User " + "WHERE ID=" + u.getID());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	
	}

