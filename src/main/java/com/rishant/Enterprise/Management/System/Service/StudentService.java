package com.rishant.Enterprise.Management.System.Service;

import com.rishant.Enterprise.Management.System.Configuration.MapperClass;
import com.rishant.Enterprise.Management.System.DTO.StudentDTO;
import com.rishant.Enterprise.Management.System.Entity.StudentEntity;
import com.rishant.Enterprise.Management.System.Repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final MapperClass mapper;
    StudentService(StudentRepository studentRepository,MapperClass mapper){
        this.studentRepository=studentRepository;
        this.mapper=mapper;
    }
    public StudentDTO createNewStudent(StudentDTO studentDTO) {
        StudentEntity entity = mapper.toEntity(studentDTO);
        StudentEntity savedEntity = studentRepository.save(entity);
        return mapper.toDTO(savedEntity);
   }
}
