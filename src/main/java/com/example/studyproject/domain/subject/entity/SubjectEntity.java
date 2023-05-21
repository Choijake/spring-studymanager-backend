package com.example.studyproject.domain.subject.entity;

import com.example.studyproject.domain.assignment.entity.AssignmentEntity;
import com.example.studyproject.domain.member.entity.MemberEntity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="subject_name")
    private long subject_name;
    private String subjectStatus; //진행, 완성, 시작전
    private String subjectStartDate;
    private String subjectEndDate;
    @OneToMany
    private Set<AssignmentEntity> assignments = new HashSet<>(); //과제 엔티티
    @OneToOne
    private MemberEntity member;
}
