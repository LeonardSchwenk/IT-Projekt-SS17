package de.hdm.marketPlace.server.db;

import java.sql.*;
import java.util.Vector;

import de.hdm.marketPlace.shared.bo.Rating;
import de.hdm.marketPlace.shared.bo.User;


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
	
	public Rating findByID(int Id){
		
		Connection con = DBConnection.getConnection();
		
	
	
	
	try {
		Statement stmt = con.createStatement();
		
		
		ResultSet rs =stmt.executeQuery("SELECT id, rate, text value FROM Rating " + "WHERE Id=" + Id +"ORDER BY rate");
		
		if ( rs.next()){
			
			Rating r = new Rating();
			r.setId(rs.getInt("id"));
			r.setRate(rs.getFloat("rate"));
			r.setText(rs.getString("text"));
			
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

	        
	        stmt.executeUpdate("INSERT INTO Rating (id, rate, text) "
	           + "VALUES (" + r.getRate() + ",'" + r.getText() +  "'" +")");
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

	      stmt.executeUpdate("UPDATE Rating " + "SET Rate=\""
	          + r.getRate() + "\", " + "text=\"" + r.getText() + "UserRef=\"" 
	          + "WHERE Id=" + r.getId());

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

	      stmt.executeUpdate("DELETE FROM Rating " + "WHERE id=" + r.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	//  getallratingofapplication
	  
	  public Vector<Rating> findRatingByApplicationRef(int applicationRef){
		  Connection con = DBConnection.getConnection();
		  Vector<Rating> result = new Vector <Rating>();
		  
		  try{
			  Statement stmt = con.createStatement();
			  
			  ResultSet rs = stmt.executeQuery("SELECT id, rate, text value FROM Rating "  +"ORDER BY rate");
			  while(rs.next()){
				  
					Rating r = new Rating();
					r.setId(rs.getInt("id"));
					r.setRate(rs.getFloat("rate"));
					r.setText(rs.getString("text"));
					
			  result.addElement(r);
			  }
		  
		  }
		  catch(Exception e){
			  e.printStackTrace();
		  }
		  return result;
	  }
	}

