package com.andresfeliper3.pkb.services;

import com.andresfeliper3.pkb.entities.User;
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
