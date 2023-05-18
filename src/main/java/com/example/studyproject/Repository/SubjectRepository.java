package com.example.studyproject.Repository;

import com.example.studyproject.Entity.Subject;
import org.springframework.data.repository.CrudRepository;

interface SubjectRepository extends CrudRepository<Subject, String>{}