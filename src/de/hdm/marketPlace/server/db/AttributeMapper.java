package de.hdm.marketPlace.server.db;

import java.sql.*;


import de.hdm.marketPlace.shared.bo.Attribute;


public class AttributeMapper {

	private static AttributeMapper attributeMapper = null;
	
	protected AttributeMapper(){
	}
	
	public Attribute findByID(int Id){
		
		Connection con = DBConnection.getConnection();
		
	
	
	
	try {
		Statement stmt = con.createStatement();
		
		
		ResultSet rs =stmt.executeQuery("SELECT Id, name, text, value FROM Attribute" + "WHERE Id=" + Id +"ORDER BY name");
		
		if ( rs.next()){
			
			Attribute a = new Attribute();
			//Set ID fehlt // die ID muss erst im business objekt erstellt werden 
			a.setId(rs.getInt("Id"));
			a.setName(rs.getString("name"));
			a.setText(rs.getString("text"));
			a.setValue(rs.getInt("value"));
			a.setPartnerprofileRef(rs.getInt("PartnerprofileRef"));
			
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

	        
	        stmt.executeUpdate("INSERT INTO attribute (Id, name, text, value, partnerprofileRef) "
	           + "VALUES (" + a.getId() + ",'" + a.getName() + "','"
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

	      stmt.executeUpdate("UPDATE Attribute " + "SET name=\""
	          + a.getName() + "\", " + "text=\"" + a.getText() + "value=\"" + a.getValue() + "PartnerprofileRef=\"" + a.getPartnerprofileRef() +  "\" "
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

	      stmt.executeUpdate("DELETE FROM Attribue " + "WHERE Id=" + a.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	
	}

