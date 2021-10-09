package by.itacademy.mikhalevich.icours.logic;

import by.itacademy.mikhalevich.icours.model.Teacher;
import java.util.Map;

public interface TeacherService {

	Map<Integer, Teacher> readTeachers();
	Map<Integer, Teacher> updateTeacher(Teacher teacher);
	Map<Integer, Teacher> createTeacher(Teacher teacher);
	Map<Integer, Teacher> deleteTeacher(Integer id);


}
