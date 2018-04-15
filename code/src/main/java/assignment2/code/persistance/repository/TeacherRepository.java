package assignment2.code.persistance.repository;

import assignment2.code.persistance.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findByName(String name);
    Optional<Teacher> findById(Integer id);
    List<Teacher> findAll();
}
