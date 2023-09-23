<%@page import="de_hwg_lu.fastBus.beans.VerbindungBean"%>
<%@page import="de_hwg_lu.fastBus.beans.HomepageBean"%>
<%@page import="java.util.Date"%>
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" --%>
<%-- 	pageEncoding="ISO-8859-1"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<!-- <link type="text/css" rel="stylesheet" href="../css/main2.0.css" /> tst-->
<link type="text/css" rel="stylesheet" href="../css/headerAndNavbar.css" />

<link type="text/css" rel="stylesheet" href="../css/footer.css" />

    <script type="text/javascript" src="../js/switch.js"> </script>

</head>

<body>
<jsp:useBean id="loginBean" class="de_hwg_lu.fastBus.beans.LoginBean" scope="session"/>

	<!-- JSP USEBEAN  -->
	<jsp:useBean id="hb" class="de_hwg_lu.fastBus.beans.HomepageBean"
		 scope="session" />
	<jsp:useBean id="vb" class="de_hwg_lu.fastBus.beans.VerbindungBean" scope="session" />
		 
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
        <div class="vortag">
          <a href="./HomepageAppl.jsp?inputStart=<jsp:getProperty name="vb" property="startStadt"/>&inputEnd=<jsp:getProperty name="vb" property="zielStadt"/>&date=<jsp:getProperty name="vb" property="vorTagFuerLink"/>&btnVerbindung=Suchen" 
          Id="tagDavor" onclick="return einTagDavor();">
          <jsp:getProperty name="vb" property="vorTag"/>
          </a>
<!--           <a href='./TerminauswahlAppl.jsp?auswaehlen=auswaehlen&uhrzeit=" + i+ "'>auswaehlen</a> -->
        </div>
        <div class="tagtag" Id="ausgewaehlterTag">
          <a href="url"> <jsp:getProperty name="vb" property="datum"/> </a>
        </div>
         <div class="nachtag">
          <a href="./HomepageAppl.jsp?inputStart=<jsp:getProperty name="vb" property="startStadt"/>&inputEnd=<jsp:getProperty name="vb" property="zielStadt"/>&date=<jsp:getProperty name="vb" property="nachTagFuerLink"/>&btnVerbindung=Suchen" >
          <jsp:getProperty name="vb" property="nachTag"/>
          </a>
<!--           <a href='./TerminauswahlAppl.jsp?auswaehlen=auswaehlen&uhrzeit=" + i+ "'>auswaehlen</a> -->
        </div>
      </div>
    </div>
    <!---------------------------------- Verbindungsbox -------------------------------------->
<!--     <div class="verbindungsbox"> -->
<!--       <div class="vObenUnten"> -->
<!--         <div class="vBoxOben"> -->
<!--           <div class="vUhrzeitStadt"> -->
<!--             <div class="vUhrzeitStadtO"> -->
<!--               <div class="vUhrzeit"> -->
<!--                 12:30 -->
<!--               </div> -->
<!--               <div class="vStadt"> -->
<!--                 MÃ¼nchen Hbf -->
<!--               </div> -->
<!--             </div> -->
<!--             <div class="vUhrzeitStadtO"> -->
<!--               <div class="vUhrzeit"> -->
<!--                 18:50 -->
<!--               </div> -->
<!--               <div class="vStadt"> -->
<!--                 Berlin Hbf -->
<!--               </div> -->
<!--             </div> -->
<!--           </div> -->
<!--           <div class="vDauer"> -->
<!--             <img class="" src="../img/timer.png" alt="anmelden" width="35px" /> &nbsp; -->
<!--             6 Std 20 Min -->
<!--           </div> -->
<!--         </div> -->
<!--         <div class="vBoxUnten"> -->
<!--           <div class="vPlaetzeFrei"> -->
<!--             30 von 30 PlÃ¤tzen frei -->
<!--           </div> -->
<!--           <div class="vPreisButton"> -->
<!--             <div class="vPreis"> -->
<!--               33,00â¬ -->
<!--             </div> -->
<!--             <div class="vButton"> -->
<!--               <input type="submit" name="btnZumAngebot" value="Zum Angebot" /> -->
<!--               <button type="submit" class="subbutton">Zum Angebot</button> -->
<!--             </div> -->
<!--           </div> -->
<!--         </div> -->
<!--       </div> -->
<!--   </div> -->
		<!-- main box end -->
		
		<form action="./VerbindungAppl.jsp" method="get">
		<jsp:getProperty name="vb" property="verbindungsBox" />
		</form>
		<!------------------ footer------------ -->
		<jsp:getProperty name="hb" property="footerAsHtml" />
		<!------------------ footer end------------ -->

	</div>
</body>
</html>