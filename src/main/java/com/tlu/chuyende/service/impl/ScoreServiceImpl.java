package com.tlu.chuyende.service.impl;

import com.tlu.chuyende.exception.NotFoundException;
import com.tlu.chuyende.model.Score;
import com.tlu.chuyende.repository.ScoreRepo;
import com.tlu.chuyende.service.ScoreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@AllArgsConstructor
public class ScoreServiceImpl implements ScoreService {

    ScoreRepo scoreRepo;

    @Override
    public List<Score> getAllScores() {
        return scoreRepo.findAll();
    }

    @Override
    public Score getScoreById(int id) {
        return scoreRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public Score createScore(Score score) {
        return scoreRepo.save(score);
    }

    @Override
    public Score updateScore(int id, Score newScore) {
        if(!scoreRepo.existsById(id)){
            throw new NotFoundException(id);
        }
        newScore.setScoreId(id);
        return scoreRepo.save(newScore);
    }

    @Override
    public boolean deleteScoreById(int id) {
        if(!scoreRepo.existsById(id)){
            throw new NotFoundException(id);
        }
        scoreRepo.deleteById(id);
        return true;
    }
}
