package assignment2.code.services.implementation;

import assignment2.code.persistance.entity.*;
import assignment2.code.persistance.repository.TeacherRepository;
import assignment2.code.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;
    private EnrolmentService enrolmentService;
    public TeacherContextHolder teacherContextHolder;
    private GradeService gradeService;
    private StudentService studentService;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository, StudentService studentService,
                              EnrolmentService enrolmentService, GradeService gradeService) {
        this.teacherRepository = teacherRepository;
        this.enrolmentService = enrolmentService;
        this.studentService = studentService;
        this.gradeService = gradeService;
    }

    @Override
    public Student createStudentAccount(Student student) {
        return studentService.updateProfile(student);
    }

    @Override
    public List<Student> viewStudents() {
        return studentService.viewAllStudents();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentService.updateProfile(student);
    }

    @Override
    public boolean generateStudentReport(Student student) {
        return true;
    }

    @Override
    public Enrolment enrollStudentToCourse(Student student, Course course) {
        return enrolmentService.enrollStudentToCourse(student, course);
    }

    @Override
    public List<Student> viewEnrolledStudents(Course course) {
        return enrolmentService.findStudentsByCourse(course);
    }


    @Override
    public Grade addStudentGrade(Student student, Course course, Integer grade) {
        return gradeService.addGrade(student, course, grade);
    }

    @Override
    public Teacher updateProfile(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

}
