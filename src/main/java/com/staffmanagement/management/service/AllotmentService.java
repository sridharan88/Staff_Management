package com.staffmanagement.management.service;

import com.staffmanagement.management.Exception.DaysNotFoundException;
import com.staffmanagement.management.Exception.HolydayException;
import com.staffmanagement.management.model.Allotment;
import com.staffmanagement.management.repository.AllotmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

}
