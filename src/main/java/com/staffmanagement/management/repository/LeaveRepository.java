package com.staffmanagement.management.repository;

import com.staffmanagement.management.model.LeaveDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveDetails,Integer>{
    
}
