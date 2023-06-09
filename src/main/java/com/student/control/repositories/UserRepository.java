package com.student.control.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.student.control.models.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User>findByEmail(String email);
}
