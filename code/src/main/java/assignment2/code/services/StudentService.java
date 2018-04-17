package assignment2.code.services;

import assignment2.code.persistance.entity.Course;
import assignment2.code.persistance.entity.Enrolment;
import assignment2.code.persistance.entity.Grade;
import assignment2.code.persistance.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    Student updateProfile(Student student);

    List<Course> viewEnrolledCourse();

    Enrolment enroll(Course course);

    List<Grade> viewGrades();

    List<Course> viewAllCourses();

    List<Student> viewAllStudents();
}
