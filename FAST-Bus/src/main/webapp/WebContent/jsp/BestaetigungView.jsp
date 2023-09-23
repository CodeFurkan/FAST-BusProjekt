<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bestellbest&auml;tigung</title>
<link type="text/css" rel="stylesheet" href="../css/bestaetigung.css" />
<link rel="stylesheet" type="text/css" href="../css/footer.css">
<link type="text/css" rel="stylesheet" href="../css/headerAndNavbar.css" />

</head>

<jsp:useBean id="hb" class="de_hwg_lu.fastBus.beans.HomepageBean"
	scope="session" />
<body>
<jsp:useBean id="loginBean" class="de_hwg_lu.fastBus.beans.LoginBean" scope="session"/>
<jsp:useBean id="rb" class="de_hwg_lu.fastBus.beans.RechnungBean" scope="session"/>
<jsp:useBean id="vb" class="de_hwg_lu.fastBus.beans.VerbindungBean"  scope="session" />

  						  <!-- Navbarr -->
      <header>
           <jsp:getProperty name="hb" property="navbarWithLoginAsHtml" />
      
      </header>
							<!-- Navbar end -->


 <div class="invoice-container">
        <div class="invoice-header">
            <h1 class="invoice-title"></h1>
        </div>
        <div class="invoice-details">
            <h2>Bestellinformationen</h2>
            <!-- strong Kundennummer wird fett geschrieben -->
            <p><strong>Kundennummer:</strong> </p>
            
            <p><strong>Datum:</strong> </p>
        </div>
        <div class="invoice-address">
            <h2>Kundeninformation</h2>
            <p><strong>Vorname :</strong></p>
		<jsp:getProperty  name="loginBean" property="vorname" />
            <p><strong>Nachname:</strong></p>
            <jsp:getProperty  name="loginBean" property="nachname" />
            <p><strong>Adresse:</strong></p>
            <jsp:getProperty  name="rb" property="adresse"/>   <jsp:getProperty  name="rb" property="stadt"/> <jsp:getProperty  name="rb" property="plz"/>
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
            <tbody>
                <tr>
                    <td><jsp:getProperty  name="rb" property="startStadt"/></td>
                    <td><jsp:getProperty  name="rb" property="datum"/></td>
                    <td>  <jsp:getProperty  name="rb" property="startUhrzeit"/></td>
                    <td rowspan="2"> <jsp:getProperty  name="rb" property="preis"/></td>
                </tr>
                <tr>
                    <td> <jsp:getProperty  name="rb" property="zielStadt"/></td>
                     <td><jsp:getProperty  name="rb" property="zielDatum"/></td>
                    <td><jsp:getProperty  name="rb" property="zielUhrzeit"/></td>
                      
                        
                </tr>
            </tbody>
        </table>
   
        <div class="ausdruckenBox noPrint">
	     <a class="ausdrucken-button noPrint" href="#" onclick="javascript:window.print();" >Jetzt ausdrucken</a>
        </div>

    </div>
    	<jsp:getProperty name="hb" property="footerAsHtml" />
    
</body>
</html>