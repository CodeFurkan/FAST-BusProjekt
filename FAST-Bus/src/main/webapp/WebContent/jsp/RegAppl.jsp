<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String vorname = request.getParameter("vorname");
	String nachname = request.getParameter("nachname");
	String alter = request.getParameter("alter");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String btnsubmit = request.getParameter("btnsubmit");
	String zumLogin = request.getParameter("zumLogin");
	
	if(btnsubmit == null) btnsubmit="";
	if(zumLogin == null) zumLogin="";
	
	if(btnsubmit.equals("kostenlos registrieren")){
		response.sendRedirect("./");
	}else if(zumLogin.equals("zumLogin")){
		response.sendRedirect("./LoginView.jsp");
		
	}else{
		response.sendRedirect("./LoginView.jsp");
	}
	
	


%>
</body>
</html>