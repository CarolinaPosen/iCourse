package by.itacademy.mikhalevich.icours.servlet.page;

import by.itacademy.mikhalevich.icours.model.Teacher;
import by.itacademy.mikhalevich.icours.servlet.AbstractController;
import by.itacademy.mikhalevich.icours.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/salary")
public class SalaryController extends AbstractController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        BigDecimal averageSalary;

        averageSalary = getTeacherService().averageSalary(id, 12);
        req.setAttribute("average", averageSalary);

        if (req.getParameter("month1") != null) {

            getTeacherService().updateTeacher(new Teacher(
                    Long.parseLong(req.getParameter("id")),
                    req.getParameter("name"),
                    Integer.parseInt(req.getParameter("age")),
                    List.of(
                            Integer.parseInt(req.getParameter("month1")),
                            Integer.parseInt(req.getParameter("month2")),
                            Integer.parseInt(req.getParameter("month3")),
                            Integer.parseInt(req.getParameter("month4")),
                            Integer.parseInt(req.getParameter("month5")),
                            Integer.parseInt(req.getParameter("month6")),
                            Integer.parseInt(req.getParameter("month7")),
                            Integer.parseInt(req.getParameter("month8")),
                            Integer.parseInt(req.getParameter("month9")),
                            Integer.parseInt(req.getParameter("month10")),
                            Integer.parseInt(req.getParameter("month11")),
                            Integer.parseInt(req.getParameter("month12"))
                    )));

            averageSalary = getTeacherService().averageSalary
                    (id, Integer.parseInt(req.getParameter("count")));
            req.setAttribute("average", averageSalary);

        }

        Teacher teacher = getTeacherService().getTeacherById(id);
        req.setAttribute("teacher", teacher);
        RoutingUtils.forwardToPage("average.jsp", req, resp);
    }
}
