function setButtonClicked(btnName) {
	document.buttonClicked = btnName;
}
function switchIt() {
	var startStadt = document.getElementById("inputStart");
	var zielStadt = document.getElementById("inputEnd");
	var merker = startStadt.value;
	//	alert(merker);
	document.getElementById('inputStart').value = document.getElementById('inputEnd').value;
	document.getElementById('inputEnd').value = merker;
	//	startStadt.value=zielStadt.value;
	//	zielStadt.value=merker;
}
function stadt(myStadt) {
	//	alert(myStadt);
	var zielStadt = document.getElementById("inputEnd");
	zielStadt.value = myStadt;
}
function datum() {

	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth() + 1;
	var yyyy = today.getFullYear();
	if (dd < 10) {
		dd = '0' + dd
	}
	if (mm < 10) {
		mm = '0' + mm
	}

	today = yyyy + '-' + mm + '-' + dd;
	//alert(today);
	document.getElementById("dateInput").setAttribute("min", today);
}
function checkSelbeStadt(verbindungSuche) {
	var verbindungSuche = true;
	if (document.buttonClicked == "btnVerbindung") {
		if (document.getElementById('inputStart').value == document.getElementById('inputEnd').value) {
			var myMsgField = document.getElementById("selbeStadtMsg");
			selbeStadtMsg.innerText = "Verschiedene Städte auswählen";
			verbindungSuche = false;
		}
//		if(document.getElementById('inputStart').value == 'Von...' || document.getElementById('inputEnd').value=='Nach...'){
//			var myMsgField = document.getElementById("selbeStadtMsg");
//			selbeStadtMsg.innerText = "Gewünschte Route bitte eingeben";
//			verbindungSuche = false;
//		}
	}
	return verbindungSuche;
}