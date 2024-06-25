package com.springcurso.cursito.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springcurso.cursito.models.UsuarioModel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository  // para base de datos  
@Transactional //para consultas de SQL

public class UsuarioDaoImp  implements UsuarioDao {

  @PersistenceContext
  EntityManager entityManager;

  @SuppressWarnings("unchecked")
  @Override
  public List<UsuarioModel> getUsuario() {
    //consula a la DB
    String query = "FROM UsuarioModel";
    
    return entityManager.createQuery(query).getResultList();
    
  }

  @Override
  public void eliminar(Long id ) {
   UsuarioModel usuarioModel = entityManager.find(UsuarioModel.class, id);
   entityManager.remove(usuarioModel);
  }




  
}



