package com.andresfeliper3.pkb.infrastructure.adapters.repositories;

import com.andresfeliper3.pkb.application.ports.output.SnippetRepository;
import com.andresfeliper3.pkb.domain.models.Snippet;
import com.andresfeliper3.pkb.persistence.entities.SnippetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public interface JpaSnippetRepository extends JpaRepository<SnippetEntity, Long>, SnippetRepository {

    @Override
    default Snippet save(Snippet snippet) {
        SnippetEntity savedEntity = save(new SnippetEntity(snippet));
        return savedEntity.toDomain();
    }

    @Override
    default Optional<Snippet> findBySnippetId(Long id) {
        return findById(id).map(SnippetEntity::toDomain);
    }

    @Override
    default List<Snippet> findSnippetsByUserId(Long userId) {
        return null;
    }

    @Override
    default boolean deleteBySnippetId(Long id) {
        if (existsById(id)) {
            deleteById(id);
            return true;
        }
        return false;
    }
}
