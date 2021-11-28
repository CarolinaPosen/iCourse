package by.itacademy.mikhalevich.icourse.logic.impl;

import javax.servlet.ServletContext;

import by.itacademy.mikhalevich.icourse.logic.AccountService;
import by.itacademy.mikhalevich.icourse.logic.GroupService;
import by.itacademy.mikhalevich.icourse.logic.MarkService;
import by.itacademy.mikhalevich.icourse.logic.SalaryService;
import by.itacademy.mikhalevich.icourse.logic.StudentService;
import by.itacademy.mikhalevich.icourse.logic.TeacherService;
import by.itacademy.mikhalevich.icourse.repository.LoginPasswordSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ServiceManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceManager.class);
	public static final String DB_DRIVER = "db.driver";
	public static final String DB_URL = "db.url";
	public static final String DB_USERNAME = "db.username";
	public static final String DB_PASSWORD = "db.password";
	private final Properties applicationProperties = new Properties();
	private BasicDataSource dataSource;

	private final TeacherService teacherService;
	private final StudentService studentService;
	private final MarkService markService;
	private final GroupService groupService;
	private final SalaryService salaryService;
	private final AccountService accountService;

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
	public MarkService getMarkService() {
		return markService;
	}
	public GroupService getGroupService() {
		return groupService;
	}
	public SalaryService getSalaryService() {
		return salaryService;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	private ServiceManager(ServletContext context) {
		loadApplicationProperties();
		dataSource = createDataSource();
		teacherService = new TrainerServiceImpl();
		studentService = new StudentServiceImpl();
		markService = new MarkServiceImpl();
		groupService = new GroupServiceImpl();
		salaryService = new SalaryServiceImpl();
		accountService = new AccountServiceImpl(new LoginPasswordSource());
	}

	private BasicDataSource createDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		//dataSource.setDefaultAutoCommit(false);
		//dataSource.setRollbackOnReturn(true);
		dataSource.setDriverClassName(getApplicationProperty(DB_DRIVER));
		dataSource.setUrl(getApplicationProperty(DB_URL));
		dataSource.setUsername(getApplicationProperty(DB_USERNAME));
		dataSource.setPassword(getApplicationProperty(DB_PASSWORD));
		return dataSource;
	}

	public String getApplicationProperty(String key) {
		return applicationProperties.getProperty(key);
	}

	private void loadApplicationProperties() {
		try (InputStream in = ServiceManager.class.getClassLoader().getResourceAsStream("application.properties")) {
			applicationProperties.load(in);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
