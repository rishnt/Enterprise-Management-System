package com.rishant.Enterprise.Management.System.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rishant.Enterprise.Management.System.DataValidation.StudentAddressValidation;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Long studentId;
    @NonNull
    private String studentName;
    @NotNull @StudentAddressValidation
    private String studentAddress;

    @JsonBackReference
    private AdmissionDTO admission;
}
