package assignment2.code.persistance.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id",referencedColumnName="id")
    private Teacher teacher;

    @OneToMany(
            mappedBy = "course",
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

    public Course(String name){
        this.name = name;
    }

    public Course(){}

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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

    public Teacher getTeacher() {
        return teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
