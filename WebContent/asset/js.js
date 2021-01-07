
var radio_a = document.getElementById("radio_a");
var radio_v = document.getElementById("radio_v");
var achat = document.getElementById("achat");
var vente = document.getElementById("vente");
function affiche_achat() {
	achat.style.display = "inline";
	vente.style.display = "none";
}
function affiche_vente() {
	achat.style.display = "none";
	vente.style.display = "inline";
}

if (radio_a) {
	radio_a.addEventListener("click", affiche_achat);
}
if (radio_v) {
	radio_v.addEventListener("click", affiche_vente);
}
