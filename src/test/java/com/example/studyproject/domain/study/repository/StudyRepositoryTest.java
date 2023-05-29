package com.example.studyproject.domain.study.repository;

import com.example.studyproject.domain.study.dto.CreateStudyResponseDto;
import com.example.studyproject.domain.study.entity.StudyEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class StudyRepositoryTest {

    @Autowired
    private StudyRepository studyRepository;

    @Test
    @DisplayName("스터디 만들기가 db에 저장이 잘 되는지 확인")
    void createStudy() {
        //given
        StudyEntity study1 = new CreateStudyResponseDto("알고리즘스터디", "백준", "줌").toEntity();

        //when
        StudyEntity result1 = studyRepository.save(study1);

        //then
//        assertThat(study1.getStudyName()).isEqualTo(result1.getStudyName());
//        assertThat(study1.getStudySubject()).isEqualTo(result1.getStudySubject());
//        assertThat(study1.getStudyMethod()).isEqualTo(result1.getStudyMethod());
//        assertThat(result1.getId()).isNotNull();
//        assertThat(studyRepository.count()).isEqualTo(1);

    }

}