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
<jsp:useBean id="loginBean" class="de_hwg_lu.fastBus.beans.LoginBean" scope="session"/>
<jsp:useBean id="vb" class="de_hwg_lu.fastBus.beans.VerbindungBean"  scope="session" />
<jsp:useBean id="rb" class="de_hwg_lu.fastBus.beans.RechnungBean"  scope="session" />

<%

String btnZumAngebot = request.getParameter("btnZumAngebot");
System.out.println(btnZumAngebot);
if(btnZumAngebot == null ) btnZumAngebot="";

if(btnZumAngebot.equals("Zum Angebot0")){
// 	System.out.println("tesuonr1");
	rb.setStartStadt(vb.getStartStadt());
	rb.setZielStadt(vb.getZielStadt());
	rb.setDatum(vb.getDatum());
	rb.setDauerStd(vb.getDauerStd());
	rb.setDauerMin(vb.getDauerMin());
	rb.setPreis(vb.getPreisString());
	
	rb.setStartUhrzeit("8:00");
	rb.setZielUhrzeit(vb.tagesZeitPlusDauer(8.0));
	
	response.sendRedirect("./RechnungView.jsp");
}

if(btnZumAngebot.equals("Zum Angebot1")){
// 	System.out.println("tesutonr1");
	rb.setStartStadt(vb.getStartStadt());
	rb.setZielStadt(vb.getZielStadt());
	rb.setDatum(vb.getDatum());
	rb.setDauerStd(vb.getDauerStd());
	rb.setDauerMin(vb.getDauerMin());
	rb.setPreis(vb.getPreisString());
	
	rb.setStartUhrzeit("16:00");
	rb.setZielUhrzeit(vb.tagesZeitPlusDauer(16.0));
	
	response.sendRedirect("./RechnungView.jsp");
}

if(btnZumAngebot.equals("Zum Angebot2")){
// 	System.out.println("tesutnr1");
	rb.setStartStadt(vb.getStartStadt());
	rb.setZielStadt(vb.getZielStadt());
	rb.setDatum(vb.getDatum());
	rb.setDauerStd(vb.getDauerStd());
	rb.setDauerMin(vb.getDauerMin());
	rb.setPreis(vb.getPreisString());
	
	rb.setStartUhrzeit("24:00");
	rb.setZielUhrzeit(vb.tagesZeitPlusDauer(24.0));
	
	response.sendRedirect("./RechnungView.jsp");
}
%>
</body>
</html>
