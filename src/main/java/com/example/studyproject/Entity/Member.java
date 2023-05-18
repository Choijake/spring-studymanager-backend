package com.example.studyproject.Entity;

import jakarta.persistence.*;

//
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private String name;
    private boolean attendance; //출석 여부
    private boolean presentation; //발표 여부
    @OneToOne
    private Subject subject;
}
