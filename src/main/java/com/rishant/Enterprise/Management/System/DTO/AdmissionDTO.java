package com.rishant.Enterprise.Management.System.DTO;

import com.rishant.Enterprise.Management.System.DataValidation.SchoolNameValidation;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdmissionDTO {
    private Long admissionId;
    @NotNull
    private Integer admissionFees;
    @NotNull @SchoolNameValidation
    private String schoolName;
}
