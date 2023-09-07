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
<!--  Bean einbinden, Methoden von Bean einfügen --> 
<%
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String btnsubmit = request.getParameter("btnsubmit");
	String zurReg = request.getParameter("zurReg");
	
	
	if(btnsubmit == null) btnsubmit="";
	if(zurReg == null) zurReg="";
	
	if(btnsubmit.equals("Anmelden")){
		
		response.sendRedirect(".HomepageView.jsp");
		}
	else if(zurReg.equals("zurReg")){
		response.sendRedirect("./RegView.jsp");
	}else{
		response.sendRedirect("./LoginView.jsp");
	}
	
%>
</body>
</html>