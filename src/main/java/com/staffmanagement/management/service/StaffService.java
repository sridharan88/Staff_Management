package com.staffmanagement.management.service;

import com.staffmanagement.management.model.StaffDetails;
import com.staffmanagement.management.repository.StaffRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service

public class StaffService {
    @Autowired
    private StaffRepository staffRepository;

    public StaffDetails storeMethod(StaffDetails staffDetails)  {
         
              return staffRepository.save(staffDetails);
    }

    public List<StaffDetails> getStaffs() {
        return staffRepository.findAll();
    }

    public void deleteStaffId(int id) {
        staffRepository.deleteById(id);
    }
   

    public ResponseEntity<StaffDetails> updateById(int id, StaffDetails staffDetails) {
      Optional<StaffDetails>staff=staffRepository.findById(id);
      if(staff.isPresent()){
        StaffDetails sDetails=staff.get();
        sDetails.setName(staffDetails.getName());
        sDetails.setEmail(staffDetails.getEmail());
        sDetails.setPhoneNo(staffDetails.getPhoneNo());
        return new ResponseEntity<>(staffRepository.save(sDetails),HttpStatus.OK);

      }else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
public List<StaffDetails> getBySubId(int subId){
  return staffRepository.findAllStaff(subId);
}

}
