package assignment2.code.persistance.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "enrolments")
@EntityListeners(AuditingEntityListener.class)
public class Enrolment {
    @EmbeddedId
    private EnrolmentId id;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE
    )
    @MapsId("studentId")
    @JsonIgnore
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE
    )
    @MapsId("courseId")
    @JsonIgnore
    private Course course;

    @Column(nullable = false)
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

    @Override
    public String toString() {
        return "Enrolment{" +
                "student=" + student +
                ", course=" + course +
                ", requestDate=" + requestDate +
                '}';
    }
}
