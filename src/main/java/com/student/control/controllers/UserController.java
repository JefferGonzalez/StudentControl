package com.student.control.controllers;

import com.student.control.models.User;
import com.student.control.repositories.UserRepository;
import java.util.Optional;

public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> Acceder(User user) {
        return userRepository.findByEmail(user.getEmail());
    }
}
