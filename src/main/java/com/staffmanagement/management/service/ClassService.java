package com.staffmanagement.management.service;

import com.staffmanagement.management.model.ClassDetails;
import com.staffmanagement.management.repository.ClassRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
}
