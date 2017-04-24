package de.hdm.marketPlace.server.db;

import java.sql.*;

import de.hdm.marketPlace.shared.bo.TenderProfile;;


public class TenderProfileMapper {

	private static TenderProfileMapper tenderProfileMapper = null;
	
	protected TenderProfileMapper(){
	}
	
	public TenderProfile findByID(int ID){
		
		Connection con = DBConnection.getConnection();
		
	
	
	
	try {
		Statement stmt = con.createStatement();
		
		
		ResultSet rs =stmt.executeQuery("SELECT ID, Tender_ID value FROM TenderProfile" + "WHERE ID=" + ID +"ORDER BY Tender_ID");
		
		if ( rs.next()){
			
			TenderProfile tp = new TenderProfile();
			//Set ID fehlt // die ID muss erst im business objekt erstellt werden 
			tp.setID(rs.getInt("ID"));
			tp.setTender_ID(rs.getInt("Tender_ID"));
	
			
			return tp; 
			
		}
	
	}
	catch(Exception e){
		e.printStackTrace();
		return null;
	}
	return null;
	
	}
	
	public TenderProfile insert(TenderProfile tp) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	  
	      ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid "
	          + "FROM TenderProfile ");

	     
	      if (rs.next()) {
	
	    tp.setID(rs.getInt("maxid") + 1);

	        stmt = con.createStatement();

	        
	        stmt.executeUpdate("INSERT INTO TenderProfile (ID, Tender_ID) "
	           + "VALUES (" + tp.getTender_ID() + "')");
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return tp;
	  }


	  public TenderProfile update(TenderProfile tp) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("UPDATE TenderProfile " + "SET Tender_ID=\""
	          + tp.getTender_ID() + "\", " +  "\" "
	          + "WHERE id=" + tp.getID());

	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return tp;
	  }

	  
	  public void delete(TenderProfile tp) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM TenderProfile " + "WHERE ID=" + tp.getID());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	
	}

