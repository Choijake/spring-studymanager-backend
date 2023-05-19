package com.example.studyproject.Entity;

import jakarta.persistence.*;

@Entity
public class Assignment {

    //PK 지정
    @Id
    //데이터베이스에 따라 자동으로 ID가 지정 - 기본 세팅
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;
    private String name;
    private String startdate;
    private String finishdate;
    private float progress;


}
