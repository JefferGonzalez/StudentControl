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

    public boolean Acceder(User user) {
        Optional<User> userEmail = userRepository.findByEmail(user.getEmail());
        if (userEmail.isPresent()) {
            String passwordBD = userEmail.get().getPassword();
            String userPassword = user.getPassword();
            return passwordBD.equals(userPassword);
        } else {
            return false;
        } 
    }
}
