package assignment2.code.controller;

import assignment2.code.services.StudentService;

public class StudentMenuController {
    private StudentService studentService;

    public StudentMenuController(StudentService studentService) {
        this.studentService = studentService;
    }
}
