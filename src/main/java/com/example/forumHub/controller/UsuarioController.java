package com.example.forumHub.controller;


import com.example.forumHub.model.Usuario;
import com.example.forumHub.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @GetMapping
    public List<Usuario> buscarUsuarios() {
        return usuarioService.buscarUsuarios();
    }

    @GetMapping(value = "/{id}")
    public Optional<Usuario> buscarUsuarioPorId(@PathVariable("id") Long id) {
        return usuarioService.buscarUsuarioPorId(id);
    }

    @PostMapping
    @PreAuthorize("permitAll()")
    public ResponseEntity<String> criarUsuario(@Valid @RequestBody Usuario usuario) {
        return usuarioService.criarUsuario(usuario);
    }

}
