package com.example.studyproject.repository;

import com.example.studyproject.Entity.Subject;
import org.springframework.data.repository.CrudRepository;

interface SubjectRepository extends CrudRepository<Subject, String>{}