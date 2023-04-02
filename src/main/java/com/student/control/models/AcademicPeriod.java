package com.student.control.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "academic_period")
public class AcademicPeriod {

    @Id
    private Integer id;

}
