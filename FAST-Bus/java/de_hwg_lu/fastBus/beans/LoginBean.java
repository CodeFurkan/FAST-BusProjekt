package de_hwg_lu.fastBus.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de_hwg_lu.fastBus.jdbc.NoConnectionException;
import de_hwg_lu.fastBus.jdbc.PostgreSQLAccess;

public class LoginBean {
	
	String  email;
	String password;
	boolean isLoggedIn;
	
	
	public LoginBean() {
		this.email  ="";
		this.password ="";
		this.isLoggedIn = false;
		
	}
	/*
	 * überprüft, ob es einen Datensatz mit this.email und this.password in table account gibt - TRUE
	 * 	andernfalls - FALSE
	*/
	public boolean checkEmailPassword() throws SQLException {
		String sql="select email from account where email=? and passwort=?";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setString(1, this.email);
		prep.setString(2, this.password);
		ResultSet dbRes = prep.executeQuery();
				
		return dbRes.next();
	}
	/*
	 * überprüft, ob der Nutzer eingeloggt ist
	 * falls nicht eingeloggt Weiterleitung an HomepageAppl
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

	
}
