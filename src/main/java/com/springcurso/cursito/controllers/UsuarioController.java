package com.springcurso.cursito.controllers;


import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcurso.cursito.models.UsuarioModel;


@RestController
public class UsuarioController {
    
@GetMapping("usuario/{id}")
public UsuarioModel getUsuario(@PathVariable Long id){
   UsuarioModel usuarioModel = new UsuarioModel();
   usuarioModel.setId(id);
   usuarioModel.setNombre("Misael");
   usuarioModel.setApellido("guzman");
   usuarioModel.setEmail("Misael@gmail");
   usuarioModel.setTelefono("80976758767");

   return usuarioModel;
}

@RequestMapping("test1")
public List<UsuarioModel>  listaUsuarios(){
   List<UsuarioModel> usuarios = new ArrayList<>();//crear lista de usuarios
   UsuarioModel usuarioModel = new UsuarioModel();

   usuarioModel.setId(123L);
   usuarioModel.setNombre("Misael");
   usuarioModel.setApellido("guzman");
   usuarioModel.setEmail("Misael@gmail");
   usuarioModel.setTelefono("80976758767");
   usuarios.add(usuarioModel);//agregar el usuario a la lista

   UsuarioModel usuarioModel2 = new UsuarioModel();
   usuarioModel2.setId(1312L);
   usuarioModel2.setNombre("segundo");
   usuarioModel2.setApellido("guzman");
   usuarioModel2.setEmail("Misael@gmail");
   usuarioModel2.setTelefono("80976758767");
   usuarios.add(usuarioModel2);

 UsuarioModel usuarioModel3 = new UsuarioModel();
   usuarioModel3.setId(12233L);
   usuarioModel3.setNombre("tercero");
   usuarioModel3.setApellido("guzman");
   usuarioModel3.setEmail("Misael@gmail");
   usuarioModel3.setTelefono("80976758767");
  usuarios.add(usuarioModel3);

   return usuarios;
}
    
@GetMapping("usuariotest")
public UsuarioModel editar(){
   UsuarioModel usuarioModel = new UsuarioModel();

   usuarioModel.setNombre("asd");
   usuarioModel.setApellido("guzman");
   usuarioModel.setEmail("Misael@gmail");
   usuarioModel.setTelefono("80976758767");

   return usuarioModel;

}

@GetMapping("/eliminar")
public UsuarioModel eliminar(){
   UsuarioModel usuarioModel = new UsuarioModel();

   usuarioModel.setNombre("Misael");
   usuarioModel.setApellido("guzman");
   usuarioModel.setEmail("Misael@gmail");
   usuarioModel.setTelefono("80976758767");

   return usuarioModel;
   
}



// @GetMapping("usuario")
// public UsuarioModel buscar(){
//    UsuarioModel usuarioModel = new UsuarioModel();

//    usuarioModel.setNombre("Misael");
//    usuarioModel.setApellido("guzman");
//    usuarioModel.setEmail("Misael@gmail");
//    usuarioModel.setTelefono("80976758767");

//    return usuarioModel;
// }

    
}
