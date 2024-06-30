package com.tlu.chuyende.dto;

import com.tlu.chuyende.model.ClassDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassDetailDto implements Serializable {
    private Integer id;
    private int studentId;
    private int classId;
    private Integer scoreId;

    public ClassDetailDto(ClassDetail classDetail){
        this.setId(classDetail.getId());
        this.setStudentId(classDetail.getStudent().getStudentId());
        this.setClassId(classDetail.getOClass().getClassId());
        this.setScoreId(classDetail.getScore().getScoreId());
    }
}
