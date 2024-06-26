

// cuando se recarga la pagina llama los usuarios de la lista
$(document).ready(function () {
  //on ready
});



// async function registrarUsuario() {

//   let datos = {};
//   datos.nombre = document.getElementById('txtNombre').value;
//   datos.apellido = document.getElementById('txtApellido').value;
//   datos.email = document.getElementById('txtEmail').value;
//   datos.password = document.getElementById('txtPassword').value;
  
//   let txtRepetirPassword = document.getElementById('txtRepetirPassword').value; 

//   if(txtRepetirPassword != datos.password){
//     alert("Contraseñas no coinciden!")
//     return
//   }
  
//   const response = await fetch('api/usuarios', {
//     method: 'POST',
//     headers: {
//       'Accept': 'application/json',
//       'Content-Type': 'application/json'
//     }
//   });

//   // Parsing the response body as JSON
//   const usuarios = await response.json();

//  body:JSON.stringify({datos})
// })
// .then(response => response.json())
// .then(data => console.log(data))
// .catch(error => console.error('Error:', error));
//  console.log(datos);

// }

async function registrarUsuario() {
  let datos = {};
  datos.nombre = document.getElementById('txtNombre').value;
  datos.apellido = document.getElementById('txtApellido').value;
  datos.email = document.getElementById('txtEmail').value;
  datos.password = document.getElementById('txtPassword').value;
  
  let txtRepetirPassword = document.getElementById('txtRepetirPassword').value; 

  if (txtRepetirPassword !== datos.password) {
      alert("¡Las contraseñas no coinciden!");
      return;
  }

  try {
      const response = await fetch('api/usuarios', {
          method: 'POST',
          headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
          },
          body: JSON.stringify(datos)  // Corrected here
      });

      if (!response.ok) {
          throw new Error('Error en la solicitud: ' + response.statusText);
      }

      const usuarios = await response.json();
     
      alert('Usuario registrado con éxito!');
  } catch (error) {
      console.error('Error:', error);
     
  }
}
