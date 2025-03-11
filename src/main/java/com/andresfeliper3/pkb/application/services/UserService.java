package com.andresfeliper3.pkb.application.services;

import com.andresfeliper3.pkb.persistence.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public boolean registerUser(User user) {
        return true;
    }

    public boolean authenticateUser(User user) {
        return true;
    }

    public User findUserById(Long  userId) {
        return null;
    }
}
