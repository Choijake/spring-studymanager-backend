package com.example.studyproject.domain.member.controller;

import reference.study.entiy.Study;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberControllerTest {

  @Test
  @DisplayName("사용자는 스터디를 만들 수 있다.")
  void 스터디_개설() {
    String name = "최재익의 스터디 모임";
    String 주제 = "김영한님 로드맵 달리자";

    Study study = new Study(name, 주제);


  }

}