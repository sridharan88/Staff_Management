package com.staffmanagement.management.controller;

import com.staffmanagement.management.dto.StaffCountDto;
import com.staffmanagement.management.model.Allotment;
import com.staffmanagement.management.model.ClassDetails;
import com.staffmanagement.management.model.Role;
import com.staffmanagement.management.model.StaffDetails;
import com.staffmanagement.management.model.Subject;
import com.staffmanagement.management.service.AllotmentService;
import com.staffmanagement.management.service.ClassService;
import com.staffmanagement.management.service.LeaveService;
import com.staffmanagement.management.service.RoleService;
import com.staffmanagement.management.service.StaffService;
import com.staffmanagement.management.service.SubjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @Autowired
    private LeaveService leaveService;

    // subject
    @PostMapping("/subject")
    public Subject postSubjectName(@RequestBody Subject subject) throws Exception {

        return subjectService.saveSubject(subject);
    }

    @PutMapping("/subject/update/{subId}")
    public ResponseEntity<Subject> updateSubject(@PathVariable("subId") int subId, @RequestBody Subject subject) {
        return subjectService.updateBySubId(subId, subject);
    }

    @DeleteMapping("/subject/{subId}")
    public void deleteSubject(@PathVariable("subId") int subId) {
        subjectService.deleteSubId(subId);
    }

    // staffDetails
    @PostMapping("/staff")
    public StaffDetails postStaffName(@RequestBody StaffDetails staffDetails) throws Exception {
        return staffService.storeMethod(staffDetails);
    }

    @PutMapping("/staff/update/{id}")
    public ResponseEntity<StaffDetails> updateStaffs(@PathVariable("id") int id,
            @RequestBody StaffDetails staffDetails) {
        return staffService.updateById(id, staffDetails);
    }

    @DeleteMapping("/staff/{id}")
    public void deleteStaff(@PathVariable("id") int id) {
        staffService.deleteStaffId(id);
    }

    // Role

    @GetMapping("/getrole")
    public List<Role> getAllRoles() {
        return roleService.getRoles();
    }

    @PutMapping("/role/update/{no}")
    public ResponseEntity<Role> updateRole(@PathVariable("no") int no, @RequestBody Role role) {
        return roleService.updateById(no, role);
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

    @PutMapping("/class/update/{clsId}")
    public ResponseEntity<ClassDetails> updateClass(@PathVariable("clsId") int clsId,
            @RequestBody ClassDetails classDetails) {
        return classService.updateById(clsId, classDetails);
    }

    @DeleteMapping("/class/{clsId}")
    public void deleteClass(@PathVariable("clsId") int clsId) {
        classService.deleteClassId(clsId);
    }

    // Allotment
    @PostMapping("/allotment")
    public Allotment postAllotment(@RequestBody Allotment allotment) throws Exception {
        return allotmentService.saveAllotment(allotment);
    }

    @PutMapping("/allotment/update/{dayID}")
    public ResponseEntity<Allotment> updateAll(@PathVariable("dayID") int dayID, @RequestBody Allotment allotment) {
        return allotmentService.updateById(dayID, allotment);
    }

    @DeleteMapping("/allotment/{dayID}")
    public void deleteAllotment(@PathVariable("dayID") int dayID) {
        allotmentService.deleteById(dayID);
    }

    @GetMapping("/allotment/staff_count")
    public List<StaffCountDto> findByStaffCounts() {
        return allotmentService.findCount();
    }

    // Leave

    @DeleteMapping("/leave/{id}")
    public void deleteLeave(@PathVariable("id") int id) {
        leaveService.deleteByLeaveId(id);
    }

    // staff_subject
    @GetMapping("/stf-sub/{subId}")
    public List<StaffDetails> getStaffSubject(@PathVariable("subId") int subId) {
        return staffService.getBySubId(subId);
    }

}
