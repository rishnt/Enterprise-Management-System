package com.rishant.Enterprise.Management.System.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProfessorDTO {
    private Long professor_id;
    private String title;
}
