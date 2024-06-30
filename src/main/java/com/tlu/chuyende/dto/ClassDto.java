package com.tlu.chuyende.dto;

import com.tlu.chuyende.model.OClass;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClassDto implements Serializable {

    private int classId;
    private String className;
    private int subjectId;
    private int lecturerId;
    private int semesterId;
    private int capacity;
    private int realAmount;
    private Date updateScoreDate;

    public ClassDto(OClass oClass){
        this.setClassId(oClass.getClassId());
        this.setClassName(oClass.getClassName());
        this.setSubjectId(oClass.getSubject().getSubjectId());
        this.setLecturerId(oClass.getLecturer().getLecturerId());
        this.setSemesterId(oClass.getSemester().getSemesterId());
        this.setCapacity(oClass.getCapacity());
        this.setRealAmount(oClass.getRealAmount());
        this.setUpdateScoreDate(oClass.getUpdateScoreDate());
    }
}
