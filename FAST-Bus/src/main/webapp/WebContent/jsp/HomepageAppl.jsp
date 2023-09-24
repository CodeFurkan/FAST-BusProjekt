<%@page import="java.util.Calendar"%>
<%@page import="de_hwg_lu.fastBus.beans.VerbindungBean"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Date"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="de_hwg_lu.fastBus.beans.HomepageBean"%>
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" --%>
<%--     pageEncoding="ISO-8859-1"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="hb" class="de_hwg_lu.fastBus.beans.HomepageBean"  scope="session" />
<jsp:useBean id="vb" class="de_hwg_lu.fastBus.beans.VerbindungBean"  scope="session" />
<jsp:useBean id="rb" class="de_hwg_lu.fastBus.beans.RechnungBean" scope="session"/>
<jsp:useBean id="loginBean" class="de_hwg_lu.fastBus.beans.LoginBean" scope="session"/>
<jsp:useBean id="mbb" class="de_hwg_lu.fastBus.beans.MeineBuchungenBean" scope="session"/>

<%

String btnVerbindung = request.getParameter("btnVerbindung");
String inputStart = request.getParameter("inputStart");
String inputEnd = request.getParameter("inputEnd");
String stringDate = request.getParameter("date");
String meineBuchungen = request.getParameter("meineBuchungen");
String quantity = request.getParameter("quantity");


	String test ="";
	String vortag ="";
	String nachtag ="";
	String blabla ="";
	String dingbing ="";
	int wunschplaetze=0;
	
try{
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date convertedCurrentDate = sdf.parse(stringDate);
	String date=sdf.format(convertedCurrentDate );


	Calendar calendar = Calendar.getInstance();
	calendar.setTime(convertedCurrentDate); //heute
	//vortag->
	calendar.add(Calendar.DATE, -1);
	Date yesterday = calendar.getTime();
	//nachtag->
	calendar.add(Calendar.DATE, +2);
	Date tmrw = calendar.getTime();


	Date myDate = convertedCurrentDate;
	 test = new SimpleDateFormat("dd.MM.yyyy").format(myDate);
	 vortag = new SimpleDateFormat("dd.MM.yyyy").format(yesterday);
	 nachtag = new SimpleDateFormat("dd.MM.yyyy").format(tmrw);

	 blabla = new SimpleDateFormat("yyyy-MM-dd").format(yesterday);
	 dingbing = new SimpleDateFormat("yyyy-MM-dd").format(tmrw);
	 
	 wunschplaetze=Integer.parseInt(quantity);
	 
}catch(Exception e){
	e.printStackTrace();
}

if(loginBean.isLoggedIn() == true){
	hb.setAnmeldung(true);
}
else{
	hb.setAnmeldung(false);
}
if(btnVerbindung == null ) btnVerbindung="";

if(btnVerbindung.equals("Suchen")){
    vb.setStartStadt(inputStart);   
    vb.setZielStadt(inputEnd);  
    hb.setInputStart(inputStart);   
    hb.setInputEnd(inputEnd); 
    vb.setWunschplaetze(wunschplaetze);
    
 	vb.setVorTag(vortag);
 	vb.setNachTag(nachtag);
   	vb.setDatum(test);
   	
   	vb.setDatumUnformatiert(stringDate);
   	vb.setVorTagFuerLink(blabla);
    vb.setNachTagFuerLink(dingbing);
    
	response.sendRedirect("./VerbindungView.jsp");
}else if(meineBuchungen.equals("meineBuchungen")){
	if(hb.isAnmeldung()){
		mbb.setEmail(rb.getEmail());
		mbb.getMeineBuchungAsHtml();
		response.sendRedirect("./meineBuchungenView.jsp");
	}else{
		response.sendRedirect("./LoginView.jsp");
	}
}else{
	response.sendRedirect("./HomepageView.jsp");
}

%>

</body>
</html>