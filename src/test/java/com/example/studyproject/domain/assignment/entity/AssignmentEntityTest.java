package com.example.studyproject.domain.assignment.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssignmentEntityTest {

    @Test
    @DisplayName("과제생성 테스트")
    void createAssignmentTest() {
        //given
        AssignmentEntity assignmentEntity = AssignmentEntity.builder().assignmentName("스프링강의 섹션 5,6 듣기").weeks(5).build();

        //when, then
        Assertions.assertThat(assignmentEntity.getAssignmentName()).isEqualTo("스프링강의 섹션 5,6 듣기");
        Assertions.assertThat(assignmentEntity.getWeeks()).isEqualTo(5);
    }
}