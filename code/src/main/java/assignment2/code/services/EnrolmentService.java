package assignment2.code.services;

import assignment2.code.persistance.entity.Course;
import assignment2.code.persistance.entity.Enrolment;
import assignment2.code.persistance.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EnrolmentService {

    List<Course> findCoursesByStudent(Student student);

    List<Student> findStudentsByCourse(Course course);

    Enrolment enrollStudentToCourse(Student student, Course course);

    Enrolment findEnrolment(Student student, Course course);
}
