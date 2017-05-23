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
		
		
		ResultSet rs =stmt.executeQuery("SELECT id, name, text, value, partnerprofileRef FROM attribute "  + "WHERE id=" + id +" ORDER BY name");
		
		if ( rs.next()){
			
			Attribute a = new Attribute();
			a.setId(rs.getInt("id"));
			a.setName(rs.getString("name"));
			a.setText(rs.getString("text"));
			a.setValue(rs.getInt("value"));
			a.setPartnerprofileRef(rs.getInt("partnerprofileRef"));
			
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

	        
	        stmt.executeUpdate("INSERT INTO attribute (id, name, text, value, partnerprofileRef) "
	           + "VALUES ('" + a.getId() + "','" + a.getName() + "','"
	            + a.getText()+ "','" +a.getValue()  + "','" +  a.getPartnerprofileRef()+  "')");
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
	          + a.getName() + "\", " + "text=\"" + a.getText() + "\", "+ "value=\"" + a.getValue() + "\", " + "PartnerprofileRef=\"" + a.getPartnerprofileRef() +  "\" "
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
		          .executeQuery("SELECT id, name, text, value, partnerprofileRef FROM attribute "
		              + " ORDER BY value");

		    
		      while (rs.next()) {
		    	  Attribute a = new Attribute();
					a.setId(rs.getInt("Id"));
					a.setName(rs.getString("name"));
					a.setText(rs.getString("text"));
					a.setValue(rs.getInt("value"));
					a.setPartnerprofileRef(rs.getInt("partnerprofileRef"));

		       
		        result.addElement(a);
		      }
		    }
		    catch (SQLException e2) {
		      e2.printStackTrace();
		    }

		   
		    return result;
		  }


	 // Getalluserprofiles 
	  
	  public Vector<UserProfile> getAllUserProfiles() {
		    Connection con = DBConnection.getConnection();

		   
		    Vector<UserProfile> result = new Vector<UserProfile>();

		    try {
		      Statement stmt = con.createStatement();

		      ResultSet rs = stmt.executeQuery("SELECT id, text, userRef, attributeRef FROM userprofile "  +"ORDER BY name");

		     
		      while (rs.next()) {
					UserProfile u = new UserProfile();
					u.setId(rs.getInt("id"));
					u.setText(rs.getString("text"));
					u.setUserRef(rs.getInt("userRef"));
					u.setAttributeRef(rs.getInt("attributeRef"));

		        
		        result.addElement(u);
		      }
		    }
		    catch (Exception e) {
		      e.printStackTrace();
		    }

		    
		    return result;
		  }

	  
	  //Getalltenderprofiles 
	  
	  
	  public Vector<UserProfile> getAllTenderProfiles() {
		    Connection con = DBConnection.getConnection();

		   
		    Vector<UserProfile> result = new Vector<UserProfile>();

		    try {
		      Statement stmt = con.createStatement();

		      ResultSet rs = stmt.executeQuery("SELECT id, text, userRef, attributeRef FROM userprofile "  +"ORDER BY name");

		     
		      while (rs.next()) {
					UserProfile u = new UserProfile();
					u.setId(rs.getInt("id"));
					u.setText(rs.getString("text"));
					u.setUserRef(rs.getInt("userRef"));
					u.setAttributeRef(rs.getInt("attributeRef"));

		        
		        result.addElement(u);
		      }
		    }
		    catch (Exception e) {
		      e.printStackTrace();
		    }

		    
		    return result;
		  }
	  
	  public Vector<Attribute> findByProfile(int ProfileRef){
		  Connection con = DBConnection.getConnection();
		  Vector<Attribute> result = new Vector <Attribute>();
		  
		  try{
			  Statement stmt = con.createStatement();
			  
			  ResultSet rs = stmt.executeQuery("SELECT id, name, text, value, partnerprofileRef FROM attribute "   +" ORDER BY name");
			  while(rs.next()){
				  
				  Attribute a = new Attribute();
					a.setId(rs.getInt("id"));
					a.setName(rs.getString("name"));
					a.setText(rs.getString("text"));
					a.setValue(rs.getInt("value"));
					a.setPartnerprofileRef(rs.getInt("partnerprofileRef"));
					
					
				  result.addElement(a);
			  }
		  
		  }
		  catch(Exception e){
			  e.printStackTrace();
		  }
		  return result;
	  }
	
	}

