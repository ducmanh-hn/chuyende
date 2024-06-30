package com.tlu.chuyende.service;

import com.tlu.chuyende.model.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectService {
    List<Subject> getAllSubjects();
    Subject getSubjectById(int id);
    Subject createSubject(Subject subject);
    Subject updateSubject(int id, Subject newSubject);
    boolean deleteSubjectById(int id);
}
