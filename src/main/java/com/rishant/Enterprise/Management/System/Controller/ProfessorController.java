package com.rishant.Enterprise.Management.System.Controller;
import com.rishant.Enterprise.Management.System.Service.ProfessorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

   private ProfessorService professorService;

   ProfessorController(ProfessorService professorService) {
       this.professorService = professorService;
   }
}
