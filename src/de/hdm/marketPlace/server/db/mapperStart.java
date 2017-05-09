package de.hdm.marketPlace.server.db;


import de.hdm.marketPlace.*;
import de.hdm.marketPlace.shared.bo.ProjectMarketplace;

public class mapperStart {
	
	public static void main(String[] args) {
		
	
	
	ProjectMarketplaceMapper m1 = ProjectMarketplaceMapper.ProjectMarketplaceMapper();
	
	ProjectMarketplace p1 = new ProjectMarketplace();
	
	p1.setName("ProjectMarketplace:Leonard nr: 01");
	
	m1.insert(p1);
	
	

	
}
}