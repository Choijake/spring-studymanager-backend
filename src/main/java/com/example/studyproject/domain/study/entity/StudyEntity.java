package com.example.studyproject.domain.study.entity;

import com.example.studyproject.domain.defaultEntity.BaseTimeEntity;
import com.example.studyproject.domain.member.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class StudyEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    public StudyEntity(String studyName, String studySubject, String studyMethod){
        this.studyName = studyName;
        this.studySubject = studySubject;
        this.studyMethod= studyMethod;
    }


}
