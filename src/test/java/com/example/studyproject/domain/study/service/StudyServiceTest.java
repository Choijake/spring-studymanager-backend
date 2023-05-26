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
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {

    StudyService studyService;

    @MockBean
    StudyRepository studyRepository;

    @MockBean
    CreateStudyResponseDto csrd;

    @BeforeEach
    void setUp(){
        studyService = new StudyService(studyRepository);
    }

    @Test
    @DisplayName("스터디 목록 읽기 성공")
    void readAllStudy() {
        StudyEntity st1 = new StudyEntity(1L, "choi", "python", "dkdk");
        StudyEntity st2 = new StudyEntity(2L, "ryu", "java", "dfkfk");
        studyRepository.save(st1);
        studyRepository.save(st2);

        List<StudyEntity> expectedList = Arrays.asList(st1, st2);
        List<StudyEntity> actualList = studyService.readAllStudy();

        assertIterableEquals(expectedList, actualList);
    }



    @Test
    @DisplayName("스터디 저장 성공")
    void saveStudy() {
        // 테스트에 필요한 데이터 설정
        csrd = new CreateStudyResponseDto(1L, "choi", "python", "dkdk");
        csrd.toEntity(); // 필요한 속성 값 설정

        // 메서드 실행
        StudyEntity savedStudy = studyService.saveStudy(csrd);

        // 저장된 스터디의 속성 값 확인
        assertEquals(1L, savedStudy.getId()); // 예상한 값과 실제 값 비교
        assertEquals("choi", savedStudy.getStudyName());
        assertEquals("python", savedStudy.getStudySubject());
        assertEquals("dkdk", savedStudy.getStudyMethod());

        // 필요한 추가적인 검증 로직 추가 가능
    }


}