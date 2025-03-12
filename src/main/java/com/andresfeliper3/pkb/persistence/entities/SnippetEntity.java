package com.andresfeliper3.pkb.persistence.entities;

import com.andresfeliper3.pkb.domain.models.Snippet;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "snippets")
@Data
public class SnippetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long snippetId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 4096)
    private String content;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @ManyToMany
    @JoinTable(
            name = "snippet_tags",
            joinColumns = @JoinColumn(name = "snippet_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags;

    public SnippetEntity(Snippet snippet) {
        this.snippetId = snippet.getId();
        this.title = snippet.getTitle();
        this.content = snippet.getContent();
        this.createdAt = snippet.getCreatedAt();
        this.updatedAt = snippet.getUpdatedAt();
    }

    public Snippet toDomain() {
        Snippet snippet = new Snippet(title, content);
        snippet.setId(snippetId);
        snippet.setCreatedAt(createdAt);
        snippet.setUpdatedAt(updatedAt);
        return snippet;
    }
}