package com.student.control.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "percentages")
public class Percentages {

    @Id
    private Integer id;
}
