package com.staffmanagement.management.service;

import com.staffmanagement.management.model.ClassDetails;
import com.staffmanagement.management.repository.ClassRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    public ClassDetails postClasses(ClassDetails classDetails) {

      

        return classRepository.save(classDetails);
    }

    public List<ClassDetails> getClasses() {
        return classRepository.findAll();
    }

    public void deleteClassId(int clsId) {
        classRepository.deleteById(clsId);
    }

    public ResponseEntity<ClassDetails> updateById(int clsId, ClassDetails classDetails) {
        Optional<ClassDetails> classUpdate = classRepository.findById(clsId);

    if (classUpdate.isPresent()) {

        ClassDetails clsDetails = classUpdate.get();
        clsDetails.setClsName(classDetails.getClsName());
      return new ResponseEntity<>(classRepository.save(clsDetails), HttpStatus.OK);
      
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    }
}
