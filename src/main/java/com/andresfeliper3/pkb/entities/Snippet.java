package com.andresfeliper3.pkb.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "snippets")
@Data
public class Snippet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long snippetId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

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

}