package de.hdm.marketPlace.client.report;

import java.util.Vector;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import de.hdm.marketPlace.client.ClientsideSettings;
import de.hdm.marketPlace.client.Showcase;
import de.hdm.marketPlace.shared.LoginInfo;
import de.hdm.marketPlace.shared.MarketplaceAdministrationAsync;
import de.hdm.marketPlace.shared.ReportGeneratorAsync;
import de.hdm.marketPlace.shared.bo.User;
import de.hdm.marketPlace.shared.report.HTMLReportWriter;
import de.hdm.marketPlace.shared.report.ProjectInterconnection;

public class ProjectInterconnectionShowcase extends Showcase {

	@Override
	protected String getHeadlineText() {
		return "Report: Projektverflechtung eines bestimmten Nutzers";
	}
	
	public LoginInfo loginInfo = null;
	public User currentUser = null;
	
	public ProjectInterconnectionShowcase(LoginInfo info){
		this.loginInfo = info;
	}

	@Override
	protected void run() {
		
		VerticalPanel inputPanel = new VerticalPanel();
		final HTMLResultPanel resultPanel = new HTMLResultPanel();
		final Showcase showcase = this;

		
		this.append("Auslesen der Projektverflechtung eines bestimmten Nutzers");
		
		
		ReportGeneratorAsync reportGenerator = ClientsideSettings.getReportGenerator();
		MarketplaceAdministrationAsync admin = ClientsideSettings.getAdministration();
		
	
		//Benutzer muss aus einer Liste seiner Bewerber einen wählen
		
		final ListBox applicantBox = new ListBox();
		applicantBox.addItem("Bitte wählen Sie den gewünschten Bewerber aus");
		
		admin.getAllApplicantOfUser(loginInfo.getUserId(), new AsyncCallback<Vector<User>>(){
			

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Fehler: "+caught.getMessage());
						
					}

					@Override
					public void onSuccess(Vector<User> result) {
						
						for (User bewerber : result) {
							
							applicantBox.addItem(bewerber.getFirstname()+", "+bewerber.getLastname()+", ID: "+bewerber.getId()); 
							
						   	
						}	
				}
		});
		
		inputPanel.add(applicantBox);
		inputPanel.add(resultPanel);
		this.add(inputPanel);
		
		//___________________________________________
		
		applicantBox.addChangeHandler(new ChangeHandler(){
			
			@Override
			public void onChange(ChangeEvent event){
				
				resultPanel.clear();
				String s = applicantBox.getValue(applicantBox.getSelectedIndex());
				String last = s.substring(s.indexOf(":")+1, s.length());
				int selectedId = Integer.valueOf(last);
				
				
				 
					admin.getUserById(selectedId,  new AsyncCallback <User> (){
					
							public void onFailure(Throwable caught) {
								showcase.append("Fehler: " + caught.getMessage());;
								
							}
				
							@Override
							public void onSuccess(User result) {
								if(result!= null){
									
									currentUser = result;
								}	
							}
						});	
		
				reportGenerator.createProjectInterconnectionReport(currentUser, new AsyncCallback <ProjectInterconnection> (){
					
					public void onFailure(Throwable caught) {
						showcase.append("Fehler: " + caught.getMessage());;
						
					}
		
					@Override
					public void onSuccess(ProjectInterconnection result) {
						if(result!= null){
							
							HTMLReportWriter writer = new HTMLReportWriter();
						
							writer.process(result);
							
							resultPanel.append(writer.getReportText());
						}	
					}
				});	
				
			}
				
			});

	}

}
