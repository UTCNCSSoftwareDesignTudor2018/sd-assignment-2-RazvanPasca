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

import static org.junit.Assert.*;

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
    public void setUp() {
        Student student1 = new StudentBuilder().setName("Alice").setEmail("alice@yahoo.com").build();
        Course course = new Course("mate");
        Course course1 = new Course("mate2");

        Teacher teacher = new TeacherBuilder().setCourse(course).build();
        teacher.addCourse(course1, true);
        assertNull(student1.getId());
        assertNull(teacher.getId());
        studentService.updateProfile(student1);
        studentService.studentContextHolder.setCurrentUser(student1);
        this.teacherRepository.save(teacher);
        assertNotNull(teacher.getId());
        assertNotNull(student1.getId());
    }

    @Test
    public void testStudentEditing() {
        List<Student> students = teacherService.viewStudents();
        Student student = students.get(0);
        student.setName("noul meu nume");
        teacherService.updateStudent(student);
        Student student1 = teacherService.viewStudents().get(0);
        assertEquals(student1, student);
    }

    @Test
    public void testStudentEnroll() {
        Teacher teacher = teacherRepository.findByEmail("default_prof@yahoo.com");
        teacherService.teacherContextHolder.setCurrentUser(teacher);

        List<Student> students = teacherService.viewStudents();
        List<Course> courses = teacherService.viewMyCourses();
        Student student = students.get(0);
        Enrolment enrolment = teacherService.enrollStudentToCourse(student, courses.get(0));
        List<Course> courses1 = studentService.viewEnrolledCourses();
        assertEquals(enrolment.getCourse(), courses1.get(0));

        //testing if the teacher can see the students enrolled to his courses
        student = teacherService.viewEnrolledStudents(courses.get(0)).get(0);
        assertEquals("noul meu nume", student.getName());
    }

    @Test
    public void testStudentGrading() {
        Teacher teacher = teacherRepository.findByEmail("default_prof@yahoo.com");
        teacherService.teacherContextHolder.setCurrentUser(teacher);

    }

}
