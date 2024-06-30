package com.tlu.chuyende.utils;

import com.tlu.chuyende.dto.ClassDetailDto;
import com.tlu.chuyende.dto.ClassDto;
import com.tlu.chuyende.exception.NotFoundException;
import com.tlu.chuyende.model.*;
import com.tlu.chuyende.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
@AllArgsConstructor
public class DtoTransfer {

    private final SubjectRepo subjectRepo;
    private final LecturerRepo lecturerRepo;
    private final SemesterRepo semesterRepo;
    private final StudentRepo studentRepo;
    private final ScoreRepo scoreRepo;
    private final ClassRepo classRepo;

    public OClass toClass(ClassDto classDto){

        Subject subject = subjectRepo.findById(classDto.getSubjectId())
                .orElseThrow(() -> new NotFoundException(classDto.getSubjectId()));
        Lecturer lecturer = lecturerRepo.findById(classDto.getLecturerId())
                .orElseThrow(() -> new NotFoundException(classDto.getLecturerId()));
        Semester semester = semesterRepo.findById(classDto.getSemesterId())
                .orElseThrow(() -> new NotFoundException(classDto.getSemesterId()));

        int classId = classDto.getClassId();
        String className = classDto.getClassName();
        int capacity = classDto.getCapacity();
        int realAmount = classDto.getRealAmount();
        Date updateScoreDate = classDto.getUpdateScoreDate();

        return OClass.builder()
                .classId(classId)
                .className(className)
                .subject(subject)
                .lecturer(lecturer)
                .semester(semester)
                .capacity(capacity)
                .realAmount(realAmount)
                .updateScoreDate(updateScoreDate).build();
    }

    public ClassDetail toClassDetail(ClassDetailDto dto){
        OClass oClass = classRepo.findById(dto.getClassId())
                .orElseThrow(() -> new NotFoundException(dto.getClassId()));
        Student student = studentRepo.findById(dto.getStudentId())
                .orElseThrow(() -> new NotFoundException(dto.getStudentId()));
        Score score = scoreRepo.findById(dto.getScoreId())
                .orElse(null);
        Integer classDetailId = dto.getId();

        return ClassDetail.builder()
                .id(classDetailId)
                .oClass(oClass)
                .student(student)
                .score(score).build();
    }
}
