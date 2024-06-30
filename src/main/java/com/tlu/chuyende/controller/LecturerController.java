package com.tlu.chuyende.controller;

import com.tlu.chuyende.model.Lecturer;
import com.tlu.chuyende.service.LecturerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lecturer")
@AllArgsConstructor
public class LecturerController {

    LecturerService service;

    @GetMapping("")
    public ResponseEntity<Object> getAllLecturers(){
        return new ResponseEntity<>(service.getAllLecturers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getLecturerById(@PathVariable int id){
        return new ResponseEntity<>(service.getLecturerById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> createLecturer(@RequestBody Lecturer lecturer){
        return new ResponseEntity<>(service.createLecturer(lecturer), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateLecturer(@PathVariable int id, @RequestBody Lecturer lecturer){
        return new ResponseEntity<>(service.updateLecturer(id, lecturer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteLecturer(@PathVariable int id){
        return new ResponseEntity<>(service.deleteLecturerById(id), HttpStatus.OK);
    }

}
