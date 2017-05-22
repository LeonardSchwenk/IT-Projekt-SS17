package de.hdm.marketPlace.server.db;

import java.sql.*;

import de.hdm.marketPlace.shared.bo.Tender;


public class TenderMapper {

	private static TenderMapper tenderMapper = null;
	
	protected TenderMapper(){
	}
	

	public static TenderMapper tenderMapper(){
		if(tenderMapper == null){
			tenderMapper = new  TenderMapper();
		}
		
		return tenderMapper;
	}
	
	
	public Tender findByID(int id){
		
		Connection con = DBConnection.getConnection();
		
	
	
	
	try {
		Statement stmt = con.createStatement();
		
		
		ResultSet rs =stmt.executeQuery("SELECT Id, Text, ProjectRef value FROM Tender " + "WHERE id= " + id +"ORDER BY ProjectRef");
		
		if ( rs.next()){
			
			Tender t = new Tender();
			//Set ID fehlt // die ID muss erst im business objekt erstellt werden 
			t.setId(rs.getInt("Id"));
			t.setText(rs.getString("Text"));
			t.setProjectRef(rs.getInt("ProjectRef"));
			
		
			
			
			
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
	
	    t.setId(rs.getInt("maxid") + 1);

	        stmt = con.createStatement();

	        
	        stmt.executeUpdate("INSERT INTO Tender (Id, Text, ProjectRef) "
	           + "VALUES (" + t.getText() + ",'" + t.getProjectRef()  + "')");
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
	          + t.getText() + "\", " + "ProjectRef=\"" + t.getProjectRef()  +  "\" "
	          + "WHERE Id=" + t.getId());

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

	      stmt.executeUpdate("DELETE FROM Tender " + "WHERE Id=" + t.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	
	}

