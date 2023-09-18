<%@page import="de_hwg_lu.fastBus.beans.HomepageBean"%>
<%@page import="de_hwg_lu.fastBus.beans.LoginBean"%>
<%@page import="de_hwg_lu.fastBus.beans.MessageBean"%>
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
<jsp:useBean id="msgBean" class="de_hwg_lu.fastBus.beans.MessageBean" scope="session"/>
<jsp:useBean id="hb" class="de_hwg_lu.fastBus.beans.HomepageBean"  scope="session" />


<%
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String btnsubmit = request.getParameter("btnsubmit");
	String zurReg = request.getParameter("zurReg");
	String btnLogout = request.getParameter("btnLogout");
	
	if(btnsubmit == null) btnsubmit="";
	if(zurReg == null) zurReg="";
	//kaka
	if(btnsubmit.equals("Anmelden")){
		loginBean.setEmail(email);
		loginBean.setPassword(password);
		try{
		boolean accountFound = loginBean.checkEmailPassword();
		if(accountFound){
			loginBean.setLoggedIn(true);
			hb.setAnmeldung(true);
			msgBean.setLogin(email);
			System.out.println("Anmelden");
			response.sendRedirect("./HomepageView.jsp");
		}else{
			loginBean.setLoggedIn(false);
			msgBean.setLoginFailed();
			response.sendRedirect("./LoginView.jsp");
		}
		}catch(Exception e){
			msgBean.setAnyError();
			e.printStackTrace();
			response.sendRedirect("./LoginView.jsp");
		}
	
	}else if(zurReg.equals("zurReg")){
		msgBean.setRegistrationWelcome();
		response.sendRedirect("./RegView.jsp");
	}else if(btnLogout.equals("true")){
	loginBean.setLoggedIn(false);
		response.sendRedirect("./RechnungsView.jsp");
	}else{
		msgBean.setGeneralWelcome();
		response.sendRedirect("./LoginView.jsp");
	}
	
%>
</body>
</html>