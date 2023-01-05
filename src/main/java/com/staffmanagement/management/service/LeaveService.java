package com.staffmanagement.management.service;

import com.staffmanagement.management.model.LeaveDetails;
import com.staffmanagement.management.repository.LeaveRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LeaveService {
    @Autowired
    private LeaveRepository leaveRepository;

    public LeaveDetails saveLeaveDetails(LeaveDetails leaveDetails) {
        return leaveRepository.save(leaveDetails);
    }

    public List<LeaveDetails> getDetails() {
        return leaveRepository.findAll();
    }

    public ResponseEntity<LeaveDetails> updateById(int id, LeaveDetails leaveDetails) {
        Optional<LeaveDetails> leave = leaveRepository.findById(id);
        if (leave.isPresent()) {
            LeaveDetails leave_Details = leave.get();
            leave_Details.setDays(leaveDetails.getDays());
            leave_Details.setStaffId(leaveDetails.getStaffId());
            leave_Details.setReason(leaveDetails.getReason());
            return new ResponseEntity<>(leaveRepository.save(leave_Details), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public void deleteByLeaveId(int id) {
        leaveRepository.deleteById(id);
    }

}
