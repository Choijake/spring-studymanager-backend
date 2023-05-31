package com.example.studyproject.domain.assignment.dto;

import com.example.studyproject.domain.assignment.entity.AssignmentEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class AssignmentDto {

        private String assignmentName;

        private int weeks;

        @Builder
        public AssignmentDto(String assignmentName, int weeks){
                this.assignmentName=assignmentName;
                this.weeks=weeks;
        }

        public AssignmentEntity toEntity() {
                AssignmentEntity build = AssignmentEntity.builder()
                        .assignmentName(assignmentName)
                        .weeks(weeks)
                        .build();
                return build;
        }
}
