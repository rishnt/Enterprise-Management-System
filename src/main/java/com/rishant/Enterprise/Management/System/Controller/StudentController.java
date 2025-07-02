package com.rishant.Enterprise.Management.System.Controller;

import com.rishant.Enterprise.Management.System.DTO.StudentDTO;
import com.rishant.Enterprise.Management.System.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<?> createNewStudent(@RequestBody @Valid StudentDTO studentDTO) {
        boolean student = studentService.createNewStudent(studentDTO);
        return student
                ? ResponseEntity.status(HttpStatus.CREATED).body(studentDTO)
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please check the Data again");
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDTO> getStudentDetails(@PathVariable Long studentId) {
        return studentService.getStudentDetails(studentId).map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllDetails() {
        List<StudentDTO> dto = studentService.getAllDetails();
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long studentId) {
        boolean status = studentService.deleteStudent(studentId);
        if (status) return ResponseEntity.ok("Student Successfully removed");
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<StudentDTO> updateStudentDetails(@PathVariable Long studentId,
                                                           @RequestBody StudentDTO studentDTO) {
        StudentDTO updatedStudent = studentService.updateStudentDetails(studentId, studentDTO);
        return updatedStudent != null
                ? ResponseEntity.ok(updatedStudent)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PatchMapping("/{studentId}")
    public ResponseEntity<StudentDTO> updatePartialDetails(@PathVariable Long studentId,
                                                           @RequestBody  Map<String, Object> studentDetails) {
        StudentDTO updatedStudent = studentService.updatePartialStudentDetails(studentId, studentDetails);
        return updatedStudent != null
                ? ResponseEntity.ok(updatedStudent)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
