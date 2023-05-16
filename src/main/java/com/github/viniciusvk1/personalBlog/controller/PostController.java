package com.github.viniciusvk1.personalBlog.controller;

import com.github.viniciusvk1.personalBlog.model.Posting;
import com.github.viniciusvk1.personalBlog.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostController {

    @Autowired
    private PostsRepository postsRepository;

    @GetMapping
    public ResponseEntity<List<Posting>> getAll() {
        return ResponseEntity.ok(postsRepository.findAll());
    }
}