package de.hdm.marketPlace.server.db;

import java.sql.*;
import de.hdm.marketPlace.*;

import de.hdm.marketPlace.server.db.*;
import de.hdm.marketPlace.shared.bo.Attribute;
import de.hdm.marketPlace.shared.bo.ProjectMarketplace;


import de.hdm.marketPlace.shared.bo.User;

public class mapperStart {
	
	
	
	
	
	public static void main(String[] args) {
		
	
	
 /*	ProjectMarketplaceMapper m1 = ProjectMarketplaceMapper.ProjectMarketplaceMapper();
	
	ProjectMarketplace p1 = new ProjectMarketplace();
	
	p1.setName("ProjectMarketplace:Leonard nr: 01");
	
	m1.insert(p1);
	
	*/
		
		UserMapper um = UserMapper.userMapper();
		
		User user1 = new User();
		
		
		user1.setName("updateleonard");
		
	//	um.insert(user1);
	
		um.update(user1);
		
		
		AttributeMapper am = AttributeMapper.attributeMapper();
		
		Attribute a1 = new Attribute();
		
		
		a1.setText("erster text");;
		
		
		am.insert(a1);
		
		
		
		
		
		
		
		
	

	
}
}