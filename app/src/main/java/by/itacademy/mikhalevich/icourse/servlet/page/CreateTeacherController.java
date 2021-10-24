package by.itacademy.mikhalevich.icourse.servlet.page;

import by.itacademy.mikhalevich.icourse.servlet.AbstractController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-teacher")
public class CreateTeacherController extends AbstractController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long defaultId = 99;
 /*       Map<Integer, Teacher> teachers = getTeacherService().createTeacher(new Teacher(
                defaultId,
                req.getParameter("name"),
                Integer.parseInt(req.getParameter("age")),
                List.of(0,0,0,0,0,0,0,0,0,0,0,0)
        ));
        req.setAttribute("teachers", teachers);*/
        RoutingUtils.forwardToPage("teachers.jsp", req, resp);
    }

}
