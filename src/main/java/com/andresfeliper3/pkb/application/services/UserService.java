package com.andresfeliper3.pkb.application.services;

import com.andresfeliper3.pkb.persistence.entities.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public boolean registerUser(UserEntity user) {
        return true;
    }

    public boolean authenticateUser(UserEntity user) {
        return true;
    }

    public UserEntity findUserById(Long  userId) {
        return null;
    }
}
