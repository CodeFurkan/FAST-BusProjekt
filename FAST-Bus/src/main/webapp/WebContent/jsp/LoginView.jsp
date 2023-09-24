<%@page import="de_hwg_lu.fastBus.beans.MessageBean"%>
<%@page import="de_hwg_lu.fastBus.beans.HomepageBean"%>
<%@page import="de_hwg_lu.fastBus.beans.LoginBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jetzt anmelden</title>
<link rel="stylesheet" type="text/css" href="../css/login.css">

<link type="text/css" rel="stylesheet" href="../css/headerAndNavbar.css" />
<link rel="stylesheet" type="text/css" href="../css/footer.css">
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@500&family=Poppins:ital,wght@0,200;0,500;1,100;1,200&display=swap"
	rel="stylesheet" />
</head>
<body>
	<jsp:useBean id="hb" class="de_hwg_lu.fastBus.beans.HomepageBean"
		scope="session" />
	<jsp:useBean id="loginBean" class="de_hwg_lu.fastBus.beans.LoginBean"
		scope="session" />
	<jsp:useBean id="msgBean" class="de_hwg_lu.fastBus.beans.MessageBean"
		scope="session" />

	<!--  
<header> <img src="../img/logo1.png" id="logoImg"/></header>
-->
	<!-- Navbar -->
	<header>
		<jsp:getProperty name="hb" property="navbarWithLoginAsHtml" />

	</header>
	<!-- Navbar endn -->
	
	<main>
			<div class="massage">
				<p1> Herzlich Willkommen</p1>
			</div>
		<form action="./LoginAppl.jsp" method="get">

				<div class="heroContainer">
					<div class="uerberschrift">
						<h1>Anmelden</h1>
					</div>

					<div class="loginItems">
						<div class="email">
							<label for="email">E-Mail</label> <br /> <input type="email"
								name="email" required placeholder="beispiel@beispiel.de" />
						</div>
						<div class="password">
							<label for="password">Passwort</label> <br /> <input
								type="password" name="password" id="Passwort" required />
						</div>

						<div class="login">
							<button type="submit" name="btnsubmit" value="Anmelden"
								class="btnsubmit">Anmelden</button>
						</div>
					</div>
				<div class="reg">
					<p>
						Sie haben noch kein Konto? <a href="./LoginAppl.jsp?zurReg=zurReg"
							class="reg">Registrieren</a>
					</p>
				</div>
			</div>
			</form>
			<div class="ms"> 
	<p1><jsp:getProperty name="msgBean" property="informationsMsg" /></p1>
	<br>
	<p1><jsp:getProperty name="msgBean" property="actionMsg" /> </p1>
			</div>
	</main>

	<jsp:getProperty name="hb" property="footerAsHtml" />
</body>
</html>