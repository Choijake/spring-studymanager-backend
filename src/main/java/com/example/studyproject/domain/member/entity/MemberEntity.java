package com.example.studyproject.domain.member.entity;

import com.example.studyproject.domain.subject.entity.SubjectEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

@NoArgsConstructor
@Getter
@jakarta.persistence.Entity
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @Column(name = "")
    private String memberName;
    private boolean attendance=false; //출석 여부
    private boolean presentation=false; //발표 여부

    @OneToOne
    private SubjectEntity subject;

    @Builder
    public MemberEntity(Long id, String memberName, boolean attendance, boolean presentation) {
        this.id = id;
        this.memberName = memberName;
        this.attendance = attendance;
        this.presentation = presentation;
    }
    public void setAttendance(boolean attendance) {
        attendance = true;
    }

    public void setPresentation(boolean presentation) {
        presentation = true;
    }
}
