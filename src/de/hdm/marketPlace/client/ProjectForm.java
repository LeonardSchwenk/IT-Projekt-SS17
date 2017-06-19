package de.hdm.marketPlace.client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.hdm.marketPlace.shared.LoginInfo;
import de.hdm.marketPlace.shared.MarketplaceAdministrationAsync;
import de.hdm.marketPlace.shared.bo.Project;
import de.hdm.marketPlace.client.ClientsideSettings;

public class ProjectForm extends Composite {
	
	private LoginInfo info = null;
	
	public void setInfo(LoginInfo info) {
		this.info = info;
	}
	
	public ProjectForm (){
		
	}
	
	MarketplaceAdministrationAsync admin = ClientsideSettings.getAdministration();
	
	VerticalPanel ButtonPanel= new VerticalPanel();
	CellTable<Project> dataGrid = new CellTable<Project>();
	Vector<Project> projectsOfUser = null;
	
	//MainView main;
	
	Button btn_createProject = new Button("Projekt erstellen");
	Button btn_updateProject = new Button("Projekt bearbeiten");
	Button btn_deleteProject = new Button("Projekt löschen");
	
	
	
	
protected void run(){
	
	RootPanel.get("Details").setWidth("75%");
	dataGrid.setWidth("100%", true);
	
	//Alle Projekte des aktuellen nutzers werden in Vector zurückgegeben
	
	admin.getAllProjectsOfUser(info.getUserId(), new AsyncCallback<Vector<Project>>(){
		
		@Override
		public void onFailure(Throwable caught) {
			
		}

		@Override
		public void onSuccess(Vector<Project> result) {
			
			projectsOfUser = result;
		
			}});
		
	
	
	dataGrid.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
	
	//Anlegen der Spalten und der Bezeichnungen
	
	TextColumn<Project> idColumn = new TextColumn<Project>(){
		
		@Override
		public String getValue(Project object) {
		
			return String.valueOf(object.getId());
		}
		
	};
	
	dataGrid.addColumn(idColumn, "ID");
	
	//------------------------------------------------------------
	
	TextColumn<Project> textColumn = new TextColumn<Project>(){
		
		@Override
		public String getValue(Project object) {
		
			return object.getText();
		}
		
	};
	
	dataGrid.addColumn(textColumn, "Text");
	
	//------------------------------------------------------------
	
	 TextColumn<Project> nameColumn = new TextColumn<Project>(){
			
			@Override
			public String getValue(Project object) {
			
				return object.getName();
			}
			
		};

		  dataGrid.addColumn(nameColumn, "Projektleiter-ID");

		//------------------------------------------------------------

TextColumn<Project> startDateColumn = new TextColumn<Project>(){
	
	
	
	@Override
	public String getValue(Project object) {
		
		return object.DateToString(object.getStartDate());
	}
	
};

  dataGrid.addColumn(startDateColumn, "Start-Datum");

//------------------------------------------------------------


TextColumn<Project> endDateColumn = new TextColumn<Project>(){
	
	@Override
	public String getValue(Project object) {
	
		return object.DateToString(object.getEndDate());
	
	}
	
};

dataGrid.addColumn(endDateColumn, "End-Datum");

//------------------------------------------------------------

TextColumn<Project> projectmarketplaceRefColumn = new TextColumn<Project>(){
	
	@Override
	public String getValue(Project object) {
	
		return String.valueOf(object.getProjectmarketplaceRef());
	}
	
};

  dataGrid.addColumn(endDateColumn, "Projektmarktplatz-ID");

//------------------------------------------------------------
  TextColumn<Project> userRefColumn = new TextColumn<Project>(){
		
		@Override
		public String getValue(Project object) {
		
			return String.valueOf(object.getUserRef());
		}
		
	};

	  dataGrid.addColumn(endDateColumn, "Projektleiter-ID");

	//------------------------------------------------------------
	  
	  final SingleSelectionModel<Project> selectionModel = new SingleSelectionModel<>();
		dataGrid.setSelectionModel(selectionModel);
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				
			}
		});

		  //Buttons dem Panel hinzufügen
		  
		  ButtonPanel.add(btn_createProject);
		  ButtonPanel.add(btn_updateProject);
		  ButtonPanel.add(btn_deleteProject);
		  
		  dataGrid.setWidth("100%");
		  
		  RootPanel.get().add(ButtonPanel);
		  RootPanel.get().add(dataGrid);
		
	  //Clickhandler anlegen
	  
	  btn_createProject.addClickHandler(new ClickHandler(){
		  
		  @Override
			public void onClick(ClickEvent event) {
			
				if (selectionModel.getSelectedObject() != null) {
					DialogBoxCreateProject dxcp = new DialogBoxCreateProjectCreate(selectionModel.getSelectedObject(), identityMarketChoice, navigation);
					dxcp.show();
					dxcp.center();
				}
				else {
					Window.alert("Bitte wählen Sie das Porjekt aus, welches Sie bearbeiten wollen!");
				}
			}
		});
	  
	  btn_updateProject.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if (selectionModel.getSelectedObject() == null) {
					Window.alert("Bitte wählen Sie ein Projekt aus!");
				}
				else {
				
					DialogBoxUpdateProject dpb = new DialogBoxUpdateProjectCreate(selectionModel.getSelectedObject(), navigation);
					int left = Window.getClientWidth() / 3;
					int top = Window.getClientHeight() / 8;
					dpb.setPopupPosition(left, top);
					
					dpb.show();
				}
			
			}
		});
	  
	  btn_deleteProject.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if (selectionModel.getSelectedObject() != null) {
						admin.deleteProject(selectionModel.getSelectedObject(), new AsyncCallback<Void>() {
						
						@Override
						public void onSuccess(Void result) {
							
							Window.alert("Das Projekt wurde gelöscht!");
							navigation.reload(); //Müssen wir das auch noch anlegen??
						}
						
						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Das Löschen des Projektes ist fehlgeschlagen");
							
						}
					});
				}
				else {
					Window.alert("Bitte wählen Sie zuerst das zu löschende Projekte aus!");
				}
				
			}
		});
	  


}


private class GetProjectCallback implements AsyncCallback<Vector<Project>>{

	@Override
	public void onFailure(Throwable caught) {
		Window.alert("Fehler: Die Projekte konnten nicht geladen werden!");
	}

	@Override
	public void onSuccess(Vector<Project> result) {

		final ListDataProvider dataProvider = new ListDataProvider();
		SimplePager pager;
		SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
		pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
		pager.setDisplay(dataGrid);
		dataProvider.addDataDisplay(dataGrid);
		dataProvider.setList(new ArrayList<Project>(projectsOfUser));
		pager.setPageSize(20);
		
		HorizontalPanel hp_pager = new HorizontalPanel();
		hp_pager.setWidth("100%");
		hp_pager.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		hp_pager.add(pager);
		RootPanel.get().add(hp_pager);
		dataGrid.setRowCount(projectsOfUser.size(), true);
		dataGrid.setRowData(0, projectsOfUser);
		
		}
	
	}

}


