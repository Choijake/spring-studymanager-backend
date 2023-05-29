package com.example.studyproject.domain.assignment.entity;

import com.example.studyproject.domain.defaultEntity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class AssignmentEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String assignmentName; //과제 이름

    @Column(nullable = false)
    private float assignmentProgress = 0; //진행률 퍼센트

    @Column(nullable = false)
    private int weeks; //몇주차 인지(=스터디주차)

    @Builder
    public AssignmentEntity(String assignmentName, int weeks ) {
        this.assignmentName = assignmentName;
        this.weeks = weeks;
    }
}
