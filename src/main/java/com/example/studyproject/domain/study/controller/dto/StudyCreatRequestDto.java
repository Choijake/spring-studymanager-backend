package com.example.studyproject.domain.study.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudyCreatRequestDto {

  private String name;
  private String subject;
  private String method;
}
