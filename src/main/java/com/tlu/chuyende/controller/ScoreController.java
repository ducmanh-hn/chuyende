package com.tlu.chuyende.controller;


import com.tlu.chuyende.model.Score;
import com.tlu.chuyende.model.Student;
import com.tlu.chuyende.service.ScoreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/score")
@AllArgsConstructor
public class ScoreController {

    ScoreService service;

    @GetMapping("")
    public ResponseEntity<Object> getAllScores(){
        return new ResponseEntity<>(service.getAllScores(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getScoreById(@PathVariable int id){
        return new ResponseEntity<>(service.getScoreById(id), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Object> createScore(@RequestBody Score score){
        return new ResponseEntity<>(service.createScore(score), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateScore(@PathVariable int id, @RequestBody Score score){
        return new ResponseEntity<>(service.updateScore(id, score), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteScoreById(@PathVariable int id){
        return new ResponseEntity<>(service.deleteScoreById(id), HttpStatus.OK);
    }
}
