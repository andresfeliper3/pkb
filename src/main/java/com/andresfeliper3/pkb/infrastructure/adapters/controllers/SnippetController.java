package com.andresfeliper3.pkb.infrastructure.adapters.controllers;

import com.andresfeliper3.pkb.application.ports.input.SnippetUseCase;
import com.andresfeliper3.pkb.domain.models.Snippet;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Create a new snippet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Snippet created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ResponseEntity<Snippet> createSnippet(@RequestBody Snippet snippet) {
        Snippet createdSnippet = snippetUseCase.createSnippet(snippet.getTitle(), snippet.getContent());
        return new ResponseEntity<>(createdSnippet, HttpStatus.CREATED);
    }

    @Operation(summary = "Get a snippet by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Snippet found"),
            @ApiResponse(responseCode = "404", description = "Snippet not found")
    })
    @GetMapping("/{snippetId}")
    public ResponseEntity<Snippet> getSnippetById(@PathVariable Long snippetId) {
        Optional<Snippet> snippet = snippetUseCase.getSnippetById(snippetId);
        return snippet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Get all snippets for a user by user ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Snippets found"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Snippet>> getSnippetsByUserId(@PathVariable Long userId) {
        List<Snippet> snippets = snippetUseCase.getSnippetsByUserId(userId);
        return ResponseEntity.ok(snippets);
    }

    @Operation(summary = "Update a snippet by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Snippet updated"),
            @ApiResponse(responseCode = "404", description = "Snippet not found")
    })
    @PutMapping("/{snippetId}")
    public ResponseEntity<Snippet> updateSnippet(@PathVariable Long snippetId, @RequestBody Snippet snippetDetails) {
        Optional<Snippet> optionalSnippet = snippetUseCase.updateSnippet(snippetId, snippetDetails.getTitle(), snippetDetails.getContent());
        return optionalSnippet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete a snippet by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Snippet deleted"),
            @ApiResponse(responseCode = "404", description = "Snippet not found")
    })
    @DeleteMapping("/{snippetId}")
    public ResponseEntity<Void> deleteSnippet(@PathVariable Long snippetId) {
        if (snippetUseCase.deleteSnippet(snippetId)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}