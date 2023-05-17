package com.github.viniciusvk1.personalBlog.controller;

import com.github.viniciusvk1.personalBlog.model.Posting;
import com.github.viniciusvk1.personalBlog.repository.PostsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Posting> getByID(@PathVariable Long id) {
        return postsRepository.findById(id)
                .map(response -> ResponseEntity.ok(response))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Posting>> getByTitle(@PathVariable String title) {
        return ResponseEntity.ok(postsRepository.findAllByTitleContainingIgnoreCase(title));
    }

    @PostMapping
    public ResponseEntity<Posting> post(@Valid @RequestBody Posting posting) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(postsRepository.save(posting));
    }

    @PutMapping
    public ResponseEntity<Posting> put(@Valid @RequestBody Posting posting) {
        return postsRepository.findById(posting.getId())
                .map(response -> ResponseEntity.status(HttpStatus.OK)
                        .body(postsRepository.save(posting)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping({"id"})
    public void delete(@PathVariable Long id) {
        Optional<Posting> posting = postsRepository.findById(id);

        if (posting.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        postsRepository.deleteById(id);
    }

}