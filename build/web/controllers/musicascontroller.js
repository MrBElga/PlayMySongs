
function listarMusicas(e) {
  event.preventDefault(); // evita refresh da tela

  const URL_TO_FETCH = "ListaMusicasServlet";
  const tab = document.getElementById("tabDados");
  tab.innerHTML = "";
  
  const buscaMusica = document.getElementById("buscaMusicas");
  const buscaArtista = document.getElementById("buscaArtistas");
  const buscaEstilo = document.getElementById("buscaEstilos");

  fetch(URL_TO_FETCH, { method: "post"})
    .then((response) => {
      return response.text();
    })
    .then((retorno) => {
        let arrMusicas = retorno.split("\n");
        
        
        for(i = 0; i < arrMusicas.length; i++) {
            if(arrMusicas[i] != "") {
                let tr = document.createElement("tr");
                let td = document.createElement("td");
                let audioc = document.createElement("audio");
                let p = document.createElement("h4");
                const info = arrMusicas[i].split("_");
                info[2] = info[2].replace(".mp3","");
                if(info[0].includes(buscaMusica.value)  && (info[1]===(buscaEstilo.value) || buscaEstilo.value === "") && info[2].includes(buscaArtista.value)) {
                    p.innerHTML = "Título: " + info[0] + "<br>Estilo: " + info[1] + "<br>Artista: " + info[2];
                    audioc.setAttribute("type","audio/mp3");
                    audioc.setAttribute("src","musicas/" + arrMusicas[i]);
                    audioc.setAttribute("controls","");
                    td.appendChild(p);
                    td.appendChild(audioc); 
                    tr.appendChild(td);
                    tab.appendChild(tr);     
                }
                   
            }
            
        }
        
    })
    .catch(function (error) {
      console.error(error);
    });
}
