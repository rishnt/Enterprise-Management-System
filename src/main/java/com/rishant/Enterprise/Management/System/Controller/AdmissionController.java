package com.rishant.Enterprise.Management.System.Controller;

import com.rishant.Enterprise.Management.System.DTO.AdmissionDTO;
import com.rishant.Enterprise.Management.System.Service.AdmissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/admission")
public class AdmissionController {

    private AdmissionService admissionService;

    @PostMapping
    public ResponseEntity<AdmissionDTO> createNewAdmission(@RequestBody AdmissionDTO admissionDTO) {
        admissionService.createNewAdmission(admissionDTO);
        return ResponseEntity.ok(admissionDTO);
    }

    @GetMapping(path = "/{admissionId}")
    public ResponseEntity<AdmissionDTO> getAdmissionDetailsById(@PathVariable Long admissionId) {
        AdmissionDTO admissionDTO = admissionService.getAdmissionDetailsById(admissionId);
        return admissionDTO != null
                ? ResponseEntity.ok(admissionDTO)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping
    public ResponseEntity<List<AdmissionDTO>> getAdmissionDetails() {
        List<AdmissionDTO> admissionDetail = admissionService.getAdmissionDetails();
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

    @PatchMapping(path = "/{admission}")
    public ResponseEntity<AdmissionDTO> updatePartialDetails(@PathVariable Long admissionId, Map<String, Object> admissionDetails) {
        AdmissionDTO admissionDTO = admissionService.updatePartialDetails(admissionId, admissionDetails);
        return admissionDTO != null
                ? ResponseEntity.ok(admissionDTO)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
