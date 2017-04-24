package de.hdm.marketPlace.server.db;

import java.sql.*;

import de.hdm.marketPlace.shared.bo.bo.bo.ProjectMarketplace;



public class ProjectMarketplaceMapper {

	
	private static ProjectMarketplaceMapper projectmarketplaceMapper = null;
	
	
	protected ProjectMarketplaceMapper () {

	}
	public ProjectMarketplace findByKey(int ProjectMarketplace_ID) {
	    
	    Connection con = DBConnection.getConnection();

	    try {
	    
	      Statement stmt = con.createStatement();

	      ResultSet rs = stmt.executeQuery("SELECT ProjectMarketplace_ID, Name, UserRef FROM ProjectMarketplace "
	              + "WHERE ProjectMarketplace_ID=" + ProjectMarketplace_ID );

	    
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
	
	
}
