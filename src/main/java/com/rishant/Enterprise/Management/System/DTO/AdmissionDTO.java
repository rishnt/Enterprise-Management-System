package com.rishant.Enterprise.Management.System.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AdmissionDTO {
    private Long admission_id;
    private Integer admission_fees;
}
