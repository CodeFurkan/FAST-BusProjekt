package de_hwg_lu.fastBus.beans;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import de_hwg_lu.fastBus.jdbc.NoConnectionException;
import de_hwg_lu.fastBus.jdbc.PostgreSQLAccess;
public class RegBean {
	
	String vorname;
	String nachname;
	Date geburtsdatum;
	String email;
	String password;
	
	
	
	public RegBean() {
		
		this.vorname ="";
		this.nachname ="";
		
		this.email="";
		this.password ="";
		
	}
	public void insertAccoutNoCheck() throws SQLException {
		String sql ="insert into account (vorname, nachname, geburtsdatum, email, password)"
				+ 	"values (?,?,?,?,?)";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		
		prep.setString(1, this.vorname);
		prep.setString(2, this.nachname);
		prep.setDate(3, this.geburtsdatum);
		prep.setString(4, this.email);
		prep.setString(5, this.password);
		prep.executeUpdate();
		System.out.println("Account " + this.email+ " erfolgreich angelegt.");
		
	}
	public boolean checkAccountExists() throws SQLException {
		String sql="select email from account where email=?";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setString(1, this.email);
		ResultSet dbRes = prep.executeQuery();
		return dbRes.next();
		
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
	public Date getGeburtsdatum() {
		return geburtsdatum;
	}
	public void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
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
