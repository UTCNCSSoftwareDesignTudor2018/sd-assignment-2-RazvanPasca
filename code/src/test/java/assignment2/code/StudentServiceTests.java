package assignment2.code;

import assignment2.code.persistance.entity.Course;
import assignment2.code.persistance.entity.Grade;
import assignment2.code.persistance.entity.Student;
import assignment2.code.persistance.entity.StudentBuilder;
import assignment2.code.persistance.repository.CourseRepository;
import assignment2.code.persistance.repository.StudentRepository;
import assignment2.code.services.implementation.GradeServiceImpl;
import assignment2.code.services.implementation.StudentServiceImpl;
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
public class StudentServiceTests {

    @Autowired
    StudentServiceImpl studentService;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    GradeServiceImpl gradeService;

    @Before
    public void setUp() {
        Student student1 = new StudentBuilder().setName("Alice").setEmail("alice@yahoo.com").build();
        Course course = new Course("mate");
        course = courseRepository.save(course);

        assertNull(student1.getId());
        this.studentRepository.save(student1);
        assertNotNull(student1.getId());
        studentService.studentContextHolder.setCurrentUser(student1);
        studentService.enroll(course);

        gradeService.addGrade(student1, course, 5);
    }

    @Test
    public void testProfile() {
        Student currentStudent = studentRepository.findByEmail("alice@yahoo.com");
        studentService.studentContextHolder.setCurrentUser(currentStudent);
        currentStudent.setCNP("111111111");
        currentStudent.setAddress("Zalau");
        studentService.updateProfile(currentStudent);
        Student updatedStudent = studentRepository.findByEmail("alice@yahoo.com");
        assertEquals("111111111", updatedStudent.getCNP());
        assertEquals("Zalau", updatedStudent.getAddress());
        assertNotNull(updatedStudent.getId());

    }


    @Test
    public void enrollmentActions() {
        Student currentStudent = studentRepository.findByEmail("alice@yahoo.com");
        studentService.studentContextHolder.setCurrentUser(currentStudent);
        assertNotNull(currentStudent.getId());

        Course course = studentService.viewAllCourses().get(0);

        studentService.enroll(course);

        List<Course> courses = studentService.viewEnrolledCourse();
        assertEquals(course, courses.get(0));
    }

    @Test
    public void gradeActions() {
        Student currentStudent = studentRepository.findByEmail("alice@yahoo.com");
        studentService.studentContextHolder.setCurrentUser(currentStudent);
        assertNotNull(currentStudent.getId());
        Grade grade = gradeService.findByStudent(currentStudent).get(0);
        assert (grade.getGrade() == 5);
    }
}
