package com.staffmanagement.management.repository;

import com.staffmanagement.management.model.Allotment;
import java.time.DayOfWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AllotmentRepository extends JpaRepository<Allotment,DayOfWeek>{
    
}
