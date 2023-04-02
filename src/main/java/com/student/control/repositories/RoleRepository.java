package com.student.control.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.student.control.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
