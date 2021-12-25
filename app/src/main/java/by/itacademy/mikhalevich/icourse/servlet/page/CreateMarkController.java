package by.itacademy.mikhalevich.icourse.servlet.page;

import by.itacademy.mikhalevich.icourse.model.*;
import by.itacademy.mikhalevich.icourse.servlet.AbstractStudentController;
import by.itacademy.mikhalevich.icourse.servlet.AbstractTeacherController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

@WebServlet("/create-mark")
public class CreateMarkController extends AbstractStudentController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getMarkService().createMark(
                new Mark()
                        .withMark(Integer.parseInt(req.getParameter("mark")))
                        .withDate(Timestamp.from(Instant.now()))
                        .withTheme(new Theme().withId(Integer.parseInt(req.getParameter("themes-id")))));

        Student student = getStudentService().getStudentById(Integer.parseInt(req.getParameter("student-id")));
        req.setAttribute("student", student);
        RoutingUtils.forwardToPage("marks.jsp", req, resp);
    }

}