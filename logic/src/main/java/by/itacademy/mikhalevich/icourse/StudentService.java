package by.itacademy.mikhalevich.icourse;

import by.itacademy.mikhalevich.icourse.model.Student;

import java.util.Map;

public interface StudentService {
    Map<Integer, Student> readStudents();
    Map<Integer, Student> updateStudent(Student student);
    Map<Integer, Student> createStudent(Student student);
    Map<Integer, Student> deleteStudent(Integer id);
    Student getStudentById (Integer id);
}
