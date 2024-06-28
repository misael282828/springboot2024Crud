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
import com.springcurso.cursito.models.Usuario;



@RestController
public class UsuarioController {

   @Autowired
   private UsuarioDao usuarioDao; // inyeccion de dependencia 

   @GetMapping("api/usuarios/{id}")
   public Usuario getUsuario(@PathVariable Long id) {
      Usuario Usuario = new Usuario();
      Usuario.setId(id);
      Usuario.setNombre("Misael");
      Usuario.setApellido("guzman");
      Usuario.setEmail("Misael@gmail");
      Usuario.setTelefono("80976758767");

      return Usuario;
   }

   @RequestMapping(value = "/api/usuarios",method = RequestMethod.GET)
   public List<Usuario> getusuarios() {

      return usuarioDao.getUsuario();//implementar funciones de UsuarioDao
   }

   @RequestMapping(value = "/api/usuarios",method = RequestMethod.POST)
   public void  registrarUsuarios(@RequestBody Usuario usuario) {

       usuarioDao.registrar(usuario);//implementar funciones de UsuarioDao
   }



   @GetMapping("editar")
   public Usuario editar() {
      Usuario Usuario = new Usuario();

      // Usuario.setNombre("asd");
      Usuario.setApellido("guzman");
      Usuario.setEmail("Misael@gmail");
      Usuario.setTelefono("80976758767");

      return Usuario;

   }

   @RequestMapping(value = "/api/usuarios/{id}",method = RequestMethod.DELETE)
   public void eliminar(@PathVariable Long id) {
    usuarioDao.eliminar(id);
      

   }

}
