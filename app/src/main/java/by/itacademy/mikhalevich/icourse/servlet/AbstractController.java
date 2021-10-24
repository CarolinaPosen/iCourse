package by.itacademy.mikhalevich.icourse.servlet;

import by.itacademy.mikhalevich.icourse.logic.AccountService;
import by.itacademy.mikhalevich.icourse.logic.GroupService;
import by.itacademy.mikhalevich.icourse.logic.StudentService;
import by.itacademy.mikhalevich.icourse.logic.TeacherService;
import by.itacademy.mikhalevich.icourse.logic.impl.ServiceManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public abstract class AbstractController extends HttpServlet {

	private TeacherService teacherService;
	private StudentService studentService;
	private GroupService groupService;
	private AccountService accountService;

	@Override
	public final void init() throws ServletException {
		teacherService = ServiceManager.getInstance(getServletContext()).getTeacherService();
		studentService = ServiceManager.getInstance(getServletContext()).getStudentService();
		groupService = ServiceManager.getInstance(getServletContext()).getGroupService();
		accountService = ServiceManager.getInstance(getServletContext()).getAccountService();
	}

	public final TeacherService getTeacherService() {
		return teacherService;
	}
	public final StudentService getStudentService() {
		return studentService;
	}
	public final GroupService getGroupService() {
		return groupService;
	}
	public final AccountService getAccountService() {
		return accountService;
	}
}
