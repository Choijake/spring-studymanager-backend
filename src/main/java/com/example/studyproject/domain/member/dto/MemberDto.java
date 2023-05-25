package com.example.studyproject.domain.member.dto;

import com.example.studyproject.domain.member.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class MemberDto {
    private Long id;
    private String memberName;
    private boolean attendance; //출석 여부
    private boolean presentation; //발표 여부

    @Builder
    public MemberDto(Long id, String memberName, boolean attendance, boolean presentation) {
        this.id = id;
        this.memberName = memberName;
        this.attendance = attendance;
        this.presentation = presentation;
    }

    public MemberEntity toEntity(){
        MemberEntity build = MemberEntity.builder()
                .id(id)
                .memberName(memberName)
                .attendance(attendance)
                .presentation(presentation)
                .build();

        return build;
    }

    public MemberEntity toOnlyNameEntity(){
        MemberEntity onlyNamebuild = MemberEntity.builder()
                .id(id)
                .build();
        return onlyNamebuild;
    }
}
