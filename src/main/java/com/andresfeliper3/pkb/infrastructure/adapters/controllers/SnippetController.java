package com.andresfeliper3.pkb.infrastructure.adapters.controllers;

import com.andresfeliper3.pkb.application.ports.input.SnippetUseCase;
import com.andresfeliper3.pkb.application.services.SnippetService;
import com.andresfeliper3.pkb.domain.models.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/snippets")
public class SnippetController {

    @Autowired
    private SnippetUseCase snippetUseCase;

    @PostMapping
    public ResponseEntity<Snippet> createSnippet(@RequestBody Snippet snippet) {
        Snippet createdSnippet = snippetUseCase.createSnippet(snippet.getTitle(), snippet.getContent());
        return new ResponseEntity<>(createdSnippet, HttpStatus.CREATED);
    }

    @GetMapping("/{snippetId}")
    public ResponseEntity<Snippet> getSnippetById(@PathVariable Long snippetId) {
        Optional<Snippet> snippet = snippetUseCase.getSnippetById(snippetId);
        return snippet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Snippet>> getSnippetsByUserId(@PathVariable Long userId) {
        List<Snippet> snippets = snippetUseCase.getSnippetsByUserId(userId);
        return ResponseEntity.ok(snippets);
    }

    @PutMapping("/{snippetId}")
    public ResponseEntity<Snippet> updateSnippet(@PathVariable Long snippetId, @RequestBody Snippet snippetDetails) {
        Optional<Snippet> optionalSnippet = snippetUseCase.updateSnippet(snippetId, snippetDetails.getTitle(), snippetDetails.getContent());
        return optionalSnippet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{snippetId}")
    public ResponseEntity<Void> deleteSnippet(@PathVariable Long snippetId) {
        if (snippetUseCase.deleteSnippet(snippetId)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}