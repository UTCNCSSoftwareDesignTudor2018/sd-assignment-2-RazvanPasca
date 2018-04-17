package assignment2.code.repository;

import assignment2.code.persistance.entity.Course;
import assignment2.code.persistance.entity.Teacher;
import assignment2.code.persistance.entity.TeacherBuilder;
import assignment2.code.persistance.repository.TeacherRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherRepositoryTests {
    @Autowired
    private TeacherRepository teacherRepository;

    @Before
    public void setUp() throws Exception {
        Course mathCourse = new Course("math1");
        Teacher teacher1 = new TeacherBuilder().setName("Alice").setEmail("12345").setCourse(mathCourse).build();
        Teacher teacher2 = new TeacherBuilder().setName("Bob").setEmail("38").build();
        //save user, verify has ID value after save
        assertNull(teacher1.getId());
        assertNull(teacher2.getId());//null before save
        this.teacherRepository.save(teacher1);
        this.teacherRepository.save(teacher2);
        assertNotNull(teacher1.getId());
        assertNotNull(teacher2.getId());
    }

    @Test
    public void testFetchData() {

        /*Test data retrieval including course*/

        Teacher teacherA = teacherRepository.findByName("Alice");
        assertNotNull(teacherA);
        assertEquals(teacherA.getCourses().get(0).getName(), "math1");


        /*Get all teachers, list should only have two*/
        List<Teacher> teachers = teacherRepository.findAll();
        int count = 0;
        for (Teacher p : teachers) {
            count++;
        }
        assertEquals(count, 2);

        /*Get the first teacher by id*/

        Optional<Teacher> firstTeacherById = teacherRepository.findById(teachers.get(0).getId());
        assertEquals(firstTeacherById.get(), teachers.get(0));
    }
}