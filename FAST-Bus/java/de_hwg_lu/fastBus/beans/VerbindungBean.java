package de_hwg_lu.fastBus.beans;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import de_hwg_lu.fastBus.jdbc.PostgreSQLAccess;

public class VerbindungBean {

	
	String startStadt;
	String zielStadt;
	String datum;
	String vorTag;
	String nachTag;
	double[] tageszeiten= {8,16,24};
	double dauer;
	double preis;
	int dauerStd, dauerMin;

	
	public String getVerbindungsBox() throws SQLException {
		dauerUndPreis();
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
					+ "              "+getPreisString()+"&euro;"
					+ "            </div>"
					+ "            <div class=\"vButton\">"
					+ "              <!-- <input type=\"submit\" name=\"btnZumAngebot\" value=\"Zum Angebot1\" /> -->"
					+ "              <button type=\"submit\" class=\"subbutton\" name='btnZumAngebot' value='Zum Angebot"+i+"' >Zum Angebot</button>"
					+ "            </div>"
					+ "          </div>"
					+ "        </div>"
					+ "      </div>"
					+ "  </div>";
		}
		
		
		return html;
	}


	public void dauerUndPreis() throws SQLException {
		
		String sql="SELECT Dauer,Preis FROM Routen where Startstadt = ? AND ZielStadt = ?";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setString(1, this.startStadt);
		prep.setString(2, this.zielStadt);
		ResultSet dbRes = prep.executeQuery();
		if(dbRes.next()){
			this.dauer= dbRes.getDouble("Dauer");
			this.preis=dbRes.getDouble("Preis");
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

	public String getPreisString() {
		Locale locale = Locale.GERMANY;
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
		String s = numberFormat.format(this.preis);
		String res;
		res= s.substring(0, s.length() - 1);

		return res;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}
	

	public static void main(String[] args) {
//		double d = 30.5;
//		System.out.println(d);
//		
//		Locale locale = Locale.GERMANY;
//		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
//		String s = numberFormat.format(d);
//		String res;
//		res= s.substring(0, s.length() - 2);
//		System.out.println(res);
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
	setVorTag(datum);
	setNachTag(datum);
	this.datum = datum;
}

public double[] getTageszeiten() {
	return tageszeiten;
}

public void setTageszeiten(double[] tageszeiten) {
	this.tageszeiten = tageszeiten;
}


public String getVorTag() {
	return vorTag;
}


public void setVorTag(String vorTag) {
	this.vorTag = vorTag;
}


public String getNachTag() {
	return nachTag;
}


public void setNachTag(String nachTag) {
	this.nachTag = nachTag;
}

}