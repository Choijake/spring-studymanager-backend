package com.example.studyproject.domain.study.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class StudyEntityTest {

 @Test
 @DisplayName("엔티티 생성 테스트")
  void createStudy() {
   //given
   StudyEntity studyEntity = StudyEntity.builder().studyName("celina").studySubject("파이썬").studyMethod("spring")
           .build();
   //when, then
  Assertions.assertThat(studyEntity.getStudyName()).isEqualTo("celina");
  Assertions.assertThat(studyEntity.getStudySubject()).isEqualTo("파이썬");
  Assertions.assertThat(studyEntity.getStudyMethod()).isEqualTo("spring");
  }



}