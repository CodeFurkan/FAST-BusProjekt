package de_hwg_lu.fastBus.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import de_hwg_lu.fastBus.jdbc.PostgreSQLAccess;

public class RechnungBean {
	
	
	String vorname;
	String nachname;
	String email;
	String adresse;
	String land; 
	String stadt;
	String plz;
	String iban;
	String bic;
	String nameKonto;
	
	public RechnungBean() {
		this.vorname ="";
		this.nachname ="";
		this.email ="";
		this.adresse="";
		this.land = "";
		this.stadt= "";
		this.plz="";
		this.iban="";
		this.bic="";
		this.nameKonto="";
		
	}
	
	public void insertIntoBuchung() throws SQLException {
		String sql ="insert into Buchung (vorname, nachname, email, adresse, land, stadt, plz, iban, bic, nameKonto) "
					+"values (?,?,?,?,?,?,?,?,?,?)";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setString(1, this.vorname);
		prep.setString(2, this.nachname);
		prep.setString(3, this.email);
		prep.setString(4, this.adresse);
		prep.setString(5, this.land);
		prep.setString(6, this.stadt);
		prep.setString(7, this.plz);
		prep.setString(8, this.iban);
		prep.setString(9, this.bic);
		prep.setString(10, this.nameKonto);
		prep.executeUpdate();
		System.out.println("Buchung erfolgreich abgeschlossen");
		
	}
	public void checkVorname(String vorname) throws Exception {
		if( vorname != null && vorname.length() <=16) {
			this.vorname = vorname;
		}else {
			throw new IllegalArgumentException("Der Vorname ist zu lang.");
		}
		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public String getStadt() {
		return stadt;
	}

	public void setStadt(String stadt) {
		this.stadt = stadt;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public String getNameKonto() {
		return nameKonto;
	}

	public void setNameKonto(String nameKonto) {
		this.nameKonto = nameKonto;
	}

	
	
}
