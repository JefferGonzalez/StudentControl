/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.student.control.repositories;

import com.student.control.models.Calificacion;

import java.awt.List;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author SEBASTIAN L
 */
public interface CalificacionRepository extends JpaRepository<Calificacion, Integer> {

  // @Transactional
  // @Query("SELECT c FROM Corte c WHERE c.nombre = :nombre")
  // Optional<Corte> selectByNombre(@Param("nombre") String nombre);
  // select all calificaciones by corte name

  @Transactional
  @Query("SELECT c FROM Calificacion c WHERE c.corte.nombre = :nombre and c.corte.periodo.id = :periodoId")
  ArrayList<Calificacion> selectByCorteNombre(String nombre, int periodoId);
}
