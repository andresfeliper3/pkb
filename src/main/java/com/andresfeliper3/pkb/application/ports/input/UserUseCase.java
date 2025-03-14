package com.andresfeliper3.pkb.application.ports.input;

import com.andresfeliper3.pkb.domain.models.User;

import java.util.Optional;

public interface UserUseCase {
    User createUser(User user);
    Optional<User> getUserById(Long userId);
}
