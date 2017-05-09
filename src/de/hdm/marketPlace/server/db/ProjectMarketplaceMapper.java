package de.hdm.marketPlace.server.db;

import java.sql.*;


import de.hdm.marketPlace.shared.bo.ProjectMarketplace;
import de.hdm.marketPlace.shared.bo.Rating;


//insert delete update ergänzen


public class ProjectMarketplaceMapper {

	
	private static ProjectMarketplaceMapper projectmarketplaceMapper = null;
	
	
	protected ProjectMarketplaceMapper () {

	}
	
	  private static ProjectMarketplace projectmarketplace = null;

	
	
	public static ProjectMarketplaceMapper ProjectMarketplaceMapper() {
	    if (projectmarketplaceMapper == null) {
	    	projectmarketplaceMapper = new ProjectMarketplaceMapper();
	    }
	    return projectmarketplaceMapper;
	  }
	    
	
	
	
	public ProjectMarketplace findByKey(int Id) {
	    
	    Connection con = DBConnection.getConnection();

	    try {
	    
	      Statement stmt = con.createStatement();

	      ResultSet rs = stmt.executeQuery("SELECT Id, Name, UserRef FROM ProjectMarketplace "
	              + "WHERE ProjectMarketplaceRef=" + Id );

	    
	      if (rs.next()) {
	    	  
	    	ProjectMarketplace pm = new ProjectMarketplace();
	        pm.setName(rs.getString("Name"));
	        
	      

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

	        
	        stmt.executeUpdate("INSERT INTO ProjectMarketplace (Id, name) "
	           + "VALUES (" + pm.getName()  +  "')");
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

	      stmt.executeUpdate("UPDATE ProjectMarketplace " + "SET name=\""
	          + pm.getName() + "\", " 
	          + "WHERE Id=" + pm.getId());

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

	      stmt.executeUpdate("DELETE FROM ProjectMarketplace " + "WHERE Id=" + pm.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	
	
}
