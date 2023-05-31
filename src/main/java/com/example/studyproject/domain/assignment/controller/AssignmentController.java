package com.example.studyproject.domain.assignment.controller;

import com.example.studyproject.domain.assignment.entity.AssignmentEntity;
import com.example.studyproject.domain.assignment.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/assignment")
public class AssignmentController {

    private AssignmentService assignmentService;

    @Autowired
    AssignmentController(AssignmentService assignmentService){
        this.assignmentService = assignmentService;
    }

    /*
    @GetMapping("/week")
    @ResponseBody
    public int getCurrentStudyWeek(){
        assignmentService.getCurrentWeeks();
    }
    */
}
