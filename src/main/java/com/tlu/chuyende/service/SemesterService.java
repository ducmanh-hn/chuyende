package com.tlu.chuyende.service;

import com.tlu.chuyende.model.Semester;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SemesterService {
    List<Semester> getAllSemesters();
    Semester getSemesterById(int id);
    Semester createSemester(Semester semester);
    Semester updateSemester(int id, Semester newSemester);
    boolean deleteSemesterById(int id);
}
