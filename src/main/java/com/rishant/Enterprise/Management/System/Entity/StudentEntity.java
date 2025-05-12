package com.rishant.Enterprise.Management.System.Entity;

import jakarta.persistence.*;

@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id;
    private String student_name;
    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private AdmissionEntity admission;
}
