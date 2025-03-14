package com.andresfeliper3.pkb.application.services;

import com.andresfeliper3.pkb.application.ports.input.UserUseCase;
import com.andresfeliper3.pkb.application.ports.output.UserRepository;
import com.andresfeliper3.pkb.domain.models.User;
import com.andresfeliper3.pkb.persistence.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserUseCase {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return userRepository.findByUserId(userId);
    }
}
