package com.example.studyproject.domain.member.entity;

import com.example.studyproject.domain.subject.entity.SubjectEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@jakarta.persistence.Entity
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @Column(name = "")
    private String memberName;
    private boolean attendance; //출석 여부
    private boolean presentation; //발표 여부

    @OneToOne
    private SubjectEntity subject;

    @Builder
    public MemberEntity(Long id, String memberName, boolean attendance, boolean presentation) {
        this.id = id;
        this.memberName = memberName;
        this.attendance = attendance;
        this.presentation = presentation;
    }
}
