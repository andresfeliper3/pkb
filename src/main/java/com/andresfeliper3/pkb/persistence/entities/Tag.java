package com.andresfeliper3.pkb.persistence.entities;

import lombok.Data;

import javax.persistence.*;
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
    private Set<SnippetEntity> snippets;

}