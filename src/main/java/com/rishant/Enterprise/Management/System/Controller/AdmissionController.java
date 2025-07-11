package com.rishant.Enterprise.Management.System.Controller;

import com.rishant.Enterprise.Management.System.DTO.AdmissionDTO;
import com.rishant.Enterprise.Management.System.Service.AdmissionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/admission")
public class AdmissionController {

    private final AdmissionService admissionService;

    AdmissionController(AdmissionService admissionService) {
        this.admissionService = admissionService;
    }

    @PostMapping
    public ResponseEntity<?> createNewAdmission(@RequestBody @Valid AdmissionDTO admissionDTO) {
        AdmissionDTO created = admissionService.createNewAdmission(admissionDTO);
        return created != null
                ? ResponseEntity.status(HttpStatus.CREATED).body(created)
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please check the Data again");
    }

    @PostMapping(path = "/upload")
    public ResponseEntity<?> uploadCsv() throws IOException {
         admissionService.saveDataFromCsv();
      return ResponseEntity.ok("Data uploaded successfully");
    }

    @GetMapping(path = "/{admissionId}")
    public ResponseEntity<?> getAdmissionDetailsById(@PathVariable Long admissionId) {
        AdmissionDTO admissionDTO = admissionService.getAdmissionDetailsById(admissionId);
        return admissionDTO != null
                ? ResponseEntity.ok(admissionDTO)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not exist in the database");
    }

    @GetMapping
    public ResponseEntity<?> getAdmissionDetails() {
        List<AdmissionDTO> admissionDetail = admissionService.getAdmissionDetails();
        if (admissionDetail == null || admissionDetail.isEmpty()) {
            return ResponseEntity.ok("No data is in the database");
        }
        return ResponseEntity.ok(admissionDetail);
    }

    @PutMapping(path = "/{admissionId}")
    public ResponseEntity<AdmissionDTO> updateAdmissionDetails(@PathVariable Long admissionId,
                                                               @RequestBody AdmissionDTO admissionDTO) {
        AdmissionDTO admissionDTO1 = admissionService.updateAdmissionDetails(admissionId, admissionDTO);
        return admissionDTO1 != null
                ? ResponseEntity.ok(admissionDTO1)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PatchMapping(path = "/{admissionId}")
    public ResponseEntity<AdmissionDTO> updatePartialDetails(@PathVariable Long admissionId, @RequestBody Map<String, Object> admissionDetails) {
        AdmissionDTO admissionDTO = admissionService.updatePartialDetails(admissionId, admissionDetails);
        return admissionDTO != null
                ? ResponseEntity.ok(admissionDTO)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping(path = "/{admissionId}")
    public ResponseEntity<String> deleteAdmissionById(@PathVariable Long admissionId) {
        boolean status = admissionService.deleteAdmission(admissionId);
        if (status) {
            return ResponseEntity.status(HttpStatus.OK).body("Admission Details removed from the database");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admission Details does not exist in the database");
        }
    }

    @DeleteMapping
    public boolean deleteAllData() {
        return admissionService.deleteAllAdmissionDetails();
    }
}
