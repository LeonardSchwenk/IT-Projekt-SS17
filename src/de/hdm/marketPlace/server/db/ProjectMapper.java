package de.hdm.marketPlace.server.db;

import java.sql.*;


import de.hdm.marketPlace.shared.bo.Project;


public class ProjectMapper {

	private static ProjectMapper projectMapper = null;
	
	protected ProjectMapper(){
	}
	
	public Project findByID(int ID){
		
		Connection con = DBConnection.getConnection();
		
	
	
	
	try {
		Statement stmt = con.createStatement();
		
		
		ResultSet rs =stmt.executeQuery("SELECT ID, name, text, ProjectManger_ID, Tender_ID value FROM Project" + "WHERE ID=" + ID +"ORDER BY name");
		
		if ( rs.next()){
			
			Project p = new Project();
			//Set ID fehlt // die ID muss erst im business objekt erstellt werden 
			p.setID(rs.getInt("ID");
			p.setName(rs.getString("Name"));
			p.setText(rs.getString("Text"));
			p.setProjectManager_ID(rs.getInt("ProjectManager_ID"));
			p.setTender_ID(rs.getInt("Tender_ID"));
			
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
	
	    p.setID(rs.getInt("maxid") + 1);

	        stmt = con.createStatement();

	        
	        stmt.executeUpdate("INSERT INTO Project (ID, Name, Text, ProjectManger_ID, Tender_ID) "
	           + "VALUES (" + p.getID() + ",'" + p.getName() + "','"
	            + p.getText()+ "','" +p.getProjectManager_ID() + "','"    + p.getTender_ID()  + "')");
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

	      stmt.executeUpdate("UPDATE Project " + "SET name=\""
	          + p.getName() + "\", " + "text=\"" + p.getText() + "ProjectManager_ID=\"" + p.getProjectManager_ID() +  "Tender_ID=\"" + p.getTender_ID() +  "\" "
	          + "WHERE id=" + p.getID());

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

	      stmt.executeUpdate("DELETE FROM Project " + "WHERE ID=" + p.getID());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	
	}

