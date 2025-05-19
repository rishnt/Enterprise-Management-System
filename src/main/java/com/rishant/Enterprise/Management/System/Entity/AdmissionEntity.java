package com.rishant.Enterprise.Management.System.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class AdmissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long admission_id;
    private Integer admission_fees;
//    @OneToOne
//    @JoinColumn(name= "student",referencedColumnName = "student_id")
//    private StudentEntity student;
}
