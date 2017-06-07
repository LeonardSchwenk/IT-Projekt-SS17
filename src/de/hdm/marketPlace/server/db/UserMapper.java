package de.hdm.marketPlace.server.db;
import java.sql.Connection;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.marketPlace.shared.bo.*;


public class UserMapper {

private static UserMapper userMapper = null;
	
	protected UserMapper(){
	}
	

	
	public static UserMapper userMapper() {
	    if (userMapper == null) {
	    	userMapper = new UserMapper();
	    }
	    return userMapper;
	  }
	    
	public User findByID(int id){
		
		Connection con = DBConnection.getConnection();
		
	
	try {
		Statement stmt = con.createStatement();
		
		
		
		ResultSet rs = stmt
		          .executeQuery("SELECT id, firstname, lastname, projectmarketplaceRef  FROM user "
		              + "WHERE id=" + id + " ORDER BY firstname");
		
		if ( rs.next()){
			
			User u = new User();
			u.setId(rs.getInt("id"));
			u.setFirstname(rs.getString("firstname"));
			u.setLastname(rs.getString("lastname"));
			u.setProjectmarketplaceRef(rs.getInt("projectmarketplaceRef"));
			
	
			
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
	          + "FROM user ");

	     
	      if (rs.next()) {
	
	    u.setId(rs.getInt("maxid") + 1);

	        stmt = con.createStatement();
	        
	        u.setId(rs.getInt("maxid") + 1);

	        
	        stmt.executeUpdate("INSERT INTO user (id, firstname, lastname, projectmarketplaceRef) "
	           + "VALUES ('" + u.getId() + "','" + u.getFirstname() +  "','" + u.getLastname()+  "','" + u.getProjectmarketplaceRef() +  "')");
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

	      stmt.executeUpdate("UPDATE user " + "SET FistName=\""
	          + u.getFirstname()+ "SET LastName=\""
	    	          + u.getLastname() + "SET ProjectMarketplaceRef=\""
	    	    	          + u.getProjectmarketplaceRef() + "\" "
	          + "WHERE id=" + u.getId());

	      
	      
	      
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

	      stmt.executeUpdate("DELETE FROM user " + "WHERE id=" + u.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	  
	  public Vector<User> findByName(String name){
		  Connection con = DBConnection.getConnection();
		  Vector<User> result = new Vector <User>();
		  
		  try{
			  Statement stmt = con.createStatement();
			  
			  ResultSet rs = stmt.executeQuery("SELECT id, firstname, lastname, projectmarketplaceRef "
			          + "FROM user " + "WHERE user LIKE '" + name
			          + "' ORDER BY name");
			  while(rs.next()){
				  
				  User u = new User();
			  u.setId(rs.getInt("id"));
				u.setFirstname(rs.getString("firstname"));
				u.setLastname(rs.getString("lastname"));
				u.setProjectmarketplaceRef(rs.getInt("projectmarketplaceRef"));
			  
			  result.addElement(u);
			  }
		  
		  }
		  catch(Exception e){
			  e.printStackTrace();
		  }
		  return result;
	  }
	  
	  public Vector<User> findAll() {
		    Connection con = DBConnection.getConnection();

		   
		    Vector<User> result = new Vector<User>();

		    try {
		      Statement stmt = con.createStatement();

		      ResultSet rs = stmt.executeQuery("SELECT id, firstname, lastname, projectmarketplaceRef FROM User "
		          + " ORDER BY id");

		     
		      while (rs.next()) {
		    	  User u = new User();
		    		u.setId(rs.getInt("id"));
		    		u.setFirstname(rs.getString("firstname"));
					u.setLastname(rs.getString("lastname"));
					u.setProjectmarketplaceRef(rs.getInt("projectmarketplaceRef"));

		        
		        result.addElement(u);
		      }
		    }
		    catch (Exception e) {
		      e.printStackTrace();
		    }

		    
		    return result;
		  }

	  public Vector<User> findAllUserByTenderRef(int TenderRef){
		  Connection con = DBConnection.getConnection();
		  Vector<User> result = new Vector <User>();
		  
		  try{
			  Statement stmt = con.createStatement();
			  
			  ResultSet rs = stmt.executeQuery("SELECT id, firstname, lastname, projectmarketplaceRef "
			          + "FROM user " + "' ORDER BY name");
			  while(rs.next()){
				  
				  User u = new User();
			  u.setId(rs.getInt("id"));
				u.setFirstname(rs.getString("firstname"));
				u.setLastname(rs.getString("lastname"));
				u.setProjectmarketplaceRef(rs.getInt("projectmarketplaceRef"));
			  
			  result.addElement(u);
			  }
		  
		  }
		  catch(Exception e){
			  e.printStackTrace();
		  }
		  return result;
	  }
	  public Vector<User> findAllUserByProjectRef(int ProjectRef){
		  Connection con = DBConnection.getConnection();
		  Vector<User> result = new Vector <User>();
		  
		  try{
			  Statement stmt = con.createStatement();
			  
			  ResultSet rs = stmt.executeQuery("SELECT id, firstname, lastname, projectmarketplaceRefe "
			          + "FROM user "   + "' ORDER BY name");
			  while(rs.next()){
				  
				  User u = new User();
			  u.setId(rs.getInt("id"));
				u.setFirstname(rs.getString("firstname"));
				u.setLastname(rs.getString("lastname"));
				u.setProjectmarketplaceRef(rs.getInt("projectmarketplaceRef"));
			  
			  result.addElement(u);
			  }
		  
		  }
		  catch(Exception e){
			  e.printStackTrace();
		  }
		  return result;
	  }
	  
	 
	  
	  
	  
	  
	  
	
	  
	  

}
