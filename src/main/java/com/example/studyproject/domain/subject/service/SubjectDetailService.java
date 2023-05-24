package com.example.studyproject.domain.subject.service;

import com.example.studyproject.domain.study.entity.StudyEntity;
import com.example.studyproject.domain.study.repository.StudyRepository;
import com.example.studyproject.domain.study.service.StudyService;
import com.example.studyproject.domain.subject.repository.SubjectRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class SubjectService {

    private StudyRepository studyRepository;
    private SubjectRepository subjectRepository;
    private StudyService studyService;

    //
    public SubjectService(SubjectRepository subjectRepository,StudyRepository studyRepository) {
        this.subjectRepository = subjectRepository;
        this.studyRepository = studyRepository;
    }

    //스터디 목록에 있는 스터디이름, 과목이름을 보여줌
    @Transactional
    public List<StudyEntity> readAllStudy() {
        return studyRepository.findAll();
    }

    
}
