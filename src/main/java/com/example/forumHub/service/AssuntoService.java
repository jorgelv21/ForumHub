package com.example.forumHub.service;


import com.example.forumHub.model.Assunto;
import com.example.forumHub.repository.AssuntoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssuntoService {

    private final AssuntoRepository assuntoRepository;

    public AssuntoService(AssuntoRepository assuntoRepository) {
        this.assuntoRepository = assuntoRepository;
    }

    public List<Assunto> buscarTodosAssuntos() {
        return assuntoRepository.findAll();
    }

    public Optional<Assunto> buscarAssuntoPorId(Long id) {
        Optional<Assunto> assunto = assuntoRepository.findById(id);
        if (assunto.isPresent()) {
            return assunto;
        }
        throw new RuntimeException("Assunto Não encontrado");
    }

    public Assunto criarAssunto(Assunto assunto) {
        return assuntoRepository.save(assunto);
    }

    public Assunto editarAssunto(Assunto novoAssunto, Long id) {
        Optional<Assunto> assuntoExistente = assuntoRepository.findById(id);
        if (assuntoExistente.isPresent()) {
            Assunto assunto = assuntoExistente.get();
            assunto.setNome(novoAssunto.getNome());
            assunto.setDeletado(novoAssunto.isDeletado());

            return assuntoRepository.saveAndFlush(assunto);
        } else {
            throw new RuntimeException("Assunto não encontrado");
        }
    }

    public void deletarAssunto(Long id) {
        Optional<Assunto> assunto = assuntoRepository.findById(id);
        if (assunto.isPresent()) {
            Assunto assuntoEncontrado = assunto.get();
            assuntoEncontrado.setDeletado(true);
            assuntoRepository.save(assuntoEncontrado);
        } else {
            throw new RuntimeException("erro");
        }
    }
}

