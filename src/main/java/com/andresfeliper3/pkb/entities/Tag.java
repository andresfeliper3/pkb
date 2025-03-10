package com.andresfeliper3.pkb.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "tags")
@Data
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Snippet> snippets;

}