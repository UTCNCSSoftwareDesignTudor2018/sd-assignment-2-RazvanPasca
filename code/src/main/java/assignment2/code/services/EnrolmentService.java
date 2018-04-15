package assignment2.code.services;

import assignment2.code.persistance.entity.Course;
import assignment2.code.persistance.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EnrolmentService {

    List<Course> findCoursesByStudent(Student student);

    List<Student> findStudentsByCourse(Course course);
}
