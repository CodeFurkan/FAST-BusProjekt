<%@page import="de_hwg_lu.fastBus.beans.VerbindungBean"%>
<%@page import="de_hwg_lu.fastBus.beans.HomepageBean"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
//zest
<link type="text/css" rel="stylesheet" href="../css/verbindungen.css" />
<!-- <link type="text/css" rel="stylesheet" href="../css/main2.0.css" /> tst-->
<link type="text/css" rel="stylesheet" href="../css/headerAndNavbar.css" />

<link type="text/css" rel="stylesheet" href="../css/footer.css" />
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
         <jsp:getProperty name="hb" property="formularBoxAsHtml" />

    <!---------------------------------- box gestern morgen -------------------------------------->
    <div class="vornachtagbox">
      <div class="vornachtag">
        <div class="vortag">
          <a href="url">12.12.1982</a>
          
        </div>
        <div class="tagtag">
          <a href="url"> <jsp:getProperty name="vb" property="datum"/> </a>
        </div>
        <div class="nachtag">
          <a href="url">14.12.1982</a>
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
<!--                 München Hbf -->
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
<!--             30 von 30 Plätzen frei -->
<!--           </div> -->
<!--           <div class="vPreisButton"> -->
<!--             <div class="vPreis"> -->
<!--               33,00€ -->
<!--             </div> -->
<!--             <div class="vButton"> -->
<!--               <input type="submit" name="btnZumAngebot" value="Zum Angebot" /> -->
<!--       �        <button type="submit" class="subbutton">Zum Angebot</button> -->
<!--             </div> -->
<!--           </div> -->
<!--         </div> -->
<!--       </div> -->
<!--   </div> -->
		<!-- main box end -->
	<jsp:getProperty name="vb" property="verbindungsBox" />

		<!------------------ footer------------ -->
		<jsp:getProperty name="hb" property="footerAsHtml" />
		<!------------------ footer end------------ -->

	</div>
</body>
</html>