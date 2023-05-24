package com.student.control.repositories;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.student.control.models.Notas;

public interface NotasRepository extends JpaRepository<Notas, Integer> {
  
  // @Query(value = "SELECT * FROM notas WHERE id_alumno = ?1 AND id_materia = ?2", nativeQuery = true) sin native query

  @Transactional
  @Query(value = "SELECT n FROM Notas n WHERE n.user.id = :userId AND n.periodo.id = :periodoId")
  ArrayList<Notas> selectByUserIdAndPeriodoId(Integer userId, Integer periodoId);


  @Transactional
  @Modifying
  @Query("DELETE FROM Notas n WHERE n.id = :id")
  void deleteByNotasId(@Param("id") Integer id);

}
