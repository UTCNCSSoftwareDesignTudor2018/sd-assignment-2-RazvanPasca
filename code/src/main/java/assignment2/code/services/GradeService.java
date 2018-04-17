package assignment2.code.services;

import assignment2.code.persistance.entity.Course;
import assignment2.code.persistance.entity.Grade;
import assignment2.code.persistance.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GradeService {

    Grade findByEnrolment(Student student, Course course);

    List<Grade> findByStudent(Student student);

    List<Grade> findByCourse(Course course);

    Grade addGrade(Student student, Course course, Integer grade);

}
