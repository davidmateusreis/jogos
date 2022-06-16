var form = document.querySelector("form");

var title = document.querySelector(".titulo");
var developer = document.querySelector(".desenvolvedor");
var publisher = document.querySelector(".publicador");
var genre = document.querySelector(".genero");
var region = document.querySelector(".regiao");

function save() {

    fetch("http://localhost:8080/jogos",
    {
        
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
            titulo: title.value,
            desenvolvedor: developer.value,
            publicador: publisher.value,
            genero: genre.value,
            regiao: region.value
        })
    })
    .then(function (res) { console.log(res) })
    .catch(function (res) { console.log(res) })

};

function clear() {
    
    title.value = "";
    developer.value = "";
    publisher.value = "";
    genre.value = "";
    region.value = "";

};

form.addEventListener('submit', function (event) {
    event.preventDefault();
    location. href = "jogos.html";

    save();
    clear();
});