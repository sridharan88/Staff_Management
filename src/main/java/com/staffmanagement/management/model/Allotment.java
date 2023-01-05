package com.staffmanagement.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;






@Data
@Entity
@Table(name = "allotment_table")
public class Allotment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dayID;
    @Column(nullable=false)
    public String days;
    @Column(nullable=false)
    public int periods;
    
    @ManyToOne
    private ClassDetails classDetails;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private StaffDetails staffDetails;
}
