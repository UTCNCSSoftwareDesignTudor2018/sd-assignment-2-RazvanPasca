package assignment2.code;

import assignment2.code.persistance.entity.Student;
import assignment2.code.persistance.repository.StudentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTests {
    @Autowired
    private StudentRepository studentRepository;

    @Before
    public void setUp() throws Exception {
        /*Test saving students*/
        Student student1 = new Student.Builder().setName("Alice").setEmail("alice@yahoo.com").build();
        Student student2 = new Student.Builder().setName("Bob").build();
        //save user, verify has ID value after save
        assertNull(student1.getId());
        assertNull(student2.getId());//null before save
        this.studentRepository.save(student1);
        this.studentRepository.save(student2);
        assertNotNull(student1.getId());
        assertNotNull(student2.getId());
    }

//    @Test
//    public void testFetchData(){
//        /*Test data retrieval*/
//        List<Student> studentA = studentRepository.findByName("Alice");
//        assertNotNull(studentA);
//        assertEquals("alice@yahoo.com", studentA.get(0).getEmail());
//
//
//        /*Get all products, list should only have two*/
//        List<Student> students = studentRepository.findAll();
//        int count = 0;
//        for(Student p : students){
//            count++;
//        }
//        assertEquals(count, 2);
//
//        /*Get the first student by id*/
//        Optional<Student> firstStudentById = studentRepository.findById(students.get(0).getId());
//        assertEquals(firstStudentById.get(),students.get(0));
//
//        /*Find by email*/
//        Student student = studentRepository.findByEmail("alice@yahoo.com");
//        assertEquals(student,studentA.get(0));
//    }

    @Test
    public void testUpdateData(){
        Student student = studentRepository.findByEmail("alice@yahoo.com");
        student.setEmail("new_email@yahoo.com");
        studentRepository.save(student);
        Student updatedStudent = studentRepository.findByEmail("new_email@yahoo.com");
        assertEquals(student,updatedStudent);
    }
}
