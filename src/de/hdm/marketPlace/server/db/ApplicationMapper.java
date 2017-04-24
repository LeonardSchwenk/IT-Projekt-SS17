package de.hdm.marketPlace.server.db;

import java.sql.*;


import de.hdm.marketPlace.shared.bo.Application;


public class ApplicationMapper {

	private static ApplicationMapper applicationMapper = null;
	
	protected ApplicationMapper(){
	}
	
	public Application findByID(int ID){
		
		Connection con = DBConnection.getConnection();
		
	
	
	
	try {
		Statement stmt = con.createStatement();
		
		
		ResultSet rs =stmt.executeQuery("SELECT ID, Text, Rating_ID, Tender_ID, User_ID value FROM Application" + "WHERE ID=" + ID +"ORDER BY Tender_ID");
		
		if ( rs.next()){
			
			Application a = new Application();
			//Set ID fehlt // die ID muss erst im business objekt erstellt werden 
			a.setID(rs.getInt("ID"));
			a.setText(rs.getString("Text"));
			a.setRating_ID(rs.getInt("Rating_ID"));
			a.setTender_ID(rs.getInt("Tender_ID"));
			a.setUser_ID(rs.getInt("User_ID"));
			
			
			
			return a; 
			
		}
	
	}
	catch(Exception e){
		e.printStackTrace();
		return null;
	}
	return null;
	
	}
	
	public Application insert(Application a) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	  
	      ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid "
	          + "FROM Application ");

	     
	      if (rs.next()) {
	
	    a.setID(rs.getInt("maxid") + 1);

	        stmt = con.createStatement();

	        
	        stmt.executeUpdate("INSERT INTO Application (ID, Text, Rating_ID, Tender_ID, User_ID) "
	           + "VALUES (" + a.getText() + ",'" + a.getRating_ID() + "','"+ a.getTender_ID() + ",'"+ a.getUser_ID()  + "')");
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return a;
	  }


	  public Application update(Application a) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("UPDATE Application " + "SET Text=\""
	          + a.getText() + "\", " + "Rating_ID=\"" + a.getRating_ID() + "User_ID=\"" + a.getUser_ID() +  "\" "
	          + "WHERE id=" + a.getID());

	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return a;
	  }

	  
	  public void delete(Application a) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM Application " + "WHERE ID=" + a.getID());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	
	}

