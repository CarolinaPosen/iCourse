package by.itacademy.mikhalevich.icourse.logic;

import by.itacademy.mikhalevich.icourse.model.Teacher;

import java.math.BigDecimal;
import java.util.Map;

public interface TeacherService {

	Map<Integer, Teacher> readTeachers();
	Map<Integer, Teacher> updateTeacher(Teacher teacher);
	Map<Integer, Teacher> createTeacher(Teacher teacher);
	Map<Integer, Teacher> deleteTeacher(Integer id);
	Teacher getTeacherById (Integer id);
	BigDecimal averageSalary(Integer id, int countOfMonth);


}
