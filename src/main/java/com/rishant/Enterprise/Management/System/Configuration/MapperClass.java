package com.rishant.Enterprise.Management.System.Configuration;

import com.rishant.Enterprise.Management.System.DTO.AdmissionDTO;
import com.rishant.Enterprise.Management.System.DTO.StudentDTO;
import com.rishant.Enterprise.Management.System.Entity.AdmissionEntity;
import com.rishant.Enterprise.Management.System.Entity.StudentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperClass {

    StudentDTO toDTO(StudentEntity studentEntity);
    StudentEntity toEntity(StudentDTO studentDTO);
    AdmissionEntity toEntity(AdmissionDTO admissionDTO);
    AdmissionDTO toDTO(AdmissionEntity admissionEntity);
}
