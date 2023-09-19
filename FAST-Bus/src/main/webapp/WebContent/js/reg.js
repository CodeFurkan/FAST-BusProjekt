function setButtonClicked(btnName){
	document.buttonClicked = btnName;

}
function togglePw(){
	var myPasswordField = document.getElementById("passwordField");
	if(myPasswordField.type == "password"){
		myPasswordField.type ="text";
	}else{
		myPasswordField.type ="password"
	}
}
function checkInput(myForm){
	var myFormOk =true;
	if(document.buttonClicked =="btnRegister"){
		var vornameOk = checkVorname(myForm.vorname.value);
		if(!vornameOk) myFormOk = false;
		
		var nachnameOk = checkNachname(myForm.nachname.value);
		if(!nachnameOk) myFormOk= false;
		
		if(!checkGeburtsdatum(myFormOk.geburtsdatum.value)) myFormOk = false;
		if (!checkEmail(myForm.email.value)) myFormOk = false;
		if(!checkPassword(myForm.password.value)) myFormOk = false;
	
	}
	return myFormOk;
}
function checkVorname(myVorname){
	var myMsgField = document.getElementById("vorname");
	if(myVorname){
		myMsgField.innerText= "";
		return true;
	}else{
		myMsgField.innerText = "Bitte geben Sie ihren Vornamen ein."
		return false;
	}
}
function checkNachname(myNachname){
	var myMsgField = document.getElementById("nachname");
	if(myNachname){
		myMsgField.innerText= "";
		return true;
	}else{
		myMsgField.innerText = "Bitte geben Sie ihren Nachnamen ein."
		return false;
	}
}

function checkGeburtsdatum(myGeburtsdatum){
	var myMsgField = document.getElementById("geburtsdatum");
	if (myGeburtsdatum){
		myMsgField.innerText = "";
		return true;
	}else{
		myMsgField.innerText = "Bitte w&auml;hlen Sie ihr Geburtsdatum aus.";
		return false;
	}
}
function checkEmail(myEmail){
	var myMsgField = document.getElementById("email");
	if (myEmail){
		myMsgField.innerText = "";
		return true;
	}else{
		myMsgField.innerText = "Bitte geben Sie ihre E-mail ein.";
		return false;
	}
}
function checkPassword(myPassword){
	var myMsgField = document.getElementById("password");
	if (myPassword){
		if (myPassword.length >= 6){
			myMsgField.innerText = "";
			return true;
		}else{
			myMsgField.innerText = "Passwort muss mindestens 6 Zeichen haben";
			return false;
		}
	}else{
		myMsgField.innerText = "Passwort darf nicht leer sein";
		return false;
	}
}


/*
function isEmailValid(email){
	const emailMuster = /^[^/s@]+@[^\s@]+\.[^\s@]+$/;
	return emailMuster.test(email);
}

//Methode die Laenge des PW bestimmt
function hasMinLength(password){
	return password.length >= 8;
	}
//Methode die Grossbuchstaben bestimmt
function hasCapLetter(password){
	return/[A-Z]/.test(password);
	
}
//Methode bestimmt Zahlen in PW
function hasNumber(password){
	return /\d/.test(password)
}

*/