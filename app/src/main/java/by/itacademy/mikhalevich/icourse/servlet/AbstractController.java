package by.itacademy.mikhalevich.icourse.servlet;

import by.itacademy.mikhalevich.icourse.logic.*;
import by.itacademy.mikhalevich.icourse.logic.impl.ServiceManager;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class AbstractController extends HttpServlet {

	private TeacherService teacherService;
	private StudentService studentService;
	private GroupService groupService;
	private SalaryService salaryService;
	private AccountService accountService;

	@Override
	public final void init() throws ServletException {
		teacherService = ServiceManager.getInstance(getServletContext()).getTeacherService();
		studentService = ServiceManager.getInstance(getServletContext()).getStudentService();
		groupService = ServiceManager.getInstance(getServletContext()).getGroupService();
		salaryService = ServiceManager.getInstance(getServletContext()).getSalaryService();
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
	public final SalaryService getSalaryService() {
		return salaryService;
	}
	public final AccountService getAccountService() {
		return accountService;
	}

}
