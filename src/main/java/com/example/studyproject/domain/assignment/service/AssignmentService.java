package com.example.studyproject.domain.assignment.service;

import com.example.studyproject.domain.assignment.entity.AssignmentEntity;
import com.example.studyproject.domain.assignment.repository.AssignmentRepository;
import com.example.studyproject.domain.member.dto.MemberDto;
import com.example.studyproject.domain.member.entity.MemberEntity;
import com.example.studyproject.domain.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private MemberEntity memberEntity;
    @Autowired
    private MemberRepository memberRepository;


    //몇주차인지
    @Transactional
    public int getCurrentWeeks(AssignmentEntity assignmentEntity) {
        LocalDate currentDate = LocalDate.now();
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int weekNumber = currentDate.get(weekFields.weekOfWeekBasedYear());
        return weekNumber;
    }
/*
    //주차별로 멤버들 상태 업데이트
    @Transactional
    public void updateMemberStatus(String memberName, int week, boolean attendance, boolean presentation) {
        MemberEntity memberEntity = memberRepository.findByMemberName(memberName);
        if (memberEntity != null) {
            // 해당 주차에 대한 멤버 상태 업데이트
            memberEntity.setAttendance(attendance);
            memberEntity.setPresentation(presentation);
            // ... (다른 필드 업데이트)
            memberRepository.save(memberEntity);
        } else {
            // 멤버가 존재하지 않을 경우 예외 처리 또는 새로운 멤버를 생성할 수도 있습니다.
        }

    }
    */

    //주차별로 상태 조회 메서드(1주차 ㅇㅇ 출석 )

    //주차별로 과제이름(ex. 세션 4,5듣기)

    //주차별로 시작날짜와 끝나는 날짜

}
