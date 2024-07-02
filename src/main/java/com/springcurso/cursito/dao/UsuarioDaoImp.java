package com.springcurso.cursito.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
  import org.springframework.transaction.annotation.Transactional;

import com.springcurso.cursito.models.Usuario;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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

  @SuppressWarnings("deprecation")
  @Override
  public boolean verificarEmailPassword(Usuario usuario) {

    String query = "FROM Usuario WHERE email = :email";
   
    @SuppressWarnings("unchecked")
    List<Usuario> lista = (List<Usuario>) entityManager.createQuery(query)
    .setParameter("email", usuario.getEmail())
    .getResultList();
    

    if (lista.isEmpty()) {
      return false;
    }
    //obtener el hash que esta en la BD
    String passwordHashed = lista.get(0).getPassword();

    //Validar el hash con la password digitado 
    Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
    return argon2.verify(passwordHashed, usuario.getPassword());
  }

}
