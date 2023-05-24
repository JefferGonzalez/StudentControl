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
  @JoinColumn(name = "periodo_id", referencedColumnName = "id", nullable = false)
  private Periodo periodo;

  public Notas() {
  }

  public Notas(Integer id, Integer quiz, Integer talleres, Integer tareas, Integer actPractica, User user,
      Periodo periodo) {
    this.id = id;
    this.quiz = quiz;
    this.talleres = talleres;
    this.tareas = tareas;
    this.actPractica = actPractica;
    this.user = user;
    this.periodo = periodo;
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

  public Periodo getPeriodo() {
    return periodo;
  }

  public void setPeriodo(Periodo periodo) {
    this.periodo = periodo;
  }

}
