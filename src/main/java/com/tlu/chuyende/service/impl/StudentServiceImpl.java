package com.tlu.chuyende.service.impl;

import com.tlu.chuyende.exception.NotFoundException;
import com.tlu.chuyende.model.Student;
import com.tlu.chuyende.repository.StudentRepo;
import com.tlu.chuyende.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    StudentRepo studentRepo;

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepo.findById(id).orElseThrow(()-> new NotFoundException(id));
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student updateStudent(int id, Student newStudent) {
        if(!studentRepo.existsById(id)){
            throw new NotFoundException(id);
        }
        newStudent.setStudentId(id);
        return studentRepo.save(newStudent);
    }

    @Override
    public boolean deleteStudentById(int id) {
        if(!studentRepo.existsById(id)){
            throw new NotFoundException(id);
        }
        studentRepo.deleteById(id);
        return true;
    }
}
