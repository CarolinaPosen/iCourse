package by.itacademy.mikhalevich.icourse.servlet.page.trainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import by.itacademy.mikhalevich.icourse.model.Trainer;
import by.itacademy.mikhalevich.icourse.servlet.AbstractTeacherController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;

@WebServlet("/teachers")
public class AllTeachersController extends AbstractTeacherController {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<Integer, Trainer> teachers = getTeacherService().readTeachers();
		req.setAttribute("teachers", teachers);
		RoutingUtils.forwardToPage("teachers.jsp", req, resp);
	}
}
