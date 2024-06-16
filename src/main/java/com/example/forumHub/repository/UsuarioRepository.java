package com.example.forumHub.repository;


import com.example.forumHub.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM forum_hub.usuario u WHERE deletado = false", nativeQuery = true)
    List<Usuario> buscarUsuarios();

    @Query(value = "SELECT * FROM forum_hub.usuario u WHERE deletado = false AND id = :id", nativeQuery = true)
    Optional<Usuario> buscarUsuarioPorId(Long id);

    @Query(value = "SELECT * FROM forum_hub.usuario u WHERE deletado = false AND username = :username", nativeQuery = true)
    Optional<Usuario> buscarUsuarioPorLogin(String username);

    Optional<Usuario> findByUsername(String username);
}
