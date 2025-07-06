package com.rishant.Enterprise.Management.System.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rishant.Enterprise.Management.System.DataValidation.SchoolNameValidation;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdmissionDTO {
    private Long admissionId;
    @NotNull
    private Integer admissionFees;
    @NotNull @SchoolNameValidation
    private String schoolName;
    @JsonManagedReference
    private StudentDTO student;
}
