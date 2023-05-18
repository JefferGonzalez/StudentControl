
package com.student.control.models;

import java.util.ArrayList;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="corte")
public class Corte {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private Integer porcentaje;
    
    private ArrayList<Calificacion> calificaciones;
    
    
}
