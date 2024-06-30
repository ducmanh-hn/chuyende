package com.tlu.chuyende.service.impl;

import com.tlu.chuyende.dto.ClassDetailDto;
import com.tlu.chuyende.exception.NotFoundException;
import com.tlu.chuyende.model.ClassDetail;
import com.tlu.chuyende.repository.ClassDetailRepo;
import com.tlu.chuyende.service.ClassDetailService;
import com.tlu.chuyende.utils.DtoTransfer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ClassDetailServiceImpl implements ClassDetailService {

    ClassDetailRepo cDRepo;
    DtoTransfer transfer;

    @Override
    public List<ClassDetailDto> getAllClassDetail() {
        return cDRepo.getAll();
    }

    @Override
    public ClassDetailDto getClassDetailById(int id) {
        if(!cDRepo.existsById(id)){
            throw new NotFoundException(id);
        }
        return cDRepo.getById(id);
    }

    @Override
    public ClassDetailDto createClassDetail(ClassDetailDto classDetailDto) {
        ClassDetail classDetail = transfer.toClassDetail(classDetailDto);
        ClassDetail save = cDRepo.save(classDetail);
        return new ClassDetailDto(save);
    }

    @Override
    public ClassDetailDto updateClassDetail(int id, ClassDetailDto classDetailDto) {
        if(!cDRepo.existsById(id)){
            throw new NotFoundException(id);
        }
        ClassDetail classDetail = transfer.toClassDetail(classDetailDto);
        classDetail.setId(id);
        ClassDetail save = cDRepo.save(classDetail);
        return new ClassDetailDto(save);
    }

    @Override
    public boolean deleteClassDetail(int id) {
        if(!cDRepo.existsById(id)){
            throw new NotFoundException(id);
        }
        cDRepo.deleteById(id);
        return true;
    }
}
