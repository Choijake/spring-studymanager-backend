package com.example.studyproject.domain.study.controller;

import com.example.studyproject.domain.study.dto.CreateStudyResponseDto;
import com.example.studyproject.domain.study.entity.StudyEntity;
import com.example.studyproject.domain.study.service.StudyService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(StudyController.class)
public class StudyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudyService studyService;

    @Test
    @DisplayName("스터디 생성 ")
    public void testCreateStudy() throws Exception {
        // 테스트에 사용할 데이터 설정
        CreateStudyResponseDto createDto = CreateStudyResponseDto.builder()
                .studyName("Study 1")
                .studySubject("Subject 1")
                .studyMethod("Method 1")
                .build();

        StudyEntity savedStudy = StudyEntity.builder()
                .studyName("Study 1")
                .studySubject("Subject 1")
                .studyMethod("Method 1")
                .build();

        // studyService.saveStudy() 메서드의 동작 설정
        when(studyService.saveStudy(any(CreateStudyResponseDto.class))).thenReturn(savedStudy);

        // POST 요청을 보내고 응답 검증
        mockMvc.perform(post("/study/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(createDto)))
                .andExpect(status().isOk())
               // .andExpect(jsonPath("$.id", is(1))) // 수정된 부분
                .andExpect(jsonPath("$.studyName", is("Study 1")))
                .andExpect(jsonPath("$.studySubject", is("Subject 1")))
                .andExpect(jsonPath("$.studyMethod", is("Method 1")));

        // studyService.saveStudy() 메서드가 올바르게 호출되었는지 검증
        verify(studyService, times(1)).saveStudy(any(CreateStudyResponseDto.class));
    }


    @Test
    public void testGetStudies() throws Exception {
        // 테스트에 사용할 데이터 설정
        StudyEntity study1 = StudyEntity.builder()
                // .id(1L)
                .studyName("Study 1")
                .studySubject("Subject 1")
                .studyMethod("Method 1")
                .build();

        StudyEntity study2 = StudyEntity.builder()
               // .id(2L)
                .studyName("Study 2")
                .studySubject("Subject 2")
                .studyMethod("Method 2")
                .build();

        List<StudyEntity> studyList = Arrays.asList(study1, study2);

        // studyService.readAllStudy() 메서드의 동작 설정
        when(studyService.readAllStudy()).thenReturn(studyList);

        // GET 요청을 보내고 응답 검증
        mockMvc.perform(get("/study/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
               // .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].studyName", is("Study 1")))
                .andExpect(jsonPath("$[0].studySubject", is("Subject 1")))
                .andExpect(jsonPath("$[0].studyMethod", is("Method 1")))
               // .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].studyName", is("Study 2")))
                .andExpect(jsonPath("$[1].studySubject", is("Subject 2")))
                .andExpect(jsonPath("$[1].studyMethod", is("Method 2")));

        // studyService.readAllStudy() 메서드가 올바르게 호출되었는지 검증
        verify(studyService, times(1)).readAllStudy();
    }

    // 객체를 JSON 문자열로 변환하는 메서드
    private static String asJsonString(final Object obj) {
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
