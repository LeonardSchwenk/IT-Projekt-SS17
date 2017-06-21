package de.hdm.marketPlace.client.dialogBox;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;

import de.hdm.marketPlace.client.ClientsideSettings;
import de.hdm.marketPlace.shared.LoginInfo;
import de.hdm.marketPlace.shared.MarketplaceAdministrationAsync;
import de.hdm.marketPlace.shared.bo.Project;

public class DialogBoxCreateProject extends DialogBox{
	
	private LoginInfo info = null;
	
	public void setInfo (LoginInfo info){
		this.info=info;
	}
	FlexTable ft_createProject = new FlexTable();
	
	Button btn_save = new Button ("Speichern");
	Button btn_cancel = new Button ("Abbrechen");
	
	
	
	
	Label lbl_projectname = new Label("Projektname: ");
	TextBox txt_projectname = new TextBox();
	Label lbl_text = new Label("Text: ");
	TextArea txta_discription = new TextArea();
	Label lbl_startdate= new Label("Startdatum: ");
	DateBox db_startdate = new DateBox();
	Label lbl_enddate = new Label("Enddatum: ");
	DateBox db_enddate = new DateBox();
	DatePicker datepicker = new DatePicker();
	HorizontalPanel hp = new HorizontalPanel();
	
	public DialogBoxCreateProject(final LoginInfo Info ){
		this.info = info;
		
		this.setText("Project Anlegen: ");
		this.setAnimationEnabled(true);
		this.setGlassEnabled(true);
		
		hp.add(btn_save);
		hp.add(btn_cancel);
		
		btn_save.addClickHandler( new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				if(txt_projectname.getText().isEmpty()){
					Window.alert("Der Projektname fehlt!");
				}
				else if(txta_discription.getText().isEmpty()){
				Window.alert("Der Beschreibungstext des Projektes fehlt!");
				}
				
				else { 
					MarketplaceAdministrationAsync admin = ClientsideSettings.getAdministration();
					
					admin.createProject(txt_projectname.getName(), txta_discription.getText(), db_startdate.getValue(), db_enddate.getValue(), info.getUserId(), new CreateProjectCallback());
				}
				}
			});
		
		btn_cancel.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				
				hide();
				
			}
			
		});
		
		DateTimeFormat dateformat =DateTimeFormat.getFormat("dd.MM.yyyy");
		db_startdate.setFormat(new DateBox.DefaultFormat(dateformat));
		db_enddate.setFormat(new DateBox.DefaultFormat(dateformat));
		
		ft_createProject.setWidget(1, 0, lbl_projectname);
		ft_createProject.setWidget(1, 1, txt_projectname);
		ft_createProject.setWidget(2, 0, lbl_text);
		ft_createProject.setWidget(2, 1, lbl_startdate);
		ft_createProject.setWidget(3, 0, db_startdate);
		ft_createProject.setWidget(3, 1, lbl_enddate);
		ft_createProject.setWidget(4, 0, db_enddate);
		ft_createProject.setWidget(4, 1, datepicker);
		
		ft_createProject.setWidget(7, 1, hp);
		
		setWidget(ft_createProject);
		
		
			
		}
		private class CreateProjectCallback implements AsyncCallback<Project>{
			
			

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Das Projekt konnte nicht angelegt werden.");
				
			}

			@Override
			public void onSuccess(Project result) {
				
				final Project p = null ;
				
				Window.alert("Das Projekt wurde erfolgreich angelegt!");
				hide();
				
				
				MarketplaceAdministrationAsync admin = ClientsideSettings.getAdministration();

				admin.createProject(txt_projectname.getValue(), txta_discription.getValue(), db_startdate.getValue(), db_enddate.getValue(), info.getUserId(), new AsyncCallback<Project>(){
					
					
					public void onFailure(Throwable caught){
						Window.alert("Das Projekt konnte nicht angelegt werden.");
						
					}
					public void onSuccess(Project result){
						
						
						Window.alert("Das Projekt"+ "  "+ p.getName() +" wurde erfolgreich angelegt");
						hide();
						
			}
				});
			
			}
			
		}
		
		
	
	
}	
	
