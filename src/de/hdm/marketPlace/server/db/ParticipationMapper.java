package de.hdm.marketPlace.server.db;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import de.hdm.marketPlace.shared.bo.Participation;
import de.hdm.marketPlace.shared.bo.User;


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
		
		
		ResultSet rs =stmt.executeQuery("SELECT id, workingDays, projectRef, userRef, ratingRef, startDate, endDate value FROM participation " + "WHERE id=" + id +"ORDER BY workingDays");
		
		if ( rs.next()){
			
			Participation p = new Participation();
			p.setId(rs.getInt("id"));
			p.setWorkingDays(rs.getInt("workingDays"));
			p.setProjectRef(rs.getInt("projectRef"));
			p.setUserRef(rs.getInt("userRef"));
			p.setRatingRef(rs.getInt("ratingRef"));
			p.setStartDate(rs.getDate("startDate"));
			p.setEndDate(rs.getDate("endDate"));
			
			
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
	        

	        SimpleDateFormat mySQLformate = new SimpleDateFormat("yyyy-MM-dd ");
	        Date currentDate = new Date();
	        String date = mySQLformate.format(currentDate);
	        

	        
	        stmt.executeUpdate("INSERT INTO Participation (id, workingDays, projectRef, userRef, ratingRef) "
	           + "VALUES ('" + p.getWorkingDays() + "','" + p.getProjectRef() + "','"
	            + p.getUserRef()+  "','"  + p.getRatingRef() + "','"    +  date +  "','"    + date + "')");
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
	      
	      
	      SimpleDateFormat mySQLformate = new SimpleDateFormat("yyyy-MM-dd");
	        Date currentDate = new Date();
	        String date = mySQLformate.format(currentDate);

	      stmt.executeUpdate("UPDATE participation " + "SET WorkingDays=\""
	          + p.getWorkingDays() + "\", " + "ProjectRef=\"" + p.getProjectRef() + "\", " + "UserRef=\"" + p.getUserRef()+ "\", " + "RatingRef=\"" + p.getRatingRef() +  "StartDate=\"" + date+  "\", " +  "EndDate=\"" + date +  "\" "
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
	
	//  getallparticipationofuser
	  
	  public Vector<Participation> findAllParticipationsByUser() {
		    Connection con = DBConnection.getConnection();

		   
		    Vector<Participation> result = new Vector<Participation>();

		    try {
		      Statement stmt = con.createStatement();

		      ResultSet rs = stmt.executeQuery("SELECT id, workingDays, projectRef, userRef, ratingRef, startDate, endDate value FROM participation " +"ORDER BY workingDays");

		     
		      while (rs.next()) {
		    	  Participation p = new Participation();
		    	  p.setId(rs.getInt("id"));
					p.setWorkingDays(rs.getInt("workingDays"));
					p.setProjectRef(rs.getInt("projectRef"));
					p.setUserRef(rs.getInt("userRef"));
					p.setRatingRef(rs.getInt("ratingRef"));
					p.setStartDate(rs.getDate("startDate"));
					p.setEndDate(rs.getDate("endDate"));
					

		        
		        result.addElement(p);
		      }
		    }
		    catch (Exception e) {
		      e.printStackTrace();
		    }

		    
		    return result;
		  }

	  
	//  getallparticipations
	  
	  public Vector<Participation> findAll() {
		    Connection con = DBConnection.getConnection();

		   
		    Vector<Participation> result = new Vector<Participation>();

		    try {
		      Statement stmt = con.createStatement();

		      ResultSet rs = stmt.executeQuery("SELECT id, workingDays, projectRef, userRef, ratingRef, startDate, endDate value FROM participation " +"ORDER BY workingDays");

		     
		      while (rs.next()) {
		    	  Participation p = new Participation();
		    	  p.setId(rs.getInt("id"));
					p.setWorkingDays(rs.getInt("workingDays"));
					p.setProjectRef(rs.getInt("projectRef"));
					p.setUserRef(rs.getInt("userRef"));
					p.setRatingRef(rs.getInt("ratingRef"));
					p.setStartDate(rs.getDate("startDate"));
					p.setEndDate(rs.getDate("endDate"));
					

		        
		        result.addElement(p);
		      }
		    }
		    catch (Exception e) {
		      e.printStackTrace();
		    }

		    
		    return result;
		  }

	}

