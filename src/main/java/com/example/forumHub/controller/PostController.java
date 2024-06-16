package com.example.forumHub.controller;


import com.example.forumHub.model.Post;
import com.example.forumHub.service.PostService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> buscarTodosPosts() {
        return postService.buscarTodosPosts();
    }

    @GetMapping("/{id}")
    public Optional<Post> buscarPostPorId(@PathVariable Long id) {
        return postService.buscarPostPorId(id);
    }

    @PostMapping
    public Post criarPost(@Valid @RequestBody Post post) {
        return postService.criarPost(post);
    }

    @PutMapping("{id}")
    public Post editarPost(@Valid @RequestBody Post post, @PathVariable Long id) {
        return postService.editarPost(id, post);
    }

    @DeleteMapping("{id}")
    public void deletarPost(@PathVariable Long id) {
        postService.deletarPost(id);
    }
}
