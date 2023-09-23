<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Impressum</title>
<link type="text/css" rel="stylesheet" href="../css/impressum.css" />
<link rel="stylesheet" type="text/css" href="../css/footer.css">
<link type="text/css" rel="stylesheet" href="../css/headerAndNavbar.css" />
<jsp:useBean id="hb" class="de_hwg_lu.fastBus.beans.HomepageBean" scope="session" />

</head>
<body>
      <header>
           <jsp:getProperty name="hb" property="navbarWithLoginAsHtml" />
      </header>
      
	<div class="headline">
		<h1>Impressum</h1>
	</div>
	<div class="container">
		<div class="containerInhalt">
			<div class="anschriftukontakt">
				<div class="anschrift">
					<div class="strasse">Musterstrasse 1</div>
					<div class="plzStadt">12345 Musterstadt</div>
					<div class="land">Deutschland</div>
					<div class="kontaktheader">
						<h3>Kontakt</h3>
					</div>
					<div class="telefonnmr">+49 123 123456789</div>
					<div class="email">
						<a href='mailto:support@fastbus.de'> support@fastbus.de </a>
					</div>
				</div>
			</div>
			<div class="rechte">
				<div class="haftung">
					<div class="haftungheader">
						<h3>Haftung für Inhalte</h3>
					</div>
					<div class="text">Die Inhalte unserer Seiten wurden mit
						größter Sorgfalt erstellt. Für die Richtigkeit, Vollständigkeit
						und Aktualität der Inhalte können wir jedoch keine Gewähr
						übernehmen. Als Diensteanbieter sind wir gemäß § 7 Abs.1 TMG für
						eigene Inhalte auf diesen Seiten nach den allgemeinen Gesetzen
						verantwortlich. Nach §§ 8 bis 10 TMG sind wir als Diensteanbieter
						jedoch nicht verpflichtet, übermittelte oder gespeicherte fremde
						Informationen zu überwachen oder nach Umständen zu forschen, die
						auf eine rechtswidrige Tätigkeit hinweisen. Verpflichtungen zur
						Entfernung oder Sperrung der Nutzung von Informationen nach den
						allgemeinen Gesetzen bleiben hiervon unberührt. Eine
						diesbezügliche Haftung ist jedoch erst ab dem Zeitpunkt der
						Kenntnis einer konkreten Rechtsverletzung möglich. Bei
						Bekanntwerden von entsprechenden Rechtsverletzungen werden wir
						diese Inhalte umgehend entfernen.</div>
				</div>
				<div class="urheber">
					<div class="urheberheader">
						<h3>Urheberrecht</h3>
					</div>
					<div class="text">Die durch die Seitenbetreiber erstellten
						Inhalte und Werke auf diesen Seiten unterliegen dem deutschen
						Urheberrecht. Die Vervielfältigung, Bearbeitung, Verbreitung und
						jede Art der Verwertung außerhalb der Grenzen des Urheberrechtes
						bedürfen der schriftlichen Zustimmung des jeweiligen Autors bzw.
						Erstellers. Downloads und Kopien dieser Seite sind nur für den
						privaten, nicht kommerziellen Gebrauch gestattet. Soweit die
						Inhalte auf dieser Seite nicht vom Betreiber erstellt wurden,
						werden die Urheberrechte Dritter beachtet. Insbesondere werden
						Inhalte Dritter als solche gekennzeichnet. Sollten Sie trotzdem
						auf eine Urheberrechtsverletzung aufmerksam werden, bitten wir um
						einen entsprechenden Hinweis. Bei Bekanntwerden von
						Rechtsverletzungen werden wir derartige Inhalte umgehend
						entfernen.</div>
				</div>
				<div class="datenschutz">
					<div class="datenschutzheader">
						<h3>Datenschutz</h3>
					</div>
					<div class="text">
						Die Nutzung unserer Webseite ist in der Regel ohne Angabe
						personenbezogener Daten möglich. Soweit auf unseren Seiten
						personenbezogene Daten (beispielsweise Name, Anschrift oder
						eMail-Adressen) erhoben werden, erfolgt dies, soweit möglich,
						stets auf freiwilliger Basis. Diese Daten werden ohne Ihre
						ausdrückliche Zustimmung nicht an Dritte weitergegeben. <br>
						Wir weisen darauf hin, dass die Datenübertragung im Internet (z.B.
						bei der Kommunikation per E-Mail) Sicherheitslücken aufweisen
						kann. Ein lückenloser Schutz der Daten vor dem Zugriff durch
						Dritte ist nicht möglich. <br> Der Nutzung von im Rahmen der
						Impressumspflicht veröffentlichten Kontaktdaten durch Dritte zur
						Übersendung von nicht ausdrücklich angeforderter Werbung und
						Informationsmaterialien wird hiermit ausdrücklich widersprochen.
						Die Betreiber der Seiten behalten sich ausdrücklich rechtliche
						Schritte im Falle der unverlangten Zusendung von
						Werbeinformationen, etwa durch Spam-Mails, vor.
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:getProperty name="hb" property="footerAsHtml" />
</body>
</html>