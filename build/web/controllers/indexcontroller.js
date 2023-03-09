// function carregaMensagem()
// {   let div = document.getElementById("mensagem");
//     fetch('FraseServlet')
//             .then(res=>{res.text()
//                 .then(dados=>{div.innerHTML=dados})})
//             .catch (err=>{div.innerHTML=err} );    
// }

function enviaArquivo(e)
{
   event.preventDefault(); // evita refresh da tela
                
   const URL_TO_FETCH = 'UpServlet';
   
   const vNome = document.getElementById("Musica");
   vNome.value = vNome.value.replaceAll(/[\W_]/g,"");
   
   const vArtista = document.getElementById("Artista");
   vArtista.value = vArtista.value.replaceAll(/[\W_]/g,"");
   
   var formData = new FormData(document.getElementById("fdados"));

   //formData.append('acao', 'confirmar'); opcional, caso queira inserir outra informação
     
          fetch(URL_TO_FETCH, { method: 'post', body: formData 
          }).then((response)=> {
               return response.text();
          }).then((retorno)=> {
               
               document.getElementById("feedback").innerHTML=retorno;
               document.getElementById("fdados").reset();
          }).catch(function (error) {
               console.error(error);
          });
     
   
 
}

