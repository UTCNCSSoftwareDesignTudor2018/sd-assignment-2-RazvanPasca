package entities;

import static java.lang.Math.round;

public class StudentBuilder {
    String address = "default";
    String password = "default";
    String CNP = String.valueOf(round(Math.random() * ((2999999999999L - 1000000000000L) + 1)));
    String email = "default@yahoo.com";
    String name;
    Integer studyGroup = 1;
    Integer id;

    public StudentBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public StudentBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public StudentBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public StudentBuilder setCNP(String CNP) {
        this.CNP = CNP;
        return this;
    }

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public StudentBuilder setStudyGroup(int studyGroup) {
        this.studyGroup = studyGroup;
        return this;
    }

    public Student build() {
        return new Student(this);
    }

}
