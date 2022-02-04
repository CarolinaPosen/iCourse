package by.itacademy.mikhalevich.icourse.servlet.page.mark;

import by.itacademy.mikhalevich.icourse.model.*;
import by.itacademy.mikhalevich.icourse.servlet.AbstractStudentController;
import by.itacademy.mikhalevich.icourse.servlet.JsonController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

@WebServlet("/marks")
public class MarkController extends AbstractStudentController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Student student = getStudentService().getById(Integer.parseInt(req.getParameter("id"))).get();
        req.setAttribute("student", student);
        RoutingUtils.forwardToPage("marks.jsp", req, resp);

    }
}