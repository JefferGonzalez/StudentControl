package com.student.control.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.student.control.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
