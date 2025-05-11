package com.rishant.Enterprise.Management.System.Repository;

import com.rishant.Enterprise.Management.System.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
}
