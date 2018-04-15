package assignment2.code.persistance.entity;


import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "enrolments")
public class Enrolment {
    @EmbeddedId
    private EnrolmentId id;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST
    )
    @MapsId("studentId")
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST
    )
    @MapsId("courseId")
    private Course course;

    @Column
    private Date requestDate;

    public Enrolment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.requestDate = new Date(System.currentTimeMillis());
        this.id = new EnrolmentId(student.getId(), course.getId());
    }

    public Enrolment() {
    }

    public EnrolmentId getId() {
        return id;
    }

    public void setId(EnrolmentId id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Enrolment)) return false;
        Enrolment enrolment = (Enrolment) o;
        return Objects.equals(student, enrolment.student) &&
                Objects.equals(course, enrolment.course);
    }

    @Override
    public int hashCode() {

        return Objects.hash(student, course);
    }
}
