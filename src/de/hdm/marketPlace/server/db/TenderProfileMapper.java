package de.hdm.marketPlace.server.db;

import java.sql.*;

import de.hdm.marketPlace.shared.bo.TenderProfile;;


public class TenderProfileMapper {

	private static TenderProfileMapper tenderProfileMapper = null;
	
	protected TenderProfileMapper(){
	}
	
	public TenderProfile findByID(int Id){
		
		Connection con = DBConnection.getConnection();
		
	
	
	
	try {
		Statement stmt = con.createStatement();
		
		
		ResultSet rs =stmt.executeQuery("SELECT Id, TenderRef, patnerprofilRef, attributeRef value FROM TenderProfile" + "WHERE Id=" + Id +"ORDER BY TenderRef");
		
		if ( rs.next()){
			
			TenderProfile tp = new TenderProfile();
			//Set ID fehlt // die ID muss erst im business objekt erstellt werden 
			tp.setId(rs.getInt("Id"));
			tp.setTenderRef(rs.getInt("TenderRef"));
			tp.setPartnerprofileRef(rs.getInt("PartnerprofileRef"));
			tp.setAttributeRef(rs.getInt("AttributeRef"));
	
			
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
	
	    tp.setId(rs.getInt("maxid") + 1);

	        stmt = con.createStatement();

	        
	        stmt.executeUpdate("INSERT INTO TenderProfile (Id, tenderRef, partnerprofileRef, attributeRef ) "
	           + "VALUES (" + tp.getTenderRef() +  ",'" + tp.getPartnerprofileRef() +  ",'" + tp.getAttributeRef()+"')");
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

	      stmt.executeUpdate("UPDATE TenderProfile " + "SET TenderRef=\""
	          + tp.getTenderRef() + "\", " + "\", " + "AttributeRef=\"" + tp.getAttributeRef() + "\", " + "PartnerprofileRef=\"" + tp.getPartnerprofileRef() +  "\" "
	          + "WHERE Id=" + tp.getId());

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

	      stmt.executeUpdate("DELETE FROM TenderProfile " + "WHERE Id=" + tp.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	
	}

