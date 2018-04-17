package assignment2.code.persistance.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private String password;
    @OneToMany(
            mappedBy = "teacher",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER
    )
    private List<Course> courses = new ArrayList<>();

    public Teacher(TeacherBuilder teacherBuilder) {
        this.id = teacherBuilder.id;
        this.name = teacherBuilder.name;
        this.email = teacherBuilder.email;
        this.password = teacherBuilder.password;
        addCourse(teacherBuilder.course);
    }



    public Teacher() {
    }

    public void addCourse(Course course){
        courses.add(course);
        course.setTeacher(this);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int teacherId) {
        this.id = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(id, teacher.id) &&
                Objects.equals(name, teacher.name) &&
                Objects.equals(email, teacher.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, email);
    }
}
