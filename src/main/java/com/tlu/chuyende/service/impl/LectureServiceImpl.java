package com.tlu.chuyende.service.impl;

import com.tlu.chuyende.exception.NotFoundException;
import com.tlu.chuyende.model.Lecturer;
import com.tlu.chuyende.repository.LecturerRepo;
import com.tlu.chuyende.service.LecturerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@AllArgsConstructor
public class LectureServiceImpl implements LecturerService {

    LecturerRepo lecturerRepo;

    @Override
    public List<Lecturer> getAllLecturers() {
        return lecturerRepo.findAll();
    }

    @Override
    public Lecturer getLecturerById(int id) {
        return lecturerRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public Lecturer createLecturer(Lecturer lecturer) {
        return lecturerRepo.save(lecturer);
    }

    @Override
    public Lecturer updateLecturer(int id, Lecturer newLecturer) {
        if(!lecturerRepo.existsById(id)){
            throw new NotFoundException(id);
        }
        newLecturer.setLecturerId(id);
        return lecturerRepo.save(newLecturer);
    }

    @Override
    public boolean deleteLecturerById(int id) {
        if(!lecturerRepo.existsById(id)){
            throw new NotFoundException(id);
        }
        lecturerRepo.deleteById(id);
        return true;
    }
}
