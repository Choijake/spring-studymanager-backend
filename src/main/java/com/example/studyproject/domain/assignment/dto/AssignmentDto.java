package com.example.studyproject.domain.assignment.dto;

import com.example.studyproject.domain.assignment.entity.AssignmentEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class AssignmentDto {

        private String assignmentName;

        private Date deadline;

        @Builder
        public AssignmentDto(String assignmentName, Date deadline){
                this.assignmentName=assignmentName;
                this.deadline=deadline;
        }

        public AssignmentEntity toEntity() {
                AssignmentEntity build = AssignmentEntity.builder()
                        .assignmentName(assignmentName)
                        .deadline(deadline)
                        .build();
                return build;
        }
}
