package de_hwg_lu.fastBus.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import de_hwg_lu.fastBus.jdbc.NoConnectionException;
import de_hwg_lu.fastBus.jdbc.PostgreSQLAccess;

public class RechnungBean {

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	String vorname;
	String nachname;
	String email;
	String adresse;
	String stadt;
	String plz;
	String iban;
	String bic;
	String nameKonto;

	String startStadt;
	String ZielStadt;
	String zielStadt;
	String datum;
	String startUhrzeit;
	String zielUhrzeit;
	int dauerStd;
	int dauerMin;
	String preis;

	String routenID;
	int plaetzeFrei;

	public RechnungBean() {
		this.vorname = "";
		this.nachname = "";
		this.email = "";
		this.adresse = "";
		this.stadt = "";
		this.plz = "";
		this.iban = "";
		this.bic = "";
		this.nameKonto = "";

	}

	public void insertIntoBuchung() throws SQLException {
		String sql = "insert into Buchung (vorname, nachname, email, adresse, stadt, plz, iban, bic, nameKonto) "
				+ "values (?,?,?,?,?,?,?,?,?)";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setString(1, this.vorname);
		prep.setString(2, this.nachname);
		prep.setString(3, this.email);
		prep.setString(4, this.adresse);
		prep.setString(5, this.stadt);
		prep.setString(6, this.plz);
		prep.setString(7, this.iban);
		prep.setString(8, this.bic);
		prep.setString(9, this.nameKonto);
		prep.executeUpdate();
		System.out.println("Buchung erfolgreich abgeschlossen");

	}

	public void checkVorname(String vorname) throws Exception {
		if (vorname != null && vorname.length() <= 16) {
			this.vorname = vorname;
		} else {
			throw new IllegalArgumentException("Der Vorname ist zu lang.");
		}

	}

	public boolean checkBusInfoExists() throws SQLException {
		String sql = "SELECT datum,tageszeit,RoutenID FROM BusInfo where datum = ? AND tageszeit = ? "
				+ "AND RoutenID=?";
		boolean gefunden = false;
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setString(1, this.datum);
		prep.setString(2, this.startUhrzeit);
		prep.setString(3, this.routenID);

		ResultSet dbRes = prep.executeQuery();
		if (dbRes.next()) {
			gefunden = true;
			this.plaetzeFrei = dbRes.getInt("PlaetzeFrei");
		}
		return gefunden;
	}

	public void insertIntoBusInfo() throws SQLException {
		boolean alreadyExists = checkBusInfoExists();
		if (plaetzeFrei != 0) {

			if (alreadyExists) {
				String sql = "update BusInfo set PlaetzeFrei='" + plaetzeFrei-- + "' where datum=? "
						+ "AND tageszeit=? AND RoutenID=?";
				System.out.println(sql);
				Connection dbConn = new PostgreSQLAccess().getConnection();
				PreparedStatement prep = dbConn.prepareStatement(sql);
				prep.executeUpdate();
			} else {
				// inserten alles
				String sql = "insert into BusInfo(datum, tageszeit, RoutenID, PlaetzeFrei) " + "values (?,?,?,?)";
				System.out.println(sql);
				Connection dbConn = new PostgreSQLAccess().getConnection();
				PreparedStatement prep = dbConn.prepareStatement(sql);
				prep.setString(1, this.datum);
				prep.setString(2, this.startUhrzeit);
				prep.setString(3, this.routenID);
				prep.setInt(4, 50);
				prep.executeUpdate();
			}
		}else {
			System.out.println("keine plaetze mehr frei! \n konnte nicht inserten");
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

	public String getStartStadt() {
		return startStadt;
	}

	public void setStartStadt(String startStadt) {
		this.startStadt = startStadt;
	}

	public String getZielStadt() {
		return zielStadt;
	}

	public void setZielStadt(String zielStadt) {
		this.zielStadt = zielStadt;
	}

	public String getStartUhrzeit() {
		return startUhrzeit;
	}

	public void setStartUhrzeit(String startUhrzeit) {
		this.startUhrzeit = startUhrzeit;
	}

	public String getZielUhrzeit() {
		return zielUhrzeit;
	}

	public void setZielUhrzeit(String zielUhrzeit) {
		this.zielUhrzeit = zielUhrzeit;
	}

	public int getDauerStd() {
		return dauerStd;
	}

	public void setDauerStd(int dauerStd) {
		this.dauerStd = dauerStd;
	}

	public int getDauerMin() {
		return dauerMin;
	}

	public void setDauerMin(int dauerMin) {
		this.dauerMin = dauerMin;
	}

	public String getPreis() {
		return preis;
	}

	public void setPreis(String preis) {
		this.preis = preis;
	}

	public String getRoutenID() {
		return routenID;
	}

	public void setRoutenID(String routenID) {
		this.routenID = routenID;
	}

}

