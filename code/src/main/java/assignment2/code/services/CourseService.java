package assignment2.code.services;

import assignment2.code.persistance.entity.Course;
import assignment2.code.persistance.entity.Student;
import assignment2.code.persistance.entity.Teacher;

import java.util.List;

public interface CourseService {
    List<Course> findCoursesByStudent(Student student);

    List<Course> findAllCourses();

    List<Course> findCoursesByTeacher(Teacher teacher);
}
