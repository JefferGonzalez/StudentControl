/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.student.control.repositories;

import com.student.control.models.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author SEBASTIAN L
 */
public interface CalificacionRepository extends JpaRepository<Calificacion, Integer >{
    
}
