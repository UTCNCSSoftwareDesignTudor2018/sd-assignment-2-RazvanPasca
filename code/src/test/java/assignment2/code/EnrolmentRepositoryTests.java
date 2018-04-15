package assignment2.code;


import assignment2.code.persistance.entity.Course;
import assignment2.code.persistance.entity.Enrolment;
import assignment2.code.persistance.entity.Student;
import assignment2.code.persistance.entity.Teacher;
import assignment2.code.persistance.repository.EnrolmentRepository;
import assignment2.code.persistance.repository.StudentRepository;
import assignment2.code.persistance.repository.TeacherRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnrolmentRepositoryTests {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EnrolmentRepository enrolmentRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @Before
    public void setUp() throws Exception {
        /*Test saving students*/
        Student student1 = new Student.Builder().setName("Alice").setEmail("alice@yahoo.com").build();
        Student student2 = new Student.Builder().setName("Bob").build();
        Course course1 = new Course("mate1");
        Course course2 = new Course("mate2");

        Teacher teacher = new Teacher.Builder().setCourse(course1).build();

        student1.addCourse(course1);
        student1.addCourse(course2);

        student2.addCourse(course1);

        //save user, verify has ID value after save
        assertNull(student1.getId());
        assertNull(student2.getId());//null before save
        this.teacherRepository.save(teacher);
        this.studentRepository.save(student1);
        this.studentRepository.save(student2);
        assertNotNull(student1.getId());
        assertNotNull(student2.getId());
    }

    @Test
    public void testEnrolmentFetch() {
        Student student1 = studentRepository.findByEmail("alice@yahoo.com");
        List<Enrolment> enrolments = enrolmentRepository.findByIdStudentId(student1.getId());
        assertEquals("mate1",enrolments.get(0).getCourse().getName());
        assertEquals("mate2",enrolments.get(1).getCourse().getName());
        assertEquals("Alice",enrolments.get(0).getStudent().getName());
        List<Enrolment> allEnrolments = enrolmentRepository.findAll();
        assert (0 != allEnrolments.size());
    }

}
