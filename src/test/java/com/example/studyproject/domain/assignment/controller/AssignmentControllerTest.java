package com.example.studyproject.domain.assignment.controller;

import com.example.studyproject.domain.assignment.dto.AssignmentDto;
import com.example.studyproject.domain.assignment.entity.AssignmentEntity;
import com.example.studyproject.domain.assignment.service.AssignmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

@WebMvcTest(AssignmentController.class)
public class AssignmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AssignmentService assignmentService;

    @Test
    public void getCurrentStudyWeek_ShouldReturnWeekNumber() throws Exception {
        int expectedWeek = 5;

        Mockito.when(assignmentService.getCurrentWeeks(Mockito.any(AssignmentEntity.class)))
                .thenReturn(expectedWeek);

        mockMvc.perform(MockMvcRequestBuilders.get("/assignment/week"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(String.valueOf(expectedWeek)));
    }

    @Test
    public void updateMemberStatus_ShouldCallServiceMethod() throws Exception {
        String memberName = "John";
        int week = 3;
        boolean attendance = true;
        boolean presentation = false;

        mockMvc.perform(MockMvcRequestBuilders.post("/assignment/updateMemberStatus")
                .param("memberName", memberName)
                .param("week", String.valueOf(week))
                .param("attendance", String.valueOf(attendance))
                .param("presentation", String.valueOf(presentation))
        ).andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(assignmentService, Mockito.times(1))
                .updateMemberStatus(memberName, week, attendance, presentation);
    }

    @Test
    public void getMemberStatusByWeek_ShouldReturnStatus() throws Exception {
        String memberName = "John";
        int week = 3;
        String expectedStatus = "Week 3: Attendance - 출석, Presentation - 미발표자";

        Mockito.when(assignmentService.getMemberStatusByWeek(memberName, week))
                .thenReturn(expectedStatus);

        mockMvc.perform(MockMvcRequestBuilders.get("/assignment/memberStatus")
                        .param("memberName", memberName)
                        .param("week", String.valueOf(week))
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedStatus));
    }

    @Test
    public void updateWeeklyAssignment_ShouldCallServiceMethod() throws Exception {
        AssignmentDto assignmentDto = AssignmentDto.builder()
                .assignmentName("Session 4,5")
                .weeks(4)
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(assignmentDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/assignment/updateWeeklyAssignment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
        ).andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(assignmentService, Mockito.times(1))
                .updateWeekelyAssignment(assignmentDto.getAssignmentName(), assignmentDto.getWeeks());
    }

}
