package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Course;
import entities.Student;
import entities.StudentBuilder;
import org.apache.http.client.methods.HttpPost;
import view.student.StudentMainView;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class StudentMainController {

    private StudentMainView smv;
    private Student student;
    private List<Course> courses;
    private final String UPDATE_STUDENT_URL = "http://localhost:8080/updateStudent";
    private final String ENROLL_REQUEST_URL = "http://localhost:8080/enrollStudent";


    public StudentMainController(StudentMainView smv, Student student, List<Course> courses) {
        this.smv = smv;
        this.student = student;
        this.courses = courses;
        this.smv.setVisible(true);
        this.smv.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addStudentUpdateListener(student.getId());
        //addCourseListListener();
        addEnrollButtonListener();
        this.smv.setStudentFields(student);
        this.smv.setCourseList(courses);
    }

    private void addEnrollButtonListener() {
        this.smv.addEnrollMeListener(e -> {
            Course course = courses.get(smv.getSelectedCourseIndex());
            sendEnrollRequest(course);
            System.out.println(course);
        });
    }

    private void addStudentUpdateListener(Integer id) {
        this.smv.addUpdateButtonListener(e -> {
            Student student = new StudentBuilder().setStudyGroup(Integer.parseInt(smv.getGroupTextField())).
                    setCNP(smv.getCnpTextField()).setAddress(smv.getAddressTextField()).
                    setEmail(smv.getEmailTextField()).setName(smv.getNameTextField()).setPassword(smv.getPasswordTextField())
                    .setId(id).build();
            System.out.println(student);
            sendUpdateRequest(student);
            this.smv.setStudentFields(student);
            this.student = student;
        });
    }

    private void sendEnrollRequest(Course course) {
        Poster.sendRequest(ENROLL_REQUEST_URL, course);
    }

    private void sendUpdateRequest(Student student) {
        Poster.sendRequest(UPDATE_STUDENT_URL, student);
    }
}

