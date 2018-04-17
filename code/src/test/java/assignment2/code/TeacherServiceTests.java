package assignment2.code;

import assignment2.code.persistance.entity.*;
import assignment2.code.persistance.repository.CourseRepository;
import assignment2.code.persistance.repository.StudentRepository;
import assignment2.code.persistance.repository.TeacherRepository;
import assignment2.code.services.implementation.GradeServiceImpl;
import assignment2.code.services.implementation.StudentServiceImpl;
import assignment2.code.services.implementation.TeacherServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherServiceTests {

    @Autowired
    TeacherServiceImpl teacherService;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    GradeServiceImpl gradeService;
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    StudentServiceImpl studentService;

    @Before
    void setUp() {
        Student student1 = new StudentBuilder().setName("Alice").setEmail("alice@yahoo.com").build();
        Teacher teacher = new TeacherBuilder().build();
        Course course = new Course("mate");
        course = courseRepository.save(course);

        assertNull(student1.getId());
        assertNull(teacher.getId());
        studentService.updateProfile(student1);
        this.teacherRepository.save(teacher);
        assertNotNull(teacher.getId());
        assertNotNull(student1.getId());
        teacherService.teacherContextHolder.setCurrentUser(teacher);
        teacherService.enrollStudentToCourse(student1, course);

        gradeService.addGrade(student1, course, 5);
    }

    @Test
    void testStudentEditing() {
        List<Student> students = teacherService.viewStudents();
        Student student = students.get(0);
        student.setName("noul meu nume");
        teacherService.updateStudent(student);
//        Student student1 = te
    }

}
