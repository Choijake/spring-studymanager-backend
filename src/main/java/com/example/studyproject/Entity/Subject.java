package com.example.studyproject.Entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
//
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="subject_name")
    private long subject_name;
    private String state; //진행, 완성, 시작전
    private String startDate;
    private String endDate;
    @OneToMany
    private Set<Assignment> assignments = new HashSet<>();
}
