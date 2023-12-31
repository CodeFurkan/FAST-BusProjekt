package de_hwg_lu.fastBus.beans;

import java.util.Date;

public class HomepageBean {
	String inputStart;
	String inputEnd;
	Date datum;
	boolean anmeldung;
	String Vorname;

	public HomepageBean() {
	}

	public String getNavbarWithLoginAsHtml() {
		String html = "";
		if (anmeldung == false) {
			html = "<nav id='navbar'>"
					+ "  <div class='logo'><a class='logolink' href='../jsp/HomepageView.jsp'><img class='FastBus' src='../img/FastBus.png'/></a></div>"
					+ "  <div class='divLinkAnmelden'>" + "    <ul>"
					+ "      <!--<li><a href=''>Reise Planen</a></li>-->"
					+ "      <li><a href='../jsp/städteView.jsp'>Städte</a></li>"
					+ "      <li><a href='./HomepageAppl.jsp?meineBuchungen=meineBuchungen'>Meine Buchungen</a></li>"
					+ "      <li><a href='../jsp/AboutUs.jsp'>About Us</a></li>" + "    </ul>" + "  </div>" + "    " + "<label>"
					+ "  <div class='divLogin'>" + "    <a href='./LoginView.jsp' class='anmelden'>" + "      <img"
					+ "        class=''" + "        src='../img/clipart153139.png'" + "        alt='anmelden'"
					+ "        width='15px'" + "      />" + "   <p1> Anmelden </p1> </a>" + "  </div>" + "    </label>"
					+ "</nav>";
		} else if (anmeldung == true) {
			html = "<nav id='navbar'>"
					+ "  <div class='logo'><a class='logolink' href='../jsp/HomepageView.jsp'><img class='FastBus' src='../img/FastBus.png'/></a></div>"
					+ "  <div class='divLink'>" + "    <ul>" + "      <!--<li><a href=''>Reise Planenn</a></li>-->"
					+ "      <li><a href='../jsp/städteView.jsp'>Städte</a></li>"
					+ "      <li><a href='./HomepageAppl.jsp?meineBuchungen=meineBuchungen'>Meine Buchungen</a></li>"
					+ "      <li><a href='../jsp/AboutUs.jsp'>About Us</a></li>" + "    </ul>" + "  </div>" + "<div class='Profilname'>"
					+ "Hallo, " + getVorname() + "!" + "</div>" + "  <div class='divLogout'>"
					+ "    <a class='abmelden' href='./LoginAppl.jsp?btnLogout=true'>" + "      <img"
					+ "        class=''" + "        src='../img/clipart153139.png'" + "        alt='abmelden'"
					+ "        width='15px'" + "      /> " + " <p1> Ausloggen </p1> </a>" + "</div>";

		}
		return html;
	}

	public String getFormularBoxAsHtml() {
		String html = "<div class='hero-container'>" + "    <div class='hero-image-container'></div>"
				+ "    <div class='hero-content'>" + "        <div class='hero-search-box'>"
				+ "            <div class='search-box-all-items'>" + "                <div class='search-box-header'>"
				+ "                    <h2>Jetzt Verbindung suchen</h2>" + "                </div>"
				+ "                <div class='searchbar-box-main'>" + "                    <div class='start-end'>"
				+ "                        <div class='start'>" + "<div class=\"custom-select\" style=\"width:150px;\">"
				+

				"                            	<select name=\"inputStart\"Id='inputStart' placeholder='Von...' required>\n"
				+ "									<option value='' disabled selected>Von...</option>\n"
				+ "									<option value='Berlin'>Berlin</option>"
				+ "									<option value='Düsseldorf'>Düsseldorf</option>"
				+ "									<option value='Frankfurt'>Frankfurt</option>"
				+ "									<option value='Hamburg'>Hamburg</option>"
				+ "									<option value='Leipzig'>Leipzig</option>"
				+ "									<option value='Mannheim'>Mannheim</option>"
				+ "									<option value='München'>München</option>"
				+ "									<option value='Stuttgart'>Stuttgart</option>"
				+ "								</select>" + "</div>"
				+ "                            <!-- inputStart Parameter erzeugen -->"
				+ "                            <div class='search'></div>" + "                        </div>"
				+ " 							&nbsp;<label><img id=\"swap\" width='25px' src=\"../img/swap.png\" title=\"swap\" onclick=\"switchIt();\"/></label>	"
				+ "                        <div class='end'>" + "<div class=\"custom-select\" style=\"width:150px;\">" +

				"                            	<select name=\"inputEnd\"Id='inputEnd' placeholder='Nach...' required>\n"
				+ "									<option value='' disabled selected>Nach...</option>\n"
				+ "									 <option value='Berlin'>Berlin</option>"
				+ "									<option value='Düsseldorf'>Düsseldorf</option>"
				+ "									<option value='Frankfurt'>Frankfurt</option>"
				+ "									<option value='Hamburg'>Hamburg</option>"
				+ "									<option value='Leipzig'>Leipzig</option>"
				+ "									<option value='Mannheim'>Mannheim</option>"
				+ "									<option value='München'>München</option>"
				+ "									<option value='Stuttgart'>Stuttgart</option>"
				+ "								</select>" + "</div>"
				+ "                            <!-- inputEnd Parameter erzeugen -->" + "                        </div>"
				+ "                    </div>" + "                    <div class='date'>"
				+ "                        <input type='date' name='date' class='date' min='2023-09-15' id='dateInput' required onclick='datum();'/>"
				+ "                    </div>" + "              	<div class='quani'>"
				+ "<img class='benutzer' src='../img/benutzer.png'/>"
				+ "                		<input 'id=\"quantity\" max=\"50\" min=\"1\" value='1' name=\"quantity\" type=\"number\" />\n"
				+ "              	</div>" + "                    <div class='submitContainer'>"
				+ "                        <button type='submit' name='btnVerbindung'  class='subbutton' value='Suchen' onclick=\"setButtonClicked(this.name)\" >Suchen</button>"
				+ "                        <!-- null check -->"
				+ "                        <!-- <img class='fastbusImg' src='img/Fast-Bus.png' />-->"
				+ "                    </div>" + "                </div> <p id='selbeStadtMsg' class='fehlerfeld'></p>"
				+ "            </div>" + "        </div>" + "    </div>" + "</div>";
		return html;
	}

	public void selectBuchung() {
		String sql = "";
		System.out.println(sql);
	}

	public String getFooterAsHtml() {
		String html = "<footer>" + "    <footer class='footer-distributed noPrint'>"
				+ "        <div class='footer-left'>" + "            <a href='#' class='link-1'>"
				+ "                <h3>FAST-<span>BUS</span></h3>" + "            </a>"
				+ "            <p class='footer-links'>"
				+ "                <a href='../jsp/HomepageView.jsp' class='link-1'>Home</a>"
				+ "                <span class='nein'><a href='../jsp/städteView.jsp'>Alle Städte</a></span>"
				+ "                <span class='nein'><a href='../jsp/meineBuchungenView.jsp'>Meine Buchungen</a></span>"
				+ "                <span class='nein'><a href='../jsp/AboutUs.jsp'>About Us</a></span>"
				+ "                <span class='nein'><a href='../jsp/ImpressumView.jsp'>Impressum</a></span>"
				+ "            </p>" + "            <p class='footer-company-name'>FAStBUS © 2023</p>"
				+ "        </div>" + "        <div class='footer-center'>" + "            <div>"
				+ "                <i class='fa fa-phone'"
				+ "                    ><img src='../img/phone-24.png' alt='' width='18px'" + "                /></i>"
				+ "                <p>+49 123 123456789</p>" + "            </div>" + "            <div>"
				+ "                <i class='fa fa-envelope'"
				+ "                    ><img src='../img/email-3-24.png' alt='' width='18px'" + "                /></i>"
				+ "                <p>"
				+ "                    <a href='mailto:support@fastbus.de'> support@fastbus.de </a>"
				+ "                </p>" + "            </div>" + "        </div>"
				+ "        <div class='footer-right'>" + "            <p class='footer-company-about'>"
				+ "                <span>Über das Unternehmen</span>"
				+ "                FAStBUS ist ein führendes Busreiseunternehmen, das sich auf"
				+ "                sichere und zuverlässige Fahrten zu jeder Tageszeit spezialisiert"
				+ "                hat. Unser Ziel ist es, unseren Kunden stressfreie und komfortable"
				+ "                Reisen zu bieten und dabei höchste Sicherheitsstandards zu"
				+ "                gewährleisten" + "            </p>" + "        </div>" + "    </footer>"
				+ "</footer>";
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

	public String getVorname() {
		return Vorname;
	}

	public void setVorname(String vorname) {
		Vorname = vorname;
	}
}
