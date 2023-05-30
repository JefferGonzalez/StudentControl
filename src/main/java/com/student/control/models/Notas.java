package com.student.control.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "notas")
public class Notas {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "quiz", nullable = true)
  private Integer quiz;

  @Column(name = "talleres", nullable = true)
  private Integer talleres;

  @Column(name = "tareas", nullable = true)
  private Integer tareas;

  @Column(name = "act_practica", nullable = true)
  private Integer actPractica;

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "corte_id", referencedColumnName = "id", nullable = false)
  private Corte corte;

  public Notas() {
  }

  public Notas(Integer id, Integer quiz, Integer talleres, Integer tareas, Integer actPractica, User user,
      Corte corte) {
    this.id = id;
    this.quiz = quiz;
    this.talleres = talleres;
    this.tareas = tareas;
    this.actPractica = actPractica;
    this.user = user;
    this.corte = corte;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getQuiz() {
    return quiz;
  }

  public void setQuiz(Integer quiz) {
    this.quiz = quiz;
  }

  public Integer getTalleres() {
    return talleres;
  }

  public void setTalleres(Integer talleres) {
    this.talleres = talleres;
  }

  public Integer getTareas() {
    return tareas;
  }

  public void setTareas(Integer tareas) {
    this.tareas = tareas;
  }

  public Integer getActPractica() {
    return actPractica;
  }

  public void setActPractica(Integer actPractica) {
    this.actPractica = actPractica;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Corte getCorte() {
    return corte;
  }

  public void setCorte(Corte corte) {
    this.corte = corte;
  }

}
