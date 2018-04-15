package assignment2.code.persistance.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.round;

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

    public void setEnrolments(List<Enrolment> enrolments) {
        this.enrolments = enrolments;
    }

    public void addCourse(Course course) {
        Enrolment enrolment = new Enrolment(this, course);
        enrolments.add(enrolment);
        course.getEnrolments().add(enrolment);
    }

//    public void addGrade(Integer grade, Course course){
//        Grade grade1 = new Grade(grade);
//        grade1.addGrade(grade,course,this);
//    }

    public Grade addGrade(Integer grade, Enrolment enrolment) {
        Grade grade1 = new Grade(grade);
        grade1.addGrade(grade,enrolment);
        //grades.add(grade1);
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


    private Student(Builder builder) {
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

    public static class Builder {
        private String address = "default";
        private String password = "default";
        private String CNP = String.valueOf(round(Math.random() * ((2999999999999L - 1000000000000L) + 1)));
                ;
        private String email = "default@yahoo.com";
        private String name;
        private Integer studyGroup = 1;
        private Integer id;

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setCNP(String CNP) {
            this.CNP = CNP;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setStudyGroup(int studyGroup) {
            this.studyGroup = studyGroup;
            return this;
        }

        public Student build() {
            return new Student(this);
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