package by.itacademy.mikhalevich.icourse.logic;

import by.itacademy.mikhalevich.icourse.model.Student;
import by.itacademy.mikhalevich.icourse.model.Teacher;
import by.itacademy.mikhalevich.icourse.model.Trainer;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface StudentService {
    Map<Integer, Student> readStudents();
    Map<Integer, Student> updateStudent(Student student);
    Map<Integer, Student> createStudent(Student student);
    Map<Integer, Student> deleteStudent(Integer id);
    Optional getStudentById (Integer id);
}
