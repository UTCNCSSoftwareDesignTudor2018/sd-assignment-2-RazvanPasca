package assignment2.code.services;

import assignment2.code.persistance.entity.Student;
import assignment2.code.persistance.entity.StudentBuilder;
import org.springframework.stereotype.Component;

@Component
public class StudentContextHolder {
    private static Student student;

    public StudentContextHolder() {
        student = new StudentBuilder().setName("Alice").setEmail("alice@yahoo.com").build();
    }

    public static Student getCurrentUser() {
        return student;
    }

    public static void setCurrentUser(Student student1) {
        student = student1;
    }
}
