package assignment2.code.services;

import assignment2.code.persistance.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {

    Student createStudentAccount(Student student);

    List<Student> viewStudents();

    Student updateStudent(Student student);

    boolean generateStudentReport(Student student);

    Enrolment enrollStudentToCourse(Student student, Course course);

    List<Student> viewEnrolledStudents(Course course);

    Grade addStudentGrade(Student student, Course course, Integer grade);

    Teacher updateProfile(Teacher teacher);

    List<Course> viewMyCourses();

    List<Teacher> viewAllTeachers();
}
