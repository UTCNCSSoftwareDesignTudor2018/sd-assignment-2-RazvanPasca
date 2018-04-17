package assignment2.code.services;

import assignment2.code.persistance.entity.Course;
import assignment2.code.persistance.entity.Grade;
import assignment2.code.persistance.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {

    Student createStudentAccount(Student student);

    List<Student> viewStudents();

    Student updateStudent(Student student);

    boolean generateStudentReport(Student student);

    List<Student> viewEnrolledStudents();

    Grade addStudentGrade(Student student, Course course);


}
