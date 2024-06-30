package com.tlu.chuyende.service;

import com.tlu.chuyende.dto.ClassDetailDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassDetailService {
    List<ClassDetailDto> getAllClassDetail();
    ClassDetailDto getClassDetailById(int id);
    ClassDetailDto createClassDetail(ClassDetailDto classDetailDto);
    ClassDetailDto updateClassDetail(int id, ClassDetailDto classDetailDto);
    boolean deleteClassDetail(int id);
}
