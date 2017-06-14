package de.hdm.marketPlace.server.db;

import java.sql.*;


import java.util.Vector;

import de.hdm.marketPlace.shared.bo.*;


public class AttributeMapper {

	private static AttributeMapper attributeMapper = null;
	
	protected AttributeMapper(){
	}
	
	public static AttributeMapper attributeMapper(){
		if(attributeMapper == null){
			attributeMapper = new  AttributeMapper();
		}
		
		return attributeMapper;
	}
	
	
	
	public Attribute findByID(int id){
		
		Connection con = DBConnection.getConnection();
		
	
	
	
	try {
		Statement stmt = con.createStatement();
		
		
		ResultSet rs =stmt.executeQuery("SELECT id, name, text, value, tenderprofileRef, userprofileRef FROM attribute "  + "WHERE id=" + id +" ORDER BY name");
		
		if ( rs.next()){
			
			Attribute a = new Attribute();
			a.setId(rs.getInt("id"));
			a.setName(rs.getString("name"));
			a.setText(rs.getString("text"));
			a.setValue(rs.getInt("value"));
			a.setTenderprofilRef(rs.getInt("tenderprofileRef"));
			a.setUserprofileRef(rs.getInt("userprofileRef"));
			
			return a; 
			
		}
	
	}
	catch(Exception e){
		e.printStackTrace();
		return null;
	}
	return null;
	
	}
	
	public Attribute insert(Attribute a) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	  
	      ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid "
	          + "FROM Attribute ");

	     
	      if (rs.next()) {
	
	    a.setId(rs.getInt("maxid") + 1);

	        stmt = con.createStatement();

	        
	        stmt.executeUpdate("INSERT INTO attribute (id, name, text, value, tenderprofileRef, userprofileRef) "
	           + "VALUES ('" + a.getId() + "','" + a.getName() + "','"
	            + a.getText()+ "','" +a.getValue()  + "','" +  a.getTenderprofilRef() + "','" +  a.getUserprofileRef()+  "')");
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return a;
	  }


	  public Attribute update(Attribute a) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("UPDATE attribute " + "SET name=\""
	          + a.getName() + "\", " + "text=\"" + a.getText() + "\", "+ "value=\"" + a.getValue() + "\", " + "TenderProfileRef=\"" + a.getTenderprofilRef()  + "\", " + "UserProfileRef=\"" + a.getUserprofileRef() +  "\" "
	          + "WHERE Id=" + a.getId());

	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    return a;
	  }

	  
	  public void delete(Attribute a) {
	    Connection con = DBConnection.getConnection();

	    try {
	      Statement stmt = con.createStatement();

	      stmt.executeUpdate("DELETE FROM attribue " + "WHERE id=" + a.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	  
	  
	  public Vector<Attribute> findAll() {
		    Connection con = DBConnection.getConnection();

		   
		    Vector<Attribute> result = new Vector<Attribute>();

		    try {
		      Statement stmt = con.createStatement();

		      ResultSet rs = stmt
		          .executeQuery("SELECT id, name, text, value, tenderprofileRef, userprofileRef FROM attribute "
		              + " ORDER BY value");

		    
		      while (rs.next()) {
		    	  Attribute a = new Attribute();
					a.setId(rs.getInt("Id"));
					a.setName(rs.getString("name"));
					a.setText(rs.getString("text"));
					a.setValue(rs.getInt("value"));
					a.setTenderprofilRef(rs.getInt("tenderprofileRef"));
					a.setUserprofileRef(rs.getInt("userprofileRef"));

		       
		        result.addElement(a);
		      }
		    }
		    catch (SQLException e2) {
		      e2.printStackTrace();
		    }

		   
		    return result;
		  }

	  
	
	  
	  public Vector<Attribute> findAllAttributesByUserProfileRef(int userprofileRef){
		  Connection con = DBConnection.getConnection();
		  Vector<Attribute> result = new Vector <Attribute>();
		  
		  try{
			  Statement stmt = con.createStatement();
			  
			  ResultSet rs = stmt.executeQuery("SELECT id, name, text, value, tenderprofileRef, userprofileRef FROM attribute " + "WHERE userprofileRef=" + userprofileRef  +" ORDER BY name");
			  while(rs.next()){
				  
				  Attribute a = new Attribute();
					a.setId(rs.getInt("id"));
					a.setName(rs.getString("name"));
					a.setText(rs.getString("text"));
					a.setValue(rs.getInt("value"));
					a.setTenderprofilRef(rs.getInt("tenderprofileRef"));
					a.setUserprofileRef(rs.getInt("userprofileRef"));
					
					
				  result.addElement(a);
			  }
		  
		  }
		  catch(Exception e){
			  e.printStackTrace();
		  }
		  return result;
	  }
	
	}

