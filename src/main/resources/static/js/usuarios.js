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
    const response = await fetch('usuario/22', {
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    });

   

    // Parsing the response body as JSON
    const usuario = await response.json();

    // Logging the fetched data (for demonstration)
    console.log(usuario);

    // You can add further processing of the usuario object here

 
}
