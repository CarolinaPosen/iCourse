package by.itacademy.mikhalevich.icourse.logic.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import by.itacademy.mikhalevich.icourse.logic.TeacherService;
import by.itacademy.mikhalevich.icourse.logic.calculating.Accounting;
import by.itacademy.mikhalevich.icourse.model.Teacher;
import by.itacademy.mikhalevich.icourse.repository.ListDataSource;

class TeacherServiceImpl implements TeacherService {
	
	private ListDataSource dataSource;
	private long incrementId = 99;
	
	public TeacherServiceImpl(ListDataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public Map<Integer, Teacher> readTeachers() {
		return dataSource.getTeachersMap();
	}

	@Override
	public Map<Integer, Teacher> updateTeacher(Teacher teacher) {
		return dataSource.updateTeacher(teacher);
	}

	@Override
	public Map<Integer, Teacher> createTeacher(Teacher teacher) {
		incrementId++;
		teacher.setId(incrementId);
		return dataSource.createTeacher(teacher);
	}

	@Override
	public Map<Integer, Teacher> deleteTeacher(Integer id) {
		return dataSource.deleteTeacher(id);
	}

	@Override
	public Teacher getTeacherById(Integer id) {
		return dataSource.getTeacherById(id);
	}

	@Override
	public BigDecimal averageSalary(Integer id, int countOfMonth) {
		return Accounting.average(dataSource.getTeacherById(id).getSalary(), countOfMonth).setScale(2, RoundingMode.HALF_UP);

	}


}
