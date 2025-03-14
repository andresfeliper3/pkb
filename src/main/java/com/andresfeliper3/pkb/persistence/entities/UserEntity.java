package com.andresfeliper3.pkb.persistence.entities;

import com.andresfeliper3.pkb.domain.models.Snippet;
import com.andresfeliper3.pkb.domain.models.User;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SnippetEntity> snippets;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SearchLog> searchLogs;

    public UserEntity() {

    }

    public UserEntity(User user) {
        this.userId = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.passwordHash = user.getPasswordHash();
        this.createdAt = user.getCreatedAt();
    }

    public User toDomain() {
        User user = new User(username, email, passwordHash);
        user.setId(userId);
        user.setCreatedAt(createdAt);
        return user;
    }
}
