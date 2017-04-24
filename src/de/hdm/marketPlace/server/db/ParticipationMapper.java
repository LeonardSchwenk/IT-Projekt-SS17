package de.hdm.marketPlace.server.db;

import java.sql.*;


import de.hdm.marketPlace.shared.bo.Participation;


public class ParticipationMapper {

	private static ParticipationMapper participationMapper = null;
	
	protected ParticipationMapper(){
	}
	
	public Participation findByID(int ID){
		
		Connection con = DBConnection.getConnection();
		
	
	
	
	try {
		Statement stmt = con.createStatement();
		
		
		ResultSet rs =stmt.executeQuery("SELECT ID, Workdays, Project_ID, User_ID value FROM Participation" + "WHERE ID=" + ID +"ORDER BY Workdays");
		
		if ( rs.next()){
			
			Participation p = new Participation();
			//Set ID fehlt // die ID muss erst im business objekt erstellt werden 
			p.setID(rs.getInt("ID");
			p.setWorkdays(rs.getInt("Workdays"));
			p.setProject_ID(rs.getInt("Project_ID"));
			p.setUser_ID(rs.getInt("User_ID"));
			
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
	
	    p.setID(rs.getInt("maxid") + 1);

	        stmt = con.createStatement();

	        
	        stmt.executeUpdate("INSERT INTO Participation (ID, Workdays, Project_ID, User_ID) "
	           + "VALUES (" + p.getWorkdays() + ",'" + p.getProject_ID() + "','"
	            + p.getUser_ID()  + "')");
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

	      stmt.executeUpdate("UPDATE Participation " + "SET Workdays=\""
	          + p.getWorkdays() + "\", " + "Project_ID=\"" + p.getProject_ID() + "User_ID=\"" + p.getUser_ID() +  "\" "
	          + "WHERE id=" + p.getID());

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

	      stmt.executeUpdate("DELETE FROM Participation " + "WHERE ID=" + p.getID());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	
	}

