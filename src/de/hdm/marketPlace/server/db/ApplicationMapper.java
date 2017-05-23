package de.hdm.marketPlace.server.db;

import java.util.Date;
import java.util.Vector;


import java.sql.*;
import java.text.SimpleDateFormat;

import de.hdm.marketPlace.shared.bo.Application;
import de.hdm.marketPlace.shared.bo.Tender;
import de.hdm.marketPlace.shared.bo.User;


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
		
		
		ResultSet rs =stmt.executeQuery("SELECT id, text, name tenderRef, userRef, applicationDate value FROM application " + "WHERE id=" + id +" ORDER BY tenderRef");
		
		if ( rs.next()){
			
			Application a = new Application();
			a.setId(rs.getInt("id"));
			a.setText(rs.getString("text"));
			a.setName(rs.getString("name"));
			
			a.setTenderRef(rs.getInt("tenderRef"));
			a.setUserRef(rs.getInt("userRef"));
			a.setApplicationDate(rs.getDate("applicationDate"));
			
			
			
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

	      SimpleDateFormat mySQLformate = new SimpleDateFormat("yyyy-MM-dd ");
	        Date currentDate = new Date();
	        String date = mySQLformate.format(currentDate);
	  
	      ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid "
	          + "FROM Application ");

	     
	      if (rs.next()) {
	
	    a.setId(rs.getInt("maxid") + 1);

	        stmt = con.createStatement();

	        
	        stmt.executeUpdate("INSERT INTO application (id, text, name  tenderRef, userRef, applicationDate) "
	           + "VALUES ('" + a.getText()  + "','"+ a.getTenderRef() + ",'"+ a.getUserRef() + "','"    +  date + "')");
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
	      
	      SimpleDateFormat mySQLformate = new SimpleDateFormat("yyyy-MM-dd");
	        Date currentDate = new Date();
	        String date = mySQLformate.format(currentDate);

	      stmt.executeUpdate("UPDATE application " + "SET Text=\""
	          + a.getText() + "\", " + "Name=\"" + a.getName() + "\", " + "\", " + "UserRef=\"" + a.getUserRef() + "\", " + "TenderRef=\"" + a.getTenderRef() +  "applicationDate=\"" + date  +  "\" "
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
	  
	  //getallApplications
	  
	  public Vector<Application> getAllApplications() {
		    Connection con = DBConnection.getConnection();

		   
		    Vector<Application> result = new Vector<Application>();

		    try {
		      Statement stmt = con.createStatement();

		      ResultSet rs = stmt
		          .executeQuery("SELECT id, text, name, tenderRef, userRef FROM application "
		              + " ORDER BY tenderRef");

		    
		      while (rs.next()) {
		    	  Application a = new Application();
		    	  a.setId(rs.getInt("id"));
					a.setText(rs.getString("text"));
					a.setTenderRef(rs.getInt("tenderRef"));
					a.setUserRef(rs.getInt("userRef"));
					a.setName(rs.getString("name"));

		       
		        result.addElement(a);
		      }
		    }
		    catch (SQLException e2) {
		      e2.printStackTrace();
		    }

		   
		    return result;
		  }

	
	  
	  
	  public Vector<Application> findAllApplicationsByUserRef(int userRef) {
			
			Connection con = DBConnection.getConnection();
		
			Vector<Application> result = new Vector<Application>();

			try {
				Statement stmt = con.createStatement();

				ResultSet rs = stmt
						.executeQuery("SELECT id, text,  tenderRef, userRef FROM application "
		              + " ORDER BY tenderRef");

			
				while (rs.next()) {
					Application a = new Application();
					a.setId(rs.getInt("id"));
					a.setText(rs.getString("text"));
					a.setName(rs.getString("name"));
					a.setTenderRef(rs.getInt("tenderRef"));
					a.setUserRef(rs.getInt("userRef"));
					
				
					result.addElement(a);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			
			return result;
		}
	
	
	}

