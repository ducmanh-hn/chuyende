package com.tlu.chuyende.service;

import com.tlu.chuyende.dto.ClassDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassService {
    List<ClassDto> getAllClasses();
    ClassDto getClassById(int id);
    ClassDto createClass(ClassDto classDto);
    ClassDto updateClass(int id, ClassDto classDto);
    boolean deleteClassById(int id);
}
