package com.example.forumHub.service;

import com.example.forumHub.model.Usuario;
import com.example.forumHub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    public List<Usuario> buscarUsuarios() {
        return usuarioRepository.buscarUsuarios();
    }

    public Optional<Usuario> buscarUsuarioPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.buscarUsuarioPorId(id);
        if (usuario.isPresent()) {
            return usuario;
        }
        throw new RuntimeException("Usuario Não encontrado");
    }

    public ResponseEntity<String> criarUsuario(Usuario usuario) {
        Optional<Usuario> usuarioCriado = usuarioRepository.findByUsername(usuario.getUsername());
        if (usuarioCriado.isPresent()) {
            return new ResponseEntity<>("Usuario Já existe", HttpStatus.FORBIDDEN);
        }
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioRepository.save(usuario);
        return new ResponseEntity<>("Usuario Criado com Sucesso", HttpStatus.CREATED);
    }


}
