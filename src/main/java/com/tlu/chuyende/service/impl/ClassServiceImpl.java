package com.tlu.chuyende.service.impl;

import com.tlu.chuyende.dto.ClassDto;
import com.tlu.chuyende.exception.NotFoundException;
import com.tlu.chuyende.model.OClass;
import com.tlu.chuyende.repository.ClassRepo;
import com.tlu.chuyende.service.ClassService;
import com.tlu.chuyende.utils.DtoTransfer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ClassServiceImpl implements ClassService {

    ClassRepo classRepo;
    DtoTransfer transfer;

    @Override
    public List<ClassDto> getAllClasses() {
        return classRepo.getAllClasses();
    }

    @Override
    public ClassDto getClassById(int id) {
        if (!classRepo.existsById(id)){
            throw new NotFoundException(id);
        }
        return classRepo.getClassById(id);
    }

    @Override
    public ClassDto createClass(ClassDto classDto) {
        OClass oClass = transfer.toClass(classDto);
        OClass saveClass = classRepo.save(oClass);
        return new ClassDto(saveClass);
    }

    @Override
    public ClassDto updateClass(int id, ClassDto classDto) {
        if(!classRepo.existsById(id)){
            throw new NotFoundException(id);
        }
        OClass oClass = transfer.toClass(classDto);
        oClass.setClassId(id);
        OClass saveClass = classRepo.save(oClass);
        return new ClassDto(saveClass);
    }

    @Override
    public boolean deleteClassById(int id) {
        if(!classRepo.existsById(id)){
            throw new NotFoundException(id);
        }
        classRepo.deleteById(id);
        return true;
    }
}
