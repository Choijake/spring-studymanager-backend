package com.example.studyproject.domain.member.repository;

import com.example.studyproject.domain.member.dto.MemberDto;
import com.example.studyproject.domain.member.entity.MemberEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("멤버 생성이 db에 저장이 잘 되는지 확인")
    void createMember() {
        //given
        MemberEntity member1 = new MemberDto("류연경", true, true).toEntity();

        //when,then
        MemberEntity result1 = memberRepository.save(member1);
    }

}