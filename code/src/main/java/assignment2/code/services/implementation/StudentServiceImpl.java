package assignment2.code.services.implementation;

import assignment2.code.persistance.entity.Course;
import assignment2.code.persistance.entity.Enrolment;
import assignment2.code.persistance.entity.Grade;
import assignment2.code.persistance.entity.Student;
import assignment2.code.persistance.repository.StudentRepository;
import assignment2.code.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private EnrolmentService enrolmentService;
    public StudentContextHolder studentContextHolder;
    private GradeService gradeService;
    private CourseService courseService;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, EnrolmentService enrolmentService,
                              CourseService courseService, GradeService gradeService) {
        this.studentRepository = studentRepository;
        this.courseService = courseService;
        this.gradeService = gradeService;
        this.enrolmentService = enrolmentService;
    }

    public StudentContextHolder getStudentContextHolder() {
        return studentContextHolder;
    }

    public void setStudentContextHolder(StudentContextHolder studentContextHolder) {
        this.studentContextHolder = studentContextHolder;
    }

    @Override
    public Student updateProfile(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Course> viewEnrolledCourse() {
        return enrolmentService.findCoursesByStudent(StudentContextHolder.getCurrentUser());
    }

    @Override
    public Enrolment enroll(Course course) {
        return enrolmentService.enrollStudentToCourse(StudentContextHolder.getCurrentUser(), course);
    }

    @Override
    public List<Grade> viewGrades() {
        return gradeService.findByStudent(StudentContextHolder.getCurrentUser());
    }

    @Override
    public List<Course> viewAllCourses() {
        return courseService.findAllCourses();
    }
}
