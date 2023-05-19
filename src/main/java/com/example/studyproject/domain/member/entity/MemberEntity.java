package com.example.studyproject.domain.member.entity;

import com.example.studyproject.domain.subject.entity.SubjectEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@jakarta.persistence.Entity
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "")
    private String name;
    private boolean attendance; //출석 여부
    private boolean presentation; //발표 여부
    @OneToOne
    private SubjectEntity subject;
}
