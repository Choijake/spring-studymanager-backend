package com.example.studyproject.domain.member.entity;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberEntityTest {

    @Test
    @DisplayName("멤버생성 테스트")
    void createMember() {
        //given
        MemberEntity memberEntity = MemberEntity.builder().memberName("류연경").attendance(true).presentation(true).build();

        //when, then
        Assertions.assertThat(memberEntity.getMemberName()).isEqualTo("류연경");
        Assertions.assertThat(memberEntity.isAttendance()).isEqualTo(true);
        Assertions.assertThat(memberEntity.isPresentation()).isEqualTo(true);

    }

}