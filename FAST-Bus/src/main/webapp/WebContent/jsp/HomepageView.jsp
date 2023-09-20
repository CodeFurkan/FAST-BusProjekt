<%@page import="de_hwg_lu.fastBus.beans.LoginBean"%>
<%@page import="de_hwg_lu.fastBus.beans.HomepageBean"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
   
    <title>FASt-Bus</title>
    <script language="javascript" type="text/javascript" src="../js/FormularBox.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@500&family=Poppins:ital,wght@0,200;0,500;1,100;1,200&display=swap"
      rel="stylesheet"
    />
	<link type="text/css" rel="stylesheet" href="../css/headerAndNavbar.css" />
    <link type="text/css" rel="stylesheet" href="../css/main1.0.css" />
    <link type="text/css" rel="stylesheet" href="../css/main2.0.css" />
    <link type="text/css" rel="stylesheet" href="../css/footer.css" />
  </head>
  
  	<!-- JSP USEBEAN  -->
	<jsp:useBean id="hb" class="de_hwg_lu.fastBus.beans.HomepageBean"
		scope="session" />
	<jsp:useBean id="loginBean" class="de_hwg_lu.fastBus.beans.LoginBean"
	scope="session" />
	<!-- JSP USEBEAN  -->
  
  
  <body>
  
		
    <div class="container">
    						  <!-- Navbar -->
      <header>
           <jsp:getProperty name="hb" property="navbarWithLoginAsHtml" />
      </header>
							<!-- Navbar end -->


							  <!-- main box -->	
      <main>
        	<!-- Box f�r Verbindungssuche -->
        <form action="./HomepageAppl.jsp" method="get">
         
         <jsp:getProperty name="hb" property="formularBoxAsHtml" />
        
        </form>
             <!-- Box f�r Verbindungssuchee -->
        
        
        
        <article>
          <div class="content-Body">
            <header class="�berschrift">
              <h1>Die meist besuchten St�dte Deutschlands</h1>
            </header>
            <div class="herocontainer-F�rAlleSt�dte">
              <div class="stadtContainer">
                <div class="stadt">
                  <a class="stadt-imgContainer" href="">
                    <span>Berlin</span>
                    <img src="../img/berlin.jpeg" />
                  </a>
                </div>
                <div class="stadt">
                  <a class="stadt-imgContainer" href="">
                    <span>M�nchen</span>
                    <img src="../img/muenchen.jpeg" />
                  </a>
                </div>
              </div>
              <div class="stadtContainer">
                <div class="stadt">
                  <a class="stadt-imgContainer" href="">
                    <span>Frankfurt</span>
                    <img src="../img/frankfurt.jpeg" />
                  </a>
                </div>
                <div class="stadt">
                  <a class="stadt-imgContainer" href="">
                    <span>Hamburg</span>
                    <img src="../img/hamburg.jpeg" />
                  </a>
                </div>
              </div>
            </div>
          </div>
        </article>
      </main>
							  <!-- main box end -->	


      <!------------------ footer------------ -->
        <jsp:getProperty name="hb" property="footerAsHtml" />
      <!------------------ footer end------------ -->
            
    </div>
  </body>
</html>