package assignment2.code.persistance.repository;

import assignment2.code.persistance.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {

}
