package de.hdm.marketPlace.server.db;

import java.sql.*;
import java.util.Vector;

import de.hdm.marketPlace.*;
import de.hdm.marketPlace.server.MarketplaceAdministrationImpl;
import de.hdm.marketPlace.server.db.*;
import de.hdm.marketPlace.server.report.ReportGeneratorImpl;
import de.hdm.marketPlace.shared.bo.*;


import de.hdm.marketPlace.shared.bo.User;
import de.hdm.marketPlace.shared.report.AllApplicationsOfUser;
import de.hdm.marketPlace.shared.report.AllTenders;
import de.hdm.marketPlace.shared.report.PlainTextReportWriter;

public class mapperStart {
	
	
	
	
	
	public static void main(String[] args) {
		
	
	
 /*	ProjectMarketplaceMapper m1 = ProjectMarketplaceMapper.projectMarketplaceMapper();
	
	ProjectMarketplace p1 = new ProjectMarketplace();
	
	p1.setName("neuerprojektmarktplatz: DBtest");
	
	m1.insert(p1);
	
	
	*/
		
	/*	UserMapper um = UserMapper.userMapper();
		
		User user1 = new User();
		
		
		user1.setFirstname("updateleonard");
		
		um.insert(user1);
	
		um.update(user1);
		
		
	//	AttributeMapper am = AttributeMapper.attributeMapper();
		
//		Attribute a1 = new Attribute();
		
		
		//a1.setText("erster text");;
		
		
	//	am.insert(a1);
		
		//am.findByID(1);
		//System.out.println(am.findByID(1));
		
	/*	ProjectMapper pm = ProjectMapper.projectMapper();
		
		Project p = new Project();
		
		p.setName("project 1 ");
		p.setText("project 1 mit text befüllen");
		
		pm.insert(p);
		
		
		
		/* TenderMapper tm = TenderMapper.tenderMapper();
		
		
		
		 Vector <Tender> allTender = tm.findAll();
		 
		 System.out.println(allTender);
		*/
		
		
		
		
/*	MarketplaceAdministrationImpl admin = new MarketplaceAdministrationImpl();
	*/	
		
/*	UserMapper um = UserMapper.userMapper();
		
		User user1 = um.findByID(1);
		
	
		
		ReportGeneratorImpl testReport = new ReportGeneratorImpl();
		PlainTextReportWriter writer = new PlainTextReportWriter();
		
		AllApplicationsOfUser test1 = testReport.createAllApplicationsOfUserReport(user1);
		
		writer.getReportText();    //process(test1);
		
		System.out.println(writer.getReportText());
	*/
		
		TenderMapper tm = TenderMapper.tenderMapper();
		
		Tender tender1 = tm.findByID(1);
		
		ReportGeneratorImpl testReport = new ReportGeneratorImpl();
		
		PlainTextReportWriter writer = new PlainTextReportWriter();
		
		AllTenders t1 = testReport.createAllTendersReport();
		
		writer.process(t1);

		System.out.println(writer.getReportText());
		
//UserMapper um = UserMapper.userMapper();
		
		
	//	System.out.println(um.findByID(1));
	
}
}