package by.itacademy.mikhalevich.icourse.servlet.page.mark;
import by.itacademy.mikhalevich.icourse.model.Mark;
import by.itacademy.mikhalevich.icourse.model.Student;
import by.itacademy.mikhalevich.icourse.servlet.AbstractMarkController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mark-edit")
public class EditMarkController extends AbstractMarkController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.parseInt(req.getParameter("id"));
        Mark mark = getMarkService().getMarkById(id);

        mark.withMark(Integer.parseInt(req.getParameter("mark")));

        getMarkService().updateMark(mark);

        Integer studentId = Integer.parseInt(req.getParameter("student-id"));
        Student student = getStudentService().getById(studentId).get();

        req.setAttribute("student", student);
        RoutingUtils.forwardToPage("marks.jsp", req, resp);
    }

}
