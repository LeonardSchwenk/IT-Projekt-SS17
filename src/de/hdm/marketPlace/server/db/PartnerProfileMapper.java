package de.hdm.marketPlace.server.db;

import java.sql.*;

import de.hdm.marketPlace.shared.bo.PartnerProfile;;


public class PartnerProfileMapper {

	private static PartnerProfileMapper partnerProfileMapper = null;
	
	protected PartnerProfileMapper(){
	}
	
	public PartnerProfile findByID(int ID){
		
		Connection con = DBConnection.getConnection();
		
	
	
	
	try {
		Statement stmt = con.createStatement();
		
		
		ResultSet rs =stmt.executeQuery("SELECT ID, Arribute_ID, text, value FROM PartnerProfile" + "WHERE ID=" + ID +"ORDER BY Attribute_ID");
		
		if ( rs.next()){
			
			PartnerProfile p = new PartnerProfile();
			//Set ID fehlt // die ID muss erst im business objekt erstellt werden 
			p.setID(rs.getInt("ID");
			p.setAttribute_ID(rs.getInt("Attribute_ID"));
			p.setText(rs.getString("text"));
			
			
			return p; 
			
		}
	
	}
	catch(Exception e){
		e.printStackTrace();
		return null;
	}
	return null;
	
	}
	
	public PartnerProfile insert(PartnerProfile p) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	  
	      ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid "
	          + "FROM customers ");

	     
	      if (rs.next()) {
	
	    p.setID(rs.getInt("maxid") + 1);

	        stmt = con.createStatement();

	        
	        stmt.executeUpdate("INSERT INTO PartnerProfile (ID, Attribute_ID, text, ) "
	           + "VALUES (" + p.getID() + ",'" + p.getText() + ",'" + p.getAttribute_ID() + "')");
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return p;
	  }


	  public PartnerProfile update(PartnerProfile p) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("UPDATE PartnerProfile " + "SET Text=\""
	          + p.getText() + "\", " + "Attribute_ID=\"" + p.getAttribute_ID() +  "\" "
	          + "WHERE id=" + p.getID());

	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return pa;
	  }

	  
	  public void delete(PartnerProfile p) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM PartnerProfile " + "WHERE ID=" + p.getID());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	
	}

