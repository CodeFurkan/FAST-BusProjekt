<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About Us</title>
<link type="text/css" rel="stylesheet" href="../css/impressum.css" />
<link rel="stylesheet" type="text/css" href="../css/footer.css">
<link type="text/css" rel="stylesheet" href="../css/headerAndNavbar.css" />
	<link type="text/css" rel="stylesheet" href="../css/aboutUs.css" />
	
<jsp:useBean id="hb" class="de_hwg_lu.fastBus.beans.HomepageBean"
	scope="session" />

</head>
<body>
	<header>
		<jsp:getProperty name="hb" property="navbarWithLoginAsHtml" />
	</header>
		<body>
			<div class="container">
				<div class="content">
					<div class="story">
						<div class="story-title">Unsere Geschichte</div>
						<div class="story-text">Wir sind ein
							Busreservierungsunternehmen, das sichere, bequeme und preiswerte
							Reisem�glichkeiten f�r Menschen im ganzen Land anbietet. Wir
							begannen unsere Reise im Jahr 2023 mit der Vision, Busreisen
							einfach und f�r jeden zug�nglich zu machen. Seitdem haben wir uns
							zu einer der f�hrenden Busreservierungsplattformen auf dem Markt
							entwickelt, mit mehr als einer Million zufriedener Kunden. Wir
							bieten eine Vielzahl von Routen und Fahrpl�nen, die Ihren
							Bed�rfnissen und Vorlieben entsprechen. Egal ob Sie gesch�ftlich,
							privat oder abenteuerlich reisen m�chten, wir haben den perfekten
							Bus f�r Sie.</div>
					</div>
					<div class="box">
						<div class="spalte">
							<img src="../img/bus.jpg" alt="Busse" class="spalte-image">
							<div class="spalte-name">Busse</div>
							<div class="spalte-beschreibung">Unsere Busse sind
								ger�umig, komfortabel und mit modernen Annehmlichkeiten wie
								Klimaanlage, verstellbaren Sitzen, Wi-Fi und
								Entertainmentsystemen ausgestattet. Sie bieten Platz f�r bis zu
								50 Fahrg�ste und sind ideal f�r Langstreckenfahrten.</div>
						</div>
						<div class="spalte">
							<img src="../img/klima.jpg" alt="warum" class="spalte-image">
							<div class="spalte-name">Klima</div>
							<div class="spalte-beschreibung">Der Klimawandel ist ein
								globales Problem, das jeden betrifft, auch uns als
								Busreservierungsunternehmen. Die Umwelt und die Zukunft unseres
								Planeten liegen uns am Herzen. Busse verursachen im Vergleich zum Auto deutlich
								weniger CO2. Nach Berechnungen des Verbandes Deutscher
								Verkehrsunternehmen (VDV) spart jeder mit dem �PNV zur�ckgelegte
								Kilometer im Vergleich zur Autofahrt im Durchschnitt 95 Gramm
								Treibhausgase. Unsere Reisebusse haben mit 1,4 Litern Diesel und
								3,2 Kilo CO2 je Person mit Abstand den geringsten Spritverbrauch
								und Abgasaussto� und ist somit erwiesenerma�en das �kologischste
								Verkehrsmittel.</div>
						</div>
					</div>
					<div class="personal">
						<div class="personal-member">
							<img src="../img/Ali.png" alt=Personal1 class="personal-image">
							<div class="personal-name">Ali</div>
							<div class="personal-role">Bus Operator Manager</div>
						</div>
						<div class="personal-member">
							<img src="../img/Furkan2.png" alt="Personal2"
								class="personal-image">
							<div class="personal-name">Furkan</div>
							<div class="personal-role">Customer Service Manager</div>
						</div>
						<div class="personal-member">
							<img src="../img/Sema.png" alt="Personal3" class="personal-image">
							<div class="personal-name">Sema</div>
							<div class="personal-role">Marketing Manager</div>
						</div>
					</div>
				</div>
			</div>
			<jsp:getProperty name="hb" property="footerAsHtml" />
		</body>
</html>