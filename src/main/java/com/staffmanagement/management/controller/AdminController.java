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
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private ClassService classService;
    @Autowired
    private AllotmentService allotmentService;

    // subject
    @PostMapping("/subject")
    public Subject postSubjectName(@RequestBody Subject subject) {

        return subjectService.saveSubject(subject);
    }

    @PutMapping
    public Optional<Subject> updateSubject(@RequestBody Subject subject) {
        return subjectService.updateBySubId(subject);
    }

    @DeleteMapping("/subject/del")
    public void deleteSubject(@RequestParam("subId") int subId) {
        subjectService.deleteSubId(subId);
    }

    // staffDetails
    @PostMapping("/staff")
    public StaffDetails postStaffName(@RequestBody StaffDetails staffDetails) {
        return staffService.storeMethod(staffDetails);
    }

    @DeleteMapping("/staff/del")
    public void deleteStaff(@RequestParam("id") int id) {
        staffService.deleteStaffId(id);
    }

    // Role
     
     @GetMapping("/getrole")
     public List<Role> getAllRoles() {
         return roleService.getRoles();
     }
    

    @DeleteMapping("/role/{no}")
    public void deleteRole(@PathVariable("no") int no) {
        roleService.deleteRoleNo(no);
    }

    // classDetails
    @PostMapping("/class")
    public ClassDetails postClassDetails(@RequestBody ClassDetails classDetails) {
        return classService.postClasses(classDetails);
    }

    @DeleteMapping("/class/del")
    public void deleteClass(@RequestParam("clsId") int clsId) {
        classService.deleteClassId(clsId);
    }

    // Allotment
    @PostMapping("/allotment")
    public Allotment postAllotment(@RequestBody Allotment allotment) throws Exception {
        return allotmentService.saveAllotment(allotment);
    }

   
    //staff_subject id get
    @GetMapping("/staff/sub")
    public Optional<StaffDetails> getStaffSubject(@RequestParam int id) {
        return staffService.getByID(id);
    }
    

}
