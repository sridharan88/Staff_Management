package com.staffmanagement.management.service;

import com.staffmanagement.management.Exception.DaysNotFoundException;
import com.staffmanagement.management.Exception.HolydayException;
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

        String day = allotment.days;
        day = day.toUpperCase();

        if (day.equals("MONDAY" )    || day.equals("THUESDAY")  ||
            day.equals("WEDNESDAY")  || day.equals("THURSDAY")  ||
            day.equals("FRIDAY")) {

            // if (classDetails.periodCounts >= allotment.periods) {

                return allotmentRepository.save(allotment);
            }

            // } else {

            //     throw new PeriodCountMismatchException();
            // }
        // }

         else if (day.equals("SATURDAY") || day.equals("SUNDAY") )  {

              throw new HolydayException();

        } else {

              throw new DaysNotFoundException();
        }
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

}
