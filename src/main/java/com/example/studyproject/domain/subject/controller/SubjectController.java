package com.example.studyproject.domain.subject.controller;

import com.example.studyproject.domain.member.dto.MemberDto;
import com.example.studyproject.domain.member.entity.MemberEntity;
import com.example.studyproject.domain.study.entity.StudyEntity;
import com.example.studyproject.domain.subject.service.SubjectDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/detail")
public class SubjectController {
    @Autowired
    private SubjectDetailService subjectDetailService;

    @PostMapping("/register")
    @ResponseBody
    public MemberEntity registerMember(@RequestBody MemberDto mto) {
        return subjectDetailService.saveMember(mto);
    }

    @GetMapping("/getMemberList")
    public List<MemberEntity> getMember() {
        return subjectDetailService.readAllMember();
    }

    @GetMapping("/getAllDetails")
    public List<StudyEntity> getAllDetails(){
        return subjectDetailService.readAllStudy();
    }

}
