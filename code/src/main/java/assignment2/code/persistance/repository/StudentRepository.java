package assignment2.code.persistance.repository;

import assignment2.code.persistance.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByName(String name);
    Optional<Student> findById(Integer id);
    List<Student> findAll();
    Student findByEmail(String email);

}
