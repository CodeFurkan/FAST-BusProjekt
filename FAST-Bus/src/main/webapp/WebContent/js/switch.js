function switchIt() {
	
	var startStadt = document.getElementById("inputStart");
	var zielStadt = document.getElementById("inputEnd");
	var merker = startStadt.value;
	startStadt.value=zielStadt.value;
	zielStadt.value=merker;
}
function stadt(myStadt){
//	alert(myStadt);
	var zielStadt = document.getElementById("inputEnd");
	zielStadt.value=myStadt;
}