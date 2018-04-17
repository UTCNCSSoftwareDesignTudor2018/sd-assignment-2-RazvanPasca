package assignment2.code.persistance.repository;

import assignment2.code.persistance.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Integer> {

    List<Course> findByTeacherId(Integer teacherId);

}
