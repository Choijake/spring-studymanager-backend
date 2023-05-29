package com.example.studyproject.domain.study.controller;

import com.example.studyproject.domain.study.dto.CreateStudyResponseDto;
import com.example.studyproject.domain.study.entity.StudyEntity;
import com.example.studyproject.domain.study.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //controller임을 알려주는 표시

@RequestMapping("/study")
public class StudyController {
    private StudyService studyService;

    @Autowired
    StudyController(StudyService studyService) {
        this.studyService=studyService;
    }

    @PostMapping("/create")
    @ResponseBody
    public StudyEntity createStudy(@RequestBody CreateStudyResponseDto csrd) {
        return studyService.saveStudy(csrd);
    }

    @GetMapping("/list")
    @ResponseBody
    public List<StudyEntity> getStudies() {
        return studyService.readAllStudy();
    }


}

