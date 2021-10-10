package by.itacademy.mikhalevich.icourse.servlet;

import by.itacademy.mikhalevich.icourse.logic.StudentService;
import by.itacademy.mikhalevich.icourse.logic.TeacherService;
import by.itacademy.mikhalevich.icourse.logic.impl.ServiceManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public abstract class AbstractController extends HttpServlet {

	private TeacherService teacherService;
	private StudentService studentService;

	@Override
	public final void init() throws ServletException {
		teacherService = ServiceManager.getInstance(getServletContext()).getTeacherService();
		studentService = ServiceManager.getInstance(getServletContext()).getStudentService();
	}

	public final TeacherService getTeacherService() {
		return teacherService;
	}
	public final StudentService getStudentService() {
		return studentService;
	}
}
