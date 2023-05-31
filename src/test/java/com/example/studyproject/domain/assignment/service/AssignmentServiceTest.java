package com.example.studyproject.domain.assignment.service;

import org.junit.jupiter.api.Test;
import com.example.studyproject.domain.assignment.entity.AssignmentEntity;
import com.example.studyproject.domain.assignment.repository.AssignmentRepository;
import com.example.studyproject.domain.member.entity.MemberEntity;
import com.example.studyproject.domain.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.mockito.*;
import java.time.*;
import java.time.temporal.WeekFields;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AssignmentServiceTest {

    @Mock
    private AssignmentRepository assignmentRepository;

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private AssignmentService assignmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test getCurrentWeeks")
    void testGetCurrentWeeks() {
        // Set the current date to a specific week
        LocalDate currentDate = LocalDate.of(2023, 5, 31); // Adjust the date as needed
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int expectedWeek = currentDate.get(weekFields.weekOfWeekBasedYear());

        int actualWeek = assignmentService.getCurrentWeeks(null);

        assertEquals(expectedWeek, actualWeek);
    }

    @Test
    @DisplayName("Test updateMemberStatus")
    void testUpdateMemberStatus() {
        // Create a mock MemberEntity
        MemberEntity memberEntity = mock(MemberEntity.class);
        when(memberRepository.findByMemberName(anyString())).thenReturn(memberEntity);

        // Call the method
        assignmentService.updateMemberStatus("John Doe", 1, true, false);

        // Verify that the member's attendance and presentation status are updated
        verify(memberEntity).setAttendance(true);
        verify(memberEntity).setPresentation(false);
        verify(memberRepository).save(memberEntity);
    }

    @Test
    @DisplayName("Test getMemberStatusByWeek")
    void testGetMemberStatusByWeek() {
        // Create a mock MemberEntity
        MemberEntity memberEntity = mock(MemberEntity.class);
        when(memberRepository.findByMemberName(anyString())).thenReturn(memberEntity);

        // Set the attendance and presentation status for the member
        when(memberEntity.isAttendance()).thenReturn(true);
        when(memberEntity.isPresentation()).thenReturn(false);

        String expectedStatus = "Week 1: Attendance - 출석, Presentation - 미발표자";
        String actualStatus = assignmentService.getMemberStatusByWeek("John Doe", 1);

        assertEquals(expectedStatus, actualStatus);
    }

    @Test
    @DisplayName("Test updateWeeklyAssignment")
    void testUpdateWeeklyAssignment() {
        String assignmentName = "Assignment 1";

        // Call the method
        assignmentService.updateWeekelyAssignment(assignmentName);

        // Verify that the assignment is saved
        ArgumentCaptor<AssignmentEntity> captor = ArgumentCaptor.forClass(AssignmentEntity.class);
        verify(assignmentRepository).save(captor.capture());

        AssignmentEntity savedAssignment = captor.getValue();
        assertEquals(assignmentName, savedAssignment.getAssignmentName());
        assertEquals(0, savedAssignment.getWeeks());
    }
}
