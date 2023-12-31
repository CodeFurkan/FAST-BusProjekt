package de_hwg_lu.fastBus.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import de_hwg_lu.fastBus.jdbc.NoConnectionException;
import de_hwg_lu.fastBus.jdbc.PostgreSQLAccess;

public class RechnungBean {

	int kundenid;
	int businfoID;
	int buchungid;
	
	String rechnungVorname;
	String rechnungNachname;
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
	String zielDatum;
	String startUhrzeit;
	String zielUhrzeit;
	int dauerStd;
	int dauerMin;
	String preis;

	String routenID;
	
	int plaetzeFrei;
	
	String nextDay;
	int wunschplaetze;

	public RechnungBean() {
		this.rechnungVorname = "";
		this.rechnungNachname = "";
		this.email = "";
		this.adresse = "";
		this.stadt = "";
		this.plz = "";
		this.iban = "";
		this.bic = "";
		this.nameKonto = "";
		this.startUhrzeit= "";
		this.zielUhrzeit= "";
	}
	public void getKundenIDvonAccount() throws SQLException {
		String sql = "SELECT kundenid FROM Account where email = ?";	//email ist unique
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setString(1, this.email);
		ResultSet dbRes = prep.executeQuery();
		if (dbRes.next()) {
			this.kundenid=dbRes.getInt("kundenid");
		}
	}
	public void getBusinfoIDvonBusinfo() throws SQLException {
		String sql = "SELECT businfoid FROM businfo where StartDatum = ? AND StartZeit=? AND routenid=?";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setString(1, this.datum);
		prep.setString(2, this.startUhrzeit);
		prep.setString(3, this.routenID);
		ResultSet dbRes = prep.executeQuery();
		if (dbRes.next()) {
			this.businfoID=dbRes.getInt("businfoid");
		}
	
	}
	public void insertIntoBuchung() throws SQLException {
		getKundenIDvonAccount();
		getBusinfoIDvonBusinfo();
		if(checkBuchungExisitertBereits()) {	//Wenn die Buchung bereits genau unter all den selben Daten existiert wird returned
			return;
		}
		String sql = "insert into Buchung (kundenid,businfoid,routenid,adresse, stadt, plz, iban, bic,vorname,nachname, nameKonto,preisgesamt)"
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?)";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setInt(1, this.kundenid);
		prep.setInt(2, this.businfoID);
		prep.setString(3, this.routenID);
		prep.setString(4, this.adresse);
		prep.setString(5, this.stadt);
		prep.setString(6, this.plz);
		prep.setString(7, this.iban);
		prep.setString(8, this.bic);
		prep.setString(9, this.rechnungVorname);
		prep.setString(10, this.rechnungNachname);
		prep.setString(11, this.nameKonto);
		prep.setString(12, this.getPreis());
		prep.executeUpdate();
		
		System.out.println("Buchung erfolgreich abgeschlossen");
	}
	public boolean checkBuchungExisitertBereits() throws SQLException {
		String sql = "SELECT buchungid FROM Buchung where kundenid = ? AND businfoid = ? AND routenid = ? AND "
				+ "adresse = ? AND stadt = ? AND plz = ? AND iban = ? AND bic = ? AND "
				+ "vorname = ? AND nachname = ? AND nameKonto = ? AND preisgesamt=? ";
		System.out.println(sql);
		boolean gefunden = false;
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setInt(1, this.kundenid);
		prep.setInt(2, this.businfoID);
		prep.setString(3, this.routenID);
		prep.setString(4, this.adresse);
		prep.setString(5, this.stadt);
		prep.setString(6, this.plz);
		prep.setString(7, this.iban);
		prep.setString(8, this.bic);
		prep.setString(9, this.rechnungVorname);
		prep.setString(10, this.rechnungNachname);
		prep.setString(11, this.nameKonto);
		prep.setString(12, this.getPreis());
		ResultSet dbRes = prep.executeQuery();
		if (dbRes.next()) {
			gefunden = true;
			this.buchungid=dbRes.getInt("buchungid");
		}
		return gefunden;
	}
	//checkt ob der Bus bereits in der Vergangenheit gebucht wurde 
	public boolean checkBusInfoExists() throws SQLException {
		String sql = "SELECT StartDatum,StartZeit,RoutenID,plaetzeFrei FROM BusInfo where StartDatum = ? AND StartZeit = ? "
				+ "AND RoutenID=?";
		System.out.println(sql);
		boolean gefunden = false;
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
			if (alreadyExists) { //Wenn der bus bereits belegt ist, nimm die noch freien plätze aus der datenbank und subtrahier die gewünschten plätze vom kunden 
				if(plaetzeFrei==0 || plaetzeFrei-wunschplaetze<0) {
					System.out.println("Insert nicht möglich \n plaetze 0 oder darunter");
					return;
				}
				plaetzeFrei-=getWunschplaetze();
				String sql = "update BusInfo set plaetzeFrei='" + plaetzeFrei + "' where StartDatum=? "
						+ "AND StartZeit=? AND RoutenID=?";
				System.out.println(sql);
				Connection dbConn = new PostgreSQLAccess().getConnection();
				PreparedStatement prep = dbConn.prepareStatement(sql);
				prep.setString(1, this.datum);
				prep.setString(2, this.startUhrzeit);	//Diese 3 daten reichen aus um zusammen einzigartig zu sein
				prep.setString(3, this.routenID);
				prep.executeUpdate();
			} else {		//Wenn der Bus nicht belegt ist trage eine neue zeile an und subtrahier die gewünschten sitze vom kunden von 50
				// inserten alles
				String sql = "insert into BusInfo(StartDatum, ZielDatum, StartZeit,Zielzeit, RoutenID, plaetzeFrei) " + "values (?,?,?,?,?,?)";
				System.out.println(sql);
				Connection dbConn = new PostgreSQLAccess().getConnection();
				PreparedStatement prep = dbConn.prepareStatement(sql);
				prep.setString(1, this.datum);
				prep.setString(2, this.getZielDatum());
				prep.setString(3, this.startUhrzeit);
				prep.setString(4, this.zielUhrzeit);
				prep.setString(5, this.routenID);
				prep.setInt(6, 50-getWunschplaetze());
				prep.executeUpdate();
			}
	}



	public String getRechnungVorname() {
		return rechnungVorname;
	}
	public void setRechnungVorname(String rechnungVorname) {
		this.rechnungVorname = rechnungVorname;
	}
	public String getRechnungNachname() {
		return rechnungNachname;
	}
	public void setRechnungNachname(String rechnungNachname) {
		this.rechnungNachname = rechnungNachname;
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

	public String getZielDatum() {
		String zweiZeichenZielUhrzeit="";
		String zweiZeichenStartUhrzeit="";
		int merkerZiel=0;
		int merkerStart=0;
		try {
			zweiZeichenZielUhrzeit = this.zielUhrzeit;
			zweiZeichenStartUhrzeit=this.startUhrzeit;
			
			zweiZeichenZielUhrzeit=zweiZeichenZielUhrzeit.substring(0, 2);
			zweiZeichenStartUhrzeit=zweiZeichenStartUhrzeit.substring(0, 2);
			
			merkerZiel=Integer.parseInt(zweiZeichenZielUhrzeit);
			merkerStart=Integer.parseInt(zweiZeichenStartUhrzeit);
			
		}catch (Exception e) {
			return getDatum();
		}
		
		if(merkerStart==22 && merkerZiel <=22 ) {

			return getNextDay();
		}
		return getDatum();
	}

	public void setZielDatum(String zielDatum) {
		this.zielDatum = zielDatum;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getNextDay() {
		return nextDay;
	}

	public void setNextDay(String nextDay) {
		this.nextDay = nextDay;
	}
	public int getKundenid() {
		return kundenid;
	}
	public void setKundenid(int kundenid) {
		this.kundenid = kundenid;
	}
	public int getBuchungid() {
		return buchungid;
	}
	public void setBuchungid(int buchungid) {
		this.buchungid = buchungid;
	}
	public String getHeutigeDatumFuerQuittung() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		LocalDate localDate = LocalDate.now();
		System.out.println(dtf.format(localDate));
		return dtf.format(localDate);
	}
	public int getWunschplaetze() {
		return wunschplaetze;
	}
	public void setWunschplaetze(int wunschplaetze) {
		this.wunschplaetze = wunschplaetze;
	}
	
}

