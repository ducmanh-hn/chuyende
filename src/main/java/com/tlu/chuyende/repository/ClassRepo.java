package com.tlu.chuyende.repository;


import com.tlu.chuyende.dto.ClassDto;
import com.tlu.chuyende.model.OClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepo extends JpaRepository<OClass, Integer> {
    @Query("SELECT new com.tlu.chuyende.dto.ClassDto(c) From OClass c")
    List<ClassDto> getAllClasses();

    @Query("SELECT new com.tlu.chuyende.dto.ClassDto(c) FROM OClass c WHERE c.id = ?1")
    ClassDto getClassById(int id);


}
