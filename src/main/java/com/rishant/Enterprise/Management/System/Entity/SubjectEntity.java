package com.rishant.Enterprise.Management.System.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SubjectEntity {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subject_id;
    private String title;

}
