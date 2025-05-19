package com.rishant.Enterprise.Management.System.Service;
import com.rishant.Enterprise.Management.System.DTO.StudentDTO;
import com.rishant.Enterprise.Management.System.Entity.StudentEntity;
import com.rishant.Enterprise.Management.System.Repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper mapper;

    StudentService(StudentRepository studentRepository, ModelMapper mapper){
        this.studentRepository=studentRepository;
        this.mapper=mapper;
    }
    public StudentDTO createNewStudent(StudentDTO studentDTO) {
        StudentEntity entity = mapper.map(studentDTO, StudentEntity.class);
        StudentEntity savedEntity = studentRepository.save(entity);
        System.out.println("Created Student: " + savedEntity);
        return mapper.map(savedEntity, StudentDTO.class);
   }
}
