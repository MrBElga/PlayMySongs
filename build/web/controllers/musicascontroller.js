
function listarMusicas(e) {
  event.preventDefault(); // evita refresh da tela

  const URL_TO_FETCH = "ListaMusicasServlet";
  const tab = document.getElementById("tabDados");

  fetch(URL_TO_FETCH, { method: "post"})
    .then((response) => {
      return response.text();
    })
    .then((retorno) => {
        let arrMusicas = retorno.split("\n");
        
        for(i = 0; i < arrMusicas.length; i++) {
            let tr = document.createElement("tr");
            let td = document.createElement("td");
            let audioc = document.createElement("audio");
            audioc.setAttribute("type","audio/mp3");
            audioc.setAttribute("src","musicas/" + arrMusicas[i]);
            audioc.setAttribute("controls","");
            td.appendChild(audioc);
            tr.appendChild(td);
            tab.appendChild(tr); 
        }
        
    })
    .catch(function (error) {
      console.error(error);
    });
}
