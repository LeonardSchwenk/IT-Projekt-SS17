package de.hdm.marketPlace.server.db;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import de.hdm.marketPlace.shared.bo.Participation;
import de.hdm.marketPlace.shared.bo.TenderProfile;
import de.hdm.marketPlace.shared.bo.UserProfile;;


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
		
		
		ResultSet rs =stmt.executeQuery("SELECT id, tenderRef, tenderprofileDate value FROM tenderProfile " + "WHERE id=" + id +"ORDER BY tenderRef");
		
		if ( rs.next()){
			
			TenderProfile tp = new TenderProfile();
			tp.setId(rs.getInt("id"));
			tp.setTenderRef(rs.getInt("tenderRef"));
			tp.setTenderprofileDate(rs.getDate("tenderprofileDate"));
			
			
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
	      
	      SimpleDateFormat mySQLformate = new SimpleDateFormat("yyyy-MM-dd ");
	        Date currentDate = new Date();
	        String date = mySQLformate.format(currentDate);
	        

	  
	      ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid "
	          + "FROM TenderProfile ");

	     
	      if (rs.next()) {
	
	    tp.setId(rs.getInt("maxid") + 1);

	        stmt = con.createStatement();

	        
	        stmt.executeUpdate("INSERT INTO TenderProfile (id, tenderRef, tenderprofileDate ) "
	           + "VALUES ('" + tp.getTenderRef() + "','"    +  date+"')");
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
	      
	      SimpleDateFormat mySQLformate = new SimpleDateFormat("yyyy-MM-dd ");
	        Date currentDate = new Date();
	        String date = mySQLformate.format(currentDate);
	        

	      stmt.executeUpdate("UPDATE TenderProfile " + "SET TenderRef=\""
	          + tp.getTenderRef() + "\", " + "tenderprofileDate=\"" + date+   "\" "
	          + "WHERE id=" + tp.getId());

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
	  public Vector<TenderProfile> findAll() {
		    Connection con = DBConnection.getConnection();

		   
		    Vector<TenderProfile> result = new Vector<TenderProfile>();

		    try {
		      Statement stmt = con.createStatement();

		      ResultSet rs = stmt.executeQuery("SELECT id, tenderRef, tenderprofileDate value FROM tenderProfile "  +"ORDER BY tenderRef");

		     
		      while (rs.next()) {

					TenderProfile tp = new TenderProfile();
					tp.setId(rs.getInt("id"));
					tp.setTenderRef(rs.getInt("tenderRef"));
					tp.setTenderprofileDate(rs.getDate("tenderprofileDate"));
					

		        
		        result.addElement(tp);
		      }
		    }
		    catch (Exception e) {
		      e.printStackTrace();
		    }

		    
		    return result;
		  }
	  
	  public UserProfile findAllTenderProfilesByTenderRef (int tenderRef) {
		  Connection con = DBConnection.getConnection();
			
			
			
			
			try {
				Statement stmt = con.createStatement();
				
				
				ResultSet rs =stmt.executeQuery("SELECT id, text, userRef FROM userprofile " + "WHERE tenderRef=" + tenderRef);
				
				if ( rs.next()){
					
					UserProfile u = new UserProfile();
					u.setId(rs.getInt("id"));
					u.setText(rs.getString("text"));
					u.setUserRef(rs.getInt("tenderRef"));
				
					
					return u; 
					
				}
			
			}
			catch(Exception e){
				e.printStackTrace();
				return null;
			}
			return null;
			
	  }
	
	  
	  
	  
	}

