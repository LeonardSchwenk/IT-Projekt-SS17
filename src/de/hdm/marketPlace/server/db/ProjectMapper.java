package de.hdm.marketPlace.server.db;

import java.sql.*;
import java.util.Vector;

import de.hdm.marketPlace.shared.bo.Attribute;
import de.hdm.marketPlace.shared.bo.Project;


public class ProjectMapper {

	private static ProjectMapper projectMapper = null;
	
	protected ProjectMapper(){
		
	}
	

	public static ProjectMapper projectMapper() {
	    if (projectMapper == null) {
	    	projectMapper = new ProjectMapper();
	    }
	    return projectMapper;
	  }
	
	public Project findByID(int id){
		
		Connection con = DBConnection.getConnection();
		
	
	
	
	try {
		Statement stmt = con.createStatement();
		
		
		ResultSet rs =stmt.executeQuery("SELECT id, name, text, projectmarketplaceRef, tenderRef, userRef value FROM project" + "WHERE id=" + id +"ORDER BY name");
		
		if ( rs.next()){
			
			Project p = new Project();
			//Set ID fehlt // die ID muss erst im business objekt erstellt werden 
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setText(rs.getString("text"));
			p.setProjectmarketplaceRef(rs.getInt("projectmarketplaceRef"));
			p.setTenderRef(rs.getInt("tenderRef"));
			p.setUserRef(rs.getInt("userRef"));
			
			
			return p; 
			
		}
	
	}
	catch(Exception e){
		e.printStackTrace();
		return null;
	}
	return null;
	
	}
	
	public Project insert(Project p) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	  
	      ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid "
	          + "FROM Project ");

	     
	      if (rs.next()) {
	
	    p.setId(rs.getInt("maxid") + 1);

	        stmt = con.createStatement();

	        
	        stmt.executeUpdate("INSERT INTO project (id, name, text, projectmarketplaceRef,userRef , tenderRef) "
	           + "VALUES ('" + p.getId() + "','" + p.getName() + "','"
	            + p.getText()+ "','" + p.getProjectmarketplaceRef() + "','"    + p.getUserRef()  + "','"    + p.getTenderRef()  + "')");
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return p;
	  }


	  public Project update(Project p) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("UPDATE project " + "SET name=\""
	          + p.getName() + "\", " + "text=\"" + p.getText()+ "\", " + "projektmarketplaceRef=\"" + p.getProjectmarketplaceRef()+ "\", " +  "UserRef=\"" + p.getUserRef() +  "\", " +  "TenderRef=\"" + p.getTenderRef() +  "\" "
	          + "WHERE Id=" + p.getId());

	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return p;
	  }

	  
	  public void delete(Project p) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM Project " + "WHERE id=" + p.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	  
	  public Vector<Project> findAll() {
		    Connection con = DBConnection.getConnection();

		   
		    Vector<Project> result = new Vector<Project>();

		    try {
		      Statement stmt = con.createStatement();

		      ResultSet rs = stmt
		          .executeQuery("SELECT id, name, text, projectmarketplaceRef, tenderRef, userRef value FROM project "
		              + " ORDER BY name");

		    
		      while (rs.next()) {
		    	  Project p = new Project();
		    	  
		    	  p.setId(rs.getInt("id"));
					p.setName(rs.getString("name"));
					p.setText(rs.getString("text"));
					p.setProjectmarketplaceRef(rs.getInt("projectmarketplaceRef"));
					p.setTenderRef(rs.getInt("tenderRef"));
					p.setUserRef(rs.getInt("userRef"));

		   
		        result.addElement(p);
		      }
		    }
		    catch (SQLException e2) {
		      e2.printStackTrace();
		    }

		   
		    return result;
		  }

	
	
	}

