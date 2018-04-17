package assignment2.code.services.implementation;

import assignment2.code.persistance.entity.*;
import assignment2.code.persistance.repository.GradeRepository;
import assignment2.code.services.EnrolmentService;
import assignment2.code.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    private GradeRepository gradeRepository;
    private EnrolmentService enrolmentService;

    @Autowired
    public GradeServiceImpl(GradeRepository gradeRepository, EnrolmentService enrolmentService) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public Grade findByEnrolment(Student student, Course course) {
        return gradeRepository.findById(new EnrolmentId(student.getId(), course.getId())).get();
    }

    @Override
    public List<Grade> findByStudent(Student student) {
        return gradeRepository.findByIdStudentId(student.getId());
    }

    @Override
    public List<Grade> findByCourse(Course course) {
        return gradeRepository.findByIdCourseId(course.getId());
    }

    @Override
    public Grade addGrade(Student student, Course course, Integer grade) {
        Enrolment enrolment = enrolmentService.findEnrolment(student, course);
        Grade addedGrade = student.addGrade(grade, enrolment);
        gradeRepository.save(addedGrade);
        return addedGrade;
    }

}
