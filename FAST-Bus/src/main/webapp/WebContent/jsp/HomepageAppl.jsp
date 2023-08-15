<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="de_hwg_lu.fastBus.beans.HomepageBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="hb" class="de_hwg_lu.fastBus.beans.HomepageBean"  scope="session" />

<%

String btnVerbindung = request.getParameter("btnVerbindung");
String inputStart = request.getParameter("inputStart");
String inputEnd = request.getParameter("inputEnd");
String stringDate = request.getParameter("date");


DateFormat format = new SimpleDateFormat("MM/dd/yyyy");

try {
    Date date = format.parse(stringDate);
    System.out.println(date);
}
catch (ParseException e) {
    e.printStackTrace();
}


if(btnVerbindung == null ) btnVerbindung="";



if(btnVerbindung.equals("Suchen")){
	hb.setInputStart(inputStart);
	hb.setInputEnd(inputEnd);
	hb.setDatum(date);
	response.sendRedirect("./VerbindungSuche.jsp");
}

%>

</body>
</html>