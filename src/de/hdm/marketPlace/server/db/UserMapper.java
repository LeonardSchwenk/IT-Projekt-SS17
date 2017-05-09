package de.hdm.marketPlace.server.db;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import de.hdm.marketPlace.shared.bo.TenderProfile;
import de.hdm.marketPlace.shared.bo.User;


public class UserMapper {

private static UserMapper UserMapper = null;
	
	protected UserMapper(){
	}
	
	public User findByID(int Id){
		
		Connection con = DBConnection.getConnection();
		
	
	
	
	try {
		Statement stmt = con.createStatement();
		
		
		ResultSet rs =stmt.executeQuery("SELECT Id, name value FROM User" + "WHERE Id=" + Id +"ORDER BY Id");
		
		if ( rs.next()){
			
			User u = new User();
			//Set ID fehlt // die ID muss erst im business objekt erstellt werden 
			u.setId(rs.getInt("Id"));
			u.setName(rs.getString("Name"));
			
	
			
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
	
	    u.setId(rs.getInt("maxid") + 1);

	        stmt = con.createStatement();

	        
	        stmt.executeUpdate("INSERT INTO User (Id, name) "
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

	      stmt.executeUpdate("UPDATE User " + "SET TenderRef=\""
	          + u.getName() + "\", " + "\" "
	          + "WHERE Id=" + u.getId());

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

	      stmt.executeUpdate("DELETE FROM User " + "WHERE Id=" + u.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	


}
