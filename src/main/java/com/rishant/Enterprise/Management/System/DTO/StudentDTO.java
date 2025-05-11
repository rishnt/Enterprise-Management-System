package com.rishant.Enterprise.Management.System.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class StudentDTO {
    private Long student_id;
    private String student_name;
}
