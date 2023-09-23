package de_hwg_lu.fastBus.beans;

import java.sql.Connection;
import java.util.Date;
import java.util.Iterator;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import de_hwg_lu.fastBus.jdbc.PostgreSQLAccess;

public class VerbindungBean {

	
	String startStadt;
	String zielStadt;
	String datum;
	String vorTag;
	String nachTag;
	String vorTagFuerLink;
	String datumUnformatiert;
	String nachTagFuerLink;
	
	String routenID;
	int plaetzeFrei;

	double[] tageszeiten= {6,14,22};
	double dauer;
	double preis;
	int dauerStd, dauerMin;
	double jetztUhrzeit;
	public VerbindungBean(){
//		tageszeiten= {6,14,22}
	}
	public void uhrzeitSchonVorbei() {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		if(date.equals(getDatumUnformatiert())) {
			System.out.println("datum unformatiert");
		       LocalTime now = LocalTime.now(ZoneId.of("Europe/Berlin"));
		       int hour = now.getHour();
		       int groeßer=3;
		       if(hour>=tageszeiten[0]) {
		    	   groeßer=2;	//alle 3 anzeigen
		    	   if(hour>=tageszeiten[1]) {
		    		   groeßer=1;
		    		   if(hour>=tageszeiten[2]) {
		    			   groeßer=0;
		    		   }
		    	   }
		       }
		       double[] merker = new double[groeßer];
		       for (int i = 0; i < merker.length; i++) {

				merker[merker.length-1-i]=tageszeiten[tageszeiten.length-1-i];
			}
		       tageszeiten=merker;
		}else {
//			double[] merker= {6,14,22};
//			this.tageszeiten=merker;
		}  
	}
	public String getVerbindungsBox() throws SQLException {
		dauerPreisRoutenID();
//		System.out.println("fürtest "+getDatumUnformatiert());
		
		uhrzeitSchonVorbei();
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
					+ "            "+getPlaetzeFrei(dauerInString(dauerSplit(tageszeiten[i])))+" von 50 Plätzen frei"
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
		
		double[] merker= {6,14,22};
		this.tageszeiten=merker;
		return html;
	}





	public void dauerPreisRoutenID() throws SQLException {
		
		String sql="SELECT Dauer,Preis,RoutenID FROM Routen where Startstadt = ? AND ZielStadt = ?";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setString(1, this.startStadt);
		prep.setString(2, this.zielStadt);
		ResultSet dbRes = prep.executeQuery();
		if(dbRes.next()){
			this.dauer= dbRes.getDouble("Dauer");
			this.preis=dbRes.getDouble("Preis");
			this.routenID=dbRes.getString("RoutenID");
//			String result = String.format("%.2f", dauer);
//			System.out.println(result)
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
	System.out.println(startStadt);
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

public String getVorTagFuerLink() {
	return vorTagFuerLink;
}

public void setVorTagFuerLink(String vorTagFuerLink) {
	this.vorTagFuerLink = vorTagFuerLink;
}

public String getNachTagFuerLink() {
	return nachTagFuerLink;
}

public void setNachTagFuerLink(String nachTagFuerLink) {
	this.nachTagFuerLink = nachTagFuerLink;
}

public String getRoutenID() {
	return routenID;
}

public void setRoutenID(String routenID) {
	this.routenID = routenID;
}


public int getPlaetzeFrei(String tageszeit) throws SQLException {
	String sql = "SELECT plaetzeFrei FROM BusInfo where datum = ? AND tageszeit = ? "
			+ "AND RoutenID=?";
	System.out.println(sql);
	Connection dbConn = new PostgreSQLAccess().getConnection();
	PreparedStatement prep = dbConn.prepareStatement(sql);
	
	plaetzeFrei=50;
	
	prep.setString(1, this.datum);
	prep.setString(2, tageszeit);
	prep.setString(3, this.routenID);
	ResultSet dbRes = prep.executeQuery();
	
	if (dbRes.next()) {
		System.out.println(tageszeit);
		this.plaetzeFrei = dbRes.getInt("PlaetzeFrei");
	}
	return plaetzeFrei;
}


public void setPlaetzeFrei(int plaetzeFrei) {
	this.plaetzeFrei = plaetzeFrei;
}
public String getDatumUnformatiert() {
	return datumUnformatiert;
}
public void setDatumUnformatiert(String datumUnformatiert) {
	this.datumUnformatiert = datumUnformatiert;
}


}