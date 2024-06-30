package com.tlu.chuyende.service;

import com.tlu.chuyende.model.Lecturer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LecturerService {
    List<Lecturer> getAllLecturers();
    Lecturer getLecturerById(int id);
    Lecturer createLecturer(Lecturer lecturer);
    Lecturer updateLecturer(int id, Lecturer newLecturer);
    boolean deleteLecturerById(int id);
}
