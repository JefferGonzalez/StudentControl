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

    private Integer valor;

    @ManyToOne
    @JoinColumn(name = "corte_id", referencedColumnName = "id", nullable = false)
    private Corte corte;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    public Calificacion() {
    }

    public Calificacion(Integer id, String nombre, Integer porcentaje, Integer valor, Corte corte, User user) {
        this.id = id;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.valor = valor;
        this.corte = corte;
        this.user = user;
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

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
