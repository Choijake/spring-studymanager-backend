package com.example.studyproject.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private boolean attendance; //출석 여부
    private boolean presentation; //발표 여부
}
