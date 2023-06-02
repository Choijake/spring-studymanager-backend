package com.example.studyproject.domain.assignment.repository;

import com.example.studyproject.domain.assignment.dto.AssignmentDto;
import com.example.studyproject.domain.assignment.entity.AssignmentEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AssignmentRepositoryTest {

    @Autowired
    private AssignmentRepository assignmentRepository;

//    @Test
//    @DisplayName("과제 생성이 db에 잘 저장이 되는지 확인")
//    void createAssignment() {
//        //given
//        AssignmentEntity assignment1 = new AssignmentDto("파이썬 1강 듣기", 5).toEntity();
//
//        //when,then
//        AssignmentEntity result1 = assignmentRepository.save(assignment1);
//    }
}