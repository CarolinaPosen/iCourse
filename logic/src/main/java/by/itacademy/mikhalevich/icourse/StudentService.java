package by.itacademy.mikhalevich.icourse;

import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.model.Student;

import java.util.Map;
import java.util.Optional;

public interface StudentService extends Service<Student> {
    Optional<Student> updateStudentsMark(Student student);
}
