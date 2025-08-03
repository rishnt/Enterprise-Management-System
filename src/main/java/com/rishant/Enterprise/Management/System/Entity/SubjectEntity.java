package com.rishant.Enterprise.Management.System.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;
    private String title;
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<ProfessorEntity> professors;
    @ManyToMany(mappedBy = "studentSubjects", cascade = CascadeType.ALL)
    private List<StudentEntity> students;
}
