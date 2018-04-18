package entities;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "email",
        "password",
        "address",
        "studyGroup",
        "enrolments",
        "cnp"
})
public class Student {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("address")
    private String address;
    @JsonProperty("studyGroup")
    private Integer studyGroup;
    @JsonProperty("enrolments")
    private List<Enrolment> enrolments = null;
    @JsonProperty("cnp")
    private String cnp;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Student(StudentBuilder builder) {
        name = builder.name;
        cnp = builder.CNP;
        address = builder.address;
        email = builder.email;
        studyGroup = builder.studyGroup;
        id = builder.id;
        password = builder.password;
    }

    public Student() {
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
        grade1.addGrade(grade, enrolment);
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

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("studyGroup")
    public Integer getStudyGroup() {
        return studyGroup;
    }

    @JsonProperty("studyGroup")
    public void setStudyGroup(Integer studyGroup) {
        this.studyGroup = studyGroup;
    }

    @JsonProperty("enrolments")
    public List<Enrolment> getEnrolments() {
        return enrolments;
    }

    @JsonProperty("enrolments")
    public void setEnrolments(List<Enrolment> enrolments) {
        this.enrolments = enrolments;
    }

    @JsonProperty("cnp")
    public String getCnp() {
        return cnp;
    }

    @JsonProperty("cnp")
    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", studyGroup=" + studyGroup +
                ", cnp='" + cnp + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}