package by.itacademy.mikhalevich.icours.servlet.page;

import by.itacademy.mikhalevich.icours.model.Teacher;
import by.itacademy.mikhalevich.icours.servlet.AbstractController;
import by.itacademy.mikhalevich.icours.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/delete-teacher")
public class DeleteTeacherController extends AbstractController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Integer, Teacher> teachers = getTeacherService().deleteTeacher(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("teachers", teachers);
        RoutingUtils.forwardToPage("teachers.jsp", req, resp);
    }
}
