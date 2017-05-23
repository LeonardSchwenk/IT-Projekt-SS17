package de.hdm.marketPlace.server.db;

import java.util.Vector;

import java.sql.*;



import de.hdm.marketPlace.shared.bo.Application;


public class ApplicationMapper {

	private static ApplicationMapper applicationMapper = null;
	
	protected ApplicationMapper(){
	}
	

	public static ApplicationMapper applicationMapper() {
	    if (applicationMapper == null) {
	    	applicationMapper = new ApplicationMapper();
	    }
	    return applicationMapper;
	  }
	
	public Application findByID(int id){
		
		Connection con = DBConnection.getConnection();
		
	
	
	
	try {
		Statement stmt = con.createStatement();
		
		
		ResultSet rs =stmt.executeQuery("SELECT id, text, ratingRef, tenderRef, userRef value FROM application " + "WHERE id=" + id +" ORDER BY tenderRef");
		
		if ( rs.next()){
			
			Application a = new Application();
			a.setId(rs.getInt("id"));
			a.setText(rs.getString("text"));
			a.setRatingRef(rs.getInt("ratingRef"));
			a.setTenderRef(rs.getInt("tenderRef"));
			a.setUserRef(rs.getInt("userRef"));
			
			
			
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

	        
	        stmt.executeUpdate("INSERT INTO application (id, text, ratingRef, tenderRef, userRef) "
	           + "VALUES ('" + a.getText() + "','" + a.getRatingRef() + "','"+ a.getTenderRef() + ",'"+ a.getUserRef()  + "')");
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

	      stmt.executeUpdate("UPDATE application " + "SET Text=\""
	          + a.getText() + "\", " + "RatingRef=\"" + a.getRatingRef()+ "\", " + "UserRef=\"" + a.getUserRef() + "\", " + "TenderRef=\"" + a.getTenderRef() +  "\" "
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

	      stmt.executeUpdate("DELETE FROM application " + "WHERE id=" + a.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	  
	  
	  
	  public Vector<Application> findAll() {
		    Connection con = DBConnection.getConnection();

		   
		    Vector<Application> result = new Vector<Application>();

		    try {
		      Statement stmt = con.createStatement();

		      ResultSet rs = stmt
		          .executeQuery("SELECT id, text, ratingRef, tenderRef, userRef FROM application "
		              + " ORDER BY ratingref");

		    
		      while (rs.next()) {
		    	  Application a = new Application();
		    	  a.setId(rs.getInt("id"));
					a.setText(rs.getString("text"));
					a.setRatingRef(rs.getInt("ratingRef"));
					a.setTenderRef(rs.getInt("tenderRef"));
					a.setUserRef(rs.getInt("userRef"));
					

		       
		        result.addElement(a);
		      }
		    }
		    catch (SQLException e2) {
		      e2.printStackTrace();
		    }

		   
		    return result;
		  }


	  
	
	
	}

