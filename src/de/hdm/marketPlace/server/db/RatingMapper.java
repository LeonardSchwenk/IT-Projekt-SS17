package de.hdm.marketPlace.server.db;

import java.sql.*;

import java.util.Vector;

import de.hdm.marketPlace.shared.bo.*;


public class RatingMapper {

	private static RatingMapper ratingMapper = null;
	
	protected RatingMapper(){
	}
	
	public static RatingMapper ratingMapper(){
		if(ratingMapper == null){
			ratingMapper = new  RatingMapper();
		}
		
		return ratingMapper;
	}
	
	public Rating findByID(int id){
		
		Connection con = DBConnection.getConnection();
		
	
	
	
	try {
		Statement stmt = con.createStatement();
		
		
		ResultSet rs =stmt.executeQuery("SELECT id, rate, text, applicationRef value FROM rating " + "WHERE id=" + id +"ORDER BY rate");
		
		if ( rs.next()){
			
			Rating r = new Rating();
			r.setId(rs.getInt("id"));
			r.setRate(rs.getFloat("rate"));
			r.setText(rs.getString("text"));
			r.setApplicationRef(rs.getInt("applicationRef"));
			
			return r; 
			
		}
	
	}
	catch(Exception e){
		e.printStackTrace();
		return null;
	}
	return null;
	
	}
	
	public Rating insert(Rating r) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	  
	      ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid "
	          + "FROM Rating ");

	     
	      if (rs.next()) {
	
	    r.setId(rs.getInt("maxid") + 1);

	        stmt = con.createStatement();

	        
	        stmt.executeUpdate("INSERT INTO rating (id, rate, text, applicationRef) "
	           + "VALUES (" + r.getRate() + ",'" + r.getText() + ",'" + r.getApplicationRef() +  "'" +")");
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return r;
	  }


	  public Rating update(Rating r) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("UPDATE rating " + "SET rate=\""
	          + r.getRate() + "\", " + "text=\"" + r.getText() + "applicationRef=\"" + r.getApplicationRef() +  "\" "
	          + "WHERE id=" + r.getId());

	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return r;
	  }

	  
	  public void delete(Rating r) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM rating " + "WHERE id=" + r.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	//  getallratingofapplication
	  
	  public Rating findRatingByApplicationRef(int applicationRef){
		  Connection con = DBConnection.getConnection();
		  Rating result = new Rating();
		  
		  try{
			  Statement stmt = con.createStatement();
			  
			  ResultSet rs = stmt.executeQuery("SELECT id, rate, text, applicationRef FROM rating " + "WHERE applicationRef=" + applicationRef +"ORDER BY rate");
			  while(rs.next()){
				  
					Rating r = new Rating();
					r.setId(rs.getInt("id"));
					r.setRate(rs.getFloat("rate"));
					r.setText(rs.getString("text"));
					r.setApplicationRef(rs.getInt("applicationRef"));
					
			 
			  }
		  
		  }
		  catch(Exception e){
			  e.printStackTrace();
		  }
		  return result;
	  }
	  
	  public Vector<Rating> findAll() {
		    Connection con = DBConnection.getConnection();

		   
		    Vector<Rating> result = new Vector<Rating>();

		    try {
		      Statement stmt = con.createStatement();

		      ResultSet rs = stmt.executeQuery("SELECT id, rate, text, applicationRef value FROM rating "  +"ORDER BY rate");

		     
		      while (rs.next()) {
		    	  
		    		Rating r = new Rating();
					r.setId(rs.getInt("id"));
					r.setRate(rs.getFloat("rate"));
					r.setText(rs.getString("text"));
					r.setApplicationRef(rs.getInt("applicationRef"));
					
		        
		        result.addElement(r);
		      }
		    }
		    catch (Exception e) {
		      e.printStackTrace();
		    }

		    
		    return result;
		  }
	}

