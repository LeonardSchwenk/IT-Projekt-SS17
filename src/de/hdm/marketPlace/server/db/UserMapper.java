package de.hdm.marketPlace.server.db;
import java.sql.Connection;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import de.hdm.marketPlace.shared.bo.TenderProfile;
import de.hdm.marketPlace.shared.bo.User;


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
		          .executeQuery("SELECT id, name FROM user "
		              + "WHERE id=" + id + " ORDER BY name");
		
		if ( rs.next()){
			
			User u = new User();
			//Set ID fehlt // die ID muss erst im business objekt erstellt werden 
			u.setId(rs.getInt("id"));
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
	          + "FROM user ");

	     
	      if (rs.next()) {
	
	    u.setId(rs.getInt("maxid") + 1);

	        stmt = con.createStatement();
	        
	        u.setId(rs.getInt("maxid") + 1);

	        
	        stmt.executeUpdate("INSERT INTO user (id, name) "
	           + "VALUES ('" + u.getId() + "','" + u.getName() +  "')");
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

	      stmt.executeUpdate("UPDATE user " + "SET Name=\""
	          + u.getName() + "\" "
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
	
	


}
