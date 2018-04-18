package assignment2.code.services.implementation;

import assignment2.code.persistance.entity.Course;
import assignment2.code.persistance.entity.Enrolment;
import assignment2.code.persistance.entity.Student;
import assignment2.code.persistance.repository.EnrolmentRepository;
import assignment2.code.services.EnrolmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnrolmentServiceImpl implements EnrolmentService {

    private EnrolmentRepository enrolmentRepository;

    @Autowired
    public EnrolmentServiceImpl(EnrolmentRepository enrolmentRepository) {
        this.enrolmentRepository = enrolmentRepository;
    }

    @Override
    public List<Course> findCoursesByStudent(Student student) {
        List<Enrolment> enrolments = enrolmentRepository.findByIdStudentId(student.getId());
        List<Course> courses = new ArrayList<>(enrolments.size());
        for (Enrolment enrolment : enrolments) {
            courses.add(enrolment.getCourse());
        }
        return courses;
    }

    @Override
    public List<Student> findStudentsByCourse(Course course) {
        List<Enrolment> enrolments = enrolmentRepository.findByIdCourseId(course.getId());
        List<Student> students = new ArrayList<>(enrolments.size());
        for (Enrolment enrolment : enrolments) {
            students.add(enrolment.getStudent());
        }
        return students;
    }

    @Override
    public Enrolment enrollStudentToCourse(Student student, Course course) {
        Enrolment newEnrolment = student.addCourse(course);
        enrolmentRepository.save(newEnrolment);
        return newEnrolment;
    }

    @Override
    public Enrolment findEnrolment(Student student, Course course) {
        return enrolmentRepository.findByIdCourseIdAndStudentId(course.getId(), student.getId()).get();
    }
}