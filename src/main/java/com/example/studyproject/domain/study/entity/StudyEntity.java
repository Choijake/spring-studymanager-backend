package com.example.studyproject.domain.study.entity;

import com.example.studyproject.domain.defaultEntity.BaseTimeEntity;
import com.example.studyproject.domain.member.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class StudyEntity extends BaseTimeEntity {

    @Id
    private Long id;
    @Column(nullable = false)
    private String studyName;

    @Column(nullable = false)
    private String studySubject;

    @Column(nullable = false)
    private String studyMethod;

    @OneToMany(fetch = FetchType.LAZY)
    private List<MemberEntity> members = new ArrayList<>();

    @Builder
    public StudyEntity(Long id, String studyName, String studySubject, String studyMethod){
        this.id = id;
        this.studyName = studyName;
        this.studySubject = studySubject;
        this.studyMethod= studyMethod;
    }


}
