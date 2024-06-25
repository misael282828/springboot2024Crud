
// Call the dataTables jQuery plugin
$(document).ready(function () {
  cargarUsuario()
  $('#usuarios').DataTable();
});



async function cargarUsuario() {

  // Fetching data from the server
  const response = await fetch('api/usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

  // Parsing the response body as JSON
  const usuarios = await response.json();

  let listadoHtml = ''

  for (let usuario of usuarios) {

    let  botonEliminar =  '<a href="#" onclick="eliminarUsuario(' + usuario.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>'
    let usuariosHtml = '<tr><td></td><td>' + usuario.nombre + ' ' + usuario.apellido + '</td><td>' + usuario.email + '</td><td>' + usuario.telefono +
      '</td><td>'+botonEliminar+'</td></tr>'

    listadoHtml += usuariosHtml;
  }

  // Logging the fetched data (for demonstration)
  //console.log(usuarios);

  document.querySelector('#usuarios tbody').outerHTML = listadoHtml;
  ;

}

async function eliminarUsuario(id){
  const response = await fetch('api/usuarios/'+ id, {
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

}