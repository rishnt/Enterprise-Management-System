package com.rishant.Enterprise.Management.System.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class SubjectDTO {
    private Long subject_id;
    private String title;
}
