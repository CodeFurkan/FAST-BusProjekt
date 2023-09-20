<%@page import="java.util.Calendar"%>
<%@page import="de_hwg_lu.fastBus.beans.VerbindungBean"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
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
<jsp:useBean id="vb" class="de_hwg_lu.fastBus.beans.VerbindungBean"  scope="session" />

<jsp:useBean id="loginBean" class="de_hwg_lu.fastBus.beans.LoginBean" scope="session"/>

<%

String btnVerbindung = request.getParameter("btnVerbindung");
String inputStart = request.getParameter("inputStart");
String inputEnd = request.getParameter("inputEnd");
String stringDate = request.getParameter("date");


// System.out.println(stringDate);
	String test ="";
	String vortag ="";
	String nachtag ="";
	String blabla ="";
	String dingbing ="";
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

	// System.out.println("vortag "+yesterday);

	Date myDate = convertedCurrentDate;
	 test = new SimpleDateFormat("dd.MM.yyyy").format(myDate);
	 vortag = new SimpleDateFormat("dd.MM.yyyy").format(yesterday);
	 nachtag = new SimpleDateFormat("dd.MM.yyyy").format(tmrw);

	 blabla = new SimpleDateFormat("yyyy-MM-dd").format(yesterday);
	 dingbing = new SimpleDateFormat("yyyy-MM-dd").format(tmrw);

}catch(Exception e){
	e.printStackTrace();
}

// System.out.println("vortag "+vortag);
// System.out.println("nachtag "+nachtag);

// try {
//     date = dateFormat.parse(stringDate);
//     System.out.println(date);
// }
// catch (ParseException e) {
//     e.printStackTrace();
//  }

if(loginBean.isLoggedIn() == true){
	hb.setAnmeldung(true);
}
else{
	hb.setAnmeldung(false);
}


if(btnVerbindung == null ) btnVerbindung="";
//Hier muss evtl die Methode von der LoginBean hinzugefuegt werden wie zb in der PortalAppl.jsp VL 
//Falls ein Nutzer nicht eingeloggt ist wird der per Message aufgeforder dies zu tun


if(btnVerbindung.equals("Suchen")){
    vb.setStartStadt(inputStart);   
    vb.setZielStadt(inputEnd);  
    
 	vb.setVorTag(vortag);
 	vb.setNachTag(nachtag);
   	vb.setDatum(test);	
   	
   	vb.setVorTagFuerLink(blabla);
    vb.setNachTagFuerLink(dingbing);
    
	response.sendRedirect("./VerbindungView.jsp");
}else{
	response.sendRedirect("./HomepageView.jsp");
}




%>

</body>
</html>