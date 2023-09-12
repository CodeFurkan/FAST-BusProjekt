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
<form action="./RechnungsAppl.jsp" method="get">
	<div class="container">
		<div class="content">
		<div class="billing-box">
			<div class="billing-all-items">
				<div class="header"><h1>Zahlungsadresse</h1></div>
				
				<div class="billing-main" >
					<div> <label>Vorname 	<input type="text" name="vorname" 
					value='<jsp:getProperty name="regBean" property="vorname"/>'/></label> </div>
	
					<div><label>Nachname <input type="text" name="nachname" 
					value='<jsp:getProperty name="regBean" property="nachname"/>' /> </label></div>
					<div>
					<label>E-mail <input type="text" name="email" 
					value='<jsp:getProperty name="regBean" property="email"/>' /></label>
					</div>
						<div >
					<label>Stra&szlig;e und Hausnummer
					<input type="text" name="adresse" value=""/> </label> </div>
					<div class="Land">
					<label>Land
					<select name="land">
					<option value="1">DE</option>
					</select></label>
					</div>
					<div> 
					<label>Stadt <input type="text" name="stadt" value=""/></label>
					</div>
					<div> 
					<label>PLZ<input type="text" name="zip" value=""/></label>			
					</div>
						
					<h1 class="header">Zahlung</h1>
						<h3>Sofort&uuml;berweisung</h3>
					<div>
						<label><input type="radio" name="zahlung" value="sofortueberweisung" />Sofort&uuml;berweisung</label> 
					</div>
					<div> <label>IBAN <input type="text" name="iban" value=""/></label></div>
					<div><label>BIC <input type="text" name="bic" value=""/></label></div>
					<div>
						<label>Name des Kontoinhabers <input type="text" name="nameKonto" value=""/></label>		
					</div>
				<div>	
				<button type="submit" name="btnZurKasse" 
					value="weiter zur Kasse" class="btnKasse">weiter zur Kasse</button>
				</div>
	
					
				</div>
				
	</div>
			</div>
	</div>
</div>

	
</form>
</main>


</body>
</html>