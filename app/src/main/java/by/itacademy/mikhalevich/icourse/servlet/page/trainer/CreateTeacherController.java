package by.itacademy.mikhalevich.icourse.servlet.page.trainer;

import by.itacademy.mikhalevich.icourse.model.Role;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import by.itacademy.mikhalevich.icourse.servlet.AbstractTeacherController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/create-teacher")
public class CreateTeacherController extends AbstractTeacherController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getTeacherService().createTrainer(
                new Trainer()
                        .withName(req.getParameter("name"))
                        .withLogin(req.getParameter("login"))
                        .withPassword(req.getParameter("password"))
                        .withRole(new Role().withTitle(req.getParameter("role"))));

        Map<Integer, Trainer> teachers = getTeacherService().readTeachers();
        req.setAttribute("teachers", teachers);
        RoutingUtils.forwardToPage("teachers.jsp", req, resp);
    }

}
