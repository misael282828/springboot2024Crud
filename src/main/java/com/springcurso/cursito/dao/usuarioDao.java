package com.springcurso.cursito.dao;

import java.util.List;

import com.springcurso.cursito.models.Usuario;

//conexion a la base de dato
public interface UsuarioDao {

  List<Usuario> getUsuario();

  void eliminar(Long id);

  void registrar(Usuario usuario);

  boolean verificarEmailPassword(Usuario usuario);

}
