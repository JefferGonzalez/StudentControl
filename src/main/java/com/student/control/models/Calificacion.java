package com.student.control.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "calificacion")
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private Integer porcentaje;

    @ManyToOne
    @JoinColumn(name = "corte_id", referencedColumnName = "id", nullable = false)
    private Corte corte;

    public Calificacion() {
    }

    public Calificacion(Integer id, String nombre, Integer porcentaje, Corte corte) {
        this.id = id;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.corte = corte;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Corte getCalificacion() {
        return corte;
    }

    public void setCalificacion(Corte corte) {
        this.corte = corte;
    }

    public Corte getCorte() {
        return corte;
    }

    public void setCorte(Corte corte) {
        this.corte = corte;
    }

}
