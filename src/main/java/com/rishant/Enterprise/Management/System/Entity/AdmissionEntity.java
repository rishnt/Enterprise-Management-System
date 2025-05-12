package com.rishant.Enterprise.Management.System.Entity;

import jakarta.persistence.*;

@Entity
public class AdmissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long admission_id;
    private Integer admission_fees;
    @OneToOne
    @JoinColumn(name= "student_id",referencedColumnName = "student_id")
    private StudentEntity student;
}
