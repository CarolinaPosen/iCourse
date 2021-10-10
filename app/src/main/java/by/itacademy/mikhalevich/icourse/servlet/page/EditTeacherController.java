package by.itacademy.mikhalevich.icourse.servlet.page;

import by.itacademy.mikhalevich.icourse.model.Teacher;
import by.itacademy.mikhalevich.icourse.servlet.AbstractController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/teacher-edit")
public class EditTeacherController extends AbstractController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Teacher teacher = getTeacherService().getTeacherById(Integer.parseInt(req.getParameter("id")));

        Map<Integer, Teacher> teachers = getTeacherService().updateTeacher(new Teacher(
                Long.parseLong(req.getParameter("id")),
                req.getParameter("name"),
                Integer.parseInt(req.getParameter("age")),
                teacher.getSalary()
        ));

        req.setAttribute("teachers", teachers);
        RoutingUtils.forwardToPage("teachers.jsp", req, resp);
    }
}
