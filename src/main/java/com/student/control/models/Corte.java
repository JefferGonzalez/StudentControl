package com.student.control.models;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "corte")
public class Corte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private Integer porcentaje;

    @OneToMany(mappedBy = "corte", cascade = CascadeType.MERGE, orphanRemoval = true)
    private Collection<Calificacion> calificaciones;

    @ManyToOne
    @JoinColumn(name = "periodo_id", referencedColumnName = "id", nullable = false)
    private Periodo periodo;

    public Corte() {
    }

    public Corte(Integer id, String nombre, Integer porcentaje, ArrayList<Calificacion> calificaciones,
            Periodo periodo) {
        this.id = id;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.calificaciones = calificaciones;
        this.periodo = periodo;
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

    public Collection<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(Collection<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

}
