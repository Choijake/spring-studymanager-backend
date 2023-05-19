package com.example.studyproject.repository;

import com.example.studyproject.Entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MemberRepository extends CrudRepository<Member, Integer> {}

