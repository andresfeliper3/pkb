package com.andresfeliper3.pkb.application.services;

import com.andresfeliper3.pkb.application.ports.input.SnippetUseCase;
import com.andresfeliper3.pkb.application.ports.output.SnippetRepository;
import com.andresfeliper3.pkb.domain.models.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SnippetService implements SnippetUseCase {

    private final SnippetRepository snippetRepository;

    @Autowired
    public SnippetService(SnippetRepository snippetRepository) {
        this.snippetRepository = snippetRepository;
    }

    @Override
    public Snippet createSnippet(String title, String content) {
        Snippet snippet = new Snippet(title, content);
        return snippetRepository.save(snippet);
    }

    @Override
    public Optional<Snippet> getSnippetById(Long snippetId) {
        return snippetRepository.findBySnippetId(snippetId);
    }

    @Override
    public List<Snippet> getSnippetsByUserId(Long userId) {
        return snippetRepository.findSnippetsByUserId(userId);
    }

    @Override
    public Optional<Snippet> updateSnippet(Long id, String title, String content) {
        return snippetRepository.findBySnippetId(id)
                .map(existingSnippet -> {
                    existingSnippet.setTitle(title);
                    existingSnippet.setContent(content);
                    existingSnippet.setUpdatedAt(LocalDateTime.now());
                    return snippetRepository.save(existingSnippet);
                });
    }

    @Override
    public boolean deleteSnippet(Long id) {
        if (snippetRepository.findBySnippetId(id).isPresent()) {
            snippetRepository.deleteBySnippetId(id);
            return true;
        }
        return false;
    }
}