package com.example.studyproject.Entity;

import jakarta.persistence.*;
//
public class Member_sub {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id; //일단 아무거나 넣음
    @ManyToOne
    private Subject subject;
    @ManyToOne
    private Member member;
}
