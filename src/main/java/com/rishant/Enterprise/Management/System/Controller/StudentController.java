package com.rishant.Enterprise.Management.System.Controller;

import com.rishant.Enterprise.Management.System.DTO.StudentDTO;
import com.rishant.Enterprise.Management.System.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    @PostMapping
    public ResponseEntity<StudentDTO> createNewStudent(@RequestBody StudentDTO studentDTO){
           StudentDTO student= studentService.createNewStudent(studentDTO);
           System.out.println("************");
           return ResponseEntity.ok(student);
    }
}
