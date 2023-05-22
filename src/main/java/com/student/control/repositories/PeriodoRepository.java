/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.student.control.repositories;

import com.student.control.models.Periodo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author SEBASTIAN L
 */
public interface PeriodoRepository extends JpaRepository<Periodo, Integer> {

  public Optional<Periodo> findByNombre(String nombre);

}
