<%@page import="de_hwg_lu.fastBus.beans.MessageBean"%>
<%@page import="de_hwg_lu.fastBus.beans.RegBean"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="regBean" class="de_hwg_lu.fastBus.beans.RegBean"
		scope="session" />
		<jsp:useBean id="msgBean" class="de_hwg_lu.fastBus.beans.MessageBean"
		scope="session" />


	<%
	String vorname = request.getParameter("vorname");
	String nachname = request.getParameter("nachname");
	String geburtsdatumStr = request.getParameter("geburtsdatum");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String btnRegister = request.getParameter("btnRegister");
	String zumLogin = request.getParameter("zumLogin");

	if (btnRegister == null)
		btnRegister = "";
	if (zumLogin == null)
		zumLogin = "";
	Date geburtsdatum = null;
	java.sql.Date geburtsdatumSql = null;

	try {
		System.out.println("Eingegebenes Geburtsdatum: " + geburtsdatumStr);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date geburtsdatumUtil = dateFormat.parse(geburtsdatumStr); // Parse das Geburtsdatum als java.util.Date
		geburtsdatumSql = new java.sql.Date(geburtsdatumUtil.getTime()); // Konvertiere es in java.sql.Date
	}

	catch (ParseException e) {
		e.printStackTrace();
		System.out.println("Fehler: Das Geburtsdatum ist ungültig. Bitte geben Sie ein Datum im Format dd.MM.yyyy ein.");
	}

	if (btnRegister.equals("kostenlos registrieren")) {
		msgBean.setRegistrationWelcome();
		regBean.setVorname(vorname);
		regBean.setNachname(nachname);
		regBean.setGeburtsdatum(geburtsdatumSql);
		regBean.setEmail(email);
		regBean.setPassword(password);
		
//	boolean accountExistiertNicht = false;
	boolean accountAngelegt = false;
	try{
		accountAngelegt = regBean.insertAccountIfNotExsits();
		if(accountAngelegt){
			msgBean.setAccountAngelegt(email);
			System.out.println("Account angelegt.");
			response.sendRedirect("./LoginView.jsp");
			
		}else{
			msgBean.setAccountVorhanden(email);
			System.out.println("Account existiert bereits.");
			response.sendRedirect("./RegView.jsp");
			
		}
	}catch(Exception e){
		msgBean.setAnyError();
		e.printStackTrace();
		response.sendRedirect("./RegView.jsp");
		
	}

	} else if (zumLogin.equals("zumLogin")) {
		msgBean.setGeneralWelcome();
		response.sendRedirect("./LoginView.jsp");

	} else {
		msgBean.setGeneralWelcome();
		response.sendRedirect("./LoginView.jsp");
	}
	%>
</body>
</html>