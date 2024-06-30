package com.tlu.chuyende.service.impl;

import com.tlu.chuyende.exception.NotFoundException;
import com.tlu.chuyende.model.Semester;
import com.tlu.chuyende.repository.SemesterRepo;
import com.tlu.chuyende.service.SemesterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class SemesterServiceImpl implements SemesterService {

    SemesterRepo semesterRepo;

    @Override
    public List<Semester> getAllSemesters() {
        return semesterRepo.findAll();
    }

    @Override
    public Semester getSemesterById(int id) {
        return semesterRepo.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    @Override
    public Semester createSemester(Semester semester) {
        return semesterRepo.save(semester);
    }

    @Override
    public Semester updateSemester(int id, Semester newSemester) {
        if(!semesterRepo.existsById(id)){
            throw new NotFoundException(id);
        }
        newSemester.setSemesterId(id);
        return semesterRepo.save(newSemester);
    }

    @Override
    public boolean deleteSemesterById(int id) {
        if(!semesterRepo.existsById(id)){
            throw new NotFoundException(id);
        }
        semesterRepo.deleteById(id);
        return true;
    }
}
