package com.springcurso.cursito.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springcurso.cursito.dao.UsuarioDao;
import com.springcurso.cursito.models.UsuarioModel;



@RestController
public class UsuarioController {

   @Autowired
   private UsuarioDao usuarioDao; // inyeccion de dependencia 

   @GetMapping("api/usuarios/{id}")
   public UsuarioModel getUsuario(@PathVariable Long id) {
      UsuarioModel usuarioModel = new UsuarioModel();
      usuarioModel.setId(id);
      usuarioModel.setNombre("Misael");
      usuarioModel.setApellido("guzman");
      usuarioModel.setEmail("Misael@gmail");
      usuarioModel.setTelefono("80976758767");

      return usuarioModel;
   }

   @RequestMapping(value = "/api/usuarios",method = RequestMethod.GET)
   public List<UsuarioModel> getusuarios() {

      return usuarioDao.getUsuario();//implementar funciones de UsuarioDao
   }

   @RequestMapping(value = "/api/usuarios",method = RequestMethod.POST)
   public void  registrarUsuarios(@RequestBody UsuarioModel usuario) {

       usuarioDao.registrar(usuario);//implementar funciones de UsuarioDao
   }



   @GetMapping("editar")
   public UsuarioModel editar() {
      UsuarioModel usuarioModel = new UsuarioModel();

      // usuarioModel.setNombre("asd");
      usuarioModel.setApellido("guzman");
      usuarioModel.setEmail("Misael@gmail");
      usuarioModel.setTelefono("80976758767");

      return usuarioModel;

   }

   @RequestMapping(value = "/api/usuarios/{id}",method = RequestMethod.DELETE)
   public void eliminar(@PathVariable Long id) {
    usuarioDao.eliminar(id);
      

   }

}
