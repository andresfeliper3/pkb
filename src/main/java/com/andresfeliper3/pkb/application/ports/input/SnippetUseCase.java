package com.andresfeliper3.pkb.application.ports.input;

import com.andresfeliper3.pkb.domain.models.Snippet;

import java.util.List;
import java.util.Optional;

public interface SnippetUseCase {
    Snippet createSnippet(String title, String content);
    Optional<Snippet> getSnippetById(Long snippetId);
    List<Snippet> getSnippetsByUserId(Long userId);
    Optional<Snippet> updateSnippet(Long id, String title, String content);
    boolean deleteSnippet(Long id);
}