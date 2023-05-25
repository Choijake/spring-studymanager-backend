package com.example.studyproject.domain.assignment.dto;


import com.example.studyproject.domain.assignment.entity.AssignmentEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class AssignmentDto {
        private Long id;
        private String assignmentName;
        private LocalDate assignmentStartDate;
        private LocalDate assignmentEndDate;
        private float assignmentProgress;
        private int weeks;

        @Builder
        public AssignmentDto(Long id, String assignmentName, LocalDate assignmentStartDate, LocalDate assignmentEndDate, float assignmentProgress, int weeks){
                this.id=id;
                this.assignmentName=assignmentName;
                this.assignmentStartDate=assignmentStartDate;
                this.assignmentEndDate=assignmentEndDate;
                this.assignmentProgress=assignmentProgress;
                this.weeks=weeks;
        }

        public AssignmentEntity toEntity() {
                AssignmentEntity build = AssignmentEntity.builder()
                        .id(id)
                        .assignmentName(assignmentName)
                        .assignmentStartDate(assignmentStartDate)
                        .assignmentEndDate(assignmentEndDate)
                        .assignmentProgress(assignmentProgress)
                        .weeks(weeks)
                        .build();
                return build;
        }
}
