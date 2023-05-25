package com.example.studyproject.domain.assignment.service;

import com.example.studyproject.domain.assignment.entity.AssignmentEntity;
import com.example.studyproject.domain.assignment.repository.AssignmentRepository;
import com.example.studyproject.domain.member.dto.MemberDto;
import com.example.studyproject.domain.member.entity.MemberEntity;
import com.example.studyproject.domain.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private AssignmentEntity assignmentEntity; //@Component 필수?

    //몇주차인지
    @Transactional
    public int getCurrentWeeks(AssignmentEntity assignmentEntity) {
        LocalDate currentDate = LocalDate.now();
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int weekNumber = currentDate.get(weekFields.weekOfWeekBasedYear());
        return weekNumber;
    }

    //주차별로 멤버들 상태 업데이트
    @Transactional
    public void updateMemberStatus(String memberName, int week, boolean attendance, boolean presentation) {
        MemberEntity memberEntity = memberRepository.findByMemberName(memberName);
        if (memberEntity != null) {
            memberEntity.setAttendance(attendance);
            memberEntity.setPresentation(presentation);
            memberRepository.save(memberEntity);
        }
        else {
            //에러 메시지
        }
    }


    //주차별로 상태 조회 메서드(1주차 ㅇㅇ 출석 )
    @Transactional
    public String getMemberStatusByWeek(String memberName, int week) {
        MemberEntity memberEntity = memberRepository.findByMemberName(memberName);
        if (memberEntity != null) {
            boolean attendance = memberEntity.isAttendance();
            boolean presentation = memberEntity.isPresentation();

            String status =
                    String.format("Week %d: Attendance - %s, Presentation - %s", week, attendance ? "출석" : "결석", presentation ? "발표자" : "미발표자");

            return status;
        } else {
            return "에러 메시지";
        }
    }

    //주차별로 과제이름(ex. 세션 4,5듣기)
    public void updateWeekelyAssignment(String weeklyAssignment){
        assignmentEntity.setAssignmentName(weeklyAssignment);
        assignmentRepository.save(assignmentEntity);
    }

    //주차별로 시작날짜와 끝나는 날짜

}
