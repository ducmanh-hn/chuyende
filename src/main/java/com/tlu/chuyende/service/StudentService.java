package com.tlu.chuyende.service;

import com.tlu.chuyende.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(int id);
    Student createStudent(Student student);
    Student updateStudent(int id, Student newStudent);
    boolean deleteStudentById(int id);
}
