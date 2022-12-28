package com.staffmanagement.management.service;

import com.staffmanagement.management.model.Subject;
import com.staffmanagement.management.repository.SubjectRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public void deleteSubId(int subId) {
        subjectRepository.deleteById(subId);
    }

    public Optional<Subject> updateBySubId(Subject subject) {
        if (subjectRepository.existsById(subject.getSubId())) {
            return Optional.of(subjectRepository.save(subject));
        } else {
            return null;
        }
        
    }

}
