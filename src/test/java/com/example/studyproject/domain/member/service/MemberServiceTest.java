package com.example.studyproject.domain.member.service;

import com.example.studyproject.domain.member.dto.MemberDto;
import com.example.studyproject.domain.member.entity.MemberEntity;
import com.example.studyproject.domain.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    @Transactional
    public void saveMemberTest() {
        // Given
        MemberDto memberDto = MemberDto.builder()
                .memberName("John")
                .attendance(true)
                .presentation(false)
                .build();

        // When
        MemberEntity savedMember = memberService.saveMember(memberDto);

        // Then
        assertNotNull(savedMember.getId());
        assertEquals("John", savedMember.getMemberName());
        assertEquals(true, savedMember.isAttendance());
        assertEquals(false, savedMember.isPresentation());
    }
}