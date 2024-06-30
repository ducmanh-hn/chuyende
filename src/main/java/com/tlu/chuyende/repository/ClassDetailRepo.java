package com.tlu.chuyende.repository;

import com.tlu.chuyende.dto.ClassDetailDto;
import com.tlu.chuyende.model.ClassDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassDetailRepo extends JpaRepository<ClassDetail, Integer> {
    @Query("SELECT new com.tlu.chuyende.dto.ClassDetailDto(cd) FROM ClassDetail cd")
    List<ClassDetailDto> getAll();

    @Query("SELECT new com.tlu.chuyende.dto.ClassDetailDto(cd) FROM ClassDetail cd WHERE cd.id = ?1")
    ClassDetailDto getById(int id);

}
