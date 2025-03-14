package com.andresfeliper3.pkb.infrastructure.adapters.repositories;

import com.andresfeliper3.pkb.application.ports.output.UserRepository;
import com.andresfeliper3.pkb.domain.models.User;
import com.andresfeliper3.pkb.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaUserRepository extends JpaRepository<UserEntity, Long>, UserRepository{

   @Override
    default Optional<User> findByUserId(Long userId) {
        return findById(userId).map(UserEntity::toDomain);
    }

    @Override
    default User save(User user) {
        UserEntity savedUser = new UserEntity(user);
        return savedUser.toDomain();
    }
}
