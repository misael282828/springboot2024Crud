

// cuando se recarga la pagina llama los usuarios de la lista
$(document).ready(function () {
  //on ready
});




async function iniciarSesion() {
 
 
  let datos = {};

  datos.email = document.getElementById('txtEmail').value;
  datos.password = document.getElementById('txtPassword').value;

  try {
      const response = await fetch('api/login', {
          method: 'POST',
          headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
          },
          body: JSON.stringify(datos)  // datos para el inicio de sesion 
      });

      if (!response.ok) {
          throw new Error('Error en la solicitud: ' + response.statusText);
      }

      const respuesta = await response.text()
      console.log(respuesta);
      if (respuesta == "ok") {
        window.location.href = 'usuarios.html'
      }else{
        alert("Credenciales invalidas, intente de nuevo.")
      }


  } catch (error) {
      console.error('Error:', error);
     
  }



}
