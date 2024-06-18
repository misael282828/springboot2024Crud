
// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuario()
  $('#usuarios').DataTable();
});

// async function cargarUsuario( ) {
  
//   const request = await fetch('usuario/2828', {
//     method: 'GET',
//     headers: {
//       'Accept': 'application/json',
//       'Content-Type': 'application/json'
//     },
//   });
//   const usuarios = await request.json();

//   console.log("hola mundo");



// }

async function cargarUsuario() {
  
    // Fetching data from the server
    const response = await fetch('usuarios', {
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    });

    // Parsing the response body as JSON
    const usuarios = await response.json();

    let listadoHtml = ''

    for (let usuario of usuarios){

      let usuariosHtml = '<tr><td>'+usuario.id+'</td><td>'+usuario.nombre + ' ' + usuario.apellido+'</td><td>'+usuario.email+'</td><td>'+usuario.telefono+
      '</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>'

      listadoHtml+= usuariosHtml;
    }

    // Logging the fetched data (for demonstration)
    //console.log(usuarios);


    
    document.querySelector('#usuarios tbody').outerHTML = listadoHtml;
;
 
}
