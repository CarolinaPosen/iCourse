package by.itacademy.mikhalevich.icourse;

import by.itacademy.mikhalevich.icourse.model.Student;

import java.util.Map;
import java.util.Optional;

public interface StudentService {
    Map<Integer, Student> readStudents();
    Map<Integer, Student> updateStudent(Student student);
    Optional<Student> createStudent(Student student);
    Optional<Student> deleteStudent(Integer id);
    Optional<Student> deleteStudent(Student student);
    Student getStudentById (Integer id);
}
