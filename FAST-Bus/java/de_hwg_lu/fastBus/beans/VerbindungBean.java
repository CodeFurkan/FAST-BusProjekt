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
	String startStadt="";
	String zielStadt="";
	String datum;
	String vorTag;
	String nachTag;
	String vorTagFuerLink;
	String datumUnformatiert;
	String nachTagFuerLink;
	String tageszeitString;
	int wunschplaetze;
	String proPerson;
	
	String routenID;
	int plaetzeFrei;

	double[] tageszeiten= {6,14,22};
	double dauer;
	double preis;
	int dauerStd, dauerMin;
	double jetztUhrzeit;

	public void uhrzeitSchonVorbei() {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		if(date.equals(getDatumUnformatiert())) {
		       LocalTime now = LocalTime.now(ZoneId.of("Europe/Berlin"));	//die jetztige Zeit
		       int hour = now.getHour();
		       int groeßer=3;
		       if(hour>=tageszeiten[0]) {
		    	   groeßer=2;	//alle 3 anzeigen
		    	   if(hour>=tageszeiten[1]) {
		    		   groeßer=1; //2 verbindungsboxen anzeigen
		    		   if(hour>=tageszeiten[2]) {
		    			   groeßer=0;	//nur eine anzeigen
		    		   }
		    	   }
		       }
		       double[] merker = new double[groeßer];
		       for (int i = 0; i < merker.length; i++) {
				merker[merker.length-1-i]=tageszeiten[tageszeiten.length-1-i];	//speichere die tageszeiten die noch übrig sind in den merker
			}
		       tageszeiten=merker;
		} 
	}
	public String getVerbindungsBox() throws SQLException {
		dauerPreisRoutenID();
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
					+ "          <div class=\"vPlaetzeFrei\" id='vPlaetzeFrei'>"
					+ "            <div id='freiePlaetze"+tageszeiten[i]+"'>"+getPlaetzeFrei(dauerInString(dauerSplit(tageszeiten[i])))+"</div> von 50 Plätzen frei"
					+ "          </div>\r\n"
					+ "          <div class=\"vPreisButton\">"
					+"			 <div class=proPerson>"+getProPerson()+"</div>"
					+ "            <div class=\"vPreis\">"
					+ "              "+getPreisString()+"&euro;"
					+ "            </div>"
					+ "            <div class=\"vButton\">"
					+ "              <button type='submit' name='btnZumAngebot' class='subbutton' onclick=\"setButtonClicked(this.name);clicked='"+tageszeiten[i]+"'\"  value='Zum Angebot"+tageszeiten[i]+"' >Zum Angebot</button>"
					+ "            </div>"
					+ "          </div>"
					+ "        </div>"
					+ "      <div id=invisibleWunschPlaetze>"+getWunschplaetze()+"</div>"
					+ "		 <div id=invisiblePlaetze>"+getPlaetzeFrei(dauerInString(dauerSplit(tageszeiten[i])))+"</div>"
					+ "		</div>"
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
		}
		
		int[] dauersplit = dauerSplit(dauer);		
		setDauerStd(dauersplit[0]);
		
		if(dauersplit[1]/10==0)dauersplit[1]*=10;	//Wenn die minutenanzahl einstellig ist 
		setDauerMin(dauersplit[1]);
		
	}
	
	public String tagesZeitPlusDauer(double tageszeit) {
		double ins= tageszeit+this.dauer; 	//tageszeit+dauer um ankunftzeit zu bestimmen
		int[] dauersplit=dauerSplit(ins); 	//die ankunftzeit wird gesplitted
		
		int speicher = dauersplit[1]/60;	//die minuten werden durch 60 geteilt um die stunden zu bekommen 
		dauersplit[0] += speicher;			

		dauersplit[1]%=60;					//die restlichen minuten 
		
		dauersplit[0] %= 24;				// falls die stunden über die 24h marke ereichen
		return dauerInString(dauersplit);	//das double wird zu einer uhrzeit formatiert
	}
	
	public int[] dauerSplit(double dauerzumsplit) {				//teilt die dauer an der komma stelle um stunden und minuten und gibt einen array mit den inhalt der beiden zurück
		String dauerString = Double.toString(dauerzumsplit);	//macht einen String um es teilen zu können
		String[] convert = dauerString.split("\\.");	
		
		int[] dauersplit= {Integer.parseInt(convert[0]),Integer.parseInt(convert[1])};	//die daten werden als integer gecasted und in einem int array gespeichert

		return dauersplit;
	     
	}
	public String dauerInString(int[]dauersplit) {
		
		tageszeitString = ""+dauersplit[0]+":"+dauersplit[1];
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
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);	//die Euro Währung
		String s = numberFormat.format(this.preis);
		String res;
		res= s.substring(0, s.length() - 1);									//der letzte char wird -1 genommen wegen des Euro Zeichens

		return res;
	}
	public void setPreis(double preis) {
		this.preis = preis;
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
	String sql = "SELECT plaetzeFrei FROM BusInfo where StartDatum = ? AND StartZeit = ? "
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
	public String getTageszeitString() {
		return tageszeitString;
	}
	public void setTageszeitString(String tageszeitString) {
		this.tageszeitString = tageszeitString;
	}
	public int getWunschplaetze() {
		return wunschplaetze;
	}
	public void setWunschplaetze(int wunschplaetze) {
		this.wunschplaetze = wunschplaetze;
	}
	public String getProPerson() {
		if(getWunschplaetze()>1) {
			proPerson="pro Person";
		}else {
			proPerson="";
		}
	return proPerson;
	}
	public void setProPerson(String proPerson) {
		this.proPerson = proPerson;
	}
	public double getPreis() {
		return preis;
	}


}