package de_hwg_lu.fastBus.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import de_hwg_lu.fastBus.jdbc.PostgreSQLAccess;

public class VerbindungBean {

	
	String startStadt;
	String zielStadt;
	String datum;
	double[] tageszeiten= {8.00,16,24};
	double dauer;
	int dauerStd, dauerMin;

	
	public String getVerbindungsBox() throws SQLException {
		dauer();
		String html="";
		for (int i = 0; i < tageszeiten.length; i++) {
			html += " <div class=\"verbindungsbox\">"
					+ "      <div class=\"vObenUnten\">"
					+ "        <div class=\"vBoxOben\">"
					+ "          <div class=\"vUhrzeitStadt\">"
					+ "            <div class=\"vUhrzeitStadtO\">"
					+ "              <div class=\"vUhrzeit\">"
					+ "                "+dauerInString(dauerSplit(tageszeiten[i]))+""
					+ "              </div>"
					+ "              <div class=\"vStadt\">"
					+ "                "+getStartStadt() +" Hbf"
					+ "              </div>"
					+ "            </div>"
					+ "            <div class=\"vUhrzeitStadtO\">"
					+ "              <div class=\"vUhrzeit\">"
					+ "                "+tagesZeitPlusDauer(tageszeiten[i]) +""
					+ "              </div>\r\n"
					+ "              <div class=\"vStadt\">"
					+ "                "+getZielStadt()+" Hbf"
					+ "              </div>"
					+ "            </div>"
					+ "          </div>"
					+ "          <div class=\"vDauer\">"
					+ "            <img class=\"\" src=\"../img/timer.png\" alt=\"anmelden\" width=\"35px\" /> &nbsp;"
					+ "            "+getDauerStd() +" Std "+getDauerMin()+" Min"
					+ "          </div>"
					+ "        </div>"
					+ "        <div class=\"vBoxUnten\">"
					+ "          <div class=\"vPlaetzeFrei\">"
					+ "            30 von 30 Plätzen frei"
					+ "          </div>\r\n"
					+ "          <div class=\"vPreisButton\">"
					+ "            <div class=\"vPreis\">"
					+ "              33,00&euro;"
					+ "            </div>"
					+ "            <div class=\"vButton\">"
					+ "              <!-- <input type=\"submit\" name=\"btnZumAngebot\" value=\"Zum Angebot\" /> -->"
					+ "              <button type=\"submit\" class=\"subbutton\">Zum Angebot</button>"
					+ "            </div>"
					+ "          </div>"
					+ "        </div>"
					+ "      </div>"
					+ "  </div>";
		}
		
		
		return html;
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

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public double[] getTageszeiten() {
		return tageszeiten;
	}

	public void setTageszeiten(double[] tageszeiten) {
		this.tageszeiten = tageszeiten;
	}

	public void dauer() throws SQLException {
		
		String sql="SELECT Dauer FROM Routen where Startstadt = ? AND ZielStadt = ?";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setString(1, this.startStadt);
		prep.setString(2, this.zielStadt);
		ResultSet dbRes = prep.executeQuery();
		if(dbRes.next()){
			this.dauer= dbRes.getDouble("Dauer");
//			String result = String.format("%.2f", dauer);
//			System.out.println(result);
		}
		
		int[] dauersplit = dauerSplit(dauer);
		setDauerStd(dauersplit[0]);
		
		if(dauersplit[1]/10==0)dauersplit[1]*=10;
		setDauerMin(dauersplit[1]);
		
	}
	
	public String tagesZeitPlusDauer(double tageszeit) {
		double ins= tageszeit+this.dauer;
		int[] dauersplit=dauerSplit(ins);
		
		int speicher = dauersplit[1]/60;
		dauersplit[0] += speicher;

		dauersplit[1]%=60;
		
		
		dauersplit[0] %= 24;
//		
//		int stunden = dauersplit[0]%24;
//		dauersplit[0] = stunden;
//		
//		int minuten= dauersplit[1]/60;
//		dauersplit[0]+=minuten;
//		
		
		

		return dauerInString(dauersplit);
	}
	
	public int[] dauerSplit(double dauerzumsplit) {
		
//		DecimalFormat df = new DecimalFormat("#.##");
//		dauerzumsplit = Double.parseDouble(df.format(dauerzumsplit));
		
		String dauerString = Double.toString(dauerzumsplit);
		String[] convert = dauerString.split("\\.");
		
		int[] dauersplit= {Integer.parseInt(convert[0]),Integer.parseInt(convert[1])};

		return dauersplit;
	     
	}
	public String dauerInString(int[]dauersplit) {
		
		String tageszeitString = ""+dauersplit[0]+":"+dauersplit[1];
		if(tageszeitString.split( "\\:" )[ 1 ].length() == 1 ) tageszeitString+="0";
		if(tageszeitString.split( "\\:" )[ 0 ].length() == 1 ) tageszeitString="0"+tageszeitString;
		return tageszeitString;
		
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
	


}
