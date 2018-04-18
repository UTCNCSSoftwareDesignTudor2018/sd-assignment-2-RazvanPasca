package controller;

import entities.*;
import view.teacher.TeacherMainView;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class TeacherMainController {

    private TeacherMainView tmv;
    private Teacher teacher;
    private List<Course> courses;
    private List<Student> students;
    private final String TEACHER_UPDATE_REQUEST = "http://localhost:8080/updateTeacher";
    private final String VIEW_TEACHER_COURSES = "http://localhost:8080/getTeacherCourses";
    private final String VIEW_TEACHER_STUDENTS = "http://localhost:8080/getTeacherStudents";
    private final String VIEW_STUDENT_GRADE = "http://localhost:8080/getStudentGrade";
    private final String SET_STUDENT_GRADE = "http://localhost:8080/setStudentGrade";
    private final String GENERATE_REPORT_REQUEST = "http://localhost:8080/generateReport";


    public TeacherMainController(TeacherMainView teacherMainView, Teacher teacher) {
        this.tmv = teacherMainView;
        teacherMainView.setVisible(true);
        teacherMainView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.teacher = teacher;
        this.courses = Poster.getCoursesRequest(VIEW_TEACHER_COURSES);
        this.tmv.setTeacherFields(teacher);
        this.tmv.setCoursesBox(courses);
        addViewListeners();
    }

    private void addViewListeners() {
        addUpdateButtonListener(teacher.getId(), teacher.getCourses());
        addWriteReportListener();
        addCoursesBoxListener();
        addStudentListListener();
        addSetGradeListener();
    }

    private void addSetGradeListener() {
        this.tmv.addSetStudentGradeListener(e -> {
            Integer grade = Integer.valueOf(tmv.getGrade());
            Poster.sendRequest(SET_STUDENT_GRADE, grade);
        });
    }

    private void addStudentListListener() {
        this.tmv.addStudentListListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = tmv.getClickIndex();
                Grade grade = sendViewGradeRequest(students.get(index));
                if (grade == null || (grade.getGrade() == -1)) {
                    tmv.setGrade("Not graded yet");
                } else
                    tmv.setGrade(grade.getGrade().toString());
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

    private Grade sendViewGradeRequest(Student student) {
        return Poster.sendRequestWithGradeReply(VIEW_STUDENT_GRADE, student);
    }

    private void addCoursesBoxListener() {
        this.tmv.addCoursesBoxListener(e -> {
            int index = tmv.getSelectedCourseIndex();
            Course course = courses.get(index);
            students = Poster.sendRequestWithStudentsReply(VIEW_TEACHER_STUDENTS, course);
            tmv.setStudentList(students);
        });
    }

    private void addWriteReportListener() {
        this.tmv.setWriteReportButtonListener(e -> {
            Poster.sendRequest(GENERATE_REPORT_REQUEST,null);
        });
    }

    private void addUpdateButtonListener(Integer id, List<Course> courses) {
        this.tmv.addUpdateButtonListener(e -> {
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


}
