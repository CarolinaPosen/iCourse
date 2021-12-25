package by.itacademy.mikhalevich.icourse.servlet.page;

import by.itacademy.mikhalevich.icourse.model.Student;
import by.itacademy.mikhalevich.icourse.servlet.AbstractMarkController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-mark")
public class DeleteMarkController extends AbstractMarkController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        Integer studentId = Integer.parseInt(req.getParameter("student"));

        getMarkService().deleteMark(Integer.parseInt(req.getParameter("id")));

        Student student = getStudentService().getStudentById(studentId);

        req.setAttribute("student", student);
        RoutingUtils.forwardToPage("marks.jsp", req, resp);
    }
}
