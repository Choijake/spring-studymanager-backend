package com.example.studyproject.domain.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Member {

  @Id
  private Long id;

  @Column(nullable = false)
  private String name;


}
