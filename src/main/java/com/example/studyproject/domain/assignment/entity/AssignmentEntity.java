package com.example.studyproject.domain.assignment.entity;

import com.example.studyproject.domain.defaultEntity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Getter
@Entity
public class AssignmentEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String assignmentName; //과제 이름

//    @Column(nullable = false)
//    private float assignmentProgress = 0; //진행률 퍼센트

    @Column(nullable = false)
    private Date deadline;

    @Builder
    public AssignmentEntity(String assignmentName, Date deadline ) {
        this.assignmentName = assignmentName;
        this.deadline = deadline;
    }
}
