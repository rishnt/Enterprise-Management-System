package com.rishant.Enterprise.Management.System.Repository;

import com.rishant.Enterprise.Management.System.DTO.AdmissionDTO;
import com.rishant.Enterprise.Management.System.Entity.AdmissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRepository extends JpaRepository<AdmissionEntity,Long> {

}
