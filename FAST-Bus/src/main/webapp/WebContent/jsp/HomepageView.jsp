<%@page import="de_hwg_lu.fastBus.beans.HomepageBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>FASt-Bus</title>
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@500&family=Poppins:ital,wght@0,200;0,500;1,100;1,200&display=swap"
      rel="stylesheet"
    />

    <link type="text/css" rel="stylesheet" href="../css/main1.0.css" />
    <link type="text/css" rel="stylesheet" href="../css/main2.0.css" />
	  <link type="text/css" rel="stylesheet" href="../css/headerAndNavbar.css" />

    <link type="text/css" rel="stylesheet" href="../css/footer.css" />
  </head>
  
  
  
  <body>
  	<!-- JSP USEBEAN  -->
	<jsp:useBean id="navbar" class="de_hwg_lu.fastBus.beans.HomepageBean"
		scope="session" />
	<!-- JSP USEBEAN  -->
		
		
    <div class="container">
    						  <!-- Navbar -->
      <header>
           <jsp:getProperty name="navbar" property="navbarWithLoginAsHtml" />
      
      </header>
							<!-- Navbar end -->


							  <!-- main box -->	
      <main>
        	<!-- Box für Verbindungssuche -->
        <form action="./HomepageAppl.jsp" method="get">
         
         <jsp:getProperty name="navbar" property="formularBoxAsHtml" />
        
        </form>
             <!-- Box für Verbindungssuche -->
        
        
        
        <article>
          <div class="content-Body">
            <header class="überschrift">
              <h1>Die meist besuchten Städte Deutschlands</h1>
            </header>
            <div class="herocontainer-FürAlleStädte">
              <div class="stadtContainer">
                <div class="stadt">
                  <a class="stadt-imgContainer" href="">
                    <span>Berlin</span>
                    <img src="../img/berlin.jpeg" />
                  </a>
                </div>
                <div class="stadt">
                  <a class="stadt-imgContainer" href="">
                    <span>München</span>
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
        <jsp:getProperty name="navbar" property="footerAsHtml" />
      <!------------------ footer end------------ -->
            
    </div>
  </body>
</html>