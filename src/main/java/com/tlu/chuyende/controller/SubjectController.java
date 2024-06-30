package com.tlu.chuyende.controller;


import com.tlu.chuyende.model.Student;
import com.tlu.chuyende.model.Subject;
import com.tlu.chuyende.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subject")
@AllArgsConstructor
public class SubjectController {

    SubjectService service;

    @GetMapping("")
    public ResponseEntity<Object> getAllSubjects(){
        return new ResponseEntity<>(service.getAllSubjects(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getSubjectById(@PathVariable int id){
        return new ResponseEntity<>(service.getSubjectById(id), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Object> createSubject(@RequestBody Subject subject){
        return new ResponseEntity<>(service.createSubject(subject), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSubject(@PathVariable int id, @RequestBody Subject subject){
        return new ResponseEntity<>(service.updateSubject(id, subject), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSubjectById(@PathVariable int id){
        return new ResponseEntity<>(service.deleteSubjectById(id), HttpStatus.OK);
    }
}
