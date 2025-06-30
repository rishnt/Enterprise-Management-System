package com.rishant.Enterprise.Management.System.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Long studentId;
    private String studentName;
    private String studentAddress;
//    private AdmissionDTO admission;
}
