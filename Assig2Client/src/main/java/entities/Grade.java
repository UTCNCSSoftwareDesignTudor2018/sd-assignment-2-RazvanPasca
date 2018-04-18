package entities;


import java.util.Date;
import java.util.Objects;

public class Grade {

    private EnrolmentId id;


    private Enrolment enrolment;

    private Date requestDate;

    private Integer grade;

    public Grade(Integer grade) {
        this.grade = grade;
        this.requestDate = new Date(System.currentTimeMillis());
    }

    public Grade() {
        this.requestDate = new Date(System.currentTimeMillis());
    }

    public Grade(Integer grade, EnrolmentId id) {
        this.id = id;
        this.grade = grade;
    }

    public EnrolmentId getId() {
        return id;
    }

    public void GradeId(EnrolmentId id) {
        this.id = id;
    }

    public void addGrade(Integer grad, Course course, Student student) {
        this.grade = grade;
        this.enrolment = new Enrolment(student, course);
//        this.id.setStudentId(student.getId());
//        this.id.setCourseId(course.getId());
        this.id = enrolment.getId();
    }

    public void addGrade(Integer grad, Enrolment enrolment) {
        this.grade = grad;
        this.id = enrolment.getId();
        this.enrolment = enrolment;
    }

//    public Course getCourse() {
//        return enrolment.getCourse();
//    }


    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grade)) return false;
        Grade grade = (Grade) o;
        return Objects.equals(id, grade.id) &&
                Objects.equals(enrolment, grade.enrolment);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, enrolment);
    }
}
