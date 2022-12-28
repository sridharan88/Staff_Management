package com.staffmanagement.management.model;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;





@Data
@Entity
@Table(name = "class_details")

public class ClassDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int clsId;
    private String clsName;
    public int periodCounts;
    

  @OneToMany(mappedBy = "classDetails")
  private List<Allotment> classAllotments;

}
