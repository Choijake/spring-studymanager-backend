package com.example.studyproject.domain.study.dto;

import com.example.studyproject.domain.study.entity.StudyEntity;
import lombok.*;

@Getter
@NoArgsConstructor
@Setter
public class CreateStudyResponseDto {

    private String studyName;
    private String studySubject;
    private String studyMethod;

    @Builder
    public CreateStudyResponseDto(String studyName, String studySubject, String studyMethod) {
        this.studyName=studyName;
        this.studySubject=studySubject;
        this.studyMethod=studyMethod;
    }

    //dto->entity
    public StudyEntity toEntity(){
        StudyEntity build = StudyEntity.builder()
                .studyName(studyName)
                .studySubject(studySubject)
                .studyMethod(studyMethod)
                .build();

        return build;
    }

}
