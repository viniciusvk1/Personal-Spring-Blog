package com.github.viniciusvk1.personalBlog.controller;

import com.github.viniciusvk1.personalBlog.model.Posting;
import com.github.viniciusvk1.personalBlog.model.Theme;
import com.github.viniciusvk1.personalBlog.repository.ThemeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/themes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ThemeController {

    @Autowired
    private ThemeRepository themeRepository;

    @GetMapping
    public ResponseEntity<List<Theme>> getAll() {
        return ResponseEntity.ok(themeRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Theme> getById(@PathVariable Long id) {
        return themeRepository.findById(id)
                .map(response -> ResponseEntity.ok(response))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/description/{description}")
    public ResponseEntity<List<Theme>> getByTitle(@PathVariable String description) {
        return ResponseEntity.ok(themeRepository.findAllByDescriptionContainingIgnoreCase(description));
    }

    @PostMapping
    public ResponseEntity<Theme> post(@Valid @RequestBody Theme theme) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(themeRepository.save(theme));
    }

    @PutMapping
    public ResponseEntity<Theme> put(@Valid @RequestBody Theme theme) {
        return themeRepository.findById(theme.getId())
                .map(response -> ResponseEntity.status(HttpStatus.CREATED)
                        .body(themeRepository.save(theme)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping({"id"})
    public void delete(@PathVariable Long id) {
        Optional<Theme> theme = themeRepository.findById(id);

        if (theme.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        themeRepository.deleteById(id);
    }
}