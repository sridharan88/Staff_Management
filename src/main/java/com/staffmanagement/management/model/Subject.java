package com.staffmanagement.management.model;


import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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


    @ManyToMany
    @JoinTable(name = "staff_subject",joinColumns = @JoinColumn(name="subject_id"),inverseJoinColumns = @JoinColumn(name="staff_id"))
    private List<StaffDetails> staffDetails;

}
