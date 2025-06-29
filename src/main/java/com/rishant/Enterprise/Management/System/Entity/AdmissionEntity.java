package com.rishant.Enterprise.Management.System.Entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Entity
public class AdmissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long admissionId;
    private Integer admissionFees;
    private String schoolName;
//    @OneToOne
//    @JoinColumn(name= "student",referencedColumnName = "student_id")
//    private StudentEntity student;
}
