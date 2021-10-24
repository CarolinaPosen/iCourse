package by.itacademy.mikhalevich.icourse.logic;

import by.itacademy.mikhalevich.icourse.model.Teacher;
import by.itacademy.mikhalevich.icourse.model.Trainer;

import java.math.BigDecimal;
import java.util.Map;

public interface TeacherService {

	Map<Integer, Trainer> readTeachers();
	Map<Integer, Trainer> updateTeacher(Teacher teacher);
	Map<Integer, Trainer> createTeacher(Teacher teacher);
	Map<Integer, Trainer> deleteTeacher(Integer id);
	Trainer getTeacherById (Integer id);
	BigDecimal averageSalary(Integer id, int countOfMonth);


}
