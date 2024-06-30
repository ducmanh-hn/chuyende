package com.tlu.chuyende.service.impl;

import com.tlu.chuyende.exception.NotFoundException;
import com.tlu.chuyende.model.Subject;
import com.tlu.chuyende.repository.SubjectRepo;
import com.tlu.chuyende.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    SubjectRepo subjectRepo;

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepo.findAll();
    }

    @Override
    public Subject getSubjectById(int id) {
        return subjectRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public Subject createSubject(Subject subject) {
        return subjectRepo.save(subject);
    }

    @Override
    public Subject updateSubject(int id, Subject newSubject) {
        if(!subjectRepo.existsById(id)){
            throw new NotFoundException(id);
        }
        newSubject.setSubjectId(id);
        return subjectRepo.save(newSubject);
    }

    @Override
    public boolean deleteSubjectById(int id) {
        if(!subjectRepo.existsById(id)){
            throw new NotFoundException(id);
        }
        subjectRepo.deleteById(id);
        return true;
    }
}
