package com.staffmanagement.management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;




@Data
@Entity
@Table(name = "staff_details")
public class StaffDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private int id;
    @Column(name = "staff_name")
    private String name;
    @Column(name = "mail_id")
    private String email;
    @Column(name = "phone_no")
    private long phoneNo;

    
    @JsonIgnore
    @ManyToMany(mappedBy = "staffDetails", cascade = { CascadeType.ALL })
    private List<Subject> sub;

    @OneToMany(mappedBy = "staffDetails")
    private List<Allotment> staffAllotment;
}