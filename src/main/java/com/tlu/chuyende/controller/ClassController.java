package com.tlu.chuyende.controller;

import com.tlu.chuyende.dto.ClassDto;
import com.tlu.chuyende.model.Account;
import com.tlu.chuyende.service.ClassService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/class")
@AllArgsConstructor
public class ClassController {

    ClassService service;

    @GetMapping("")
    public ResponseEntity<Object> getAllClasses(){
        return new ResponseEntity<>(service.getAllClasses(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getClassById(@PathVariable int id){
        return new ResponseEntity<>(service.getClassById(id), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Object> createClass(@RequestBody ClassDto classDto){
        return new ResponseEntity<>(service.createClass(classDto), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateClass(@PathVariable int id, @RequestBody ClassDto classDto){
        return new ResponseEntity<>(service.updateClass(id, classDto), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClassById(@PathVariable int id){
        return new ResponseEntity<>(service.deleteClassById(id), HttpStatus.OK);
    }
}
