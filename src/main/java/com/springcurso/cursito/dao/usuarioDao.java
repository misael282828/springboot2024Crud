package com.springcurso.cursito.dao;

import java.util.List;

import com.springcurso.cursito.models.UsuarioModel;

//conexion a la base de dato
public interface UsuarioDao {

  List<UsuarioModel> getUsuario();

  void eliminar(Long id);

}
