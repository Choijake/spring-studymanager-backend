package com.example.studyproject.domain.assignment.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
public class AssignmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String assignmentName; //과제 이름

    @Column(nullable = false)
    private LocalDate assignmentStartDate;

    @Column(nullable = false)
    private LocalDate assignmentEndDate;

    @Column(nullable = false)
    private float assignmentProgress; //진행률 퍼센트

    @Column(nullable = false)
    private int weeks; //몇주차 인지



}
