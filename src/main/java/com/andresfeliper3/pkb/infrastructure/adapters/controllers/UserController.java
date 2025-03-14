package com.andresfeliper3.pkb.infrastructure.adapters.controllers;

import com.andresfeliper3.pkb.application.ports.input.UserUseCase;
import com.andresfeliper3.pkb.domain.models.User;
import com.andresfeliper3.pkb.persistence.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserUseCase userService;

    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("Service is running");
    }

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            Optional<User> createdUserOpt = Optional.ofNullable(userService.createUser(user));
            return createdUserOpt
                    .map(createdUser -> ResponseEntity.status(HttpStatus.CREATED).body(createdUser))
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Error-Message", "User registration failed: " + e.getMessage())
                    .build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .header("Error-Message", "An error occurred: " + e.getMessage())
                    .build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserEntity user) {
        return null;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserInfo(@PathVariable Long userId) {
        return userService.getUserById(userId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
