package com.staffmanagement.management.service;

import com.staffmanagement.management.Exception.AlreadyExistsException;
import com.staffmanagement.management.dto.StaffCountDto;
import com.staffmanagement.management.model.Allotment;
import com.staffmanagement.management.repository.AllotmentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class AllotmentService {
    @Autowired
    private AllotmentRepository allotmentRepository;
//    @Autowired
//    private ClassDetails classDetails;

    public Allotment saveAllotment(Allotment allotment) throws Exception {

       Allotment existAllotment = allotmentRepository.findAlreadyExist(allotment.getDays(),allotment.getPeriods(),allotment.getStaffDetails().getId());
        if(existAllotment!=null){
            throw new AlreadyExistsException(allotment.getStaffDetails().getName() +" already exist");
        }

                      return allotmentRepository.save(allotment);
          
    }
    

    public List<Allotment> getAllotment() {
        return allotmentRepository.findAll();
    }


    public ResponseEntity<Allotment> updateById(int dayID, Allotment allotment) {
        Optional<Allotment>timeTable=allotmentRepository.findById(dayID);
        if(timeTable.isPresent()){
            Allotment allot_Table=timeTable.get();
            allot_Table.setDays(allotment.getDays());
            allot_Table.setPeriods(allotment.getPeriods());
            allot_Table.setClassDetails(allotment.getClassDetails());
            allot_Table.setSubject(allotment.getSubject());
            allot_Table.setStaffDetails(allotment.getStaffDetails());

            return new ResponseEntity<>(allotmentRepository.save(allot_Table),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
       
    }


    public void deleteById(int dayID) {
        allotmentRepository.deleteById(dayID);
    }

    public  List<StaffCountDto> findCount(){
         return allotmentRepository.findAllStaffCount();
    }
}
