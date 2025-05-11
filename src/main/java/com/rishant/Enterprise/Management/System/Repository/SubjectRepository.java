package com.rishant.Enterprise.Management.System.Repository;

import com.rishant.Enterprise.Management.System.Entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity,Long> {
}
