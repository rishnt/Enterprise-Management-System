package com.rishant.Enterprise.Management.System.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rishant.Enterprise.Management.System.DTO.StudentDTO;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class AdmissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long admissionId;
    private Integer admissionFees;
    private String schoolName;
    @OneToOne(cascade = CascadeType.ALL)

    @JoinColumn(name = "student_id", referencedColumnName = "studentId")
    private StudentEntity student;
}
