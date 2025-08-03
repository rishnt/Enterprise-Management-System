package com.rishant.Enterprise.Management.System.DTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDTO {
    private Long professorId;
    private String title;
    @JsonManagedReference
    private SubjectDTO subject;
    @JsonManagedReference
    private List<StudentDTO> professorStudents;
}
