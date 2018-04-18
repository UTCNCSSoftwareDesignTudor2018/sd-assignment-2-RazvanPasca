package assignment2.code.controller;


import assignment2.code.persistance.entity.Course;
import assignment2.code.persistance.entity.Student;
import assignment2.code.services.implementation.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping("/getStudents")
    public List<Student> viewAllStudents() {
        return this.studentService.viewAllStudents();
    }

    @RequestMapping(value = "/loginRequest", method = RequestMethod.POST)
    @ResponseBody
    public Student viewStudentProfile(@RequestBody Student input) {
        Student student = new Student(input);
        studentService.setCurrentUser(student);
        System.out.println(student);
        return student;
    }

    @RequestMapping("/getCourses")
    public List<Course> viewAllCourses() {
        return this.studentService.viewAllCourses();
    }


    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    @ResponseBody
    public Student updateStudentProfile(@RequestBody Student input) {
        Student student = new Student(input);
        studentService.setCurrentUser(student);
        studentService.updateProfile(student);
        System.out.println(student);
        return student;
    }

    @RequestMapping(value = "/enrollStudent", method = RequestMethod.POST)
    @ResponseBody
    public Course enrollStudentToCourse(@RequestBody Course input) {
        Course course = new Course(input);
        System.out.println(course);
        System.out.println(studentService.getCurrentUser());
        this.studentService.enroll(course);
        return course;
    }

}


