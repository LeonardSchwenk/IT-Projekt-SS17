package de.hdm.marketPlace.shared.bo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date; 

		/**
		 * Realisierung einer Projektbeteiligung. Diese deutet an, dass ein Projektleiter mit einem Bewerber zusammenarbeiten will.
		 */

public class Participation extends BusinessObject{
	
		/**
		 * Attribute der Klasse
		 */
		
		/**
		 * Referenz auf das jeweilige Projekt
		 */
		private int projectRef = 0;
		
		/**
		 * Referenz auf den jeweiligen User
		 */
		private int userRef = 0; 
		
		/**
		 * Referenz auf die jeweilige Bewertung
		 */
		private int ratingRef = 0; 
		
		/**
		 * Referenz auf die jeweilige Ausschreibung
		 */
		private int tenderRef  = 0;
		
		/**
		 * Anzahl der damit verbundenen Arbeitstage
		 */
		private int workingDays = 0;
		
		/**
		 * Anfangsdatum der Beteiligung
		 */
		private Date startDate;
		
		/**
		 * Enddatum der Beteiligung
		 */
		private Date endDate;
	
		/**
		 * Alle Get und Set Methoden zum Auslesen und Setzen der Attribute
		 */
	
		/**
		 * Ausgabe der Projekt Referenz
		 */
		public int getProjectRef() {
			return projectRef;
		}
		
		/**
		 * Setzen der Projekt Referenz
		 */
		public void setProjectRef(int projectRef) {
			this.projectRef = projectRef;
		}
		
		/**
		 * Ausgabe der User Referenz
		 */
		public int getUserRef() {
			return userRef;
		}
		
		/**
		 * Setzen der User Referenz
		 */
		public void setUserRef(int userRef) {
			this.userRef = userRef;
		}
		
		/**
		 * Ausgabe der Bewertungs Referenz
		 */
		public int getRatingRef() {
			return ratingRef;
		}
		
		/**
		 * Setzen der Bewertungs Referenz
		 */
		public void setRatingRef(int ratingRef) {
			this.ratingRef = ratingRef;
		}
		
		/**
		 * Ausgabe der Ausschreibungsreferenz
		 */
		public int getTenderRef() {
			return tenderRef;
		}
		
		/**
		 * Setzen der Ausschreibungsreferenz
		 */
		public void setTenderRef(int tenderRef) {
			this.tenderRef = tenderRef;
		}

		/**
		 * Integerwert wird auf String geändert, um im späteren Verlauf im Reportgeneratro ausgegeben zu werden
		 */
		public String getWorkingDays() {
			
		/*
		 * Der Variable s vom Typ String wird der Wert von workingDays zugewiesen und im Anschluss zurückgegeben
		 */
			String s = String.valueOf(workingDays);
			return s;
		}
		
		/**
		 * Setzen der Arbeitstage
		 */
		public void setWorkingDays(int workingDays) {
			this.workingDays = workingDays;
		}
		
		/**
		 * Ausgabe des Anfangsdatums
		 */
		public Date getStartDate() {
			return startDate;
		}
		
		/**
		 * Setzen des Anfangsdatums
		 */
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		
		/**
		 * Ausgabe des Enddatums
		 */
		public Date getEndDate() {
			return endDate;
		}
		
		/**
		 * Setzen des Enddatums
		 */
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
		
		/**
		 * Textuelle Ausgabe der jeweiligen Projektbeteiligungs-Instanz 
		 */
		public String toString() {
			
		/*
		 * Ausgabe der Projektreferenz, Userreferenz, Bewertungsreferenz, Arbeitstage und zusätzlich Start- und Enddatum
		 */
		    return super.toString() + "projectRef:  " + this.projectRef + "userRef: " + this.userRef+ " ratingRef: " + this.ratingRef + "workingDays" + this.workingDays+ "startdate" + this.startDate+ "enddate" + this.endDate;
		}
	 
		/**
		 * Ein Übergabeparameter vom Typ Date wird in einen String umgewandelt und im Anschluss zurückgegeben
		 */
		public String DateToString(Date d){
			
		/*
		 * Ein neues Datums Objekt wird erstellt 
		 */
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			
		/*
		 * Einem neuen String Objekt werden die Werte von übergebenen Datums Objekt d zugewiesen
		 */
			String stringDate = df.format(d);
			
		/*
		 * Das neue String Objekt wird zurückgegeben
		 */
			return stringDate;
		}
	
}