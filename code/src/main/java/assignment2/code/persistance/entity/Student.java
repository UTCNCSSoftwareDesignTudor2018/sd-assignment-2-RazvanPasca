package assignment2.code.persistance.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "students",
        uniqueConstraints= {@UniqueConstraint(columnNames = {"CNP", "email"})}
        )
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private String CNP;
    private String password;
    private String address;
    private Integer studyGroup;

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.PERSIST,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<Enrolment> enrolments = new ArrayList<>();

    public List<Enrolment> getEnrolments() {
        return enrolments;
    }

    public Student(StudentBuilder builder) {
        name = builder.name;
        CNP = builder.CNP;
        address = builder.address;
        email = builder.email;
        studyGroup = builder.studyGroup;
        id = builder.id;
        password = builder.password;
    }

    public Student() {
    }

    public void setEnrolments(List<Enrolment> enrolments) {
        this.enrolments = enrolments;
    }

    public Enrolment addCourse(Course course) {
        Enrolment enrolment = new Enrolment(this, course);
        enrolments.add(enrolment);
        course.getEnrolments().add(enrolment);
        return enrolment;
    }

    public Grade addGrade(Integer grade, Course course) {
        Grade grade1 = new Grade(grade);
        grade1.addGrade(grade, course, this);
        return grade1;
    }

    public Grade addGrade(Integer grade, Enrolment enrolment) {
        Grade grade1 = new Grade(grade);
        grade1.addGrade(grade,enrolment);
        return grade1;
    }

    public void removeCourse(Course course) {
        for (Iterator<Enrolment> iterator = enrolments.iterator();
             iterator.hasNext(); ) {
            Enrolment enrolment = iterator.next();

            if (enrolment.getStudent().equals(this) &&
                    enrolment.getCourse().equals(course)) {
                iterator.remove();
                enrolment.getCourse().getEnrolments().remove(enrolment);
                enrolment.setStudent(null);
                enrolment.setCourse(null);
            }
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStudyGroup() {
        return studyGroup;
    }

    public void setStudyGroup(int studyGroup) {
        this.studyGroup = studyGroup;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) &&
                Objects.equals(name, student.name) &&
                Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, email);
    }
}