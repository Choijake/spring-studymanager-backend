package com.example.studyproject.domain.assignment.controller;

import com.example.studyproject.domain.assignment.dto.AssignmentDto;
import com.example.studyproject.domain.assignment.entity.AssignmentEntity;
import com.example.studyproject.domain.assignment.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/assignment")
public class AssignmentController {

    private final AssignmentService assignmentService;

    @Autowired
    AssignmentController(AssignmentService assignmentService){
        this.assignmentService = assignmentService;
    }

    @GetMapping("/week")
    @ResponseBody
    public int getCurrentStudyWeek(){
        AssignmentEntity assignmentEntity = new AssignmentEntity();
        return assignmentService.getCurrentWeeks(assignmentEntity);
    }

    @PostMapping("/updateMemberStatus")
    public void updateMemberStatus(@RequestParam String memberName, @RequestParam int week, @RequestParam boolean attendance, @RequestParam boolean presentation){
        assignmentService.updateMemberStatus(memberName, week, attendance, presentation);
    }

    @GetMapping("/readmemberStatus")
    public String getMemberStatusByWeek(@RequestParam String memberName, @RequestParam int week){
        return assignmentService.getMemberStatusByWeek(memberName, week);
    }

    @PostMapping("/updateWeeklyAssignment")
    public void updateWeekelyAssignment(@RequestBody AssignmentDto assignmentDto){
        assignmentService.updateWeekelyAssignment(assignmentDto.getAssignmentName(), assignmentDto.getDeadline());
    }


}

