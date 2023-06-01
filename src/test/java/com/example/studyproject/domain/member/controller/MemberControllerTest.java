package com.example.studyproject.domain.member.controller;

import com.example.studyproject.domain.assignment.controller.AssignmentController;
import com.example.studyproject.domain.assignment.service.AssignmentService;
import com.example.studyproject.domain.member.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.example.studyproject.domain.member.dto.MemberDto;
import com.example.studyproject.domain.member.entity.MemberEntity;
import com.example.studyproject.domain.member.service.MemberService;
import com.example.studyproject.domain.study.entity.StudyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest(MemberController.class)
public class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @Test
    public void createMember_ShouldReturnCreatedMember() throws Exception {
        MemberDto memberDto = MemberDto.builder()
                .memberName("John Doe")
                .attendance(true)
                .presentation(false)
                .build();

        MemberEntity createdMember = MemberEntity.builder()
                .memberName("John Doe")
                .attendance(true)
                .presentation(false)
                .build();

        Mockito.when(memberService.saveMember(Mockito.any(MemberDto.class))).thenReturn(createdMember);

        mockMvc.perform(MockMvcRequestBuilders.post("/member_create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(memberDto))
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.memberName", Matchers.is("John Doe")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.attendance", Matchers.is(true)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.presentation", Matchers.is(false)));
    }

    @Test
    public void getMembers_ShouldReturnListOfMembers() throws Exception {
        MemberEntity member1 = MemberEntity.builder()
                .memberName("John Doe")
                .attendance(true)
                .presentation(false)
                .build();

        MemberEntity member2 = MemberEntity.builder()
                .memberName("Jane Smith")
                .attendance(false)
                .presentation(true)
                .build();

        List<MemberEntity> memberList = Arrays.asList(member1, member2);

        Mockito.when(memberService.readAllMember()).thenReturn(memberList);

        mockMvc.perform(MockMvcRequestBuilders.get("/member_list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].memberName", Matchers.is("John Doe")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].attendance", Matchers.is(true)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].presentation", Matchers.is(false)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].memberName", Matchers.is("Jane Smith")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].attendance", Matchers.is(false)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].presentation", Matchers.is(true)));
    }

    // Helper method to convert object to JSON string
    private static String asJsonString(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
