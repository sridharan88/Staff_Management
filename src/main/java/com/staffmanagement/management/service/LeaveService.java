package com.staffmanagement.management.service;

import com.staffmanagement.management.model.LeaveDetails;
import com.staffmanagement.management.repository.LeaveRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

  

    public void deleteByLeaveId(int id) {
        leaveRepository.deleteById(id);
    }

}
