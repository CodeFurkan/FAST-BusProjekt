<%@page import="de_hwg_lu.fastBus.beans.MessageBean"%>
<%@page import="de_hwg_lu.fastBus.beans.RegBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jetzt Registrieren</title>
</head>
<link type="text/css" rel="stylesheet" href="../css/headerAndNavbar.css" />
<link rel="stylesheet" type="text/css" href="../css/reg.css">
<link rel="stylesheet" type="text/css" href="../css/footer.css">
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@500&family=Poppins:ital,wght@0,200;0,500;1,100;1,200&display=swap"
	rel="stylesheet" />
<script type="text/javascript" src="../js/reg.js"></script>
<body>

	<jsp:useBean id="regBean" class="de_hwg_lu.fastBus.beans.RegBean"
		scope="session" />
	<jsp:useBean id="hb" class="de_hwg_lu.fastBus.beans.HomepageBean" />
	<jsp:useBean id="msgBean" class="de_hwg_lu.fastBus.beans.MessageBean"
		scope="session" />


	<!-- Navbarr -->
	<header>
		<jsp:getProperty name="hb" property="navbarWithLoginAsHtml" />

	</header>
	<!-- Navbar end -->

	<main>
		<div class="massage">
				<p1> Herzlich Willkommen</p1>
			</div>
		<form action="./RegAppl.jsp" method="get">
			<div class="heroContainer">
				<div class="uerberschrift">
					<h1>Registrieren</h1>
				</div>

				<div class="loginItems">
					<div class="vorname">
						<label for="vorname">Vorname</label> <input type="text"
							name="vorname" required />
					</div>

					<div class="nachname">
						<label for="nachname">Nachname</label> <input type="text"
							name="nachname" required />
					</div>

					<div class="alter">
						<label for="alter">Geburtsdatum</label> <input type="date"
							name="geburtsdatum" required />
					</div>

					<div class="email">
						<label for="email">E-Mail</label> <input type="email" name="email"
							required placeholder="beispiel@beispiel.de" />
					</div>
					<div class="password">
						<label for="password">Passwort</label> <input type="password"
							name="password" minlength="6" required />
					</div>

					<div class="login">
						<button type="submit" name="btnRegister" class="btnsubmit"
							value="kostenlos registrieren">
							kostenlos registrieren</button>
					</div>
				</div>
				<div class="reg">
					<p>
						Sie haben ein Konto? <a href="./RegAppl.jsp?zumLogin=zumLogin"
							class="log">Jetzt anmelden</a>
					</p>
				</div>
			</div>
	
		</form>
		

	<h2><jsp:getProperty name="msgBean" property="actionMsg" />	</h2>
	</main>
	<jsp:getProperty name="hb" property="footerAsHtml" />
</body>
</html>