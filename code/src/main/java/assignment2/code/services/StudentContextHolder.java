package assignment2.code.services;

import assignment2.code.persistance.entity.Student;

public class StudentContextHolder {
    private static Student student;

    public static Student getCurrentUser() {
        return student;
    }

    public static void setCurrentUser(Student student) {
        student = student;
    }
}
