package com.andresfeliper3.pkb.application.ports.output;

import com.andresfeliper3.pkb.domain.models.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUserId(Long userId);
    User save(User user);
}
