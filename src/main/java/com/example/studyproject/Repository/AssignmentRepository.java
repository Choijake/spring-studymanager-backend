package com.example.studyproject.Repository;

import com.example.studyproject.Entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AssignmentRepository extends CrudRepository<Member, Long> {}