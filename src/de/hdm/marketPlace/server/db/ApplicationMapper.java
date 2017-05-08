package de.hdm.marketPlace.server.db;

import java.sql.*;


import de.hdm.marketPlace.shared.bo.Application;


public class ApplicationMapper {

	private static ApplicationMapper applicationMapper = null;
	
	protected ApplicationMapper(){
	}
	
	public Application findByID(int Id){
		
		Connection con = DBConnection.getConnection();
		
	
	
	
	try {
		Statement stmt = con.createStatement();
		
		
		ResultSet rs =stmt.executeQuery("SELECT Id, Text, RatingRef, TenderRef, UserRef value FROM Application" + "WHERE Id=" + Id +"ORDER BY TenderRef");
		
		if ( rs.next()){
			
			Application a = new Application();
			//Set ID fehlt // die ID muss erst im business objekt erstellt werden 
			a.setId(rs.getInt("Id"));
			a.setText(rs.getString("Text"));
			a.setRatingRef(rs.getInt("RatingRef"));
			a.setTenderRef(rs.getInt("TenderRef"));
			a.setUserRef(rs.getInt("UserRef"));
			
			
			
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
	
	    a.setId(rs.getInt("maxid") + 1);

	        stmt = con.createStatement();

	        
	        stmt.executeUpdate("INSERT INTO Application (Id, Text, RatingRef, TenderRef, UserRef) "
	           + "VALUES (" + a.getText() + ",'" + a.getRatingRef() + "','"+ a.getTenderRef() + ",'"+ a.getUserRef()  + "')");
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
	          + a.getText() + "\", " + "RatingRef=\"" + a.getRatingRef() + "UserRef=\"" + a.getUserRef() +  "\" "
	          + "WHERE id=" + a.getId());

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

	      stmt.executeUpdate("DELETE FROM Application " + "WHERE Id=" + a.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	
	}

