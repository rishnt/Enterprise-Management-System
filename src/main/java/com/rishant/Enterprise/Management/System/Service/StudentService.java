package com.rishant.Enterprise.Management.System.Service;

import com.rishant.Enterprise.Management.System.DTO.StudentDTO;
import com.rishant.Enterprise.Management.System.Entity.AdmissionEntity;
import com.rishant.Enterprise.Management.System.Entity.StudentEntity;
import com.rishant.Enterprise.Management.System.Repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper mapper;

    StudentService(StudentRepository studentRepository, ModelMapper mapper) {
        this.studentRepository = studentRepository;
        this.mapper = mapper;
    }

    private boolean existById(Long studentId) {
        return studentRepository.existsById(studentId);
    }

    public boolean createNewStudent(StudentDTO studentDTO) {
        StudentEntity entity = mapper.map(studentDTO, StudentEntity.class);
        StudentEntity savedEntity = studentRepository.save(entity);
        System.out.println("Created Student: " + savedEntity);
        return savedEntity != null && savedEntity.getStudentId() != null;
    }

    public Optional<StudentDTO> getStudentDetails(Long studentId) {
        boolean existById = existById(studentId);
        if (existById) {
            Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);
            return studentEntity.map(entity -> mapper.map(entity, StudentDTO.class));
        }
        return Optional.empty();
    }

    public List<StudentDTO> getAllDetails() {
        List<StudentEntity> detail = studentRepository.findAll();
        System.out.println("Retrieved Student Details:"+ detail);
        return detail.stream()
                .map(entity -> mapper.map(entity, StudentDTO.class))
                .toList();
    }

    public boolean deleteStudent(Long studentId) {
        if (studentRepository.existsById(studentId)) {
            studentRepository.deleteById(studentId);
            return true;
        }
        return false;
    }

    public StudentDTO updateStudentDetails(Long studentId, StudentDTO studentDTO) {
        boolean existById = existById(studentId);
        if (existById) {
            StudentEntity entity = mapper.map(studentDTO, StudentEntity.class);
            entity.setStudentId(studentId);
            StudentEntity savedEntity = studentRepository.save(entity);
            return mapper.map(savedEntity, StudentDTO.class);
        } else {
            return null;
        }
    }

    public StudentDTO updatePartialStudentDetails(Long studentId, Map<String, Object> details) {
        boolean existById = existById(studentId);
        if (existById) {
            StudentEntity entity = studentRepository.findById(studentId)
                    .orElseThrow(() -> new RuntimeException("Student not found"));

            details.forEach((key, value) -> {
                switch (key) {
                    case "studentName":
                        entity.setStudentName((String) value);
                        break;
                    case "studentAddress":
                        entity.setStudentAddress((String) value);
                        break;
                    default:
                        throw new RuntimeException("Invalid field: " + key);
                }
            });
            StudentEntity savedEntity = studentRepository.save(entity);
            return mapper.map(savedEntity, StudentDTO.class);
        } else {
            return null;
        }
    }
}
