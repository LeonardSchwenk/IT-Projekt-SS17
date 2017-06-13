package de.hdm.marketPlace.server.db;

import java.sql.*;
import java.util.Vector;

import de.hdm.marketPlace.shared.bo.Application;
import de.hdm.marketPlace.shared.bo.UserProfile;


public class UserProfileMapper {

	private static UserProfileMapper userProfileMapper = null;
	
	protected UserProfileMapper(){
		
		
	}
	
	public static UserProfileMapper  userProfileMapper() {
		if (userProfileMapper == null){
			userProfileMapper = new UserProfileMapper();
			
		}
		return userProfileMapper;
	}
	
	public UserProfile findByID(int id){
		
		Connection con = DBConnection.getConnection();
		
	
	
	
	try {
		Statement stmt = con.createStatement();
		
		
		ResultSet rs =stmt.executeQuery("SELECT id, text, userRef FROM userprofile " + "WHERE id=" + id);
		
		if ( rs.next()){
			
			UserProfile u = new UserProfile();
			u.setId(rs.getInt("id"));
			u.setText(rs.getString("text"));
			u.setUserRef(rs.getInt("userRef"));
		
			
			
			
			
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
	          + "FROM userprofile ");

	     
	      if (rs.next()) {
	
	    u.setId(rs.getInt("maxid") + 1);

	        stmt = con.createStatement();

	        
	        stmt.executeUpdate("INSERT INTO userprofile (id, userRef ,text) "
	           + "VALUES ('" + u.getUserRef() +  "','" + u.getText() +   "')");
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

	      stmt.executeUpdate("UPDATE User " +  "\", " + "SET Text=\""   + u.getText() + "\", "  + "SET UserRef=\""
	    	    	          + u.getUserRef() + "\" " + "WHERE id=" + u.getId());

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
	  public Vector<UserProfile> findAll() {
		    Connection con = DBConnection.getConnection();

		   
		    Vector<UserProfile> result = new Vector<UserProfile>();

		    try {
		      Statement stmt = con.createStatement();

		      ResultSet rs = stmt.executeQuery("SELECT id, text, userRef FROM userprofile "  +"ORDER BY name");

		     
		      while (rs.next()) {

		    		UserProfile u = new UserProfile();
					u.setId(rs.getInt("id"));
					u.setText(rs.getString("text"));
					u.setUserRef(rs.getInt("userRef"));
				

		        
		        result.addElement(u);
		      }
		    }
		    catch (Exception e) {
		      e.printStackTrace();
		    }

		    
		    return result;
		  }
	  
	  public UserProfile findUserProfileByUserRef (int userRef) {
		  Connection con = DBConnection.getConnection();
			
			
			
			
			try {
				Statement stmt = con.createStatement();
				
				
				ResultSet rs =stmt.executeQuery("SELECT id, text, userRef FROM userprofile " + "WHERE userRef=" + userRef);
				
				if ( rs.next()){
					
					UserProfile u = new UserProfile();
					u.setId(rs.getInt("id"));
					u.setText(rs.getString("text"));
					u.setUserRef(rs.getInt("userRef"));
				
					
					return u; 
					
				}
			
			}
			catch(Exception e){
				e.printStackTrace();
				return null;
			}
			return null;
			
	  }
	
	}

