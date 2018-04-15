package assignment2.code.persistance.repository;

import assignment2.code.persistance.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GradeRepository extends JpaRepository{
    List<Grade> findAll();

    List<Grade>findByIdStudentId(Integer studentId);

    List<Grade> findByIdCourseId(Integer courseId);

    Optional<Grade> findByIdCourseIdAndStudentId(Integer courseId, Integer studentId);

}
