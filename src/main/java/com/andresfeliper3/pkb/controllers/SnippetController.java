package com.andresfeliper3.pkb.controllers;

import com.andresfeliper3.pkb.entities.Snippet;
import com.andresfeliper3.pkb.services.SnippetService;
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
    private SnippetService snippetService;

    @PostMapping
    public ResponseEntity<Snippet> createSnippet(@RequestBody Snippet snippet) {
        Snippet createdSnippet = snippetService.createSnippet(snippet);
        return new ResponseEntity<>(createdSnippet, HttpStatus.CREATED);
    }

    @GetMapping("/{snippetId}")
    public ResponseEntity<Snippet> getSnippetById(@PathVariable Long snippetId) {
        Optional<Snippet> snippet = snippetService.getSnippetById(snippetId);
        return snippet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Snippet>> getSnippetsByUserId(@PathVariable Long userId) {
        List<Snippet> snippets = snippetService.getSnippetsByUserId(userId);
        return ResponseEntity.ok(snippets);
    }

    @PutMapping("/{snippetId}")
    public ResponseEntity<Snippet> updateSnippet(@PathVariable Long snippetId, @RequestBody Snippet snippetDetails) {
        Optional<Snippet> optionalSnippet = snippetService.updateSnippet(snippetId, snippetDetails);
        return optionalSnippet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{snippetId}")
    public ResponseEntity<Void> deleteSnippet (@PathVariable Long snippetId) {
        if (snippetService.deleteSnippet(snippetId)) {
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }



}
