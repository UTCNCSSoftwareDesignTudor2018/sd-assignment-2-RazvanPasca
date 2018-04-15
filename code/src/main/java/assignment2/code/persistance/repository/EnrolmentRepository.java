package assignment2.code.persistance.repository;

import assignment2.code.persistance.entity.Enrolment;
import assignment2.code.persistance.entity.EnrolmentId;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EmbeddedId;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface EnrolmentRepository extends JpaRepository<Enrolment,EnrolmentId>{
    List<Enrolment> findAll();

    List<Enrolment>findByIdStudentId(Integer studentId);

    List<Enrolment> findByIdCourseId(Integer courseId);

    Optional<Enrolment> findByIdCourseIdAndStudentId(Integer courseId, Integer studentId);

   // List<Enrolment> findByDate(Date date);

}
