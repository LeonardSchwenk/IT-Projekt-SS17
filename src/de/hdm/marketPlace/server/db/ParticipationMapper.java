package de.hdm.marketPlace.server.db;

import java.sql.*;


import de.hdm.marketPlace.shared.bo.Participation;


public class ParticipationMapper {

	private static ParticipationMapper participationMapper = null;
	
	protected ParticipationMapper(){
	}
	
	public Participation findByID(int Id){
		
		Connection con = DBConnection.getConnection();
		
	
	
	
	try {
		Statement stmt = con.createStatement();
		
		
		ResultSet rs =stmt.executeQuery("SELECT Id, Workdays, ProjectRef, UserRef value FROM Participation" + "WHERE Id=" + Id +"ORDER BY WorkingDays");
		
		if ( rs.next()){
			
			Participation p = new Participation();
			//Set ID fehlt // die ID muss erst im business objekt erstellt werden 
			p.setId(rs.getInt("Id"));
			p.setWorkingDays(rs.getInt("WorkingDays"));
			p.setProjectRef(rs.getInt("ProjectRef"));
			p.setUserRef(rs.getInt("UserRef"));
			
			return p; 
			
		}
	
	}
	catch(Exception e){
		e.printStackTrace();
		return null;
	}
	return null;
	
	}
	
	public Participation insert(Participation p) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	  
	      ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid "
	          + "FROM Participation ");

	     
	      if (rs.next()) {
	
	    p.setId(rs.getInt("maxid") + 1);

	        stmt = con.createStatement();

	        
	        stmt.executeUpdate("INSERT INTO Participation (Id, WorkingDays, ProjectRef, UserRef) "
	           + "VALUES (" + p.getWorkingDays() + ",'" + p.getProjectRef() + "','"
	            + p.getUserRef()  + "')");
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return p;
	  }


	  public Participation update(Participation p) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("UPDATE Participation " + "SET WorkingDays=\""
	          + p.getWorkingDays() + "\", " + "ProjectRef=\"" + p.getProjectRef() + "UserRef=\"" + p.getUserRef() +  "\" "
	          + "WHERE Id=" + p.getId());

	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return p;
	  }

	  
	  public void delete(Participation p) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM Participation " + "WHERE Id=" + p.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	
	}

