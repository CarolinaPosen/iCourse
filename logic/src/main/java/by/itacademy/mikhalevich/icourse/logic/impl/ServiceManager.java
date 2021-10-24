package by.itacademy.mikhalevich.icourse.logic.impl;

import javax.servlet.ServletContext;

import by.itacademy.mikhalevich.icourse.logic.AccountService;
import by.itacademy.mikhalevich.icourse.logic.GroupService;
import by.itacademy.mikhalevich.icourse.logic.StudentService;
import by.itacademy.mikhalevich.icourse.logic.TeacherService;
import by.itacademy.mikhalevich.icourse.repository.ListDataSource;
import by.itacademy.mikhalevich.icourse.repository.LoginPasswordSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceManager.class);

	public static ServiceManager getInstance(ServletContext context) {
		ServiceManager instance = (ServiceManager) context.getAttribute("SERVICE_MANAGER");
		if (instance == null) {
			instance = new ServiceManager(context);
			context.setAttribute("SERVICE_MANAGER", instance);
			LOGGER.info("Instant application: {}", "SERVICE");
		}
		return instance;
	}
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	public GroupService getGroupService() {
		return groupService;
	}
	public AccountService getAccountService() {
		return accountService;
	}

	private final TeacherService teacherService;
	private final StudentService studentService;
	private final GroupService groupService;
	private final AccountService accountService;

	private ServiceManager(ServletContext context) {
		//teacherService = new TeacherServiceImpl();
		teacherService = new TrainerServiceImpl();
		studentService = new StudentServiceImpl();
		groupService = new GroupServiceImpl();
		accountService = new AccountServiceImpl(new LoginPasswordSource());
	}

}
