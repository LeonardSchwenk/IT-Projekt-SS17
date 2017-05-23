package de.hdm.marketPlace.server.db;

import java.sql.*;




import de.hdm.marketPlace.shared.bo.ProjectMarketplace;
import de.hdm.marketPlace.shared.bo.Rating;


//insert delete update erg�nzen


public class ProjectMarketplaceMapper {

	
	private static ProjectMarketplaceMapper projectmarketplaceMapper = null;
	
	
	protected ProjectMarketplaceMapper () {

	}
	
	Connection con = DBConnection.getConnection();

	
	
	public static ProjectMarketplaceMapper projectMarketplaceMapper() {
	    if (projectmarketplaceMapper == null) {
	    	projectmarketplaceMapper = new ProjectMarketplaceMapper();
	    }
	    return projectmarketplaceMapper;
	  }
	    
	
	
	
	public ProjectMarketplace findByID(int id) {
	    
	    Connection con = DBConnection.getConnection();

	    try {
	    
	      Statement stmt = con.createStatement();

	      ResultSet rs = stmt.executeQuery("SELECT id, name, userRef FROM projectmarketplace "
	              + "WHERE id=" + id +"ORDER BY name" );

	    
	      if (rs.next()) {
	    	  
	    	ProjectMarketplace pm = new ProjectMarketplace();
	        pm.setName(rs.getString("name"));
	        
	        
	      

	        return pm;
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	      return null;
	    }

	    return null;
	  }

	public ProjectMarketplace insert(ProjectMarketplace pm) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	  
	      ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid "
	          + "FROM ProjectMarketplace ");

	     
	      if (rs.next()) {
	
	    pm.setId(rs.getInt("maxid") + 1);

	        stmt = con.createStatement();

	        
	        stmt.executeUpdate("INSERT INTO projectmarketplace (id, name) "
	           + "VALUES ('" + pm.getName()  +  "')");
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return pm;
	  }


	  public ProjectMarketplace update(ProjectMarketplace pm) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("UPDATE projectmarketplace " + "SET name=\""
	          + pm.getName() + "\", " 
	          + "WHERE id=" + pm.getId());

	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return pm;
	  }

	  
	  public void delete(ProjectMarketplace pm) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM ProjectMarketplace " + "WHERE id=" + pm.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	
	
}
