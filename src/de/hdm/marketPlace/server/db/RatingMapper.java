package de.hdm.marketPlace.server.db;

import java.sql.*;

import de.hdm.marketPlace.shared.bo.Rating;


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
		
		
		ResultSet rs =stmt.executeQuery("SELECT Id, rate, text value FROM Rating " + "WHERE Id=" + Id +"ORDER BY rate");
		
		if ( rs.next()){
			
			Rating r = new Rating();
			//Set ID fehlt // die ID muss erst im business objekt erstellt werden 
			r.setId(rs.getInt("Id"));
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

	        
	        stmt.executeUpdate("INSERT INTO Rating (Id, rate, text) "
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

	      stmt.executeUpdate("DELETE FROM Rating " + "WHERE Id=" + r.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	
	}

