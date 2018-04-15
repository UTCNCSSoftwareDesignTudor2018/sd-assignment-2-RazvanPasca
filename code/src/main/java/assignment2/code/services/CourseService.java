package assignment2.code.services;

import assignment2.code.persistance.entity.Course;
import assignment2.code.persistance.entity.Student;

import java.util.List;

public interface CourseService {
    List<Course> findCoursesByStudent(Student student);

}
