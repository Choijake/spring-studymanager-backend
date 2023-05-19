package com.example.studyproject.domain.member.repository;

import com.example.studyproject.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
