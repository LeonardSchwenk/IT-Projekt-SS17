package de.hdm.marketPlace.server.db;

import java.sql.*;

import de.hdm.marketPlace.shared.bo.Rating;


public class RatingMapper {

	private static RatingMapper participationMapper = null;
	
	protected RatingMapper(){
	}
	
	public Rating findByID(int ID){
		
		Connection con = DBConnection.getConnection();
		
	
	
	
	try {
		Statement stmt = con.createStatement();
		
		
		ResultSet rs =stmt.executeQuery("SELECT ID, rate, text value FROM Rating" + "WHERE ID=" + ID +"ORDER BY rate");
		
		if ( rs.next()){
			
			Rating r = new Rating();
			//Set ID fehlt // die ID muss erst im business objekt erstellt werden 
			r.setID(rs.getInt("ID");
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
	
	    r.setID(rs.getInt("maxid") + 1);

	        stmt = con.createStatement();

	        
	        stmt.executeUpdate("INSERT INTO Rating (ID, rate, text) "
	           + "VALUES (" + r.getRate() + ",'" + r.getText() +  "')");
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
	          + r.getRate() + "\", " + "text=\"" + r.getText() + "User_ID=\"" 
	          + "WHERE id=" + r.getID());

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

	      stmt.executeUpdate("DELETE FROM Rating " + "WHERE ID=" + p.getID());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	
	}

