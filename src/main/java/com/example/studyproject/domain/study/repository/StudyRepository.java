package com.example.studyproject.domain.study.repository;

import com.example.studyproject.domain.study.entity.StudyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<StudyEntity, Long> {}
