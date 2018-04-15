package assignment2.code.services.implementation;

import assignment2.code.persistance.entity.Course;
import assignment2.code.persistance.entity.Student;
import assignment2.code.persistance.repository.StudentRepository;
import assignment2.code.services.EnrolmentService;
import assignment2.code.services.StudentContextHolder;
import assignment2.code.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private EnrolmentService enrolmentService;
    private StudentContextHolder studentContextHolder;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, EnrolmentService enrolmentService) {
        this.studentRepository = studentRepository;
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
    public List<Course> viewCourses() {
        return enrolmentService.findCoursesByStudent(StudentContextHolder.getCurrentUser());
    }

    @Override
    public boolean enroll() {
        return false;
    }
}
