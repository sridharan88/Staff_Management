package com.staffmanagement.management.repository;

import com.staffmanagement.management.model.StaffDetails;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;






public interface StaffRepository extends JpaRepository<StaffDetails,Integer>{
    
    @Query(value = "select * from staff_details  where staff_id = any (select staff_details_staff_id from staff_subject where subjects_subject_id=:subId) ", nativeQuery = true)
    List<StaffDetails> findAllStaff(@Param("subId") int subId);


}