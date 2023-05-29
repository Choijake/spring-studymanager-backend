package com.example.studyproject.domain.assignment.repository;

import com.example.studyproject.domain.assignment.entity.AssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepository extends JpaRepository<AssignmentEntity, Long> {
}
