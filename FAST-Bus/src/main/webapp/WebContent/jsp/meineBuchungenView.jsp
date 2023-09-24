<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Meine Buchungen</title>
<link rel="stylesheet" type="text/css" href="../css/footer.css">
<link type="text/css" rel="stylesheet" href="../css/headerAndNavbar.css" />
  <link type="text/css" rel="stylesheet" href="../css/bestaetigung.css" />

</head>
<body>
<jsp:useBean id="hb" class="de_hwg_lu.fastBus.beans.HomepageBean"
	scope="session" />
<jsp:useBean id="loginBean" class="de_hwg_lu.fastBus.beans.LoginBean" scope="session"/>
<jsp:useBean id="rb" class="de_hwg_lu.fastBus.beans.RechnungBean" scope="session"/>
<jsp:useBean id="vb" class="de_hwg_lu.fastBus.beans.VerbindungBean"  scope="session" />
<jsp:useBean id="mbb" class="de_hwg_lu.fastBus.beans.MeineBuchungenBean" scope="session"/>

				  <!-- Navbarr -->
      <header>
           <jsp:getProperty name="hb" property="navbarWithLoginAsHtml" />
      
      </header>
							<!-- Navbar end -->

    <div class="invoice-container">
        <div class="ueberschrift">
            <h1> Ihre Buchungen
            </h1>
        </div>
        <table class="invoice-table">
            <thead>
                <tr>
                    <th>Verbindung</th>
                    <th>Datum </th>
                    <th>Uhrzeit</th>
                    <th>Preis</th>
                </tr>
            </thead>
            <jsp:getProperty name="mbb" property="meineBuchungAsHtml" />
        </table>

</div>
							
							<!-- Footer -->
    	<jsp:getProperty name="hb" property="footerAsHtml" />
							<!-- Footer -->
</body>
</html>