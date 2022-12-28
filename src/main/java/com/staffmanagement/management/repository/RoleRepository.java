package com.staffmanagement.management.repository;

import com.staffmanagement.management.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>{
    // Role findByUserName(String userName);
}
