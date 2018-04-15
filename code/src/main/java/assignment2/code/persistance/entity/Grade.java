package assignment2.code.persistance.entity;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "grades")
public class Grade {

    @EmbeddedId
    private EnrolmentId id;

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST)
    @MapsId("enrolmentId")
    @JoinColumns({
            @JoinColumn(name = "course_id", referencedColumnName = "course_id"),
            @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    })
    private Enrolment enrolment;

    @Column
    private Date requestDate;

    @Column
    private Integer grade;

    public Grade(Integer grade) {
        this.grade = grade;
        this.requestDate = new Date(System.currentTimeMillis());
    }

    public Grade() {
        this.requestDate = new Date(System.currentTimeMillis());
    }

    public EnrolmentId getId() {
        return id;
    }

    public void GradeId(EnrolmentId id) {
        this.id = id;
    }

    public void addGrade(Integer grad, Course course, Student student) {
        this.grade = grade;
        this.id.setStudentId(student.getId());
        this.id.setCourseId(course.getId());
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
}
