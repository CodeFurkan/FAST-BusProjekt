<%@page import="de_hwg_lu.fastBus.beans.HomepageBean"%>
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

<link type="text/css" rel="stylesheet" href="../css/verbindungen.css" />
<!-- <link type="text/css" rel="stylesheet" href="../css/main2.0.css" /> -->
<link type="text/css" rel="stylesheet" href="../css/headerAndNavbar.css" />

<link type="text/css" rel="stylesheet" href="../css/footer.css" />
</head>



<body>
	<!-- JSP USEBEAN  -->
	<jsp:useBean id="navbar" class="de_hwg_lu.fastBus.beans.HomepageBean"
		 scope="session" />
	<jsp:useBean id="verbindung" class="de_hwg_lu.fastBus.beans.VerbindungBean" scope="session" />
		 
	<!-- JSP USEBEAN  -->


	<div class="container">
		<!-- Navbar -->
		<header>
			<jsp:getProperty name="navbar" property="navbarWithLoginAsHtml" />

		</header>
		<!-- Navbar end -->


		<!-- main box -->
 <div class="hintergrund">
      <div class="box">
        <div class="flexcol">
          <div class="ueberschrift">
            <h2>Jetzt Verbindung suchen</h2>
          </div>
          <div class="unterehaelfte">
            <div class="flexrow">
              <div class="von">
                <input type="text" name="inputStart" placeholder="Von..." />
              </div>
              <div class="nach">
                <input name="inputEnd" placeholder="Nach..." />
              </div>
              <div class="datum">
                <input type="date" name="date" />
              </div>
              <div class="suchen">
                <button type='submit' name='btnVerbindung'  class='subbutton'>Suchen</button>
                <!-- <input type="submit" name="btnSuchen" value="Suchen" /> -->
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!---------------------------------- box gestern morgen -------------------------------------->
    <div class="vornachtagbox">
      <div class="vornachtag">
        <div class="vortag">
          <a href="url">12.12.1982</a>
          
        </div>
        <div class="tagtag">
          <a href="url">13.12.1982</a>
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
<!--               <button type="submit" class="subbutton">Zum Angebot</button> -->
<!--             </div> -->
<!--           </div> -->
<!--         </div> -->
<!--       </div> -->
<!--   </div> -->
		<!-- main box end -->
	<jsp:getProperty name="verbindung" property="verbindungsBox" />
	<jsp:getProperty name="verbindung" property="verbindungsBox" />
	<jsp:getProperty name="verbindung" property="verbindungsBox" />

		<!------------------ footer------------ -->
		<jsp:getProperty name="navbar" property="footerAsHtml" />
		<!------------------ footer end------------ -->

	</div>
</body>
</html>