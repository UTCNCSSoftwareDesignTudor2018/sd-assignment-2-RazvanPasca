package assignment2.code.services;

import assignment2.code.persistance.entity.Teacher;
import assignment2.code.persistance.entity.TeacherBuilder;
import org.springframework.stereotype.Component;

@Component
public class TeacherContextHolder {
    private static Teacher teacher;

    public TeacherContextHolder() {
        teacher = new TeacherBuilder().setName("Liviu Vlaicu").setEmail("liviu_vlaicu@yahoo.com").build();
    }

    public static Teacher getCurrentUser() {
        return teacher;
    }

    public static void setCurrentUser(Teacher teacher) {
        teacher = teacher;
    }
}


