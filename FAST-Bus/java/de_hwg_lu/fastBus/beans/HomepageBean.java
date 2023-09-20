package de_hwg_lu.fastBus.beans;

import java.util.Date;

public class HomepageBean {
	String inputStart;
	String inputEnd;
	Date datum;
	boolean anmeldung;
	
//damit man pullen kann
public HomepageBean() {
}
	
	
	
	public String getNavbarWithLoginAsHtml() {
		String html= "";
		if(anmeldung == false) {
		 html =
			    "<nav id='navbar'>" +
			    "  <div class='logo'><h1>FASTBUS</h1></div>" +
			    "  <div class='divLink'>" +
			    "    <ul>" +
			    "      <!--<li><a href=''>Reise Planen</a></li>-->" +
			    "      <li><a href='url'>Städte</a></li>" +
			    "      <li><a href='url'>Meine Buchungen</a></li>" +
			    "      <li><a href='url'>Hilfe</a></li>" +
			    "    </ul>" +
			    "  </div>" +
			    "  <div class='divLogin'>" +
			    "    <label class='anmelden'>" +
			    "      <img" +
			    "        class=''" +
			    "        src='../img/clipart153139.png'" +
			    "        alt='anmelden'" +
			    "        width='15px'" +
			    "      />" 	 + 
			    "<a href='./LoginView.jsp' class=''>Anmelden</a>" +
			    			"    </label>" +
			    			"  </div>" +
			    			"</nav>";
			    }
			    else if(anmeldung == true) {
			    	html =   "<nav id='navbar'>" +
						    "  <div class='logo'><h1>FASTBUS</h1></div>" +
						    "  <div class='divLink'>" +
						    "    <ul>" +
						    "      <!--<li><a href=''>Reise Planenn</a></li>-->" +
						    "      <li><a href='url'>Städte</a></li>" +
						    "      <li><a href='url'>Meine Buchungen</a></li>" +
						    "      <li><a href='url'>Hilfe</a></li>" +
						    "    </ul>" +
						    "  </div>"													+
						    "  <div class='divLogout'>" 								+
						    "    <label class='abmelden'>" 								+
						    "      <img" 												+
						    "        class=''" 											+
						    "        src='../img/clipart153139.png'"					+
						    "        alt='abmelden'" 									+
						    "        width='15px'" 										+
						    "      />" 	;												
			    	
			    }
		return html;
	}
	public String getNavbarWithLogoutAsHtml() {
			String html =
				    "<nav id='navbar'>"											+
				    "  <div class='logo'><h1>FASTBUS</h1></div>" 				+
				    "  <div class='divLink'>" 									+
				    "    <ul>" 													+
				    "      <!--<li><a href=''>Reise Planen</a></li>-->" 		+
				    "      <li><a href='url'>Städte</a></li>" 					+
				    "      <li><a href='url'>Meine Buchungen</a></li>" 			+
				    "      <li><a href='url'>Hilfe</a></li>" 					+
				    "    </ul>" 												+
				    "  </div>"													+
				    "  <div class='divLogout'>" 								+
				    "    <label class='abmelden'>" 								+
				    "      <img" 												+
				    "        class=''" 											+
				    "        src='../img/clipart153139.png'"					+
				    "        alt='abmelden'" 									+
				    "        width='15px'" 										+
				    "      />" 													+
				    "<a href='./LoginAppl.jsp?btnLogout=true' class='abmelden'>Abmelden</a>"     +
				    "    </label>"												+
	    			"  </div>" 													+
	    			"</nav>";
	
	
	return html;
	}
	
	public String getFormularBoxAsHtml() {
		String html =
			    "<div class='hero-container'>" +
			    "    <div class='hero-image-container'></div>" +
			    "    <div class='hero-content'>" +
			    "        <div class='hero-search-box'>" +
			    "            <div class='search-box-all-items'>" +
			    "                <div class='search-box-header'>" +
			    "                    <h2>Jetzt Verbindung suchen</h2>" +
			    "                </div>" +
			    "                <div class='searchbar-box-main'>" +
			    "                    <div class='start-end'>" +
			    "                        <div class='start'>" +
			    "                            <input" +
			    "                                type='text'" +
			    "                                name='inputStart'" +
			    "                                class='input'" +
			    "                                placeholder='Von...'" +
			    "                            />" +
			    "                            <!-- inputStart Parameter erzeugen -->" +
			    "                            <div class='search'></div>" +
			    "                        </div>" +
			    "                        <div class='end'>" +
			    "                            <input" +
			    "                                name='inputEnd'" +
			    "                                class='inputEnd'" +
			    "                                placeholder='Nach...'" +
			    "                            />" +
			    "                            <!-- inputEnd Parameter erzeugen -->" +
			    "                        </div>" +
			    "                    </div>" +
			    "                    <div class='date'>" +
			    "                        <input type='date' name='date' class='date' id='dateInput'/>" +
			    "                    </div>" +
			    "                    <div class='submitContainer'>" +
			    "                        <button type='submit' name='btnVerbindung'  class='subbutton' value='Suchen' >Suchen</button>" +
			    "                        <!-- null check -->" +
			    "                        <!-- <img class='fastbusImg' src='img/Fast-Bus.png' />-->" +
			    "                    </div>" +
			    "                </div>" +
			    "            </div>" +
			    "        </div>" +
			    "    </div>" +
			    "</div>";
		return html;
	}

	public void selectBuchung() {
		
		String sql = "";
		System.out.println(sql);
	}
	
	
	
	
	public String getFooterAsHtml(){
		String html =
			    "<footer>" +
			    "    <footer class='footer-distributed'>" +
			    "        <div class='footer-left'>" +
			    "            <a href='#' class='link-1'>" +
			    "                <h3>FASt<span>BUS</span></h3>" +
			    "            </a>" +
			    "            <p class='footer-links'>" +
			    "                <a href='#' class='link-1'>Home</a>" +
			    "                <span class='nein'><a href='#'>Alle Städte</a></span>" +
			    "                <span class='nein'><a href='#'>Meine Buchungen</a></span>" +
			    "                <span class='nein'><a href='#'>Hilfe</a></span>" +
			    "            </p>" +
			    "            <p class='footer-company-name'>FAStBUS © 2023</p>" +
			    "        </div>" +
			    "        <div class='footer-center'>" +
			    "            <div>" +
			    "                <i class='fa fa-phone'" +
			    "                    ><img src='../img/phone-24.png' alt='' width='18px'" +
			    "                /></i>" +
			    "                <p>+49 176 32985346</p>" +
			    "            </div>" +
			    "            <div>" +
			    "                <i class='fa fa-envelope'" +
			    "                    ><img src='../img/email-3-24.png' alt='' width='18px'" +
			    "                /></i>" +
			    "                <p>" +
			    "                    <a href='mailto:support@company.com'>sema.saglam@live.de</a>" +
			    "                </p>" +
			    "            </div>" +
			    "        </div>" +
			    "        <div class='footer-right'>" +
			    "            <p class='footer-company-about'>" +
			    "                <span>Über das Unternehmen</span>" +
			    "                FAStBUS ist ein führendes Busreiseunternehmen, das sich auf" +
			    "                sichere und zuverlässige Fahrten zu jeder Tageszeit spezialisiert" +
			    "                hat. Unser Ziel ist es, unseren Kunden stressfreie und komfortable" +
			    "                Reisen zu bieten und dabei höchste Sicherheitsstandards zu" +
			    "                gewährleisten" +
			    "            </p>" +
			    "        </div>" +
			    "    </footer>" +
			    "</footer>";
		return html;
	
	}
	
	
	

public String getInputStart() {
	return inputStart;
}



public void setInputStart(String inputStart) {
	this.inputStart = inputStart;
}



public String getInputEnd() {
	return inputEnd;
}



public void setInputEnd(String inputEnd) {
	this.inputEnd = inputEnd;
}



public Date getDatum() {
	
	return datum;
}



public void setDatum(Date datum) {
	this.datum = datum;
}

public boolean isAnmeldung() {
	return anmeldung;
}



public void setAnmeldung(boolean anmeldung) {
	this.anmeldung = anmeldung;
}
}

