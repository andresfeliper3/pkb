package com.andresfeliper3.pkb.application.ports.output;

import com.andresfeliper3.pkb.domain.models.Snippet;

import java.util.List;
import java.util.Optional;

public interface SnippetRepository {
    Snippet save(Snippet snippet);
    Optional<Snippet> findBySnippetId(Long id);
    List<Snippet> findSnippetsByUserId(Long userId);
    boolean deleteBySnippetId(Long id);
}