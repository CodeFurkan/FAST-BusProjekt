package de_hwg_lu.fastBus.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de_hwg_lu.fastBus.jdbc.NoConnectionException;
import de_hwg_lu.fastBus.jdbc.PostgreSQLAccess;
	
public class LoginBean {
	
	int userid;
	String vorname;
	String nachname;
	String email;
	String geburtsdatum;
	String password;
	boolean isLoggedIn;
	
	
	public LoginBean() {
		this.vorname="";
		this.nachname ="";
		this.email  ="";
		this.geburtsdatum  ="";
		this.password ="";
		this.isLoggedIn = false;
		
	}
	/*
	 * überprüft, ob es einen Datensatz mit this.email und this.password in table account gibt - TRUE
	 * 	andernfalls - FALSE
	*/
	public boolean checkEmailPassword2() throws SQLException {
		String sql="select email from account where email=? and passwort=?";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setString(1, this.email);
		prep.setString(2, this.password);
		ResultSet dbRes = prep.executeQuery();
				
		return dbRes.next();
	} 
	public boolean checkEmailPassword() throws SQLException {
		String sql="select * from account where email=? and passwort=?";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setString(1, this.email);
		prep.setString(2, this.password);
		ResultSet dbRes = prep.executeQuery();
		while(dbRes.next()) {
			this.vorname=dbRes.getString("vorname");
			this.nachname= dbRes.getString("nachname");
			this.email = dbRes.getString("email");
			this.geburtsdatum= dbRes.getString("geburtsdatum");
			this.userid= dbRes.getInt("kundenid");
			
			return true;
		}
		
		return false;
	}
	/*
	 * überprüft, ob der Nutzer eingeloggt ist
	 * falls nicht eingeloggt Weiterleitung an ErrorpageView
	 * falls eingeloggt leerer String - keine Weiterleitung
	 */
	
	public String getCheckLoggedIn() {
		System.out.println("login");
		if(!this.isLoggedIn()) 
			return "<meta http-equiv='refresh' content='0; URL=./ErrorpageView.jsp' >\n";
		else return "";
	}
	
	public boolean isLoggedIn(){
		return isLoggedIn;
		
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getGeburtsdatum() {
		return geburtsdatum;
	}
	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	
}
