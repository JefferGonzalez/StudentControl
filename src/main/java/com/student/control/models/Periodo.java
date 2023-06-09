package com.student.control.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "periodo")
public class Periodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @OneToMany(mappedBy = "periodo", cascade = CascadeType.ALL)
    private Collection<Corte> cortes;

    public Periodo() {
    }

    public Periodo(Integer id, String nombre, ArrayList<Corte> cortes) {
        this.id = id;
        this.nombre = nombre;
        this.cortes = cortes;
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

    public Collection<Corte> getCortes() {
        return cortes;
    }

    public void setCortes(Collection<Corte> cortes) {
        this.cortes = cortes;
    }

}
