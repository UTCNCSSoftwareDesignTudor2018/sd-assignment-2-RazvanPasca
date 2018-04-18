package controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Course;
import entities.Student;
import entities.Teacher;
import entities.TeacherBuilder;
import view.teacher.TeacherMainView;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherMainController {

    private TeacherMainView tmv;
    private Teacher teacher;
    private List<Course> courses;
    private List<Student> students;
    private final String TEACHER_UPDATE_REQUEST = "http://localhost:8080/updateTeacher";
    private final String VIEW_TEACHER_COURSES = "http://localhost:8080/getTeacherCourses";
    private final String VIEW_TEACHER_STUDENTS = "http://localhost:808/getTeacherStudents";


    public TeacherMainController(TeacherMainView teacherMainView, Teacher teacher) {
        this.tmv = teacherMainView;
        teacherMainView.setVisible(true);
        teacherMainView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.teacher = teacher;
        this.courses = getCoursesRequest();
        this.tmv.setTeacherFields(teacher);
        this.tmv.setCoursesBox(courses);
        addViewListeners();

    }

    private void addViewListeners(){
        addUpdateButtonListener(teacher.getId(),teacher.getCourses());
        addWriteReportListener();
        addCoursesBoxListener();
        addStudentListListener();
    }

    private void addStudentListListener() {
        this.tmv.addStudentListListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    private void addCoursesBoxListener() {
        this.tmv.addCoursesBoxListener(e ->{
            int index = tmv.getSelectedCourseIndex();
            Course course = courses.get(index);
            students = Poster.sendRequestWithResponse(VIEW_TEACHER_STUDENTS,course);
            tmv.setStudentList(students);
        });
    }

    private void addWriteReportListener() {
        this.tmv.setWriteReportButtonListener(e -> {

        });
    }

    private void addUpdateButtonListener(Integer id, List<Course> courses) {
        this.tmv.addUpdateButtonListener(e ->{
            Teacher teacher = new TeacherBuilder().setEmail(tmv.getEmailTextField()).
                    setName(tmv.getNameTextField()).setPassword(tmv.getPasswordTextField()).setId(id).build();
            teacher.setCourses(courses);
            System.out.println(teacher);
            sendUpdateRequest(teacher);
            this.tmv.setTeacherFields(teacher);
        });
    }

    private void sendUpdateRequest(Teacher teacher) {
        Poster.sendRequest(TEACHER_UPDATE_REQUEST, teacher);
    }

    private List<Course> getCoursesRequest() {
        List<Course> courses = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            URL getCoursesRequest = new URL(VIEW_TEACHER_COURSES);
            Scanner scanner = new Scanner(getCoursesRequest.openStream());
            String response = scanner.useDelimiter("\\Z").next();
            courses = objectMapper.readValue(response, new TypeReference<List<Course>>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courses;
    }
}
