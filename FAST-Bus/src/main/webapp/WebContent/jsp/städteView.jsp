<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>St�dte</title>
</head>
<link type="text/css" rel="stylesheet" href="../css/headerAndNavbar.css" />
<link type="text/css" rel="stylesheet" href="../css/footer.css" />
<link type="text/css" rel="stylesheet" href="../css/stadt.css" />

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Mooli&family=Open+Sans:wght@500&family=Poppins:ital,wght@0,200;0,500;1,100;1,200&family=Roboto:wght@700&display=swap"
	rel="stylesheet">
<!-- JSP USEBEAN  -->
<jsp:useBean id="hb" class="de_hwg_lu.fastBus.beans.HomepageBean"
	scope="session" />
<body>
	<header>
		<jsp:getProperty name="hb" property="navbarWithLoginAsHtml" />
	</header>
	<!-- Main -->

	<main>

		<h1 class="uberschrift">Deutschlands St�dte</h1>
		<div class="hero-container-alleStdte">

			<div class="stadtReihe">

				<div class="container-Stadt">
					<div class="bild">
						<img src="../img/berlin.jpeg" alt="">
					</div>
					<div class="text">
						<h3>Berlin</h3>
						<p1>Die pulsierende Hauptstadt Deutschlands, die f�r ihre
						lebendige Kunst- und Kulturszene, historischen Sehensw�rdigkeiten
						wie das Brandenburger Tor und ein aufregendes Nachtleben bekannt
						ist.</p1>
					</div>
				</div>

				<div class="container-Stadt">
					<div class="bild">
						<img src="../img/frankfurt.jpeg" alt="">
					</div>
					<div class="text">
						<h3>Frankfurt</h3>
						<p1>Das wirtschaftliche Herz Deutschlands, das f�r seine
						beeindruckende Skyline, die Frankfurter Buchmesse und seine
						internationale Finanzwelt bekannt ist.</p1>
					</div>
				</div>


				<div class="container-Stadt">
					<div class="bild">
						<img src="../img/hamburg.jpeg" alt="">
					</div>
					<div class="text">
						<h3>Hamburg</h3>
						<p1>Die Hafenstadt im Norden, die f�r ihre einzigartige
						Architektur, die Elbphilharmonie und eine maritime Atmosph�re
						entlang der Alster und Elbe ber�hmt ist.</p1>
					</div>
				</div>
			</div>



			<div class="stadtReihe">
				<div class="container-Stadt">
					<div class="bild">
						<img src="../img/mannheim.jpeg" alt="">
					</div>
					<div class="text">
						<h3>Mannheim</h3>
						<p1>Mannheim, oft als "Stadt der Quadrate" bezeichnet,
						besticht durch ihr einzigartiges Stra�ennetzwerk und das imposante
						barocke Schloss Mannheim.</p1>
					</div>
				</div>
				<div class="container-Stadt">
					<div class="bild">
						<img src="../img/muenchen.jpeg" alt="">
					</div>
					<div class="text">
						<h3>M�nchen</h3>
						<p1>Die bayerische Metropole, die f�r ihr Oktoberfest,
						pr�chtige Schl�sser wie Nymphenburg und eine reiche Tradition in
						Kunst und Wissenschaft ber�hmt ist.</p1>
					</div>
				</div>

				<div class="container-Stadt">
					<div class="bild">
						<img src="../img/stuttgart.jpeg" alt="">
					</div>
					<div class="text">
						<h3>Stuttgart</h3>
						<p1>Die Stadt im Herzen von Baden-W�rttemberg, die f�r ihre
						Automobilindustrie, das Mercedes-Benz Museum und malerische
						Weinberge in der Umgebung gesch�tzt wird.</p1>
					</div>
				</div>
			</div>


			<div class="stadt3Reihe">
				<div class="container-Stadt">
					<div class="bild">
						<img src="../img/duesseldorf.jpeg" alt="">
					</div>
					<div class="text">
						<h3>D�sseldorf</h3>
						<p1>Die Mode- und Kunststadt am Rhein, die f�r die ber�hmte
						K�nigsallee, lebhafte Kunstszene und exzellente Restaurants und
						Bars ger�hmt wird.</p1>
					</div>
				</div>


				<div class="container-Stadt">
					<div class="bild">
						<img src="../img/leipzig.jpeg" alt="">
					</div>
					<div class="text">
						<h3>Leipzig</h3>
						<p1>Die Stadt der Musik, die f�r das Thomaskirchenorchester,
						das Bach-Museum und eine aufstrebende Kreativszene bekannt ist.</p1>
					</div>
				</div>

			</div>


		</div>
	</main>

					  <!-- main box end -->	


      <!------------------ footer------------ -->
        <jsp:getProperty name="hb" property="footerAsHtml" />
      <!------------------ footer end------------ -->

</body>
</html>