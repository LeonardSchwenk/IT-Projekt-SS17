package de.hdm.marketPlace.server.db;

import java.sql.*;


import de.hdm.marketPlace.shared.bo.Project;


public class ProjectMapper {

	private static ProjectMapper projectMapper = null;
	
	protected ProjectMapper(){
	}
	
	public Project findByID(int Id){
		
		Connection con = DBConnection.getConnection();
		
	
	
	
	try {
		Statement stmt = con.createStatement();
		
		
		ResultSet rs =stmt.executeQuery("SELECT Id, name, text, ProjectMangerRef, TenderRef value FROM Project" + "WHERE Id=" + Id +"ORDER BY name");
		
		if ( rs.next()){
			
			Project p = new Project();
			//Set ID fehlt // die ID muss erst im business objekt erstellt werden 
			p.setId(rs.getInt("ID"));
			p.setName(rs.getString("Name"));
			p.setText(rs.getString("Text"));
			p.setProjectManagerRef(rs.getInt("ProjectManagerRef"));
			
			
			p.setTenderRef(rs.getInt("TenderRef"));
			
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

	        
	        stmt.executeUpdate("INSERT INTO Project (Id, Name, Text, ProjectMangerRef, TenderRef) "
	           + "VALUES (" + p.getId() + ",'" + p.getName() + "','"
	            + p.getText()+ "','" +p.getProjectManagerRef() + "','"    + p.getTenderRef()  + "')");
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
	          + p.getName() + "\", " + "text=\"" + p.getText() + "ProjectManagerRef=\"" + p.getProjectManagerRef() +  "TenderRef=\"" + p.getTenderRef() +  "\" "
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

	      stmt.executeUpdate("DELETE FROM Project " + "WHERE Id=" + p.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	
	}

