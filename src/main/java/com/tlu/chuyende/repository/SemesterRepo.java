package com.tlu.chuyende.repository;

import com.tlu.chuyende.model.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemesterRepo extends JpaRepository<Semester, Integer> {
}
