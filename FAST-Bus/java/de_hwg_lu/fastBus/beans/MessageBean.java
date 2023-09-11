package de_hwg_lu.fastBus.beans;

public class MessageBean {
	
	String informationsMsg;
	String actionMsg;
	
	public MessageBean() {
		this.setGeneralWelcome();
		this.setRegistrationWelcome();
//		this.setAccountAngelegt();
//		this.setAccountVorhanden(actionMsg);
//		this.setLogin(actionMsg);
//		this.setLoginFailed();
//		this.setLoggedOut();
//		this.setNotLoggedIn();	
		
	}
	public void setGeneralWelcome(){
		
	this.setInformationsMsg("Ein Schritt entfernt von Ihrer großen Reise.");
	this.setActionMsg("Bitte melden Sie sich an");
		
	}
	//Reg-Methoden
	public void setRegistrationWelcome() {
		this.setInformationsMsg("Planen Sie ihre n&auml;chste Reise mit FASt-Bus.");
		this.setActionMsg("Bitte registrieren Sie sich");
		
	}
	public void setAccountAngelegt(String email) {
		this.setInformationsMsg("Account "+email+ "erfolgreich angelegt.");
		this.setActionMsg("Melden Sie sich an.");
	}
	public void setAccountVorhanden(String email) {
		this.setInformationsMsg("Account "+email+ " ist ung&uuml;ltig.");
		this.setActionMsg("Bitte verwenden Sie eine g&uuml;ltige E-mail.");
	}
	//Login-Methoden
	public void setLogin(String email) {
		this.setInformationsMsg("Willkommen bei FASt-Bus.");
		this.setActionMsg("Ihre Reise beginnt hier.");
	}
	public void setLoginFailed() {
		this.setInformationsMsg("Ihre Anmeldung konnte nicht abgeschlossen werden.");
		this.setActionMsg("Bitte versuchen Sie es erneut.");
	}
	public void setLoggedOut() {
		this.setInformationsMsg("Sie haben sich abgemeldet.");
		this.setActionMsg("Bitte melden sie sich wieder an, um ihre n&auml;chste Reise zu planen.");
	}
	public void setNotLoggedIn() {
		this.setInformationsMsg("Sie sind nicht angemeldet.");
		this.setActionMsg("Bitte melden sie sich an, um ihre Reise zu planen.");
		
	}
	//Falls ein Fehler auftretet
	
	public void setAnyError() {
		this.setInformationsMsg("Es ist ein unbekannter Fehler aufgetreten.");
		this.setActionMsg("Bitte wenden Sie sich an den Support.");
	}
	
	public String getInformationsMsg() {
		return informationsMsg;
	}

	public void setInformationsMsg(String informationsMsg) {
		this.informationsMsg = informationsMsg;
	}

	public String getActionMsg() {
		return actionMsg;
	}

	public void setActionMsg(String actionMsg) {
		this.actionMsg = actionMsg;
	}

}
