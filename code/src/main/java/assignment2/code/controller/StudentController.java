package assignment2.code.controller;


import assignment2.code.persistance.entity.Student;
import assignment2.code.services.implementation.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping("/getStudents")
    public List<Student> viewAllStudents() {
        return this.studentService.viewAllStudents();
    }

    @RequestMapping("/getProfile")
    public String viewStudentProfile() {
        return this.studentService.
    }

}
