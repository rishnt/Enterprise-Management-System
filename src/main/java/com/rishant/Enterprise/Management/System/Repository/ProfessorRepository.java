package com.rishant.Enterprise.Management.System.Repository;

import com.rishant.Enterprise.Management.System.Entity.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity,Long> {
}
