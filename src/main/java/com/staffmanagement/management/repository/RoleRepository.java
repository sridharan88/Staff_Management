package com.staffmanagement.management.repository;

import com.staffmanagement.management.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role,Integer>{
    // Role findByUserName(String userName);
}
