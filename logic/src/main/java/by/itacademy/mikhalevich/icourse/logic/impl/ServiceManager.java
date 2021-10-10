package by.itacademy.mikhalevich.icourse.logic.impl;

import javax.servlet.ServletContext;

import by.itacademy.mikhalevich.icourse.logic.StudentService;
import by.itacademy.mikhalevich.icourse.logic.TeacherService;
import by.itacademy.mikhalevich.icourse.repository.ListDataSource;

public class ServiceManager {
	public static ServiceManager getInstance(ServletContext context) {
		ServiceManager instance = (ServiceManager) context.getAttribute("SERVICE_MANAGER");
		if (instance == null) {
			instance = new ServiceManager(context);
			context.setAttribute("SERVICE_MANAGER", instance);
		}
		return instance;
	}
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public StudentService getStudentService() {
		return studentService;
	}

	private final TeacherService teacherService;
	private final StudentService studentService;

	private ServiceManager(ServletContext context) {
		teacherService = new TeacherServiceImpl(new ListDataSource());
		studentService = new StudentServiceImpl(new ListDataSource());
	}

}
