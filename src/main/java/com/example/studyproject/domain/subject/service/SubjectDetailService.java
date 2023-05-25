package com.example.studyproject.domain.subject.service;

import com.example.studyproject.domain.member.dto.MemberDto;
import com.example.studyproject.domain.member.entity.MemberEntity;
import com.example.studyproject.domain.member.repository.MemberRepository;
import com.example.studyproject.domain.study.entity.StudyEntity;
import com.example.studyproject.domain.study.repository.StudyRepository;
import com.example.studyproject.domain.study.service.StudyService;
import com.example.studyproject.domain.subject.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class SubjectDetailService {
    @Autowired
    private StudyRepository studyRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private StudyService studyService;
    @Autowired
    private MemberRepository memberRepository;

    //스터디 목록에 있는 스터디이름, 과목이름을 보여줌
    @Transactional
    public List<StudyEntity> readAllStudy() {
        return studyRepository.findAll();
    }

    //어떤 멤버가 참여하는지 입력(등록), 나중에 기능 확인해야함
    @Transactional
    public MemberEntity saveMember(MemberDto memberDto){
        MemberEntity memberEntity = memberDto.toOnlyNameEntity();
        return memberRepository.save(memberEntity);
    }

    //어떤 멤버가 참여하는지 보여줌
    @Transactional
    public List<MemberEntity> readAllMember(){
        return memberRepository.findAll();
    }

    //벌금 보류


}
