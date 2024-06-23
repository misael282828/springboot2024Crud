package com.springcurso.cursito.dao;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.springcurso.cursito.models.UsuarioModel;

@Repository
@Transactional

public class UsuarioDaoImp implements usuarioDao {

  @Override
  public List<UsuarioModel> getUsuario() {
    
    throw new UnsupportedOperationException("Unimplemented method 'getUsuario'");
  }
  
}
