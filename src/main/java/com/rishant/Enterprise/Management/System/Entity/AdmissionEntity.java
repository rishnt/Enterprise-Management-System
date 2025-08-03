package com.rishant.Enterprise.Management.System.Entity;
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
    @JoinColumn(name = "ad_student_id", referencedColumnName = "studentId")
    private StudentEntity student;
}
