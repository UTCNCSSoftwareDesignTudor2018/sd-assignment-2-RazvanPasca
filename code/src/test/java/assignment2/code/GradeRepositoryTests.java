package assignment2.code;

import assignment2.code.persistance.entity.Course;
import assignment2.code.persistance.entity.Enrolment;
import assignment2.code.persistance.entity.Grade;
import assignment2.code.persistance.entity.Student;
import assignment2.code.persistance.repository.EnrolmentRepository;
import assignment2.code.persistance.repository.GradeRepository;
import assignment2.code.persistance.repository.StudentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GradeRepositoryTests {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EnrolmentRepository enrolmentRepository;
    @Autowired
    private GradeRepository gradeRepository;

    @Before
    public void setUp() throws Exception {
        /*Test saving students*/
        Student student1 = new Student.Builder().setName("Alice").setEmail("alice@yahoo.com").build();
        Student student2 = new Student.Builder().setName("Bob").build();
        Course course1 = new Course("mate1");
        Course course2 = new Course("mate2");

        student1.addCourse(course1);
        student1.addCourse(course2);

        student2.addCourse(course1);

        Grade grade = student1.addGrade(5, student1.getEnrolments().get(0));

        //save user, verify has ID value after save
        assertNull(student1.getId());
        assertNull(student2.getId());//null before save
        this.studentRepository.save(student1);
        this.studentRepository.save(student2);
        this.gradeRepository.save(grade);
        assertNotNull(student1.getId());
        assertNotNull(student2.getId());
    }

    @Test
    public void testGradeInsert() {
        Student student1 = studentRepository.findByEmail("alice@yahoo.com");
        Enrolment enrolment = student1.getEnrolments().get(0);
        System.out.println(enrolment);
        Optional<Grade> grade1 = gradeRepository.findById(enrolment.getId());
        assert (grade1.get().getGrade() == 5);
    }
}
