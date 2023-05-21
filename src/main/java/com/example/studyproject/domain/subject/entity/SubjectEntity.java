package com.example.studyproject.domain.subject.entity;

import com.example.studyproject.domain.assignment.entity.AssignmentEntity;
<<<<<<< HEAD

=======
>>>>>>> ee260c986bfc221c47f90a1b7909220df4288fa3
import com.example.studyproject.domain.member.entity.MemberEntity;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;

@Entity
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="subject_name")
    private long subject_name;
    private String subjectStatus; //진행, 완성, 시작전
    private String subjectStartDate;
    private String subjectEndDate;
    @OneToMany
    private Set<AssignmentEntity> assignments = new HashSet<>(); //과제 엔티티
    @OneToOne
    private MemberEntity member;
    @jakarta.persistence.Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
