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

    public Teacher(Builder teacherBuilder) {
        this.id = teacherBuilder.id;
        this.name = teacherBuilder.name;
        this.email = teacherBuilder.email;
        this.password = teacherBuilder.password;
        addCourse(teacherBuilder.course);
    }

    public static class Builder{
        private String password = "default";
        private String email = "default_prof@yahoo.com";
        private String name = "default_prof_name";
        private Integer id;
        private Course course = new Course("Math" + Math.round(Math.random()*1000000));

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setEmail(String email){
            this.email = email;
            return  this;
        }

        public Builder setCourse(Course course){
            this.course = course;
            return this;
        }

        public Teacher build(){
            return new Teacher(this);
        }

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
