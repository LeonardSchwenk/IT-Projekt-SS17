package de.hdm.marketPlace.server.db;


import java.sql.*;



public class DBConnection {
	
    private static Connection con = null; 

	
	private static final String JDBC_URL =   "jdbc:mysql://173.194.245.224/projectmarketplace?user=LeonardSchwenk&password=1234";
	

	
//	"jdbc:mysql://localhost:3306/marketplace";
	
	
	private static final String User ="root";
	private static final String Pass = null ;
	
	
   


	
	public static Connection getConnection() {
		
		if(con == null){
			
		
	try {
		
			con =  DriverManager.getConnection(JDBC_URL);
			
		 //con =  DriverManager.getConnection(JDBC_URL,User,Pass);
	}
	catch(Exception E){
		con = null;
		System.out.println(E.toString());
		E.printStackTrace();
	}
	}
	return con; 

	}
}
