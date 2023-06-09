package com.example.studyproject.domain.study.service;

import com.example.studyproject.domain.study.dto.CreateStudyResponseDto;
import com.example.studyproject.domain.study.entity.StudyEntity;
import com.example.studyproject.domain.study.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudyService {

    @Autowired
    private StudyRepository studyRepository;

    public StudyService(StudyRepository studyRepository){
        this.studyRepository = studyRepository;
    }

    //스터디 목록 보기
    @Transactional
    public List<StudyEntity> readAllStudy() {
        return studyRepository.findAll();
    }

    //스터디 생성
    @Transactional
    public StudyEntity saveStudy(CreateStudyResponseDto csrd){
        StudyEntity studyEntity = csrd.toEntity();
        return studyRepository.save(studyEntity);
    }
}
