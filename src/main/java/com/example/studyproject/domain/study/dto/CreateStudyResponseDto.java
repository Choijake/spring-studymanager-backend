package com.example.studyproject.domain.study.dto;

import com.example.studyproject.domain.study.entity.StudyEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateStudyResponseDto {

    private Long id;
    private String studyName;
    private String studySubject;
    private String studyMethod;

    @Builder
    public CreateStudyResponseDto(Long id, String studyName, String studySubject, String studyMethod) {
        this.id=id;
        this.studyName=studyName;
        this.studySubject=studySubject;
        this.studyMethod=studyMethod;
    }

    //dto->entity
    public StudyEntity toEntity(){
        StudyEntity build = StudyEntity.builder()
                .id(id)
                .studyName(studyName)
                .studySubject(studySubject)
                .studyMethod(studyMethod)
                .build();

        return build;
    }

}
