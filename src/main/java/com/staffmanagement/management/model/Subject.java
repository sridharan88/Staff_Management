package com.staffmanagement.management.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "subject_details")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "subject_id")
    private int subId;
   
    @Column(name = "subject_name")
    private String subName;


   
}
