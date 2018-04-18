package controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Course;
import entities.Student;
import entities.Teacher;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import view.StartingView;
import view.student.StudentMainView;
import view.teacher.TeacherMainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.apache.http.HttpHeaders.USER_AGENT;


public class StartingViewController {
    private StartingView startingView;
    private List<Student> students;
    private List<Teacher> teachers;
    private final String TEACHER_LOGIN_URL = "http://localhost:8080/loginRequestTeacher";
    private final String STUDENT_LOGIN_URL = "http://localhost:8080/loginRequest";
    private final String STUDENT_REQUEST_URL = "http://localhost:8080/getStudents";
    private final String TEACHER_REQUEST_URL = "http://localhost:8080/getTeachers";
    private final String COURSES_REQUEST_URL = "http://localhost:8080/getCourses";


    public StartingViewController(StartingView startingView) {
        this.startingView = startingView;
        this.students = getStudentsRequest();
        this.teachers = getTeachersRequest();
        startingView.setStudentsBox(students);
        startingView.setTeachersBox(teachers);
        addStudentLoginListener();
        addTeacherLoginListener();
    }

    private void addTeacherLoginListener() {
        startingView.addTeacherLoginListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = startingView.getSelectedTeacherIndex();
                sendSelectedTeacher(index);
                TeacherMainView teacherMainView = new TeacherMainView();
                startingView.setVisible(false);
                TeacherMainController teacherMainController = new TeacherMainController(teacherMainView,
                        teachers.get(index));
            }
        });
    }

    private void addStudentLoginListener() {
        startingView.addStudentLoginListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = startingView.getSelectedStudentIndex();
                sendSelectedStudent(index);
                StudentMainView studentMainView = new StudentMainView();
                startingView.setVisible(false);
                List<Course> courses = getAllCoursesRequest();
                StudentMainController studentMainController = new StudentMainController(studentMainView,
                        students.get(index), courses);
            }
        });

    }

    private void sendSelectedStudent(int index) {
        Poster.sendRequest(STUDENT_LOGIN_URL, students.get(index));
    }

    private void sendSelectedTeacher(int index) {
        System.out.println(teachers.get(index));
        HttpPost post = new HttpPost(TEACHER_LOGIN_URL);
        post.setHeader("User-Agent", USER_AGENT);
        post.setHeader("Content-Type", "application/json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonString = objectMapper.writeValueAsString(teachers.get(index));
            StringEntity postedString = new StringEntity(jsonString);
            HttpClient client = new DefaultHttpClient();
            post.setEntity(postedString);
            HttpResponse response = client.execute(post);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Course> getAllCoursesRequest() {
        List<Course> courses = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            URL getCoursesRequest = new URL(COURSES_REQUEST_URL);
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

    private List<Student> getStudentsRequest() {
        List<Student> students = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            URL getStudentsRequest = new URL(STUDENT_REQUEST_URL);
            Scanner scanner = new Scanner(getStudentsRequest.openStream());
            String response = scanner.useDelimiter("\\Z").next();
            students = objectMapper.readValue(response, new TypeReference<List<Student>>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    private List<Teacher> getTeachersRequest() {
        List<Teacher> teachers = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            URL getTeacherRequestURL = new URL(TEACHER_REQUEST_URL);
            Scanner scanner = new Scanner(getTeacherRequestURL.openStream());
            String response = scanner.useDelimiter("\\Z").next();
            teachers = objectMapper.readValue(response, new TypeReference<List<Teacher>>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return teachers;
    }

//    private void sendSelectedStudent(int index) {
//        String url = "http://localhost:8080/loginRequest";
//        Gson gson = new Gson();
//        HttpClient client = new DefaultHttpClient();
//        HttpPost post = new HttpPost(url);
//        Student student = students.get(index);
//        System.out.println(student);
//        post.setHeader("User-Agent", USER_AGENT);
//        try {
//            StringEntity postedString = new StringEntity(gson.toJson(student));
//            post.setEntity(postedString);
//            post.setHeader("Content-type", "application/json");
//            HttpResponse response = client.execute(post);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
