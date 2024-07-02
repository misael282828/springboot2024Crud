

// cuando se recarga la pagina llama los usuarios de la lista
$(document).ready(function () {
  //on ready
});




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

      alert(
        "Cuenta fue creada exitosamenete!!"
        ,window.location.href = "login.html"
      )
    
  } catch (error) {
      console.error('Error:', error);
     
  }

}
