package com.example.forumHub.controller;


import com.example.forumHub.model.Assunto;
import com.example.forumHub.service.AssuntoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assunto")
public class AssuntoController {

    private final AssuntoService assuntoService;

    public AssuntoController(AssuntoService assuntoService) {
        this.assuntoService = assuntoService;
    }


    @GetMapping
    public List<Assunto> buscarTodosAssuntos() {
        return assuntoService.buscarTodosAssuntos();
    }

    @GetMapping("/{id}")
    public Optional<Assunto> buscarAssuntoPorId(@PathVariable Long id) {
        return assuntoService.buscarAssuntoPorId(id);
    }

    @PostMapping
    public Assunto criarAssunto(@Valid @RequestBody Assunto assunto) {
        return assuntoService.criarAssunto(assunto);
    }

    @PutMapping("{id}")
    public Assunto editarAssunto(@Valid @RequestBody Assunto assunto, @PathVariable Long id) {
        return assuntoService.editarAssunto(assunto, id);
    }

    @DeleteMapping("{id}")
    public void deletarAssunto(@PathVariable Long id) {
        assuntoService.deletarAssunto(id);
    }

}
