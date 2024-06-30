package com.tlu.chuyende.service;

import com.tlu.chuyende.model.Score;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScoreService {
    List<Score> getAllScores();
    Score getScoreById(int id);
    Score createScore(Score score);
    Score updateScore(int id, Score newScore);
    boolean deleteScoreById(int id);
}
