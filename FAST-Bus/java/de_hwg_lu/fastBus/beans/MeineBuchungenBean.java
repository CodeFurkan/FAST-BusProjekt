package de_hwg_lu.fastBus.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;

import de_hwg_lu.fastBus.jdbc.PostgreSQLAccess;

public class MeineBuchungenBean {
	
	String email;
	int kundenid;
	String routenid;
	int businfoid;
	
	String startStadt;
	String zielStadt;
	
	String startDatum;
	String zielDatum;
	
	String startZeit;
	String zielZeit;
	
	double preisdouble;
	String preis;

	public void selectAccount() throws SQLException {
		String sql = "SELECT kundenid FROM Account where email = ?";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setString(1, this.email);
		ResultSet dbRes = prep.executeQuery();
		if (dbRes.next()) {
			this.kundenid=dbRes.getInt("kundenid");
			System.out.println(kundenid);
		}
	}
	public String getMeineBuchungAsHtml() throws SQLException {
		selectAccount();
		String html="";
		String sql = "SELECT * FROM Buchung where kundenid=?";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setInt(1, this.kundenid);
		ResultSet dbRes = prep.executeQuery();
		while(dbRes.next()) {
			this.routenid=dbRes.getString("routenid");
			this.businfoid=dbRes.getInt("businfoid");
			this.preis=dbRes.getString("preisgesamt");
			selectRoute();
			selectBusinfo();
			html+="            <tbody>\r\n"
					+ "                <tr>\r\n"
					+ "                    <td>"+getStartStadt()+"</td>\r\n"
					+ "                    <td>"+getStartDatum()+"</td>\r\n"
					+ "                    <td>"+getStartZeit()+"</td>\r\n"
					+ "                    <td rowspan=\"2\">"+getPreis()+"&euro;</td>\r\n"
					+ "                </tr>\r\n"
					+ "                <tr>\r\n"
					+ "                    <td>"+getZielStadt()+"</td>\r\n"
					+ "                     <td>"+getZielDatum()+"</td>\r\n"
					+ "                    <td>"+getZielZeit()+"</td>\r\n"
					+ "                      \r\n"
					+ "                        \r\n"
					+ "                </tr>\r\n"
					+ "            </tbody>";
		}
		return html;
	}
	public void selectRoute() throws SQLException {
		String sql = "SELECT startstadt,zielstadt FROM Routen where routenid = ?";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setString(1, this.routenid);
		ResultSet dbRes = prep.executeQuery();
		if (dbRes.next()) {
			this.startStadt=dbRes.getString("startstadt");
			this.zielStadt=dbRes.getString("zielstadt");
		}
	}
	public void selectBusinfo() throws SQLException {
		String sql = "SELECT startdatum,zieldatum,startZeit,zielZeit FROM businfo where businfoid = ?";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setInt(1, this.businfoid);
		ResultSet dbRes = prep.executeQuery();
		if (dbRes.next()) {
			this.startDatum=dbRes.getString("startdatum");
			this.zielDatum=dbRes.getString("zieldatum");
			this.startZeit=dbRes.getString("startzeit");
			this.zielZeit=dbRes.getString("zielzeit");
		}
	}

	public String getPreisString() {
		Locale locale = Locale.GERMANY;
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
		String s = numberFormat.format(this.preisdouble);
		String res;
		res= s.substring(0, s.length() - 1);

		return res;
	}
	public String getPreis() {
		return preis;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getKundenid() {
		return kundenid;
	}
	public String getRoutenid() {
		return routenid;
	}
	public int getBusinfoid() {
		return businfoid;
	}
	public String getStartStadt() {
		return startStadt;
	}
	public String getZielStadt() {
		return zielStadt;
	}
	public String getStartDatum() {
		return startDatum;
	}
	public String getZielDatum() {
		return zielDatum;
	}
	public String getStartZeit() {
		return startZeit;
	}
	public String getZielZeit() {
		return zielZeit;
	}

}
