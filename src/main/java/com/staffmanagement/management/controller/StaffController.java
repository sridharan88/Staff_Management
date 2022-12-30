package com.staffmanagement.management.controller;

import com.staffmanagement.management.model.Allotment;
import com.staffmanagement.management.model.ClassDetails;
import com.staffmanagement.management.model.Role;
import com.staffmanagement.management.model.StaffDetails;
import com.staffmanagement.management.model.Subject;
import com.staffmanagement.management.service.AllotmentService;
import com.staffmanagement.management.service.ClassService;
import com.staffmanagement.management.service.RoleService;
import com.staffmanagement.management.service.StaffService;
import com.staffmanagement.management.service.SubjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/staff")

public class StaffController {

    @Autowired
    private StaffService staffService;
    @Autowired
    private ClassService classService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private AllotmentService allotmentService;
    @Autowired
    private RoleService roleService;

    @GetMapping()
    public List<StaffDetails> getAllStaffs() {
        return staffService.getStaffs();
    }

    @GetMapping("/subjects")
    public List<Subject> getSubjectNames() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("/class")
    public List<ClassDetails> getClassDetails() {
        return classService.getClasses();
    }

    @GetMapping("/allotment")
    public List<Allotment> getAllotmentTable() {
        return allotmentService.getAllotment();
    }
    
    @PostMapping("/role")
    public Role postRoleName(@RequestBody Role role) {

        return roleService.saveRole(role);
    }
}
