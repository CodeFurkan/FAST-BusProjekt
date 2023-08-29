<%@page import="de_hwg_lu.fastBus.beans.RegBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jetzt Registrieren</title>
</head>
   <link rel="stylesheet" type="text/css" href="../css/reg.css">
    <link rel="stylesheet" type="text/css" href="../css/footer.css">
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@500&family=Poppins:ital,wght@0,200;0,500;1,100;1,200&display=swap"
      rel="stylesheet"
    />
<body>
<jsp:useBean id="regBean" class="de_hwg_lu.fastBus.beans.RegBean" scope="session"/>
  <header> <img src="../img/logo1.png" id="logoImg"/></header>
  <main>
  	 <form action="./RegAppl.jsp" method="get">
            <div class="hero-container">
                <div class="hero-content">
                    <div class="hero-reg-box">
                        <div class="reg-box-all-items">
                            <div class="reg-box-header">
                                <h1>Konto erstellen</h1>
                            </div>
                            <div class="reg-box-main">
                            <div class="vorname">
                              <label for ="vorname">Vorname</label> 
                              <input type="text" name="vorname"  required />
                         	</div>
                        	<div class="nachname">
                              <label for="nachname">Nachname</label>    
                               <input type="text" name="nachname" required />
                               <br>
                          	</div>
                     
                         	<div class="alter">
                            <label for ="alter">Geburtsdatum</label> 
                            <input type="date" name="alter"  />
                       		</div>
                           
                            <div class="email">
                                <label for ="email">E-Mail</label> 
                                <input type="email" name="email"  required placeholder="beispiel@beispiel.de" />
                            </div>
                            <div class="password">
           
                                <label for="password">Passwort</label>    
                                 <input type="password" name="password" required />
                                 <br>
                            </div>
                      
                            <div class="regist">
                                <button type="submit" name="btnsubmit" class="btnsubmit">kostenlos registrieren</button>
                            </div>
                            <div>
                              <p>Sie haben ein Konto?
                                <a href="./RegAppl.jsp?zumLogin=zumLogin" class="log">Jetzt anmelden</a>
                              </p>
                            </div>
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