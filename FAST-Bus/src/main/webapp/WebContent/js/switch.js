
function setButtonClicked(btnName) {
	document.buttonClicked = btnName;
}
function switchIt() {
	var startStadt = document.getElementById("inputStart");
	var zielStadt = document.getElementById("inputEnd");
	var merker = startStadt.value;
	document.getElementById('inputStart').value = document.getElementById('inputEnd').value;
	document.getElementById('inputEnd').value = merker;
}
function stadt(myStadt) {
	var zielStadt = document.getElementById("inputEnd");
	zielStadt.value = myStadt;
}
function datum() {
	//für calendar vergangenheit disable
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
	document.getElementById("dateInput").setAttribute("min", today);
	
}

function einTagDavor(){
	
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

	today = dd + '.' + mm + '.' + yyyy;
	
	var ausgewaehlterTag = document.getElementById("ausgewaehlterTag").innerText;
	if(today==ausgewaehlterTag){
		return false;
	}
	return true;
}
function checkSelbeStadt(verbindungSuche) {
	var verbindungSuche = true;
	if (document.buttonClicked == "btnVerbindung") {
	var startStadt=document.getElementById('inputStart').value;
	var zielStadt=document.getElementById('inputEnd').value;
	
		if (startStadt == zielStadt) {
			var myMsgField = document.getElementById("selbeStadtMsg");
			selbeStadtMsg.innerText = "Verschiedene Städte auswählen";
			verbindungSuche = false;
			return verbindungSuche;
		}
		startStadt
	}
	return verbindungSuche;
}
var clicked;
function ueberbuchung(verbindungen){
	var verbindungSuche = true;
	if (document.buttonClicked == "btnZumAngebot") {
	var plaetzefrei=document.getElementById('freiePlaetze'+clicked).innerText;

	var wunschplaetze=document.getElementById('invisibleWunschPlaetze').innerText;

		if(plaetzefrei < wunschplaetze){
			verbindungSuche=false;
		}
	}
	return verbindungSuche;
}

// JavaScript-Funktion, um den A-Tag auszulösen, wenn auf das Bild geklickt wird
var klickElemente = document.getElementsByClassName("klickElement");

for (var i = 0; i < klickElemente.length; i++) {
  klickElemente[i].addEventListener("click", function() {
    var parentDiv = this.closest(".nachtag"); // Das Elternelement mit der Klasse "nachtag" finden
    var linkTag = parentDiv.querySelector("a"); // Das nächste <a>-Tag innerhalb des Elternelements finden
    if (linkTag) {
      linkTag.click(); // A-Tag auslösen
    }
  });
}