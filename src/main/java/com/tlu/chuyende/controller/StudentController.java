package com.tlu.chuyende.controller;


import com.tlu.chuyende.model.Student;
import com.tlu.chuyende.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@AllArgsConstructor
public class StudentController {

    StudentService service;

    @GetMapping("")
    public ResponseEntity<Object> getAllStudents(){
        return new ResponseEntity<>(service.getAllStudents(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getStudentById(@PathVariable int id){
        return new ResponseEntity<>(service.getStudentById(id), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Object> createStudent(@RequestBody Student student){
        return new ResponseEntity<>(service.createStudent(student), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateStudent(@PathVariable int id, @RequestBody Student student){
        return new ResponseEntity<>(service.updateStudent(id, student), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStudentById(@PathVariable int id){
        return new ResponseEntity<>(service.deleteStudentById(id), HttpStatus.OK);
    }
}
