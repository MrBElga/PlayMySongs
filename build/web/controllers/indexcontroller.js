// function carregaMensagem()
// {   let div = document.getElementById("mensagem");
//     fetch('FraseServlet')
//             .then(res=>{res.text()
//                 .then(dados=>{div.innerHTML=dados})})
//             .catch (err=>{div.innerHTML=err} );
// }

function verificaReg(vNome) {
  vNome.value = vNome.value.replaceAll(/[\W_]/g, "");
}

function enviaArquivo(e) {
  event.preventDefault(); // evita refresh da tela

  const URL_TO_FETCH = "UpServlet";
  const vNome = document.getElementById("Musica");
  const vArtista = document.getElementById("Artista");

  verificaReg(vNome);
  verificaReg(vArtista);

  //vArtista.value = vArtista.value.replaceAll(/[\W_]/g,"");

  //formData.append('acao', 'confirmar'); opcional, caso queira inserir outra informação
  var formData = new FormData(document.getElementById("fdados"));
  fetch(URL_TO_FETCH, { method: "post", body: formData })
    .then((response) => {
      return response.text();
    })
    .then((retorno) => {
      document.getElementById("feedback").innerHTML = retorno;
      document.getElementById("fdados").reset();
    })
    .catch(function (error) {
      console.error(error);
    });
}
