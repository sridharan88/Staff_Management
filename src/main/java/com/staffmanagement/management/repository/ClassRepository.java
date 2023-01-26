package com.staffmanagement.management.repository;

import com.staffmanagement.management.model.ClassDetails;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClassRepository extends JpaRepository<ClassDetails,Integer>{
    
}
