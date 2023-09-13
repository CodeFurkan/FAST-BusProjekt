package de_hwg_lu.fastBus.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de_hwg_lu.fastBus.jdbc.PostgreSQLAccess;

public class VerbindungBean {
	
	String startStadt;
	String zielStadt;
	String datum;
	int[] tageszeiten= {8,16,24};
	double dauer;
	int dauerStd, dauerMin;

	
	public String getVerbindungsBox() {
		String html="";
		for (int i = 0; i < tageszeiten.length; i++) {
			html += " <div class=\"verbindungsbox\">"
					+ "      <div class=\"vObenUnten\">"
					+ "        <div class=\"vBoxOben\">"
					+ "          <div class=\"vUhrzeitStadt\">"
					+ "            <div class=\"vUhrzeitStadtO\">"
					+ "              <div class=\"vUhrzeit\">"
					+ "                "+tageszeiten[i]+""
					+ "              </div>"
					+ "              <div class=\"vStadt\">"
					+ "                München Hbf"
					+ "              </div>"
					+ "            </div>"
					+ "            <div class=\"vUhrzeitStadtO\">"
					+ "              <div class=\"vUhrzeit\">"
					+ "                "+tageszeiten[i]+dauer +""
					+ "              </div>\r\n"
					+ "              <div class=\"vStadt\">"
					+ "                Berlin Hbf"
					+ "              </div>"
					+ "            </div>"
					+ "          </div>"
					+ "          <div class=\"vDauer\">"
					+ "            <img class=\"\" src=\"../img/timer.png\" alt=\"anmelden\" width=\"35px\" /> &nbsp;"
					+ "            6 Std 20 Min"
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

	public int[] getTageszeiten() {
		return tageszeiten;
	}

	public void setTageszeiten(int[] tageszeiten) {
		this.tageszeiten = tageszeiten;
	}

	public Double getDauer() throws SQLException {
		String sql="SELECT Dauer FROM Routen where Startstadt = ? AND ZielStadt = ?";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setString(1, this.startStadt);
		prep.setString(2, this.zielStadt);
		ResultSet dbRes = prep.executeQuery();
		dauer= dbRes.getDouble("Dauer");
		return dauer;
	}
	public void splitDauer() {
		String dauerString = Double.toString(dauer);
		String[] convert = dauerString.split("\\.");
		
	     int std = Integer.parseInt(convert[0]);
	     int min = Integer.parseInt(convert[1]);
	     
	     setDauerStd(std);
	     setDauerMin(min);
	     
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
