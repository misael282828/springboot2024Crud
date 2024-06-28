package com.springcurso.cursito.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springcurso.cursito.models.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository // para base de datos
@Transactional // para consultas de SQL

public class UsuarioDaoImp implements UsuarioDao {

  @PersistenceContext
  EntityManager entityManager;

  @SuppressWarnings("unchecked")
  @Override
  public List<Usuario> getUsuario() {
    // consula a la DB
    String query = "FROM Usuario";

    return entityManager.createQuery(query).getResultList();

  }

  @Override
  public void eliminar(Long id) {
    Usuario Usuario = entityManager.find(Usuario.class, id);
    entityManager.remove(Usuario);

  }

  @Override
  public void registrar(Usuario usuario) {

    entityManager.merge(usuario);
  }

  @Override
  public boolean verificarEmailPassword(Usuario usuario) {

    String query = "FROM Usuario WHERE email = :email AND password = :password";
   
    @SuppressWarnings("unchecked")
    List<Usuario> lista = (List<Usuario>) entityManager.createQuery(query)
    .setParameter("email", usuario.getEmail())
    .setParameter("password", usuario.getPassword())
    .getResultList();
    
    
    return !lista.isEmpty();
  }

}
