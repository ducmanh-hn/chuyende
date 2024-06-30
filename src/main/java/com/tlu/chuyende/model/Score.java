package com.tlu.chuyende.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "score_id")
    private int scoreId;

    @Column(name = "midterm_score")
    private float midtermScore;

    @Column(name = "final_score")
    private float finalScore;

    private float average;

    public void setAverage() {
        this.average = 0.7f*finalScore +0.3f*midtermScore;
    }
}
