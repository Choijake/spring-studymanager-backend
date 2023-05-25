package com.example.studyproject.domain.assignment.entity;



import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@NoArgsConstructor
@Getter
@Entity
public class AssignmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String assignmentName; //과제 이름

    @Column(nullable = false)
    private LocalDate assignmentStartDate;

    @Column(nullable = false)
    private LocalDate assignmentEndDate;

    @Column(nullable = false)
    private float assignmentProgress; //진행률 퍼센트

    @Column(nullable = false)
    private int weeks; //몇주차 인지(=스터디주차)

    @Builder
    public AssignmentEntity(Long id, String assignmentName, LocalDate assignmentStartDate, LocalDate assignmentEndDate, float assignmentProgress, int weeks ){
        this.id = id;
        this.assignmentName = assignmentName;
        this.assignmentStartDate = assignmentStartDate;
        this.assignmentEndDate = assignmentEndDate;
        this.assignmentProgress = assignmentProgress;
        this.weeks = weeks;
    }

    public void setAssignmentName(String assignmentName){
        this.assignmentName = assignmentName;
    }
}
