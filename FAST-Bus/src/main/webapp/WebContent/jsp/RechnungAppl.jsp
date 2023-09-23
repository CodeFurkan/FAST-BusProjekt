<%@page import="de_hwg_lu.fastBus.beans.MessageBean"%>
<%@page import="de_hwg_lu.fastBus.beans.LoginBean"%>
<%@page import="de_hwg_lu.fastBus.beans.RechnungBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="loginBean" class="de_hwg_lu.fastBus.beans.LoginBean" scope="session"/>
<jsp:useBean id="rb" class="de_hwg_lu.fastBus.beans.RechnungBean" scope="session"/>
<jsp:useBean id="msgBean" class="de_hwg_lu.fastBus.beans.MessageBean" scope="session"/>
<%
	String vorname = request.getParameter("vorname");
	String nachname = request.getParameter("nachname");
	String email = request.getParameter("email");
	String adresse = request.getParameter("adresse");
	String plz =  request.getParameter("plz");
	String stadt =  request.getParameter("stadt");
	
	String nameKonto =  request.getParameter("nameKonto");
	String iban =  request.getParameter("iban");
	String bic =  request.getParameter("bic");
	
	String btnJetztKaufen =  request.getParameter("btnJetztKaufen");
	
	if(btnJetztKaufen ==null) btnJetztKaufen ="";
	
	if(!loginBean.isLoggedIn()){
		msgBean.setNotLoggedIn();
		response.sendRedirect("./LoginView.jsp");
		
	}else if(btnJetztKaufen.equals("jetzt kaufen")){
		

		rb.setAdresse(adresse);
		rb.setStadt(stadt);
		rb.setPlz(plz);
		rb.setIban(iban);
		rb.setBic(bic);
		rb.setNameKonto(nameKonto);
		rb.insertIntoBuchung();
		rb.insertIntoBusInfo();
		
		response.sendRedirect("./BestaetigungView.jsp");
		
	}else{
		response.sendRedirect("./HomepageView.jsp");
	}
%>
</body>
</html>