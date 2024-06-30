package com.tlu.chuyende.controller;


import com.tlu.chuyende.model.Semester;
import com.tlu.chuyende.model.Student;
import com.tlu.chuyende.service.SemesterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/semester")
@AllArgsConstructor
public class SemesterController {

    SemesterService service;

    @GetMapping("")
    public ResponseEntity<Object> getAllSemesters(){
        return new ResponseEntity<>(service.getAllSemesters(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getSemesterById(@PathVariable int id){
        return new ResponseEntity<>(service.getSemesterById(id), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Object> createSemester(@RequestBody Semester semester){
        return new ResponseEntity<>(service.createSemester(semester), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSemester(@PathVariable int id, @RequestBody Semester semester){
        return new ResponseEntity<>(service.updateSemester(id, semester), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSemesterById(@PathVariable int id){
        return new ResponseEntity<>(service.deleteSemesterById(id), HttpStatus.OK);
    }


}
