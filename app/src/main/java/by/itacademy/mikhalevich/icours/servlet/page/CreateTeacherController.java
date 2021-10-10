package by.itacademy.mikhalevich.icours.servlet.page;

import by.itacademy.mikhalevich.icours.model.Teacher;
import by.itacademy.mikhalevich.icours.servlet.AbstractController;
import by.itacademy.mikhalevich.icours.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/create-teacher")
public class CreateTeacherController extends AbstractController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long defaultId = 99;
        Map<Integer, Teacher> teachers = getTeacherService().createTeacher(new Teacher(
                defaultId,
                req.getParameter("name"),
                Integer.parseInt(req.getParameter("age")),
                List.of(0,0,0,0,0,0,0,0,0,0,0,0)
        ));
        req.setAttribute("teachers", teachers);
        RoutingUtils.forwardToPage("teachers.jsp", req, resp);
    }

}
