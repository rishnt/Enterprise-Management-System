package com.rishant.Enterprise.Management.System.Controller;

import com.rishant.Enterprise.Management.System.DTO.StudentDTO;
import com.rishant.Enterprise.Management.System.Service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentService studentService;
    StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    @PostMapping
    public StudentDTO createNewStudent(@RequestBody StudentDTO studentDTO){
           return studentService.createNewStudent(studentDTO);
    }
}
