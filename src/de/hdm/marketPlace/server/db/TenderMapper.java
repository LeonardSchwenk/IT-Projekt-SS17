package de.hdm.marketPlace.server.db;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import de.hdm.marketPlace.shared.bo.Tender;
import de.hdm.marketPlace.shared.bo.User;


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
		
		
		ResultSet rs =stmt.executeQuery("SELECT id, name, text, projectRef, startDate, endDate value FROM tender " + "WHERE id= " + id +"ORDER BY projectRef");
		
		if ( rs.next()){
			
			Tender t = new Tender();
			t.setId(rs.getInt("id"));
			t.setName(rs.getString("name"));
			t.setText(rs.getString("text"));
			t.setProjectRef(rs.getInt("projectRef"));
			t.setStartDate(rs.getDate("startDate"));
			t.setEndDate(rs.getDate("endDate")); 
		
			
			
			
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
	        
	        SimpleDateFormat mySQLformate = new SimpleDateFormat("yyyy-MM-dd");
	        Date currentDate = new Date();
	        String date = mySQLformate.format(currentDate);

	        
	        stmt.executeUpdate("INSERT INTO Tender ( id, text, projectRef, startDate, endDate ) "
	           + "VALUES (" + t.getText() + ",'" + t.getProjectRef() + ",'" + t.getName()  +  "','"    +  date +  "','"    + date +"')");
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
	      
	      SimpleDateFormat mySQLformate = new SimpleDateFormat("yyyy-MM-dd");
	        Date currentDate = new Date();
	        String date = mySQLformate.format(currentDate);

	      stmt.executeUpdate("UPDATE Tender " + "SET Text=\""
	          + t.getText() + "\", " + "ProjectRef=\"" + t.getProjectRef() + "\", " + "Name=\"" + t.getName() +  "StartDate=\"" + date +  "\", " +  "EndDate=\"" + date  +  "\" "
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

	      stmt.executeUpdate("DELETE FROM Tender " + "WHERE id=" + t.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	//  getalltenderbyuser
	  
	  public Vector<Tender> findAllTenderByUserRef(int userRef) {
		    Connection con = DBConnection.getConnection();

		   
		    Vector<Tender> result = new Vector<Tender>();

		    try {
		      Statement stmt = con.createStatement();

		      ResultSet rs = stmt.executeQuery("SELECT id ,name, text, projectRef, startDate, endDate value FROM tender "+ "WHERE userRef=" + userRef +"ORDER BY projectRef");

		     
		      while (rs.next()) {
		    	  Tender t = new Tender();
					t.setId(rs.getInt("id"));
					t.setName(rs.getString("name"));
					t.setText(rs.getString("text"));
					t.setProjectRef(rs.getInt("projectRef"));
					t.setStartDate(rs.getDate("startDate"));
					t.setEndDate(rs.getDate("endDate")); 
		        
		        result.addElement(t);
		      }
		    }
		    catch (Exception e) {
		      e.printStackTrace();
		    }

		    
		    return result;
		  }
	  
	
	  
	  
	  
		  //getalltenderbyname
	  
	  public Vector<Tender> findByName(String name){
		  Connection con = DBConnection.getConnection();
		  Vector<Tender> result = new Vector <Tender>();
		  
		  try{
			  Statement stmt = con.createStatement();
			  
			  ResultSet rs = stmt.executeQuery("SELECT id, text, projectRef, startDate, endDate value FROM tender " + "WHERE name=" + name +"ORDER BY projectRef");
			  while(rs.next()){
				  
				  				Tender t = new Tender();
								t.setId(rs.getInt("id"));
								t.setName(rs.getString("name"));
								t.setText(rs.getString("text"));
								t.setProjectRef(rs.getInt("projectRef"));
								t.setStartDate(rs.getDate("startDate"));
								t.setEndDate(rs.getDate("endDate")); 
								
			  result.addElement(t);
			  }
		  
		  }
		  catch(Exception e){
			  e.printStackTrace();
		  }
		  return result;
	  }
		 // getalltender
	  
	  public Vector<Tender> findAll() {
		    Connection con = DBConnection.getConnection();

		   
		    Vector<Tender> result = new Vector<Tender>();

		    try {
		      Statement stmt = con.createStatement();

		      ResultSet rs = stmt.executeQuery("SELECT id ,name, text, projectRef, startDate, endDate value FROM tender " +"ORDER BY projectRef");

		     
		      while (rs.next()) {
		    	  Tender t = new Tender();
					t.setId(rs.getInt("id"));
					t.setName(rs.getString("name"));
					t.setText(rs.getString("text"));
					t.setProjectRef(rs.getInt("projectRef"));
					t.setStartDate(rs.getDate("startDate"));
					t.setEndDate(rs.getDate("endDate")); 
		        
		        result.addElement(t);
		      }
		    }
		    catch (Exception e) {
		      e.printStackTrace();
		    }

		    
		    return result;
		  }
		 // gettendermatch
	  
	  public Vector <Tender> findAllTendersByProjectRef (int projectRef) {
		  Connection con = DBConnection.getConnection();
		  
		  Vector <Tender> result = new Vector <Tender>();
		  
		  try {
			  Statement stmt = con.createStatement();
			  ResultSet rs = stmt.executeQuery("SELECT id ,name, text, projectRef, startDate, endDate value FROM tender "+ "WHERE projectRef=  " + projectRef +"ORDER BY projectRef");
			  
			  while (rs.next()) {
				  Tender t = new Tender();
					  t.setId(rs.getInt("id"));
					  t.setName(rs.getString("name"));
					  t.setText(rs.getString("text"));
					  t.setProjectRef(rs.getInt("projectRef"));
					  t.setStartDate(rs.getDate("startDate"));
					  t.setEndDate(rs.getDate("endDate"));
					  
				  result.addElement(t);
			  	}
		  	}
		  
			catch (Exception e){
				e.printStackTrace();
			}
		  
		  return result;
	  }
}
			
				  
			  
		  

	
	



