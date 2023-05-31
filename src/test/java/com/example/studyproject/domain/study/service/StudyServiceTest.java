package com.example.studyproject.domain.study.service;

import com.example.studyproject.domain.study.dto.CreateStudyResponseDto;
import com.example.studyproject.domain.study.entity.StudyEntity;
import com.example.studyproject.domain.study.repository.StudyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class StudyServiceTest {

    @Autowired
    StudyService studyService;

    @Autowired
    StudyRepository studyRepository;

    @BeforeEach
    void setUp(){
        studyService = new StudyService(studyRepository);
    }

    @Test
    @DisplayName("스터디 목록 읽기 성공")
    void readAllStudy() {
        // Given
        StudyEntity st1 = new StudyEntity("choi", "python", "dkdk");
        StudyEntity st2 = new StudyEntity("ryu", "java", "dfkfk");
        studyRepository.save(st1);
        studyRepository.save(st2);

        // When
        List<StudyEntity> actualList = studyService.readAllStudy();

        // Then
        assertEquals(2, actualList.size());
        assertEquals(st1.getStudyName(), actualList.get(0).getStudyName());
        assertEquals(st1.getStudySubject(), actualList.get(0).getStudySubject());
        assertEquals(st1.getStudyMethod(), actualList.get(0).getStudyMethod());
        assertEquals(st2.getStudyName(), actualList.get(1).getStudyName());
        assertEquals(st2.getStudySubject(), actualList.get(1).getStudySubject());
        assertEquals(st2.getStudyMethod(), actualList.get(1).getStudyMethod());
    }


    @Test
    @DisplayName("스터디 저장 성공")
    void saveStudy() {
        // 테스트에 필요한 데이터 설정

        CreateStudyResponseDto csrd = new CreateStudyResponseDto("choi", "python", "dkdk");
        csrd.toEntity(); // 필요한 속성 값 설정

        // 메서드 실행
        StudyEntity savedStudy = studyService.saveStudy(csrd);

        // 저장된 스터디의 속성 값 확인
        assertEquals("choi", savedStudy.getStudyName());
        assertEquals("python", savedStudy.getStudySubject());
        assertEquals("dkdk", savedStudy.getStudyMethod());

        // 필요한 추가적인 검증 로직 추가 가능
    }


}