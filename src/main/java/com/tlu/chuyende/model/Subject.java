package com.tlu.chuyende.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private int subjectId;

    private String name;

    private Float factor;                     // he so

    private boolean active;
}
