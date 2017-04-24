package de.hdm.marketPlace.server.db;

import java.sql.*;


import de.hdm.marketPlace.shared.bo.Attribute;


public class AttributeMapper {

	private static AttributeMapper attributeMapper = null;
	
	protected AttributeMapper(){
	}
	
	public Attribute findByID(int ID){
		
		Connection con = DBConnection.getConnection();
		
	
	
	
	try {
		Statement stmt = con.createStatement();
		
		
		ResultSet rs =stmt.executeQuery("SELECT ID, name, text, value FROM Attribute" + "WHERE ID=" + ID +"ORDER BY name");
		
		if ( rs.next()){
			
			Attribute a = new Attribute();
			//Set ID fehlt // die ID muss erst im business objekt erstellt werden 
			a.setID(rs.getInt("ID");
			a.setName(rs.getString("name"));
			a.setText(rs.getString("text"));
			a.setValue(rs.getInt("value"));
			
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
	
	    a.setID(rs.getInt("maxid") + 1);

	        stmt = con.createStatement();

	        
	        stmt.executeUpdate("INSERT INTO attribute (ID, name, text, value) "
	           + "VALUES (" + a.getID() + ",'" + a.getName() + "','"
	            + a.getText()+ "','" +a.getValue()   + "')");
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
	          + a.getName() + "\", " + "text=\"" + a.getText() + "value=\"" + a.getValue() +  "\" "
	          + "WHERE id=" + a.getID());

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

	      stmt.executeUpdate("DELETE FROM Attribue " + "WHERE ID=" + a.getID());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
	
	
	}

