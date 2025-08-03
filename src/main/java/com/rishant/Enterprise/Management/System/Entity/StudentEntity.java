package com.rishant.Enterprise.Management.System.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String studentName;
    private String studentAddress;
    @OneToOne(mappedBy = "student")
    private AdmissionEntity admission;
    @ManyToMany(mappedBy = "professorStudents", cascade = CascadeType.ALL)
    private List<ProfessorEntity> professors;
    @ManyToMany
    @JoinTable(name = "student_subject",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId"),
            inverseJoinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "subjectId"))
    private List<SubjectEntity> studentSubjects;
}
