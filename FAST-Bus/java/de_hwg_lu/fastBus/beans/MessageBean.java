package de_hwg_lu.fastBus.beans;

public class MessageBean {
	
	String informationsMsg;
	String actionMsg;
	
	public MessageBean() {
		this.setGeneralWelcome();
		this.setRegistrationWelcome();
	}
	public void setGeneralWelcome(){
		
	this.setInformationsMsg("Ein Schritt entfernt von Ihrer großen Reise.");
	this.setActionMsg("Bitte melden Sie sich an");
		
	}
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
	public void setAnyError() {
		this.setInformationsMsg("Es ist ein unbekannter Fehler .");
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
