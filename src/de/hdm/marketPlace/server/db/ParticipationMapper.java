package de.hdm.marketPlace.server.db;

import java.sql.*;


import de.hdm.marketPlace.shared.bo.Participation;


public class ParticipationMapper {

	private static ParticipationMapper participationMapper = null;
	
	protected ParticipationMapper(){
	}


	public static ParticipationMapper participationMapper() {
	    if (participationMapper == null) {
	    	participationMapper = new ParticipationMapper();
	    }
	    return participationMapper;
	  }
	    
	public Participation findByID(int id){
		
		Connection con = DBConnection.getConnection();
		
	
	
	
	try {
		Statement stmt = con.createStatement();
		
		
		ResultSet rs =stmt.executeQuery("SELECT id, workingDays, projectRef, userRef, ratingRef value FROM participation " + "WHERE id=" + id +"ORDER BY workingDays");
		
		if ( rs.next()){
			
			Participation p = new Participation();
			//Set ID fehlt // die ID muss erst im business objekt erstellt werden 
			p.setId(rs.getInt("id"));
			p.setWorkingDays(rs.getInt("workingDays"));
			p.setProjectRef(rs.getInt("projectRef"));
			p.setUserRef(rs.getInt("userRef"));
			p.setRatingRef(rs.getInt("ratingRef"));
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

	        
	        stmt.executeUpdate("INSERT INTO Participation (id, workingDays, projectRef, userRef, ratingRef) "
	           + "VALUES ('" + p.getWorkingDays() + "','" + p.getProjectRef() + "','"
	            + p.getUserRef()+  "','"  + p.getRatingRef() + "')");
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

	      stmt.executeUpdate("UPDATE participation " + "SET WorkingDays=\""
	          + p.getWorkingDays() + "\", " + "ProjectRef=\"" + p.getProjectRef() + "\", " + "UserRef=\"" + p.getUserRef()+ "\", " + "RatingRef=\"" + p.getRatingRef() +  "\" "
	          + "WHERE id=" + p.getId());

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

	      stmt.executeUpdate("DELETE FROM participation " + "WHERE id=" + p.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	
	}

