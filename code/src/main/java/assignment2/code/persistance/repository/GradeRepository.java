package assignment2.code.persistance.repository;

import assignment2.code.persistance.entity.EnrolmentId;
import assignment2.code.persistance.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grade, EnrolmentId> {
    List<Grade> findAll();

    Optional<Grade> findById(EnrolmentId id);

    List<Grade> findByIdCourseId(Integer courseId);

    List<Grade> findByIdStudentId(Integer studentId);

//    Optional<Grade> findByIdCourseIdAndStudentId(Integer courseId, Integer studentId);

}
