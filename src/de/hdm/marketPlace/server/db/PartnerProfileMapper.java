package de.hdm.marketPlace.server.db;

import java.sql.*;

import de.hdm.marketPlace.shared.bo.PartnerProfile;;


public class PartnerProfileMapper {

	private static PartnerProfileMapper partnerProfileMapper = null;
	
	protected PartnerProfileMapper(){
	}
	
	public PartnerProfile findByID(int Id){
		
		Connection con = DBConnection.getConnection();
		
	
	
	
	try {
		Statement stmt = con.createStatement();
		
		
		ResultSet rs =stmt.executeQuery("SELECT Id, ArributeRef, text, value FROM PartnerProfile" + "WHERE Id=" + Id +"ORDER BY AttributeRef");
		
		if ( rs.next()){
			
			PartnerProfile p = new PartnerProfile();
			//Set ID fehlt // die ID muss erst im business objekt erstellt werden 
			p.setId(rs.getInt("Id"));
			
			p.getAttributeRef();
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
	
	    p.setId(rs.getInt("maxid") + 1);

	        stmt = con.createStatement();

	        
	        stmt.executeUpdate("INSERT INTO PartnerProfile (Id, AttributeRef, text, ) "
	           + "VALUES (" + p.getId() + ",'" + p.getText() + ",'" + p.getAttributeRef() + "')");
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
	          + p.getText() + "\", " + "AttributeRef=\"" + p.getAttributeRef() +  "\" "
	          + "WHERE Id=" + p.getId());

	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return p;
	  }

	  
	  public void delete(PartnerProfile p) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM PartnerProfile " + "WHERE Id=" + p.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	
	}

