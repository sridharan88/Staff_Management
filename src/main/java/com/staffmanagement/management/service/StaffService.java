package com.staffmanagement.management.service;

import com.staffmanagement.management.model.StaffDetails;
import com.staffmanagement.management.repository.StaffRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class StaffService {
    @Autowired
    private StaffRepository staffRepository;

    public StaffDetails storeMethod(StaffDetails staffDetails) {
        return staffRepository.save(staffDetails);
    }

    public List<StaffDetails> getStaffs() {
        return staffRepository.findAll();
    }

    public void deleteStaffId(int id) {
        staffRepository.deleteById(id);
    }
    public  Optional<StaffDetails> getByID(int id){
        return staffRepository.findById(id);
    }

}
