<%@page import="de_hwg_lu.fastBus.beans.LoginBean"%>
<%@page import="de_hwg_lu.fastBus.beans.HomepageBean"%>
<%@page import="de_hwg_lu.fastBus.beans.RegBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:getProperty name="loginBean" property="checkLoggedIn" />

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
<jsp:useBean id="loginBean" class="de_hwg_lu.fastBus.beans.LoginBean"
	scope="session" />
<jsp:useBean id="regBean" class="de_hwg_lu.fastBus.beans.RegBean"
	scope="session" />
<jsp:useBean id="hb" class="de_hwg_lu.fastBus.beans.HomepageBean"
	scope="session" />

<body>
		<header>
			<jsp:getProperty name="hb" property="navbarWithLogoutAsHtml" />
		</header>
		
		<main>

			<div class="container">
				<div class="zahlungsadresse">

					<div class="header">
						<h1>Zahlungsadresse</h1>
					</div>
					<form action="./RechnungAppl.jsp" method="get">
						<div class="main-Content">
							<div class="vor-Nachname">
								<div class="vorname">
									<label class="vorname">Vorname </label> <input type="text"
										name="vorname"                     value='<jsp:getProperty name="regBean" property="vorname"/>' />
								</div>
								<div class="nachname">
									<label>Nachname </label> <input type="text" name="nachname"
										                    value='<jsp:getProperty name="regBean" property="nachname" />' 
										                    />
								</div>
							</div>
							<div class="email">
								<label>Email </label> <input type="text" name="email" 
                  				  value='<jsp:getProperty name="regBean" property="email"/>'
								/>
							</div>
							<div class="adresse">
								<label>Stra&szlig;e und Hausnummer </label> <input type="text"
									name="adresse" value="" required />
							</div>
							<div class="stadt-plz">


								<div class="plz">
									<label>PLZ </label> <input type="text" name="plz" value=""
										pattern="[0-9]{5}" required />
								</div>
								<div class="stadt">
									<label>Stadt </label> <input type="text" name="stadt" value=""
										required />
								</div>
							</div>
						</div>

						<div class="zahlung">

							<div class="zwischen-Header">
								<h1>SEPA-Lastschrift</h1>
							</div>

							<div class="kontoname">
								<label>Kontoname </label> <input type="text" name="nameKonto"
									value="" required />
							</div>
							<div class="iban-bic">
								<label>IBAN </label> <input type="text" name="iban" value=""
									required />
							</div>

							<div class="iban-bic">
								<label>BIC </label> <input type="text" name="bic" value=""
									required />
							</div>
							<div class="kasse">
								<button type="submit" name="btnJetztKaufen" value="jetzt kaufen"
									class="btnKasse">Jetzt kaufen</button>
							</div>
						</div>
				</div>
			</div>
			</form>
	</div>

	<div class="verbindungsContainer">
		<div class="überschrift">
			<h1>Deine Verbindung</h1>
		</div>
		<div class="main-container">
			<div class="von">Von</div>
			<div class="busBild">
				<img src="img/Fast-BusZahlung.png" alt="">
			</div>
			<div class="nach">Nach</div>

		</div>

		<div class="gesamtpreis"></div>

	</div>

	</main>

	<jsp:getProperty name="hb" property="footerAsHtml" />





</body>
</html>