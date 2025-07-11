package com.rishant.Enterprise.Management.System.Service;

import com.rishant.Enterprise.Management.System.DTO.AdmissionDTO;
import com.rishant.Enterprise.Management.System.Entity.AdmissionEntity;
import com.rishant.Enterprise.Management.System.Entity.StudentEntity;
import com.rishant.Enterprise.Management.System.Repository.AdmissionRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AdmissionService {
    private final AdmissionRepository admissionRepository;
    private final ModelMapper mapper;

    AdmissionService(AdmissionRepository admissionRepository, ModelMapper mapper) {
        this.admissionRepository = admissionRepository;
        this.mapper = mapper;
    }

    public AdmissionDTO createNewAdmission(AdmissionDTO admissionDTO) {
        AdmissionEntity entity = mapper.map(admissionDTO, AdmissionEntity.class);
        AdmissionEntity savedEntity = admissionRepository.save(entity);
        return savedEntity != null
                ? mapper.map(savedEntity, AdmissionDTO.class)
                : null;
    }

    public AdmissionDTO getAdmissionDetailsById(Long admissionId) {
        Optional<AdmissionEntity> entity = admissionRepository.findById(admissionId);
        return entity.map(admissionEntity -> mapper.map(admissionEntity, AdmissionDTO.class))
                .orElseThrow(null);
    }

    public List<AdmissionDTO> getAdmissionDetails() {
        List<AdmissionEntity> entities = admissionRepository.findAll();
        if (!entities.isEmpty()) {
            return entities.stream()
                    .map(admissionEntity -> mapper.map(admissionEntity, AdmissionDTO.class))
                    .toList();
        } else {
            return null;
        }

    }

    public AdmissionDTO updateAdmissionDetails(Long admissionId, AdmissionDTO admissionDTO) {
        boolean exists = admissionRepository.existsById(admissionId);
        if (exists) {
            AdmissionEntity entity = mapper.map(admissionDTO, AdmissionEntity.class);
            entity.setAdmissionId(admissionId);
            AdmissionEntity savedEntity = admissionRepository.save(entity);
            return mapper.map(savedEntity, AdmissionDTO.class);
        } else {
            return null;
        }
    }

    public AdmissionDTO updatePartialDetails(Long admissionId, Map<String, Object> admissionDetails) {
        boolean exists = admissionRepository.existsById(admissionId);
        if (exists) {
            AdmissionEntity entity = admissionRepository.findById(admissionId)
                    .orElseThrow(() -> new RuntimeException("Admission not found"));

            admissionDetails.forEach((key, value) -> {
                switch (key) {
                    case "admissionFees":
                        entity.setAdmissionFees((Integer) value);
                        break;
                    case "schoolName":
                        entity.setSchoolName((String) value);
                        break;
                    default:
                        throw new RuntimeException("Invalid field: " + key);
                }
            });
            AdmissionEntity savedEntity = admissionRepository.save(entity);
            return mapper.map(savedEntity, AdmissionDTO.class);
        } else {
            return null;
        }
    }

    public boolean deleteAdmission(Long admissionId) {
        if (admissionRepository.existsById(admissionId)) {
            admissionRepository.deleteById(admissionId);
            return true;
        }
        return false;
    }

    public boolean deleteAllAdmissionDetails() {
        admissionRepository.deleteAll();
        return true;
    }

    @Transactional
    public void saveDataFromCsv() throws IOException {
        admissionRepository.deleteAll();
        try (InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream("admissions_500.csv");
             // InputStream => bytes
             // Input Stream Reader => bytes -> characters
             //Buffered Reader => characters -> lines
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            List<AdmissionEntity> admissions = new ArrayList<>();
            String line;
            boolean isFirst = true;
            while ((line = reader.readLine()) != null) {
                if (isFirst) {
                    isFirst = false; // skip the header
                    continue;
                }

                String[] parts = line.split(",");

                AdmissionEntity admission = new AdmissionEntity();
                admission.setAdmissionFees(Integer.parseInt(parts[0]));
                admission.setSchoolName(parts[1]);

                StudentEntity student = new StudentEntity();
                student.setStudentName(parts[2]);
                student.setStudentAddress(parts[3]);
                boolean exists = admissionRepository.existsBySchoolNameAndStudent_StudentNameAndStudent_StudentAddress(
                        parts[1], parts[2], parts[3]
                );

                if (exists) {
                    System.out.println("The record"+parts[1]+" "+parts[2]+" "+parts[3]+" is already present in the database");
                    continue; // Skip inserting this record
                }
                else{
                    admission.setStudent(student);
                    admissions.add(admission);
                }
            }

            admissionRepository.saveAll(admissions);
        }
    }
}
