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
	String btnsubmit = request.getParameter("btnsubmit");
	String zumLogin = request.getParameter("zumLogin");

	if (btnsubmit == null)
		btnsubmit = "";
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

	if (btnsubmit.equals("kostenlos registrieren")) {
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
//boolean accountExistiert = false;
		//Überprüfen ob Account schon existiert (EmailCheck)	
//		accountExistiert = regBean.checkAccountExists(); //falls existiert auf true gesetzt;
//if (accountExistiert) {
//			System.out.println("Account existiertt");
//			response.sendRedirect("./RegView.jsp");
//		} 
//		else {
//			regBean.insertAccoutNoCheck();
//			System.out.println("registieren erfolgreich.");
//			response.sendRedirect("./HomepageView.jsp");
//		}

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