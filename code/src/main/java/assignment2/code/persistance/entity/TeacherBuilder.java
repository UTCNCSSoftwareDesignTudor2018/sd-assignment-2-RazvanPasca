package assignment2.code.persistance.entity;

public class TeacherBuilder {
    String password = "default";
    String email = "default_prof@yahoo.com";
    String name = "default_prof_name";
    Integer id;
    Course course = new Course("Math" + Math.round(Math.random() * 1000000));

    public TeacherBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public TeacherBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public TeacherBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public TeacherBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public TeacherBuilder setCourse(Course course) {
        this.course = course;
        return this;
    }

    public Teacher build() {
        return new Teacher(this);
    }

}
