package com.andresfeliper3.pkb.services;

import com.andresfeliper3.pkb.entities.Snippet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SnippetService {

    public Snippet createSnippet(Snippet snippet) {
        return null;
    }

    public Optional<Snippet> getSnippetById(Long snippetId) {
        return Optional.empty();
    }

    public List<Snippet> getSnippetsByUserId(Long userId) {
        return null;
    }

    public Optional<Snippet> updateSnippet(Long snippetId, Snippet snippetDetails) {
        return Optional.empty();
    }

    public boolean deleteSnippet(Long snippetId) {
        return true;
    }

}
