package by.itacademy.mikhalevich.icourse.servlet.page.trainer;

import by.itacademy.mikhalevich.icourse.model.Trainer;
import by.itacademy.mikhalevich.icourse.servlet.AbstractTeacherController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/delete-teacher")
public class DeleteTeacherController extends AbstractTeacherController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getTeacherService().deleteTrainer(Integer.parseInt(req.getParameter("id")));

        Map<Integer, Trainer> teachers = getTeacherService().readTeachers();
        req.setAttribute("teachers", teachers);
        RoutingUtils.forwardToPage("teachers.jsp", req, resp);
    }
}
