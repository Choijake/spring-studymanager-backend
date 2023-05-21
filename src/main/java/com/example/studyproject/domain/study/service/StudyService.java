package com.example.studyproject.domain.study.service;

import com.example.studyproject.domain.study.dto.CreateStudyResponseDto;
import com.example.studyproject.domain.study.entity.StudyEntity;
import com.example.studyproject.domain.study.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudyService {
    private StudyRepository studyRepository;

    public StudyService(StudyRepository studyRepository){
        this.studyRepository = studyRepository;
    }


    //스터디 생성
    @Transactional
    public StudyEntity saveStudy(CreateStudyResponseDto csrd){
        StudyEntity studyEntity = csrd.toEntity();
        return studyRepository.save(studyEntity);
    }
}
