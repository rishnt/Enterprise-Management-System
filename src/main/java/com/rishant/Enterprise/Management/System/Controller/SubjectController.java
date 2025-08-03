package com.rishant.Enterprise.Management.System.Controller;

import com.rishant.Enterprise.Management.System.Service.SubjectService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectService subjectService;
    SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
}
