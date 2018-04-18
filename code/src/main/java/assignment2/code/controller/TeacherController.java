package assignment2.code.controller;

import assignment2.code.persistance.entity.Course;
import assignment2.code.persistance.entity.Grade;
import assignment2.code.persistance.entity.Student;
import assignment2.code.persistance.entity.Teacher;
import assignment2.code.services.implementation.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    TeacherServiceImpl teacherService;
    private Course course;
    private Student student;

    @RequestMapping("/getTeachers")
    public List<Teacher> viewAllTeachers() {
        return this.teacherService.viewAllTeachers();
    }

    @RequestMapping(value = "/loginRequestTeacher", method = RequestMethod.POST)
    @ResponseBody
    public Teacher viewTeacherProfile(@RequestBody Teacher input) {
        Teacher teacher = new Teacher(input);
        teacherService.setCurrentUser(teacher);
        System.out.println(teacher);
        return teacher;
    }

    @RequestMapping(value = "/updateTeacher", method = RequestMethod.POST)
    @ResponseBody
    public Teacher updateTeacherProfile(@RequestBody Teacher input) {
        Teacher teacher = new Teacher(input);
        teacherService.setCurrentUser(teacher);
        teacherService.updateProfile(teacher);
        System.out.println(teacher);
        return teacher;
    }

    @RequestMapping("/getTeacherCourses")
    public List<Course> viewAllTeacherCourses() {
        return this.teacherService.viewMyCourses();
    }

    @RequestMapping(value = "/getTeacherStudents", method = RequestMethod.POST)
    @ResponseBody
    public List<Student> viewAllTeacherStudents(@RequestBody Course input) {
        Course course = new Course(input);
        this.course = course;
        return teacherService.viewEnrolledStudents(course);
    }

    @RequestMapping(value = "/getStudentGrade", method= RequestMethod.POST)
    @ResponseBody
    public Grade getStudentGrade(@RequestBody Student input){
        Student student = new Student(input);
        this.student = student;
        return teacherService.getStudentGrade(student,course);
    }

    @RequestMapping(value = "/setStudentGrade",method= RequestMethod.POST)
    @ResponseBody
    public Grade setStudentGrade(@RequestBody Integer intg){
        Grade grade = teacherService.addStudentGrade(student,course,intg);
        return grade;
    }

    @RequestMapping("/generateReport")
    public void generateStudentsReport(){
        teacherService.generateStudentReport(course);
    }

}
