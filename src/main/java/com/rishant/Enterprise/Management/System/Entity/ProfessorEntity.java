package com.rishant.Enterprise.Management.System.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProfessorEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long professorId;
    private String title;
    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subjectId")
    private SubjectEntity subject;
    @ManyToMany
    @JoinTable(name = "professor_student",
            joinColumns = @JoinColumn(name = "professor_id", referencedColumnName = "professorId"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId"))
    private List<StudentEntity> professorStudents;
}
