<%@page import="de_hwg_lu.fastBus.beans.MessageBean"%>
<%@page import="de_hwg_lu.fastBus.beans.HomepageBean"%>
<%@page import="de_hwg_lu.fastBus.beans.LoginBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jetzt anmelden</title>
 <link rel="stylesheet" type="text/css" href="../css/login.css">
 
 	 <link type="text/css" rel="stylesheet" href="../css/headerAndNavbar.css" />
    <link rel="stylesheet" type="text/css" href="../css/footer.css">
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com"  />
     <link
      href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@500&family=Poppins:ital,wght@0,200;0,500;1,100;1,200&display=swap"
      rel="stylesheet"
    />
</head>
<body>
	<jsp:useBean id="navbar" class="de_hwg_lu.fastBus.beans.HomepageBean" scope="session" />
	<jsp:useBean id="loginBean" class="de_hwg_lu.fastBus.beans.LoginBean" scope="session"/>
	<jsp:useBean id="msgBean" class="de_hwg_lu.fastBus.beans.MessageBean" scope="session"/>

<!--  
<header> <img src="../img/logo1.png" id="logoImg"/></header>
-->
   						  <!-- Navbar -->
      <header>
           <jsp:getProperty name="navbar" property="navbarWithLoginAsHtml" />
      
      </header>
							<!-- Navbar end -->
<h2><jsp:getProperty name="msgBean" property="informationsMsg" />	</h2>					
<h2><jsp:getProperty name="msgBean" property="actionMsg" />	</h2>	
<main>
 <form action="./LoginAppl.jsp" method="get">
            <div class="hero-container">
                <div class="hero-content">
                    <div class="hero-login-box">
                        <div class="login-box-all-items">
                            <div class="login-box-header">
                                <h1>Anmelden</h1>
                            </div>
                            <div class="email">
                                <label for ="email">E-Mail</label> <br>
                                <input type="email" name="email"  required placeholder="beispiel@beispiel.de" />
                            </div>

                            <div class="password">
           
                                <label for="password">Passwort</label>    <br>
                                 <input type="password" name="password" id="Passwort" required />
                                 <br>
                             </div>
                             <br>
                             <div class="login">
                                <button type="submit" name="btnsubmit" value="Anmelden" class="btnsubmit">Anmelden</button>
                            </div>
                            <div>
                                <p>Sie haben noch kein Konto?
                                    <a href="./LoginAppl.jsp?zurReg=zurReg" class="reg">Registrieren</a>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>       
        </form>
   </main>
   
   <footer>
      <footer class="footer-distributed">
  
        <div class="footer-left">
  
          <a href="#" class="link-1">
            <h3>FASt<span>BUS</span></h3>
          </a>
  
          <p class="footer-links">
            <a href="#" class="link-1">Home</a>
  
            <span class="nein"><a href="#">Alle Städte</a></span>
  
            <span class="nein"><a href="#">Meine Buchungen</a></span>
  
            <span class="nein"><a href="#">Hilfe</a></span>
  
          </p>
  
          <p class="footer-company-name">FAStBUS © 2023</p>
        </div>
  
        <div class="footer-center">
          <div>
            <i class="fa fa-phone"><img src="../img/phone-24.png" alt="" width="18px"></i>
            <p>+49 176 32985346</p>
          </div>
  
          <div>
            <i class="fa fa-envelope"><img src="../img/email-3-24.png" alt="" width="18px"></i>
            <p><a href="mailto:support@company.com">sema.saglam@live.de</a></p>
          </div>
  
        </div>
  
        <div class="footer-right">
  
          <p class="footer-company-about">
            <span>Über das Unternehmen</span>
            FAStBUS ist ein führendes Busreiseunternehmen, das sich auf sichere und zuverlässige Fahrten zu jeder
            Tageszeit spezialisiert hat.
            Unser Ziel ist es, unseren Kunden stressfreie und komfortable Reisen zu bieten und dabei höchste
            Sicherheitsstandards zu gewährleisten
          </p>
        </div>
  
      </footer>
    </footer>
</body>
</html>