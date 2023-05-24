package com.student.control.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.control.models.Notas;

public interface NotasRepository extends JpaRepository<Notas, Integer> {
  
}
