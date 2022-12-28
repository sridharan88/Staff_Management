package com.staffmanagement.management.repository;

import com.staffmanagement.management.model.StaffDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StaffRepository extends JpaRepository<StaffDetails,Integer>{
    
}