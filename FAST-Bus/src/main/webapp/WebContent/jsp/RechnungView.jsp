<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Zahlungsvorgang</title>
<link rel="stylesheet" type="text/css" href="../css/rechnung.css">
<link rel="stylesheet" type="text/css" href="../css/footer.css">
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@500&family=Poppins:ital,wght@0,200;0,500;1,100;1,200&display=swap"
	rel="stylesheet" />
</head>
<jsp:useBean id="regBean" class="de_hwg_lu.fastBus.beans.RegBean" scope="session"/>

<body>
<main>
	<div class="container">
		<div class="header">
		<h3>Zahlungsadresse</h3>
		</div>
		<form action="./RechnungsAppl.jsp" method="get">

	<div class="billing-all-items">
			<div class="name">
				<label>Vorname 
				<input type="text" name="vorname" 
				value='<jsp:getProperty name="regBean" property="email"/>' 
				/></label>

				<label>Nachname <input type="text" name="nachname" 
				value='<jsp:getProperty name="regBean" property="nachname"/>' /> </label>
			</div>
			<div class="email">
				<label>E-mail 
				<input type="text" name="email" 
				value='<jsp:getProperty name="regBean" property="email"/>' 
				/></label>
			</div>
			<div class="anschrift">
				<label>Stra&szlig;e und Hausnummer
				<input type="text" name="adresse" value=""/> </label>
			</div>
			<div class="anschrift2">
				<label>Land
				<select name="land">
				<option value="1">DE</option>
				</select></label>
				
				<label>Stadt <input type="text" name="stadt" value=""/></label>
				
				<label>PLZ<input type="text" name="zip" value=""/></label>
			</div>
			
			<div class="zahlung">
				<h3>Zahlung</h3>
	
	
				<h4>Sofort&uuml;berweisung</h4>
					<label><input type="radio" name="zahlung" value="sofortueberweisung" />Sofort&uuml;berweisung</label> 
	
				<div class="kartendaten">
					<label>IBAN <input type="text" name="iban" value=""/></label>
	
					<label>BIC <input type="text" name="bic" value=""/></label>
				</div>
			<div class="kartenname">
					<label>Name des Kontoinhabers <input type="text" name="nameKonto" value=""/></label>
			</div>
	</div>
				<div class="zurKasse">
					<input type="submit" name="btnZurKasse" value="weiter zur Kasse" class="btnKasse"/>
				</div>
</div>

		</form>
	</div>
</main>


</body>
</html>