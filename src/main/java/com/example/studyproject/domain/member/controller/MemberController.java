package com.example.studyproject.domain.member.controller;

import com.example.studyproject.domain.member.dto.MemberDto;
import com.example.studyproject.domain.member.entity.MemberEntity;
import com.example.studyproject.domain.member.service.MemberService;
import com.example.studyproject.domain.study.entity.StudyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    private MemberService memberService;

    @Autowired
    MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/member_create")
    @ResponseBody
    public MemberEntity createMember(@RequestBody MemberDto md) {
        return memberService.saveMember(md);
    }

    @GetMapping("/member_list")
    @ResponseBody
    public List<MemberEntity> getMembers() {
        return memberService.readAllMember();
    }

}
