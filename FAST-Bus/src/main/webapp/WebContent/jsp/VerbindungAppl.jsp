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
<jsp:useBean id="msgBean" class="de_hwg_lu.fastBus.beans.MessageBean" scope="session"/>
<%

String btnZumAngebot = request.getParameter("btnZumAngebot");

if(btnZumAngebot == null ) btnZumAngebot="";

msgBean.setInformationsMsg("");
msgBean.setActionMsg("");

if(btnZumAngebot.equals("Zum Angebot6.0")){
// 	System.out.println("tesuonr1");
	rb.setStartStadt(vb.getStartStadt());
	rb.setZielStadt(vb.getZielStadt());
	rb.setDatum(vb.getDatum());
	
	rb.setDauerStd(vb.getDauerStd());
	rb.setDauerMin(vb.getDauerMin());
	rb.setPreis(vb.getPreisString());
	
	rb.setRoutenID(vb.getRoutenID());
	
	rb.setStartUhrzeit("06:00");
	rb.setZielUhrzeit(vb.tagesZeitPlusDauer(6.0));
	
	rb.setNextDay(vb.getNachTag());
	
	response.sendRedirect("./RechnungView.jsp");
}else if(btnZumAngebot.equals("Zum Angebot14.0")){
// 	System.out.println("tesutonr1");
	rb.setStartStadt(vb.getStartStadt());
	rb.setZielStadt(vb.getZielStadt());
	rb.setDatum(vb.getDatum());
	rb.setDauerStd(vb.getDauerStd());
	rb.setDauerMin(vb.getDauerMin());
	rb.setPreis(vb.getPreisString());
	
	rb.setRoutenID(vb.getRoutenID());
	
	rb.setStartUhrzeit("14:00");
	rb.setZielUhrzeit(vb.tagesZeitPlusDauer(14.0));
	
	rb.setNextDay(vb.getNachTag());
	
	response.sendRedirect("./RechnungView.jsp");
}else if(btnZumAngebot.equals("Zum Angebot22.0")){
// 	System.out.println("tesutnr1");
	rb.setStartStadt(vb.getStartStadt());
	rb.setZielStadt(vb.getZielStadt());
	rb.setDatum(vb.getDatum());
	rb.setDauerStd(vb.getDauerStd());
	rb.setDauerMin(vb.getDauerMin());
	rb.setPreis(vb.getPreisString());
	
	rb.setRoutenID(vb.getRoutenID());
	
	rb.setStartUhrzeit("22:00");
	rb.setZielUhrzeit(vb.tagesZeitPlusDauer(22.0));
	
	rb.setNextDay(vb.getNachTag());
	
	response.sendRedirect("./RechnungView.jsp");
}else{
	response.sendRedirect("./HomepageView.jsp");
}
%>
</body>
</html>
