package com.example.studyproject.domain.assignment.repository;

import com.example.studyproject.domain.assignment.entity.AssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<AssignmentEntity, Long> {
}
