package com.rishant.Enterprise.Management.System.DTO;

import com.rishant.Enterprise.Management.System.DataValidation.StudentAddressValidation;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Long studentId;
    @NonNull
    private String studentName;
    @NotNull @StudentAddressValidation
    private String studentAddress;
}
