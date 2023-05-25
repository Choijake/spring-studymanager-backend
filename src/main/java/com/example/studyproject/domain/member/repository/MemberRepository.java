package com.example.studyproject.domain.member.repository;

import com.example.studyproject.domain.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    MemberEntity findByMemberName(String memberName);
}
