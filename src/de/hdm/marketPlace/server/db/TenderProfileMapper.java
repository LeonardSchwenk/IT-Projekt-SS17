package de.hdm.marketPlace.server.db;

import java.sql.*;

import de.hdm.marketPlace.shared.bo.TenderProfile;;


public class TenderProfileMapper {

	private static TenderProfileMapper tenderProfileMapper = null;
	
	protected TenderProfileMapper(){
	}
	

	public static TenderProfileMapper tenderProfileMapper() {
	    if (tenderProfileMapper == null) {
	    	tenderProfileMapper = new TenderProfileMapper();
	    }
	    return tenderProfileMapper;
	  }
	
	public TenderProfile findByID(int id){
		
		Connection con = DBConnection.getConnection();
		
	
	
	
	try {
		Statement stmt = con.createStatement();
		
		
		ResultSet rs =stmt.executeQuery("SELECT id, tenderRef, patnerprofilRef, attributeRef value FROM tenderProfile" + "WHERE id=" + id +"ORDER BY tenderRef");
		
		if ( rs.next()){
			
			TenderProfile tp = new TenderProfile();
			//Set ID fehlt // die ID muss erst im business objekt erstellt werden 
			tp.setId(rs.getInt("id"));
			tp.setTenderRef(rs.getInt("tenderRef"));
			tp.setPartnerprofileRef(rs.getInt("partnerprofileRef"));
			tp.setAttributeRef(rs.getInt("attributeRef"));
	
			
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

	        
	        stmt.executeUpdate("INSERT INTO TenderProfile (id, tenderRef, partnerprofileRef, attributeRef ) "
	           + "VALUES ('" + tp.getTenderRef() +  "','" + tp.getPartnerprofileRef() +  "','" + tp.getAttributeRef()+"')");
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
	          + tp.getTenderRef() + "\", "  + "AttributeRef=\"" + tp.getAttributeRef() + "\", " + "PartnerprofileRef=\"" + tp.getPartnerprofileRef() +  "\" "
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

