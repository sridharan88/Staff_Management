package com.staffmanagement.management.repository;

import com.staffmanagement.management.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;




public interface SubjectRepository extends JpaRepository<Subject, Integer> {
   

}
