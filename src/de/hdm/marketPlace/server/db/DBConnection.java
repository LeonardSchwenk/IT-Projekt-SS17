package de.hdm.marketPlace.server.db;


import java.sql.*;

public class DBConnection {

	
	private static final String JDBC_URL = "jdbc:mysql//localhost/marcetplace";
	private static final String User ="root";
	private static final String Pass = null ;
	
	
   

    private static Connection con = null; 

	
	public static Connection getConnection() {
	try {
		
		return DriverManager.getConnection(JDBC_URL,User,Pass);
		
	}
	catch(Exception E){
		E.printStackTrace();
	}
	
	return null; 

	}
}
