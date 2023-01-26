package com.staffmanagement.management.service;

import com.staffmanagement.management.Exception.AlreadyExistsException;
import com.staffmanagement.management.model.Subject;
import com.staffmanagement.management.repository.SubjectRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;





@Service

public class SubjectService {
  @Autowired
  private SubjectRepository subjectRepository;

  public Subject saveSubject(Subject subject) throws Exception{

  Optional  <Subject> existSubject=subjectRepository.findById(subject.getSubId());
    if(existSubject != null){
      throw new AlreadyExistsException("This subject is Already Exists");
    }
    return subjectRepository.save(subject);
  }

  public List<Subject> getAllSubjects() {
    List<Subject> subjects = subjectRepository.findAll();
    return subjects;
  }

  public void deleteSubId(int subId) {
    subjectRepository.deleteById(subId);
  }

  public ResponseEntity<Subject> updateBySubId(int subId, Subject subject) {

    Optional<Subject> subjectUpdate = subjectRepository.findById(subId);

    if (subjectUpdate.isPresent()) {

      Subject sub_update = subjectUpdate.get();
      sub_update.setSubName(subject.getSubName());
      return new ResponseEntity<>(subjectRepository.save(sub_update), HttpStatus.OK);
      
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

  }






}
