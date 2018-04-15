package assignment2.code.services;

import assignment2.code.persistance.entity.Course;
import assignment2.code.persistance.entity.Student;

import java.util.List;

public interface StudentService {
    Student updateProfile(Student student);

    List<Course> viewCourses();

    boolean enroll();
}
