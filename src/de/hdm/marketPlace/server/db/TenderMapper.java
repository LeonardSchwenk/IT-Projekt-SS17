package de.hdm.marketPlace.server.db;

import java.sql.*;

import de.hdm.marketPlace.shared.bo.Tender;


public class TenderMapper {

	private static TenderMapper tenderMapper = null;
	
	protected TenderMapper(){
	}
	
	public Tender findByID(int ID){
		
		Connection con = DBConnection.getConnection();
		
	
	
	
	try {
		Statement stmt = con.createStatement();
		
		
		ResultSet rs =stmt.executeQuery("SELECT ID, Text, Project_ID value FROM Tender" + "WHERE ID=" + ID +"ORDER BY Project_ID");
		
		if ( rs.next()){
			
			Tender t = new Tender();
			//Set ID fehlt // die ID muss erst im business objekt erstellt werden 
			t.setID(rs.getInt("ID");
			t.setText(rs.getString("Text"));
			t.setProject_ID(rs.getInt("Project_ID"));
			
		
			
			
			
			return t; 
			
		}
	
	}
	catch(Exception e){
		e.printStackTrace();
		return null;
	}
	return null;
	
	}
	
	public Tender insert(Tender t) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	  
	      ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid "
	          + "FROM Tender ");

	     
	      if (rs.next()) {
	
	    t.setID(rs.getInt("maxid") + 1);

	        stmt = con.createStatement();

	        
	        stmt.executeUpdate("INSERT INTO Tender (ID, Text, Project_ID) "
	           + "VALUES (" + t.getText() + ",'" + t.getProject_ID()  + "')");
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return t;
	  }


	  public Tender update(Tender t) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("UPDATE Tender " + "SET Text=\""
	          + t.getText() + "\", " + "Project_ID=\"" + t.getProject_ID()  +  "\" "
	          + "WHERE id=" + t.getID());

	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return t;
	  }

	  
	  public void delete(Tender t) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM Tender " + "WHERE ID=" + t.getID());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	
	}

