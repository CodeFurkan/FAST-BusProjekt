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
<jsp:useBean id="regBean" class="de_hwg_lu.fastBus.beans.RegBean" scope="session"/>


<%
	String vorname = request.getParameter("vorname");
	String nachname = request.getParameter("nachname");
	String geburtsdatum = request.getParameter("geburtsdatum");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String btnsubmit = request.getParameter("btnsubmit");
	String zumLogin = request.getParameter("zumLogin");
	
	if(btnsubmit == null) btnsubmit="";
	if(zumLogin == null) zumLogin="";
	
	Date gebdatum = null; // Deklaration und Initialisierung von gebdatum
	String outputDateString = null;
		   SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	
	try{
        System.out.println("Eingegebenes Geburtsdatum: " + geburtsdatum);
        Date date = dateFormat.parse(geburtsdatum);
        // Erstellen Sie ein SimpleDateFormat-Objekt für das gewünschte Ausgabeformat
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
       
         outputDateString = outputDateFormat.format(date);        
        // gebdatum = dateFormat.parse(geburtsdatum);	
		     }
	
	catch (ParseException e) {
	   e.printStackTrace();
    System.out.println("Fehler: Das Geburtsdatum ist ungültig. Bitte geben Sie ein Datum im Format dd.MM.yyyy ein.");
	}
	
	
	if(btnsubmit.equals("kostenlos registrieren")){
		regBean.setVorname(vorname);
		regBean.setNachname(nachname);

		 // Konvertieren Sie das outputDateString in ein Date-Objekt
	    SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date geburtsdate = inputDateFormat.parse(outputDateString);
	    java.sql.Date sqlGebDatum = new java.sql.Date(geburtsdate.getTime());
		regBean.setGeburtsdatum(sqlGebDatum);
		regBean.setEmail(email);
		regBean.setPassword(password);
		regBean.insertAccoutNoCheck();
		System.out.println("registieren erfolgreich.");
		response.sendRedirect("./HomepageView.jsp");
	}else if(zumLogin.equals("zumLogin")){
		response.sendRedirect("./LoginView.jsp");
		
	}else{
		response.sendRedirect("./LoginView.jsp");
	}
	

%>
</body>
</html>