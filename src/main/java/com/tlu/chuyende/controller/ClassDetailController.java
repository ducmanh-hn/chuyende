package com.tlu.chuyende.controller;

import com.tlu.chuyende.dto.ClassDetailDto;
import com.tlu.chuyende.model.Lecturer;
import com.tlu.chuyende.service.ClassDetailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/class-detail")
@AllArgsConstructor
public class ClassDetailController {

    ClassDetailService service;

    @GetMapping("")
    public ResponseEntity<Object> getAllClassDetail(){
        return new ResponseEntity<>(service.getAllClassDetail(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getClassDetailById(@PathVariable int id){
        return new ResponseEntity<>(service.getClassDetailById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> createClassDetail(@RequestBody ClassDetailDto classDetailDto){
        return new ResponseEntity<>(service.createClassDetail(classDetailDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateClassDetail(@PathVariable int id, @RequestBody ClassDetailDto classDetailDto){
        return new ResponseEntity<>(service.updateClassDetail(id, classDetailDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClassDetail(@PathVariable int id){
        return new ResponseEntity<>(service.deleteClassDetail(id), HttpStatus.OK);
    }
}
