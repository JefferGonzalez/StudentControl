/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.student.control.repositories;

import com.student.control.models.Corte;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author SEBASTIAN L
 */
public interface CorteRepository extends JpaRepository<Corte, Integer >{

  @Transactional
  @Modifying
  @Query("DELETE FROM Calificacion cal WHERE cal.corte.id IN (SELECT c.id FROM Corte c WHERE c.periodo.id = :id)")
  void deleteCalificacionesByPeriodoId(@Param("id") Integer id);
    
  @Transactional
  @Modifying
  @Query("DELETE FROM Corte c WHERE c.periodo.id = :id")
  void deleteByPeriodoId(@Param("id") Integer id);

}
