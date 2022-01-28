package by.itacademy.mikhalevich.icourse.base;

import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.model.Student;

import java.util.Map;

public interface StudentBaseRepository extends Repository<Student> {
    Map<Integer, Student> getStudentMap();
}
