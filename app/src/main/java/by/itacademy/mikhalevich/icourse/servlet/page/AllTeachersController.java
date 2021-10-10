package by.itacademy.mikhalevich.icourse.servlet.page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import by.itacademy.mikhalevich.icourse.model.Teacher;
import by.itacademy.mikhalevich.icourse.servlet.AbstractController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;


@WebServlet("/teachers")
public class AllTeachersController extends AbstractController {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//List<Teacher> teachers = getTeacherService().listAllTeachers();
		Map<Integer, Teacher> teachers = getTeacherService().readTeachers();
		req.setAttribute("teachers", teachers);
		RoutingUtils.forwardToPage("teachers.jsp", req, resp);
	}
}
