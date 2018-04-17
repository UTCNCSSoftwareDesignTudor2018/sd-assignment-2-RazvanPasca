package assignment2.code.services.implementation;

import assignment2.code.persistance.entity.Course;
import assignment2.code.persistance.entity.Student;
import assignment2.code.persistance.entity.Teacher;
import assignment2.code.persistance.repository.CourseRepository;
import assignment2.code.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findCoursesByStudent(Student student) {
        return null;
    }

    @Override
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> findCoursesByTeacher(Teacher teacher) {
        return courseRepository.findByTeacherId(teacher.getId());
    }
}
