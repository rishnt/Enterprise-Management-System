package com.rishant.Enterprise.Management.System.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentEntity {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id;
    private String student_name;
}
