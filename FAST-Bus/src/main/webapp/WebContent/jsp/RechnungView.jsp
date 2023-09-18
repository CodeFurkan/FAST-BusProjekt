<%@page import="de_hwg_lu.fastBus.beans.LoginBean"%>
<%@page import="de_hwg_lu.fastBus.beans.HomepageBean"%>
<%@page import="de_hwg_lu.fastBus.beans.RegBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:getProperty name="loginBean" property="checkLoggedIn"/>

<title>Zahlungsvorgang</title>
<link rel="stylesheet" type="text/css" href="../css/rechnung.css">
<link rel="stylesheet" type="text/css" href="../css/footer.css">
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@500&family=Poppins:ital,wght@0,200;0,500;1,100;1,200&display=swap"
	rel="stylesheet" />

<link type="text/css" rel="stylesheet" href="../css/headerAndNavbar.css" />
<link type="text/css" rel="stylesheet" href="../css/footer.css" />
</head>
<jsp:useBean id="loginBean" class="de_hwg_lu.fastBus.beans.LoginBean" scope="session"/>
<jsp:useBean id="regBean" class="de_hwg_lu.fastBus.beans.RegBean" scope="session" />
<jsp:useBean id="hb" class="de_hwg_lu.fastBus.beans.HomepageBean"  scope="session" />

<body>
	<div class="container">
		<header>
		 <jsp:getProperty name="hb" property="navbarWithLogoutAsHtml" />
		</header>
		<main>

			<form action="./RechnungAppl.jsp" method="get">
				<div class="content">
					<div class="billing-box">
						<div class="billing-all-items">
							<div class="header">
								<h1>Zahlungsadresse</h1>
							</div>

							<div class="billing-main">
								<div class="vorname">
									<label>Vorname <input type="text" name="vorname"
										value='<jsp:getProperty name="regBean" property="vorname"/>' /></label>
								</div>
								<div class="nachname">
									<label>Nachname <input type="text" name="nachname"
										value='<jsp:getProperty name="regBean" property="nachname"/>' />
									</label>
								</div>
								<div class="email">
									<label>E-mail <input type="text" name="email"
										value='<jsp:getProperty name="regBean" property="email"/>' /></label>
								</div>
								<div class="anschrift">
									<label>Stra&szlig;e und Hausnummer <input type="text"
										name="adresse" value="" />
									</label>
								</div>
								<div class="Land">
									<label>Land <select name="land">
											<option value="1">DE</option>
									</select></label>
								</div>
								<div class="stadt">
									<label>Stadt <input type="text" name="stadt" value="" /></label>
								</div>
								<div class="plz">
									<label>PLZ<input type="text" name="plz" value="" /></label>
								</div>

								<h1 class="header">Zahlung</h1>
								<h3>Sofort&uuml;berweisung</h3>

								<div class="iban">
									<label>IBAN <input type="text" name="iban" value="" /></label>
								</div>
								<div class="bic">
									<label>BIC <input type="text" name="bic" value="" /></label>
								</div>
								<div class="nameKonto">
									<label>Name des Kontoinhabers <input type="text"
										name="nameKonto" value="" /></label>
								</div>

								<!-- button-Element, dient zur Erstellung eines Buttons -->
								<div class="kasse">
									<button type="submit" name="btnJetztKaufen" value="jetzt kaufen"
										class="btnKasse">Jetzt kaufen</button>
								</div>


							</div>

						</div>
					</div>
				</div>
	</form>
	</main>
        <jsp:getProperty name="hb" property="footerAsHtml" />

	</div>




</body>
</html>