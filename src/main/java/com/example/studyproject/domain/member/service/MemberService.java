package com.example.studyproject.domain.member.service;

import com.example.studyproject.domain.member.dto.MemberDto;
import com.example.studyproject.domain.member.entity.MemberEntity;
import com.example.studyproject.domain.member.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }

    @Transactional
    public List<MemberEntity> readAllMember(){
        return memberRepository.findAll();
    }

    @Transactional
    public MemberEntity saveMember(MemberDto memberDto){
        MemberEntity memberEntity = memberDto.toEntity();
        return memberRepository.save(memberEntity);
    }

}
