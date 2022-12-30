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

}