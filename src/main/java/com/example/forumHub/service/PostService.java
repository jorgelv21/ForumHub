package com.example.forumHub.service;


import com.example.forumHub.model.Post;
import com.example.forumHub.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> buscarTodosPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> buscarPostPorId(Long id) {
        return postRepository.findById(id);
    }

    public Post criarPost(Post post) {
        return postRepository.save(post);
    }

    public Post editarPost(Long id, Post novoPost) {
        Optional<Post> postExistente = postRepository.findById(id);
        if (postExistente.isPresent()) {
            Post post = postExistente.get();
            post.setTexto(novoPost.getTexto());
            post.setDeletado(novoPost.isDeletado());

            return postRepository.saveAndFlush(post);
        } else {
            throw new RuntimeException("Post não encontrado com o id: " + id);
        }
    }

    public void deletarPost(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            Post postEncontrado = post.get();
            postEncontrado.setDeletado(true);
            postRepository.save(postEncontrado);
        } else {
            throw new RuntimeException("erro");
        }
    }
}
