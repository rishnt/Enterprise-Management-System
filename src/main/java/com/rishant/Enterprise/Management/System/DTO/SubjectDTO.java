package com.rishant.Enterprise.Management.System.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {
    private Long subjectId;
    private String title;
    @JsonBackReference
    private List<ProfessorDTO> professors;
    @JsonBackReference
    private List<StudentDTO> students;
}
