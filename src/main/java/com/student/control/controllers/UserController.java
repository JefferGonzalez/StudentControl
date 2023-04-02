package com.student.control.controllers;

import com.student.control.models.User;
import com.student.control.repositories.UserRepository;

public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
