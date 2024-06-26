
// cuando se recarga la pagina llama los usuarios de la lista
$(document).ready(function () {
  cargarUsuario()
  $('#usuarios').DataTable();
});



async function cargarUsuario() {
  try {
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

      let botonEliminar = '<a href="#" onclick="eliminarUsuario(' + usuario.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>'

      let usuariosHtml = '<tr><td>' + usuario.id + '</td><td>' + usuario.nombre + ' ' + usuario.apellido + '</td><td>' + usuario.email + '</td><td>' + (usuario.telefono ? usuario.telefono : '') +
                '</td><td>' + botonEliminar + '</td></tr>';

      listadoHtml += usuariosHtml;
    }
    console.log(usuarios);

    // Actualizar el contenido de la tabla
    document.querySelector('#usuarios tbody').outerHTML = listadoHtml;
  } catch (error) {
    console.error('Error:', error);
    alert('Hubo un problema al cargar los usuarios.');
  }

}

async function eliminarUsuario(id) {
  const response = await fetch('api/usuarios/' + id, {
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

}