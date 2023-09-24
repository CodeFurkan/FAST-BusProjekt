<%@page import="de_hwg_lu.fastBus.beans.VerbindungBean"%>
<%@page import="de_hwg_lu.fastBus.beans.HomepageBean"%>
<%@page import="java.util.Date"%>
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" --%>
<%-- 	pageEncoding="ISO-8859-1"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>FASt-Bus</title>
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@500&family=Poppins:ital,wght@0,200;0,500;1,100;1,200&display=swap"
	rel="stylesheet" />
<link type="text/css" rel="stylesheet" href="../css/main1.0.css" />
<link type="text/css" rel="stylesheet" href="../css/verbindungen.css" />
<link type="text/css" rel="stylesheet" href="../css/headerAndNavbar.css" />

<link type="text/css" rel="stylesheet" href="../css/footer.css" />

<script type="text/javascript" src="../js/switch.js">
	
</script>

</head>

<body>
	<jsp:useBean id="loginBean" class="de_hwg_lu.fastBus.beans.LoginBean"
		scope="session" />

	<!-- JSP USEBEAN  -->
	<jsp:useBean id="hb" class="de_hwg_lu.fastBus.beans.HomepageBean"
		scope="session" />
	<jsp:useBean id="vb" class="de_hwg_lu.fastBus.beans.VerbindungBean"
		scope="session" />
	<jsp:useBean id="mb" class="de_hwg_lu.fastBus.beans.MessageBean"
		scope="session" />

	<!-- JSP USEBEAN  -->


	<div class="container">
		<!-- Navbar -->
		<header>
			<jsp:getProperty name="hb" property="navbarWithLoginAsHtml" />

		</header>
		<!-- Navbar end -->


		<!-- main box -->
		<form action="./HomepageAppl.jsp" method="get">
			<jsp:getProperty name="hb" property="formularBoxAsHtml" />
		</form>
		<!---------------------------------- box gestern morgen -------------------------------------->
		<div class="vornachtagbox">
			<div class="vornachtag">
			<!-- VORTAG -->
				<div class="vortag">
					<img class="calendar" src="../img/calendar.png"> <a
						href="./HomepageAppl.jsp?inputStart=<jsp:getProperty name="vb" property="startStadt"/>&inputEnd=<jsp:getProperty name="vb" property="zielStadt"/>&date=<jsp:getProperty name="vb" property="vorTagFuerLink"/>&quantity=<jsp:getProperty name="vb" property="wunschplaetze"/>&btnVerbindung=Suchen"
						Id="tagDavor" onclick="return einTagDavor();"> 
						<jsp:getProperty name="vb" property="vorTag" />
					</a>
				</div>
				<img class="pfeillinks" src="../img/pfeil_links.png">
				
				
				<!-- HEUTIGER DATUM -->
				<div class="tagtag" Id="ausgewaehlterTag">
					<img class="calendar" src="../img/calendar.png" /> 
					<a href="">
					<jsp:getProperty name="vb" property="datum" />
					</a>
				</div>
				
				<img class="pfeilrechts klickElement" src="../img/pfeil_rechts.png" />
				
				<!--  NachtTAG-->
				<div class="nachtag">
					<img class="calendar" src="../img/calendar.png"> <a
						href="./HomepageAppl.jsp?inputStart=<jsp:getProperty name="vb" property="startStadt"/>&inputEnd=<jsp:getProperty name="vb" property="zielStadt"/>&date=<jsp:getProperty name="vb" property="nachTagFuerLink"/>&quantity=<jsp:getProperty name="vb" property="wunschplaetze"/>&btnVerbindung=Suchen" class="klickElement">
						<jsp:getProperty name="vb" property="nachTag" />
					</a>

				</div>
			</div>
		</div>
		
		<form action="./VerbindungAppl.jsp" method="get" onsubmit="return ueberbuchung(this)">
			<jsp:getProperty name="vb" property="verbindungsBox" />
		</form>
		<!------------------ footer------------ -->
		<jsp:getProperty name="hb" property="footerAsHtml" />
		<!------------------ footer end------------ -->
	</div>
</body>
</html>