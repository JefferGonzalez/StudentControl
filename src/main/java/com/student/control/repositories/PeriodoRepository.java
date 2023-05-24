/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.student.control.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.student.control.models.Periodo;

/**
 *
 * @author SEBASTIAN L
 */
public interface PeriodoRepository extends JpaRepository<Periodo, Integer> {

  @Transactional
  @Query("SELECT p FROM Periodo p WHERE p.nombre = :nombre ")
  Optional<Periodo> selectByNombre(@Param("nombre") String nombre);


  public Optional<Periodo> findByNombre(String nombre);

}
